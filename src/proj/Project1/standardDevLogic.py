# Standard deviation logic
import math
from statistics import stdev

data = [9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4]

def standardDev(dataSet):
  sum = 0
  for d in dataSet:
    sum += d
  
  avg = sum/len(dataSet)

  for d in dataSet:
    temp = (d - avg)
    temp = temp * temp
    sum += math.sqrt(temp)

  return math.sqrt((sum/len(dataSet)))



print(standardDev(data))
print(stdev(data))