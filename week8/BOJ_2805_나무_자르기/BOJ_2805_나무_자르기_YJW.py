#2805 나무 자르기

import sys

N,M = map(int, input().split())
tree = list(map(int, input().split()))
tree.sort() #나무 높이 정렬하기

left=0
right=max(tree)


while left<=right:
    mid = (left + right) // 2
    stack = 0   #잘린 나무

    for i in tree:
        if i>mid:
            stack+= i-mid
            if stack==M:
                break
    if stack >=M:
        left=mid+1
    else:
        right=mid-1

print(right)
