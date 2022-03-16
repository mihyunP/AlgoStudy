# 1260 DFS와 BFS

from collections import deque
import sys

# 정점의 개수 N, 간선의 개수 M, 탐색시작 정점 번호 V
N,M,V = map(int,input().split())

edge = [[] for _ in range(N+1)]

for _ in range(M):
    a,b =map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

for i in edge:
    i.sort()

d_check = [False for _ in range(N+1)]

def dfs(x):
    d_check[x]=True
    print(x, end=' ')
    for y in edge[x]:
        if d_check[y]==False:
            dfs(y)

def bfs():
    queue = deque([V])
    b_check = [False for _ in range(N + 1)]
    b_check[V] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in edge[v]:
            if not b_check[i]:
                b_check[i] = True
                queue.append(i)


dfs(V)
print()
bfs()
print()

