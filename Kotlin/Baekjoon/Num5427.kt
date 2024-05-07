// 백준 - 불(5427)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue

data class Fire (
  val x: Int,
  val y: Int
)
data class Person (
  val x: Int,
  val y: Int,
  val time: Int
)

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var map: Array<Array<Char>> = arrayOf()                 // 빌딩 지도
var person = LinkedList<Person>() as Queue<Person> // 상근이 위치
var fire = LinkedList<Fire>() as Queue<Fire>       // 불 위치

var w = 0
var h = 0
var testResult = 0

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  val T = br.readLine().toInt()
  var answer = StringBuilder()

  for(i: Int in 0..T-1) {
    val st = StringTokenizer(br.readLine())
    w = st.nextToken().toInt() // 너비
    h = st.nextToken().toInt() // 높이

    map = Array(h, {Array(w,{' '})}) // 빌딩 지도
    person = LinkedList<Person>() as Queue<Person> // 상근이 위치
    fire = LinkedList<Fire>() as Queue<Fire>      // 불 위치

    for(j: Int in 0..h-1) {
      val input = br.readLine()
      for(k: Int in 0..w-1) {
        map[j][k] = input[k]
        if(map[j][k].equals('@')) person.offer(Person(j, k, 0))
        else if(map[j][k].equals('*')) fire.offer(Fire(j, k))
      }
    }

    testResult = 0
    bfs()
    if(testResult == 0)
      answer.append("IMPOSSIBLE\n")
    else
      answer.append(testResult).append("\n")
  }

  print(answer)
}

fun bfs() {
  while(!person.isEmpty()) {
    val fireCnt = fire.size
    val personCnt = person.size

    for(i: Int in 0..fireCnt-1) {
      val cur = fire.poll()
      // 불이 상하좌우로 번짐
      for(j: Int in 0..3) {
        val moveX = cur.x + dx[j]
        val moveY = cur.y + dy[j]

        // 공간 범위 벗어나거나 이미 불인 경우, 벽인 경우 패스
        if(moveX < 0 || moveX >= h || moveY < 0 || moveY >= w || map[moveX][moveY].equals('#') || map[moveX][moveY].equals('*')) continue

        // 불 번짐
        map[moveX][moveY] = '*'
        fire.offer(Fire(moveX, moveY))
      }
    }

    for(i: Int in 0..personCnt-1) {
      val cur = person.poll()
      // 상근이가 상하좌우로 이동
      for(j: Int in 0..3) {
        val moveX = cur.x + dx[j]
        val moveY = cur.y + dy[j]

        // 공간 범위 벗어나면 탈출 성공
        if(moveX < 0 || moveX >= h || moveY < 0 || moveY >= w) {
          testResult = cur.time + 1
          return
        }

        // 이동 가능한 길이면 이동
        if(map[moveX][moveY].equals('.')) {
          map[moveX][moveY] = '@' // 재방문 방지
          person.offer(Person(moveX, moveY, cur.time + 1))
        }
      }
    }
  }
}