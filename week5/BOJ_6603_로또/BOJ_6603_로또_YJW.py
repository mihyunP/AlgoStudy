# 6603 로또

import sys
from itertools import combinations

while True:
    # 전체 입력받기
    s = list(map(int, input().split()))

    # 입력받은 첫번째 숫자는 k로 분리하기
    k = s.pop(0)

    # 종료조건
    if k==0 :
        break

    # 조합 사용하기 sCr
    lotto = list(combinations(iterable=s, r=6))

    for i in lotto:
        for j in i:
            print(j,end=' ')
            # print(j)
        print()
    print()
