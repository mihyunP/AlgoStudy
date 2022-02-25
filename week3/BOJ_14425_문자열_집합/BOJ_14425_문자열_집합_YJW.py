# 14425 문자열 집합

import sys

n,m = map(int, input().split())

s = []
cnt =0

for i in range(n):
    s.append(sys.stdin.readline().rstrip('\n'))

for i in range(m):
    tmp = sys.stdin.readline().rstrip('\n')
    if tmp in s:
        cnt+=1
print(cnt)
