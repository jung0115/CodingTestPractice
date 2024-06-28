// 백준 - Contact(1013) - 메모리 초과
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var T = br.readLine().toInt()

  for(i: Int in 1..T) {
    var contact = br.readLine()

    // (100+1+ | 01)+
    // 01 -> 앞에 아무것도 없거나 1이 온다 / 0은 앞에 올 수 없다
    // 01이 확실한 것들을 찾아서 2로 바꾸기
    contact = contact.replace("101", "12")
    if(contact[0] == '0' && contact[1] == '1') {
      contact = "2" + contact.substring(2)
    }

    // 100 찾기
    while(contact.length > 0) {
      // 100의 위치 인덱스
      var idx = contact.indexOf("100")

      // 없을 경우 중지
      if(idx == -1) break

      // 100+1+ 조건에 맞는 수인지 체크
      var checkIdx = check100_1_(contact, idx)
      if(checkIdx == -1) break // 조건에 맞지 않음
      
      // 조건에 맞음 => 맞는 부분 제거
      contact = contact.substring(0, idx) + contact.substring(checkIdx)
    }

    contact = contact.replace("2", "")

    if(contact.length == 0) println("YES")
    else println("NO")
  }
}

// 100+1+ 조건에 맞는가?  
fun check100_1_(contact: String, idx: Int) : Int {
  // 1+가 시작되는 지점
  var startOne = contact.indexOf("01")
  // 없으면 조건에 맞지 않음
  if(startOne == -1) return -1
  startOne++

  // 중간에 2가 있다
  for(i: Int in idx+2..startOne-1) {
    if(contact[i] == '2') return -1
  }

  // 1+가 끝나는 지점
  var finishOne = contact.indexOf("10", startOne)
  // 없을 경우 중간에 2가 있는지 체크
  if(finishOne == -1) {
    for(i: Int in startOne+1..contact.length - 1) {
      if(contact[i] == '2') return -1
    }
    // 2가 없다 -> 뒤가 다 1이라는 뜻이므로 조건 성립
    return contact.length
  }

  // 있을 경우 1의 개수가 1개이면 ~~010~~ 이런 형태 -> 조건에 맞지 않음
  if(startOne == finishOne) return -1

  // 1의 개수가 1 이상
  for(i: Int in startOne+1..finishOne) {
    if(contact[i] == '2') return i
  }
  // 중간에 2가 없다 -> ~~0110~~ -> ~~01까지는 조건에 맞는 게 확실
  return finishOne
}