# idea : 일직선 상에서 중간값 구하기.  n//2를 사용하면 답으로 여러값이 도출되어도 가장 작은 값 출력 가능하니 노상관..

import sys
from sys import stdin

n = int(sys.stdin.readline())
house = list(map(int, sys.stdin.readline().split()))

house.sort()

print(house[(n-1)//2])

