//백준 - 세 개의 소수 문제(11502)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val sb = StringBuilder()

  val T = br.readLine().toInt()

  val nums = IntArray(T) { 0 }
  for(i: Int in 0..T-1) {
    nums[i] = br.readLine().toInt()
  }

  val primes = mutableListOf<Int>()

  for (i in 2..1000) {
    var isPrime = true
    for (p in primes) {
      if (p * p > i) break  // 이미 구한 소수로만 나눠서 확인
      if (i % p == 0) {
        isPrime = false
        break
      }
    }
    if (isPrime) {
      primes.add(i)  // 소수면 리스트에 추가
    }
  }

  for(i: Int in 0..T-1) {
    val result = searchThreeNum(nums[i], primes)

    if (result != null) {
      sb.append("${result.first} ${result.second} ${result.third}\n")
    } else {
      sb.append("0\n")
    }
  }

  print(sb)
}

fun searchThreeNum(n: Int, primes: List<Int>): Triple<Int, Int, Int>? {
  for (i in primes) {
    for (j in primes) {
      for (k in primes) {
        if (i + j + k == n) {
          return Triple(i, j, k)
        }
      }
    }
  }
  return null
}