import sys
from sys import stdin

# 체스판의 가로길이 M, 세로길이 N 입력받기 (m:x,n:y)
n ,m = map(int, sys.stdin.readline().split())
result = 0

if n==1:    #세로길이가 1인경우(이동이 불가하므로 시작점만 카운트)
    result=1
elif n==2:  #세로길이가 2인경우
    result= min(4, (m+1)//2)
else:
    if m<=6:
        result = min(4,m)
    else:
        result= m-2

print(result)

##문제이해 어려웠음.. 반복 리뷰하기
