// LeetCode - 2358. Maximum Number of Groups Entering a Competition
class Solution {
  fun maximumGroups(grades: IntArray): Int {
    // grade가 작은 학생부터 앞 그룹에 배치하면 됨
    // 학생 수에따라 그룹 수가 달라짐
    var answer = 0        // 그룹 수
    var studentCount = 0  // 그룹에 들어간 학생 수

    while(studentCount < grades.size) {
      // 만약 앞 그룹 수보다 적은 인원이 남았다면
      if(answer >= grades.size - studentCount) break

      // n번 그룹에 n명 배치
      answer++;
      studentCount += answer
    }

    return answer
  }
}