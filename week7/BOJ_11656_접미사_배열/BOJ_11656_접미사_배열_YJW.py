# 11656 접미사 배열

import sys
from sys import stdin

words = sys.stdin.readline().strip('\n')
li = list(words)
new_li = []
suffix = []

for i in range(len(words)):
    suffix.append(li[i:])

for i in suffix:
    new_li.append((''.join(i)))
    new_li.sort()

for i in new_li:
    print(i)
