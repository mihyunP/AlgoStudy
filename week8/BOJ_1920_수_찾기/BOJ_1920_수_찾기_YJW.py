# 1920 수 찾기

# 이진탐색
# 이진 탐색이란 데이터가 정렬돼 있는 배열에서 특정한 값을 찾아내는 알고리즘.
# 배열의 중간에 있는 임의의 값을 선택하여 찾고자 하는 값 X와 비교한다.
# X가 중간 값보다 작으면 중간 값을 기준으로 좌측의 데이터들을 대상으로,
# X가 중간값보다 크면 배열의 우측을 대상으로 다시 탐색한다.
# 동일한 방법으로 다시 중간의 값을 임의로 선택하고 비교한다.
# 해당 값을 찾을 때까지 이 과정을 반복한다.


import sys
from sys import stdin

n = int(input())
n_li = list(map(int, input().split()))
# n_li = list(map(int, sys.stdin.readline().split()))
n_li.sort()

m = int(input())
m_li = list(map(int, input().split()))
# m_li = list(map(int, sys.stdin.readline().split()))

def b_srch(target,n_li):
    left = 0
    right = n-1

    while left<=right:
        mid = (left+right)//2

        if target == n_li[mid]:
            return 1
        elif target < n_li[mid]:
            right = mid-1
        elif target > n_li[mid]:
            left = mid+1
    return 0


for i in range(m):
    print(b_srch(m_li[i],n_li))
