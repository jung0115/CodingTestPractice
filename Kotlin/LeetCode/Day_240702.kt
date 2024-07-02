// LeetCode - 1079. Letter Tile Possibilities
class Solution {
  var answer = 0
  fun numTilePossibilities(tiles: String): Int {
    // 알파벳 개수 세기
    var alphabet ￼= mutableListOf<Int>()
    for(i: Int in 0..25) {
      var alpha = 'A' + i
      alphabet.add(tiles.count { it == alpha })
    }

    calculate(tiles.length, alphabet)

    return answer
  }

  fun calculate(len: Int, alphabet: MutableList<Int>) {
    if(len == 0) return
    
    // 선택한 알파벳을 지운다는 느낌
    // 선택한 것부터 나열해서 타일 만들기
    for(i: Int in 0..25) {
      if(alphabet[i] > 0) {
        alphabet[i]--
        answer++
        calculate(len - 1, alphabet)
        alphabet[i]++
      }
    }
  }
}