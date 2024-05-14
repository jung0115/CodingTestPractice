// 백준 - 자두나무(2240) - 시간초과
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

var T = 0
var W = 0

var plum: Array<Int> = arrayOf()
val change: MutableList<Int> = mutableListOf() // 떨어지는 자두 나무가 변경되는 타이밍

var moveTime: Array<Boolean> = arrayOf()
var maxPlum = 0

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  T = st.nextToken().toInt() // 떨어지는 자두의 개수
  W = st.nextToken().toInt() // 자두가 최대로 움직일 횟수
  plum = Array(T, {0})

  var default = 0
  
  for(i: Int in 0..T-1) {
    plum[i] = br.readLine().toInt()
    // 떨어지는 자두 나무가 변경되는 타이밍
    if(i > 0 && plum[i] != plum[i-1]) {
      change.add(i)
    }
    else if(i == 0 && plum[i] != 1) {
      change.add(i)
    }
    // 아직 2번 나무로 떨어진 적 없이 1번 나무로 떨어지는 자두
    else if(change.size == 0 && plum[i] == 1) {
      default++
    }
  }

  moveTime = Array(change.size, {false})

  selectMoveTime(0, 0)

  print(maxPlum + default)
}

// 자두가 이동할 타이밍 선택
fun selectMoveTime(idx: Int, cnt: Int) {
  // 자두가 최대로 움직였거나, 움직일 필요가 없을 경우
  if(cnt == W || idx == change.size) {
    maxPlum = max(maxPlum, countPlum())
    return
  }

  for(i: Int in idx..change.size - 1) {
    moveTime[i] = true
    selectMoveTime(i + 1, cnt + 1)
    moveTime[i] = false
  }
}

// 자두가 받을 수 있는 자두 개수 세기
fun countPlum(): Int {
  var cnt = 0
  var point = 1 // 현재 위치한 나무 번호

  for(i: Int in 0..change.size - 1) {
    // 나무 이동
    if(moveTime[i]) {
      point = (point % 2) + 1
    }

    // 자두가 현재 위치로 떨어질 경우 받음 - 위치가 바뀔 때까지
    if(plum[change[i]] == point) {
      var f = T
      if(i < change.size - 1) f = change[i + 1]

      cnt += f - change[i]
    }
  }

  return cnt
}