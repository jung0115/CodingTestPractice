// 백준 - 줄 세우기(2252)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt()
  val M = st.nextToken().toInt()

  var graph = Array(N+1, {mutableListOf<Int>()})
  var edgeCnt = Array(N+1, {0})

  for(i: Int in 0..M-1) {
    st = StringTokenizer(br.readLine())
    val A = st.nextToken().toInt()
    val B = st.nextToken().toInt()

    graph[A].add(B)
    edgeCnt[B]++ // 진입차수 기록
  }

  var queue = LinkedList<Int>() as Queue<Int>
  var answer = StringBuilder()

  // 진입차수 0인 값을 큐에 = 본인보다 앞에 서야하는 사람이 없다
  for(i: Int in 1..N) {
    if(edgeCnt[i] == 0)
      queue.offer(i);
  }

  while(!queue.isEmpty()) {
    var student = queue.poll()

    // 남은 학생 중에 본인보다 앞에 서야하는 사람이 없으므로 바로 줄 세워줌
    answer.append(student).append(" ")

    for(i: Int in 0..graph[student].size - 1) {
      // 현재 학생보다 뒤에 서야했던 학생 => 앞에 세워야 했던 사람이 한 명 줄어듦
      var back = graph[student][i]
      edgeCnt[back]--
      // 한 명 줄어들면서 더이상 앞에 서야하는 사람이 없으면 큐에 추가
      if(edgeCnt[back] == 0) {
        queue.offer(back)
      }
    }
  }

  print(answer)
}