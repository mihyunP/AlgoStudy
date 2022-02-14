
## idea
# 2 4 5 7 9 정렬       ->  2   5   9   7   4 :답
# [0] [1] [2] [3] [4] -> [0] [2] [4] [3] [1]

import sys
from sys import stdin

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    # l = list(map(int, input().split()))
    l = list(map(int, sys.stdin.readline().split()))

    l.sort()
    gap = 0

    for i in range(n-2):
        gap = max(gap,abs(l[i]-l[i+2]))
    print(gap)

    # for i in range(2, n):
    #     gap = max(gap,abs(l[i]-l[i-2]))
    # -> 런타임 에러(NameError) 발생
    #
    # 참고 : https://www.acmicpc.net/board/view/70327
