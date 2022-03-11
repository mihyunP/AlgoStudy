# 9934 완전 이진 트리

import sys

k = int(input())
tree = list(map(int, input().split()))

level = [[] for _ in range(k)]

def cbTree(a,b,depth):
    if a==b:
        level[depth].append(tree[a])
        return
    root = a+b//2
    level[depth].append(tree[root])

    cbTree(a, root-1, depth+1)  #왼쪽 하위 서브트리 순회
    cbTree(root+1, b, depth+1)  #오른쪽 하위 서브트리 순회

cbTree(0,len(tree)-1,0)


for i in level:
    for j in i:
        print(j,end=' ')
    print()
