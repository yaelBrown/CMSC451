from random import random
import math


# print(math.floor(random() * 10000))
def genRan(n):
  out = ""
  for _ in range(n):
    out += str(math.floor(random() * 10000)) + " "

  print(out)




vals = [600, 700, 800, 900, 1000]

for v in vals:
  genRan(v)
  print("\n")