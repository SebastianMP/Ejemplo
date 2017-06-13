import math
import time

class karatsuba:

	def _init__(self):
		print "karatsuba"

	def multiply(self, x, y):
		sx = str(x)
		sy = str(y)
		nx = len(sx)
		ny = len(sy)
		if nx==1 or ny==1:
			r = int(x)*int(y)
			return r
		n = nx
		if nx>ny:
			sy = sy.rjust(nx, '0')
			n = nx
		elif ny>nx:
			sx = sx.rjust(ny, '0')
			n = ny
		m = n % 2
		offset = 0
		even = n
		if m!=0:
			n+=1
			offset = 1
		floor = int(math.floor(n/2))-offset
		ceil = int(math.ceil(n/2))-offset
		a = sx[0:floor]
		b = sx[ceil:n]
		c = sy[0:floor]
		d = sy[ceil:n]
		r = ((10**n)*self.multiply(a,c)) + ((10**(n/2))*(self.multiply(a,d) + self.multiply(b,c))) + self.multiply(b,d)
		return r


k = karatsuba();

start = time.time()
print k.multiply(65389223434234234223423242342341345,34012234234234231223423423392342342342127)
end = time.time()
print(end - start)