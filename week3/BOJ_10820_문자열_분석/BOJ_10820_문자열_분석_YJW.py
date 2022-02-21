# 10820 문자열 분석
# 첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서
# 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.

import sys
from sys import stdin
sys.setrecursionlimit(100000)
# python has a recurison depth of < 1000~. so for the purpose of this assignment I'm increasing it
#1000개 이상의 재귀는 파이썬에서 기본적으로 제한하고 있기 때문에 위 코드가 재귀의 제한을 풀어줌..

while True:
    line = sys.stdin.readline().rstrip('\n')

    if not line:
        break

    smallA = 0
    bigA = 0
    num = 0
    space = 0

    for i in line:
        if i.islower():
            smallA += 1
        elif i.isupper():
            bigA += 1
        elif i.isdigit():
            num += 1
        elif i.isspace():
            space += 1
    print(smallA, bigA, num, space)
