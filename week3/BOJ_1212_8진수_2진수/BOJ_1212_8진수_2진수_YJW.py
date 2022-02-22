# 1212 8진수 2진수

import sys

tmp = 0
tmp = bin(int(input(),8)).replace("0b","") # int(a,8)  : 8진수 a를 10진수로 변환, 2진수 접두어(0b)제거

print(tmp)

# 입력받은 8진수를 -> 10진수로 변환
# tmp = int(input(),8)

# 10진수를 2진수로 변환
# tmp = bin(tmp).replace("0b","")


## python의 10진수 ->2,8,16진수 변환 내장함수
# bin() : 10진수 -> 2진수
# oct() : 10진수 -> 8진수
# hex() : 10진수 -> 16진수
