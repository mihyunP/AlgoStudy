import sys
sys.setrecursionlimit(10**6)

t = int(input())

def search(x,y):
    if x < 0 or x >= M or y < 0 or y >= N:
        return

    if field[x][y] == 0:
        return

    field[x][y] = 0 # 탐색한 배추는 0으로 갱신

    # 상하좌우 탐색
    search(x, y+1)
    search(x,y-1)
    search(x+1, y)
    search(x-1, y)


for _ in range(t):
    N, M, K = map(int, input().split()) # 가로길이, 세로길이, 배추 수
    field = [[0] * N for _ in range(M)]

    cnt = 0

    # 배추밭 생성
    for _ in range(K):
        a,b = map(int,input().split())
        field[b][a] = 1     # 배추 위치 표시하기

    for i in range(M):
        for j in range(N):
            if field[i][j] == 1: # 배추가 존재하는 경우
                search(i,j) # 인접 배추 탐색
                cnt += 1    # 인접 배추 탐색 끝나면, 지렁이 수 증가

    print(cnt)
