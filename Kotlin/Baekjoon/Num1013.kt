// 백준 - Contact(1013)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var T = br.readLine().toInt()

  // 정규표현식
  val regex = "(100+1+|01)+".toRegex()

  for(i: Int in 1..T) {
    var contact = br.readLine()

    if(contact.matches(regex)) println("YES")
    else println("NO")
  }
}