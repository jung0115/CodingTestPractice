// 백준 - 컨베이어 벨트 위의 로봇(20055)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt()
  val K = st.nextToken().toInt()

  st = StringTokenizer(br.readLine())
  var belt = mutableListOf<Int>()
  for(i: Int in 1..N * 2) {
    belt.add(st.nextToken().toInt())
  }

  var robots = Array(N * 2, {false})

  var zeroCnt = 0
  var answer = 0

  var start = 0
  var end = N - 1

  while(zeroCnt < K) {
    // 단계 체크
    answer++

    // 벨트 한 칸 움직임 -> 시작점, 끝점을 -1
    start = if(start == 0) N * 2 - 1 else start - 1
    end = if(end == 0) N * 2 - 1 else end - 1

    // 벨트가 움직여서 끝점에 로봇이 도착했다면 로봇 내리기
    robots[end] = false

    // 먼저 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동
    // 시작점의 인덱스보다 끝점의 인덱스가 클 경우
    if(start < end) {
      for(i: Int in end - 1 downTo start) {
        // 로봇이 올라가있고, 다음 칸에 로봇이 없으며 다음 칸의 내구도가 1 이상 남아있을 경우
        val next = (i + 1) % (2 * N)
        if(robots[i] && !robots[next] && belt[next] >= 1) {
          robots[i] = false   // 로봇 내림
          robots[next] = true // 로봇 올림
          belt[next]--        // 내구도 감소
          if(belt[next] == 0) zeroCnt++
        }
      }
    }
    // 시작점의 인덱스가 끝점의 인덱스보다 작을 경우 -> 끊어서 체크
    else {
      for(i: Int in end - 1 downTo 0) {
        // 로봇이 올라가있고, 다음 칸에 로봇이 없으며 다음 칸의 내구도가 1 이상 남아있을 경우
        val next = (i + 1) % (2 * N)
        if(robots[i] && !robots[next] && belt[next] >= 1) {
          robots[i] = false   // 로봇 내림
          robots[next] = true // 로봇 올림
          belt[next]--        // 내구도 감소
          if(belt[next] == 0) zeroCnt++
        }
      }
      for(i: Int in N * 2 - 1 downTo start) {
        // 로봇이 올라가있고, 다음 칸에 로봇이 없으며 다음 칸의 내구도가 1 이상 남아있을 경우
        val next = (i + 1) % (2 * N)
        if(robots[i] && !robots[next] && belt[next] >= 1) {
          robots[i] = false   // 로봇 내림
          robots[next] = true // 로봇 올림
          belt[next]--        // 내구도 감소
          if(belt[next] == 0) zeroCnt++
        }
      }
    }

    // 로봇 이동 후에 끝 점에 로봇이 도착했다면 로봇 내리기
    robots[end] = false

    // 시작점의 내구도가 1 이상이면 로봇 올리기
    if(belt[start] > 0) {
      robots[start] = true // 로봇 올림
      belt[start]--        // 내구도 감소
      if(belt[start] == 0) zeroCnt++
    }
  }
  
  print(answer)
}