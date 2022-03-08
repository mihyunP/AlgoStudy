#1780 종이의 개수
# 첫째 줄에 -1로만 채워진 종이의 개수를,
# 둘째 줄에 0으로만 채워진 종이의 개수를,
# 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

import sys

n=int(input())

paper = [list(map(int,input().split())) for _ in range(n)]
# print(paper)

minus=0
zero=0
plus=0

def checkPaper(x,y,n):
    global minus,zero,plus

    for i in range(x,x+n):
        for j in range(y,y+n):

            if (paper[i][j] != paper[x][y]):
                for k in range(3):
                    for l in range(3):
                        checkPaper(x+k*n//3, y+l*n//3, n//3)
                return
    if paper[x][y] == -1:
        minus+=1
    elif paper[x][y] == 0:
        zero+=1
    else:
        plus+=1

checkPaper(0,0,n)

print(minus)
print(zero)
print(plus)
