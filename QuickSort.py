import random
import time
def partition(lst, start, end):
    pos = start                          
                                          

    for i in range(start, end):          
        if lst[i] < lst[end]:             
            lst[i],lst[pos] = lst[pos],lst[i]
            pos += 1

    lst[pos],lst[end] = lst[end],lst[pos] 
                                        
    return pos

def quick_sort_recursive(lst, start, end):
    if start < end:                       
        pos = partition(lst, start, end)
        quick_sort_recursive(lst, start, pos - 1)
        quick_sort_recursive(lst, pos + 1, end)
                                        
                  

for y in range(1,45000,2500):
  example = []
  for x in range(1,y):
    example.append(random.randint(1,10000)) 
  start = time.time()
  quick_sort_recursive(example, 0, len(example) - 1)
  end = time.time()
  print "tiempo estimado con "+str(y)+"elementos"
  print(end - start)
