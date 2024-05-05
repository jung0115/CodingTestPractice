// 백준 - 소문난 칠공주(1941)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var selected : Array<Int> = Array(7, {0})
var visited : Array<Boolean> = Array(7, {false})
var answer = 0

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  // 교실 배치 - 이다솜파는 1, 임도연파는 0으로 표시
  var map : Array<Array<Int>> = Array(5, {Array(5, {0})})

  for(i : Int in 0..4) {
    var input : String = br.readLine();
    for(j : Int in 0..4) {
      // 이다솜파면 1로 표시
      if(input[j].equals('S')) {
        map[i][j] = 1
      }
    }
  }

  selectSeven(map, 0, 0, 0)

  print(answer)
}

// 이다솜파(S, 1)가 4명 이상인 자리 7개 뽑기
// cnt: 현재 뽑은 인원 수 / s: 뽑은 인원 중 이다솜파
fun selectSeven(map : Array<Array<Int>>, start: Int, cnt: Int, s: Int) {
  // 7명을 선택했다면
  if(cnt == 7) {
    // 이다솜파가 4명 이상 포함
    if(s >= 4){
      visited = Array(7, {false})
      // 자리가 가로세로로 모두 인접해있다면
      if(isNear()) {
        answer++
      }
    }

    return
  }

  for(i: Int in start..24) {
    val x = i / 5
    val y = i % 5
    // 선택
    selected[cnt] = i
    selectSeven(map, i + 1, cnt + 1, s + map[x][y])
  }
}

// 7명의 자리가 가로 또는 세로로 인접해있는지 확인
fun isNear() : Boolean {
  val queue = LinkedList<Array<Int>>() as Queue<Array<Int>>

  // 첫번째 자리
  queue.offer(arrayOf(selected[0] / 5, selected[0] % 5))
  visited[0] = true

  // 인접한 자리 개수 체크
  var check: Int = 1

  while(!queue.isEmpty()) {
    var cur: Array<Int> = queue.poll()

    // 상하좌우 체크
    for(i: Int in 0..3) {
      val moveX = cur[0] + dx[i]
      val moveY = cur[1] + dy[i]

      // 5*5 배열을 1차원 배열로 만들었을 때 몇 번째 인덱스인지
      val moveIdx = moveX * 5 + moveY

      // 범위를 벗어나는지 체크
      if(moveX < 0 || moveX >= 5 || moveY < 0 || moveY >= 5) continue

      for(j: Int in 0..6) {
        // 선택된 자리 중 하나라면? -> 해당 자리는 인접한 것
        if(!visited[j] && selected[j] == moveIdx) {
          queue.offer(arrayOf(moveX, moveY))
          visited[j] = true
          check++
        }
      }
    }
  }

  if(check == 7) return true
  
  return false
}