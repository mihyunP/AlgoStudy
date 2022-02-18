import sys
coin=[]

# 입력받기
n,k = map(int, input().split())
for _ in range(n):
    coin.append(int(input()))

coin.sort(reverse=True)


res=0
# 방법1
for i in coin:
    cnt = 0
    if k >= i:
        cnt = k//i
        k -= cnt*i
        res+=cnt
print(res)


# 방법2 (간결버전)
# 몫으로 나누어진 나머지의 값을 다시 최종 값에 대입하는 방식으로 진행
cnt2=0
for j in coin:
  cnt2+=k//j
  k=k%j
print(cnt2)
