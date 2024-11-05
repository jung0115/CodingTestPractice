# 백준 - 랜선 자르기(1654)
import sys

K, N = map(int, sys.stdin.readline().split())

lines = []
for i in range(K) :
  lines.append(int(sys.stdin.readline()))

left = 1
right = max(lines)

while left <= right :
  mid = (left + right) // 2
  
  count = 0
  for line in lines :
    count += line // mid
  
  if(count >= N) :
    left = mid + 1
  else :
    right = mid - 1

print(right)