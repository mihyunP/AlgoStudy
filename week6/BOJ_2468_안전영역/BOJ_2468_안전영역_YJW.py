# 2468 안전 영역

#idea
# 최고높이 구하기? 0~(최고높이-1)까지 다 돌고 최대개수가 나오는 높이가 최고높이

import sys
from collections import deque

n = int(input())
maxHigh = 0
zone = []
# zone = [list(map(int,input().split())) for _ in range(n)]

for i in range(n):
    zone.append(list(map(int, input().split())))
    for j in range(n):
        if zone[i][j]>maxHigh:
            maxHigh=zone[i][j]

# 상하좌우
dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(a,b,value,visited):
    q = deque()
    q.append((a,b))
    visited[a][b]=1

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x+ dx[i]
            ny = y+ dy[i]
            if (0<=nx<n) and 0<=ny<n:
                if zone[nx][ny] > value and visited[nx][ny]==0:
                    visited[nx][ny]=1
                    q.append((nx,ny))

result=0
for i in range(maxHigh):
    visited=[[0]*n for i in range(n)]
    cnt =0

    for j in range(n):
        for k in range(n):
            if zone[j][k]>i and visited[j][k]==0:
                bfs(j,k,i,visited)
                cnt+=1

    if result<cnt:
        result=cnt
print(result)ㅠ
