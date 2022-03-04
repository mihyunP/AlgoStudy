# 10994 별 찍기

import sys

n = int(input())
star_len = 4*n-3
star_li =[[' ' for _ in range(star_len)] for _ in range(star_len)]


def fill_star(n,x,y):
    if n ==1:
        star_li[y][x]='*'
        return

    for i in range(4*n-3):
        star_li[y][x+i]='*'
        star_li[y+i][x]='*'
        star_li[y+(4*n-3)-1][x+i]='*'
        star_li[y+i][x+(4*n-3)-1]='*'
    fill_star(n-1,x+2,y+2)

fill_star(n,0,0)

for j in star_li:
    print(''.join(j))
