// 백준 - 이모티콘(14226)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue

data class Emoticon (
  val time: Int,
  val length: Int,
  val clipboard: Int
)

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var S = br.readLine().toInt()
  
  var emoticon = LinkedList<Emoticon>() as Queue<Emoticon>
  var visited = Array(S+1, {Array(S+1, {false})})

  emoticon.offer(Emoticon(0, 1, 0))
  visited[1][0] = true

  while(!emoticon.isEmpty()) {
    val emot = emoticon.poll()

    if(emot.length == S) {
      print(emot.time)
      break
    }

    // 클립보드에 저장
    emoticon.offer(Emoticon(emot.time + 1, emot.length, emot.length))

    // 붙여넣기
    // 클립보드에 저장된 게 있을 경우 + S보다 길지 않고 방문한적 없는 경우
    val pasteLength = emot.length + emot.clipboard
    if(emot.clipboard > 0 && pasteLength <= S && !visited[pasteLength][emot.clipboard]) {
      emoticon.offer(Emoticon(emot.time + 1, pasteLength, emot.clipboard))
      visited[pasteLength][emot.clipboard] = true
    }

    // 이모티콘 하나 삭제
    // 삭제해도 이모티콘이 1개 이상 남고, 방문한적 없는 경우
    val deleteLength = emot.length - 1
    if(deleteLength >= 1 && !visited[deleteLength][emot.clipboard]) {
      emoticon.offer(Emoticon(emot.time + 1, deleteLength, emot.clipboard))
      visited[deleteLength][emot.clipboard] = true
    }
  }
}