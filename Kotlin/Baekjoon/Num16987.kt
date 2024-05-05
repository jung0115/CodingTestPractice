// 백준 - 계란으로 계란치기(16987)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

var eggs: Array<Array<Int>> = Array(1, {Array(1, {0})})
var maxEgg = 0

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  var N = br.readLine().toInt()
  eggs = Array(N, {Array(2, {0})})

  for(i : Int in 0..N-1) {
    var st = StringTokenizer(br.readLine())
    eggs[i][0] = st.nextToken().toInt() // 내구도
    eggs[i][1] = st.nextToken().toInt() // 무게
  }
  
  checkAll(N, 0, 0)

  print(maxEgg)
}

// 모든 계란끼리 부딪혀보기
// idx: 부딪혀볼 계란 / broken: 깨진 계란 수
fun checkAll(N: Int, idx: Int, broken: Int) {
  // N개의 계란까지 모두 들어봤거나 더이상 들어볼 계란이 없을 경우
  if(idx == N || broken >= N-1) {
    maxEgg = max(maxEgg, broken)
    return
  }
  // 손에 든 계란이 이미 깨졌으면 다음 계란 들어보기
  if(eggs[idx][0] <= 0) {
    checkAll(N, idx + 1, broken)
    return
  }

  for(i: Int in 0..N-1) {
    // 손에 들고 있는 계란과 같은 계란이거나, 이미 깨져있다면 패스
    if(i == idx || eggs[i][0] <= 0) continue

    // 계란끼리 부딪혀보기
    hit(i, idx)

    // 부딪혀서 깨진 계란 체크
    var newBroken = 0
    if(eggs[i][0] <= 0) newBroken++
    if(eggs[idx][0] <= 0) newBroken++

    // 다음 계란 들어보기
    checkAll(N, idx + 1, broken + newBroken)

    // 부딪히기 전 상태로 복구
    back(i, idx)
  }
}

// 계란 부딪혀보기
fun hit(left: Int, right: Int) {
  eggs[left][0] -= eggs[right][1]
  eggs[right][0] -= eggs[left][1]
}

// 부딪히기 전 상태로 되돌리기
fun back(left: Int, right: Int) {
  eggs[left][0] += eggs[right][1]
  eggs[right][0] += eggs[left][1]
}