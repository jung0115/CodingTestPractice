// 백준 - 신기한 소수(2023)
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

val answer = StringBuilder()

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var N = br.readLine().toInt()

  // 제일 첫 숫자는 2, 3, 5, 7중 하나
  val firstNum: Array<Int> = arrayOf(2, 3, 5, 7)
  for(i: Int in 0..3) {
    findAmazingPrime(firstNum[i], N - 1)
  }

  print(answer)
}

// 신기한 소수 찾기
fun findAmazingPrime(num: Int, N: Int) {
  // N자리 수를 만들었다면
  if(N == 0) {
    // 소수인지 체크
    if(isPrime(num))
      answer.append(num).append("\n")
    
    return
  }

  for(i: Int in 0..9) {
    // 다음 숫자
    val nextNum = num * 10 + i
    if(isPrime(nextNum))
      findAmazingPrime(nextNum, N - 1)
  }
}


// 소수인지 아닌지
fun isPrime(num: Int) : Boolean {
  if(num < 2) return false

  for(i: Int in 2..sqrt(num.toDouble()).toInt()) {
    if(num % i == 0) return false
  }

  return true
}