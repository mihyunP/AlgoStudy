# 11729 하노이 탑 이동 순서

import sys

#RecursionError: maximum recursion depth exceeded in comparison
#-> 만약 RecursionError 에러발생하면 재귀의 한도 10**6까지 늘려주기
# sys.setrecursionlimit(10**6)

def moveHanoi(num,start,sub,target):
    # 종료조건
    if num == 1:
        print(start,target)

        return

    moveHanoi(num-1, start, target, sub)
    print(start,target)
    moveHanoi(num-1, sub,start,target)

n = int(sys.stdin.readline())
print(2**n-1)
moveHanoi(n,1,2,3)
