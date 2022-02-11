# 문제 : 최고의 피자
# 최고의피자 : 1원당 열량이 가장 높은 피자 <- 가격은 최선, 열량은 최고

# 토핑 N개 중 여러개 선택 가능(토핑없는 경우도 가능)
# 단, 같은 종류의 토핑 2개 이상 선택 불가
# 도우가격 = A원, 토핑가격 = B원(토핑 가격 모두 같음) -> * 높은 열량 기준으로 찾기
# 피자 가격 = 도우가격+토핑가격 = A+B*k(k:토핑종류)
# 피자 열량 = 도우열량(C)+토핑열량(D1,D2..)
# 최고의 피자 1원당 열량 구하기

import sys
n = int(input())
a, b = map(int, input().split())
c = int(input())
d = []

for i in range(n):
    d.append(int(input()))

d.sort(reverse=True)

kcalToping = 0
best = 0
k = 0

for i in d:
    kcalToping+=i
    kcal = kcalToping + c
    k+=1

    # price = a + b*k
    # tmp = kcal//price
    tmp = kcal//(a + b*k)

    if tmp>=best:
        best = tmp
    else:
        print(int(best))
