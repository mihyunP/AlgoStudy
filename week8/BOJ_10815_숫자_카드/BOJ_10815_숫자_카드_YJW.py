# 10815 숫자 카드

import sys
from sys import stdin

def binary_srch(target,n_li):
    left = 0
    right = n-1

    while left<=right:
        mid = (left+right)//2
        if target == n_li[mid]:
            return True
        elif target < n_li[mid]:
            right = mid-1
        elif target > n_li[mid]:
            left = mid+1
    return False

n = int(sys.stdin.readline())
n_li = list(map(int, sys.stdin.readline().split()))
n_li.sort()

m = int(sys.stdin.readline())
m_li = list(map(int, sys.stdin.readline().split()))

for i in range(m):
    if binary_srch(m_li[i],n_li)==True:
        print(1)
    else:
        print(0)
