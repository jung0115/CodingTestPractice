// 백준 - Contact(1013)
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
    contact = contact.replace("101", "123")
    if(contact[0] == '0' && contact[1] == '1') {
      contact = "23" + contact.substring(2)
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

    contact = contact.replace("23", "")

    if(contact.length == 0) println("YES")
    else println("NO")
  }
}

// 100+1+ 조건에 맞는가?  
fun check100_1_(contact: String, idx: Int) : Int {
  // 1+가 시작되는 지점
  var startOne = contact.indexOf("1", idx + 2)
  // 없으면 조건에 맞지 않음
  if(startOne == -1) return -1

  // 1+가 끝나는 지점
  var finishOne = startOne
  while(finishOne < contact.length) {
    if(contact[finishOne] == '0') break
    finishOne++
  }

  // 이어서 연달아 오는 0의 끝 지점
  var zero = finishOne + 1
  while(zero < contact.length) {
    if(contact[zero] == '1') break
    zero++
  }

  // 있을 경우 1의 개수가 1개이면 -> 뒤에 01(=23)인지 체크
  if(startOne == finishOne) {
    if(contact[finishOne + 1] == '2' && contact[finishOne + 2] == '3') return finishOne + 3
    else return -1 // 01이 아니다 => 조건 성립 X
  }

  // 1의 개수가 1 이상
  // 뒤에 오는 0의 개수가 1
  if(zero - finishOne == 1) {
    return finishOne
  }
  // 뒤에 오는 0의 개수가 2 이상
  else {
    return finishOne - 1
  }
}