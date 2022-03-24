# 10825 국영수

import sys

n = int(input())
li = []

for _ in range(n):
    name, kor, eng, math = sys.stdin.readline().split()
    kor = int(kor)
    eng = int(eng)
    math = int(math)
    li.append([name,kor,eng,math])

sorted_li = sorted(li, key=lambda x: (-x[1], x[2], -x[3], x[0]))

for sl in sorted_li:
    print(sl[0])
