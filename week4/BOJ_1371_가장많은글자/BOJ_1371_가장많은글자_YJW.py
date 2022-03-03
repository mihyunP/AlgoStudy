# 1371 가장 많은 글자

import sys
# 줄바꿈과 공백을 제거하여 전체를 입력받기
data = sys.stdin.read().replace('\n','').replace(' ','')

alpha = [0]*26

# 유니코드 값을 돌려주는 ord함수 사용
# ord(a)=97 이므로, alpha리스트에 각 알파벳 갯수 카운트 하기
for i in data:
    alpha[ord(i)-97] +=1


# alpha리스트에서 가장 갯수가 많은 알파벳 번호 뽑기
max_val = max(alpha)

# ord함수와 반대인 chr함수를 사용해서 max_val을 유니코드->알파벳으로 만들기
for i in range(len(alpha)):
    if alpha[i] == max_val:
        print(chr(i+97),end='')
