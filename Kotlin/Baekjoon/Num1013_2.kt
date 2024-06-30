// 백준 - Contact(1013)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var T = br.readLine().toInt()

  for(i: Int in 1..T) {
    var contact = br.readLine()

    if(contact.matches(regex)) println("YES")
    else println("NO")
  }
}