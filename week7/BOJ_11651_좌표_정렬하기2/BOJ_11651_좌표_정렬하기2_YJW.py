# 11651 좌표정렬하기2

import sys

n = int(input())
li= []

for i in range(n):
    x,y= map(int, input().split())
    li.append([y,x])

li.sort()

for y,x in li:
    print(x,y)
