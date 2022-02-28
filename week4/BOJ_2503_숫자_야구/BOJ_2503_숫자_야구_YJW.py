# 2503번 숫자 야구
## 완전탐색

# 예시
# 4
# 123 1 1 -> ex:123 s:1 b:1
# 356 1 0
# 327 2 0
# 489 0 1

# 답 :2
# (324, 328 가능)

import sys
from itertools import permutations
data = ['1','2','3','4','5','6','7','8','9']
dataset = list(permutations(iterable=data, r=3)) #원소가 3개인 순열 뽑기

n = int(input())
for _ in range(n):
    ex,s,b = (map(int, input().split()))    #민혁예시 ex:123 s:1 b:1 각각 입력받기
    cnt = 0
    delete = 0

    for j in range(len(dataset)):
        strike=0
        ball=0
        j -= delete
        ex = str(ex)    #순열로 만들어진 dataset이 리스트 str형식이므로 ex도 str로 형변환 필요

        for k in range(3):
            if dataset[j][k]==ex[k]:
            #순열dataset 124의 1과 민혁이 입력한123의 1이 일치하면 strike+=1
                strike+=1

            elif ex[k] in dataset[j]:
            #민혁이 입력한 124의 1이  순열dataset 123에 있으면 ball+=1
                ball+=1

        if strike!=s or ball!=b:
        # 민혁이 입력한 s와 b개수가 순열을 비교해서 만들어진 strike과 ball과 일치 하지 않을경우
        # -> 조건에 부합하지 않는 순열임 -> 순열 리스트에서 삭제시키자
            dataset.remove(dataset[j])
            delete+=1
            
# -> 최종 남아있는 순열의 개수가 가능한 답이될수 있는 수!
print(len(dataset))

