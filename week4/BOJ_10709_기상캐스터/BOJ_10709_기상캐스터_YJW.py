import sys

h,w = map(int,input().split())
pred = [[0]* w for i in range(h)]
region = [list(map(str,input())) for _ in range(h)]

# cloud값 False로 초기화
cloud = False

for i in range(h):
    cloud = False
    num = 1

    for j in range(w):
        # 구름(c)이 없는 경우(.) -> -1
        if cloud==False and region[i][j] =='.':
            pred[i][j] = -1

        # 구름(c)이 있는 경우 -> 0
        elif region[i][j] =='c':
            cloud= True 
            pred[i][j] = 0
            num = 1 

        # 구름(c)이 지나갈 예정인 경우 -> 1, 2, 3 ... 다음 칸마다 누적되며 증가가
        elif cloud == True and region[i][j] =='.':
            pred[i][j] = num
            num += 1 


# 결과 출력하기
for i in range(h):
    for j in range(w):
        print(pred[i][j],end=' ')
    print()
