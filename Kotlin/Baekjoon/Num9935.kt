// 백준 - 문자열 폭발(9935)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  var str = br.readLine()
  val bomb = br.readLine()

  // while(str.indexOf(bomb) != -1) {
  //   str = str.replace(bomb, "")
  // }

  val bombLen = bomb.length
  val result = StringBuilder()

  for (char in str) {
    result.append(char)

    if (result.endsWith(bomb)) {
      result.delete(result.length - bombLen, result.length)
    }
  }

  if (result.isEmpty()) {
    println("FRULA")
  } else {
    println(result.toString())
  }
}

fun StringBuilder.endsWith(suffix: String): Boolean {
  if (this.length < suffix.length) return false
  return this.substring(this.length - suffix.length) == suffix
}