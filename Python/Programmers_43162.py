# 프로그래머스 - 네트워크(Lv.3)
def solution(n, computers):
  visited = [False for _ in range(n)]
  
  def dfs(current):
    visited[current] = True  # 현재 노드 방문 처리
    for i in range(n):
      if computers[current][i] == 1 and not visited[i]:  # 연결되었고 방문하지 않았다면
        dfs(i)  # 다음 노드 탐색
  
  answer = 0
  for i in range(n):
    if not visited[i]:  # 새로운 네트워크를 발견한 경우
      answer += 1
      dfs(i)
    
  return answer