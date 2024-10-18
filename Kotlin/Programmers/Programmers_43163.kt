// 프로그래머스 - 단어 변환(Lv.3)
import java.util.Queue
import java.util.LinkedList

class Solution {
  data class Word(
    val word: String,
    val count: Int
  )
  
  fun solution(begin: String, target: String, words: Array<String>): Int {
    var answer = 51
    var targetIndex = words.indexOf(target)
    
    var visited = Array<Boolean>(words.size) { false }
    
    if(targetIndex == -1) {
      answer = 0
    }
    else {
      val queue: Queue<Word> = LinkedList<Word>()
      queue.offer(Word(begin, 0))
      
      while(queue.isNotEmpty()) {
        val current = queue.poll()
        
        if(current.word == target) {
          answer = current.count
          break
        }
        
        for(i: Int in 0..words.size - 1) {
          if(!visited[i] && isPossibleChange(current.word, words[i])) {
            queue.offer(Word(words[i], current.count + 1))
            visited[i] = true
          }
        }
      }
    }
    
    return answer
}

fun isPossibleChange(str1: String, str2: String): Boolean {
    if(str1.length != str2.length) return false
    
    var isDiff = false
    
    for(i: Int in 0..str1.length - 1) {
      if(str1[i] != str2[i]) {
        if(isDiff) return false
        isDiff = true
      }
    }
    
    return true
  }
}