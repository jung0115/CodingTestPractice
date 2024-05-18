// 백준 - 경사로(14890)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 경사로 겹치는 거 체크해야함

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt()
  val L = st.nextToken().toInt()

  val map = Array(N, {Array(N, {0})})

  for(i: Int in 0..N-1) {
    st = StringTokenizer(br.readLine())
    for(j: Int in 0..N-1) {
      map[i][j] = st.nextToken().toInt()
    }
  }

  var answer = 0

  for(i: Int in 0..N-1) {
    // 지나갈 수 있는 길인지 체크
    var row = true
    var col = true

    // 경사로 놓은 위치 체크
    val rowSelected = Array(N, {false})
    val colSelected = Array(N, {false})

    for(j: Int in 1..N-1) {
      // 앞과의 차이
      val rowSub = map[i][j-1] - map[i][j]
      val colSub = map[j-1][i] - map[j][i]

      // 행 체크 - 1이상 차이 = 경사로도 못 놓음
      if(rowSub > 1 || rowSub < -1) row = false
      // 행 체크 - 앞이 더 큼
      else if(row && rowSub == 1) {
        // 이미 경사로가 놓아져있어서 경사로 놓을 수 없음
        if(rowSelected[j]) {
          row = false
        }
        // 경사로 놓기 시도
        else {
          var cnt = 1
          rowSelected[j] = true
          while(cnt < L) {
            // 범위 벗어나거나 경사로가 이미 설치된 곳이면 불가
            if(j + cnt >= N || rowSelected[j + cnt]) break
            // 높이가 다르면 불가
            if(map[i][j + cnt] != map[i][j]) break
            rowSelected[j + cnt] = true // 경사로 설치
            cnt++
          }
          if(cnt < L) row = false
        }
      }
      // 행 체크 - 뒤가 더 큼
      else if(row && rowSub == -1) {
        // 이미 경사로가 놓아져있어서 경사로 놓을 수 없음
        if(rowSelected[j - 1]) {
          row = false
        }
        // 경사로 놓기 시도
        else {
          var cnt = 1
          rowSelected[j - 1] = true
          while(cnt < L) {
            // 범위 벗어나거나 경사로가 이미 설치된 곳이면 불가
            if(j - cnt - 1 < 0 || rowSelected[j - cnt - 1]) break
            // 높이가 다르면 불가
            if(map[i][j - cnt - 1] != map[i][j-1]) break
            rowSelected[j - cnt - 1] = true // 경사로 설치
            cnt++
          }
          if(cnt < L) row = false
        }
      }

      // 열 체크 - 1 이상 차이 = 경사로도 못 놓음
      if(colSub > 1 || colSub < -1) col = false
      // 열 체크 - 위가 더 큼
      else if(col && colSub == 1) {
        // 이미 경사로가 놓아져있어서 경사로 놓을 수 없음
        if(colSelected[j]) {
          col = false
        }
        // 경사로 놓기 시도
        else {
          var cnt = 1
          colSelected[j] = true
          while(cnt < L) {
            // 범위 벗어나거나 경사로가 이미 설치된 곳이면 불가
            if(j + cnt >= N || colSelected[j + cnt]) break
            // 높이가 다르면 불가
            if(map[j + cnt][i] != map[j][i]) break
            colSelected[j + cnt] = true // 경사로 설치
            cnt++
          }
          if(cnt < L) col = false
        }
      }
      // 열 체크 - 위가 더 큼
      else if(col && colSub == -1) {
        // 이미 경사로가 놓아져있어서 경사로 놓을 수 없음
        if(colSelected[j - 1]) {
          col = false
        }
        // 경사로 놓기 시도
        else {
          var cnt = 1
          colSelected[j - 1] = true
          while(cnt < L) {
            // 범위 벗어나거나 경사로가 이미 설치된 곳이면 불가
            if(j - cnt - 1 < 0  || colSelected[j - cnt - 1]) break
            // 높이가 다르면 불가
            if(map[j - cnt - 1][i] != map[j-1][i]) break
            colSelected[j - cnt - 1] = true // 경사로 설치
            cnt++
          }
          if(cnt < L) col = false
        }
      }

      // 행, 열 둘다 못 지나가면 중지
      if(!row && !col) break
    }

    // 행 지나갈 수 있음
    if(row) {
      answer++
      //println("row " + i.toString())
    }
    // 열 지나갈 수 있음
    if(col) {
      answer++
      //println("col " + i.toString())
    }
  }

  print(answer)
}