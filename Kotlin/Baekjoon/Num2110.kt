// 백준 - 공유기 설치(2110)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var house: Array<Int> = arrayOf()

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt()
  val C = st.nextToken().toInt()

  house = Array(N, {0})

  for(i: Int in 0..N-1) {
    house[i] = br.readLine().toInt()
  }

  // 오름차순 정렬
  house.sort()

  var low = 1 // 최소거리의 최소
  var high = house[N-1] - house[0] + 1 // 최소거리의 최대

  var answer = 1

  while(low < high) {
    val mid = (low + high) / 2

    // 설치 가능한 공유기 개수가 C보다 작으면, 거리 좁히기
    if(wifi(mid) < C) {
      high = mid
    }
    // 설치 가능한 공유기 개수가 C보다 크거나 같으면, 거리 넓히기
    else {
      low = mid + 1
      answer = mid  // 일단 거리가 mid일 때 공유기 C개 설치 가능하므로 체크
    }
  }

  print(answer)
}
// 최소거리가 d일 때 설치할 수 있는 와이파이 공유기
fun wifi(d: Int): Int {
  var cnt = 1
  var preHouse = house[0] // 제일 가까운 곳에 설치한 공유기

  for(i: Int in 1..house.size - 1) {
    // 거리가 d 이상
    if(house[i] - preHouse >= d) {
      cnt++
      preHouse = house[i]
    }
  }

  return cnt
}