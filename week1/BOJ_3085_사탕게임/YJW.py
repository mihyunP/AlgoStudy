n = int(input())

candy = []
for i in range(n):
    candy.append(list(map(str, input())))

# trade -> check

def candyCheck(candy):

    result = 1
    for i in range(n):
        # 행 방항 체크
        cnt = 1
        for j in range(1,n):      #사탕 색상 같으면 cnt 증가
            if candy[j][i]==candy[j-1][i]:
                cnt+=1
            else:               #사탕 색상 다르면 cnt 원상태로
                cnt = 1
            if cnt>result:      # cnt가 2이상인 경우(색상 같은게 2개 이상인 경우) result값에 cnt넣기
                result=cnt

        # 열 방향 체크
        cnt  = 1
        for j in range(1,n):      #사탕 색상 같으면 cnt 증가
            if candy[i][j]==candy[i][j-1]:
                cnt+=1
            else:               #사탕 색상 다르면 cnt 원상태로
                cnt = 1
            if cnt>result:      # cnt가 2이상인 경우(색상 같은게 2개 이상인 경우) result값에 cnt넣기
                result=cnt
    return result

result = 0
# trade하기
for i in range(n):
    for j in range(n):
        if j+1<n:       # 열 기준 교환하기
            candy[i][j],candy[i][j+1] = candy[i][j+1],candy[i][j]
            tmp = candyCheck(candy)

            if tmp>result:
                result = tmp
            # 교환했던 사탕 원래대로 복구
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]


        if i+1 < n:     # 행 기준 교환하기
            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]
            tmp = candyCheck(candy)

            if tmp > result:
                result = tmp
            # 교환했던 사탕 원래대로 복구
            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]

print(result)
