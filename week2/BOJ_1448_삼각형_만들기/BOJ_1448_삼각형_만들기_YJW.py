# 1448 삼각형 만들기
# idea : 삼각형의 두변의 합은 가장 긴 변보다 작다 !

import sys

n = int(sys.stdin.readline())
tri = []
for _ in range(n):
    # tri.append(int(input()))
    tri.append(int(sys.stdin.readline()))

tri.sort(reverse=True)

# 삼각형 가장 긴 변의 길이 < 두변의 합
result=0
for i in range(n-2):
    if tri[i] < tri[i+1]+tri[i+2]:
        result = tri[i]+tri[i+1]+tri[i+2]
        break
    else:
        result =-1
print(result)
