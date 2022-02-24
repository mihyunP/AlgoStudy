# 9342 염색체
#1 문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
#2 그 다음에는 A가 하나 또는 그 이상 있어야 한다.
#3 그 다음에는 F가 하나 또는 그 이상 있어야 한다.
#4 그 다음에는 C가 하나 또는 그 이상 있어야 한다.
#5 그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다.


## key idea
# 정규표현식 문제
# 조건을 1~5 순차조건으로 이해해야 됨...(?)

import sys, re

case  = []
# 입력받기
t = int(sys.stdin.readline())
for _ in range(t):
    case.append(sys.stdin.readline())

# 조건에 부합하는 정규표현식 생성하기
case_regex = re.compile('^[A-F]{0,1}A+F+C+[A-F]{0,1}$') #== re.compile('^[A-F]?A+F+C+[A-F]?$')

for i in case:
    res = case_regex.match(i)   #정규표현식에 부합하는지 체크하기
    # print(res)
    if(res!=None):              #부합하는 경우
        print('Infected!')
    else:                       #부합하지 않는경우(None)
        print('Good')
