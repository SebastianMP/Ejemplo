import random
import time
def merge(left, right):
    if not len(left) or not len(right):
        return left or right

    result = []
    i, j = 0, 0
    while (len(result) < len(left) + len(right)):
        if left[i] < right[j]:
            result.append(left[i])
            i+= 1
        else:
            result.append(right[j])
            j+= 1
        if i == len(left) or j == len(right):
            result.extend(left[i:] or right[j:])
            break 

    return result

def mergesort(list):
    if len(list) < 2:
        return list

    middle = len(list)/2
    left = mergesort(list[:middle])
    right = mergesort(list[middle:])

    return merge(left, right)

for y in range(1,45000,2500):
  example = []
  for x in range(1,y):
    example.append(random.randint(1,10000)) 
  start = time.time()
  mergesort(example)
  end = time.time()
  print "tiempo estimado con "+str(y)+"elementos"
  print(end - start)