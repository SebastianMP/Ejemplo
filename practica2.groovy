class practica2
{
	static def BurbujaSimple(A, int n)
	{
		int temp;
			for(int i=1; i<n; i++)
			{
				for(int j=0; j<n-1; j++)
				{
					if(A[j]>A[j+1] )
					{
						temp=A[j];
						A[j]= A[j+1];
						A[j+1]=temp;
					}			
				}
			}	
	}

	static def void BurbujaMejorada( A, int n)
	{
			int temp;
			for(int i=1; i<n; i++)
			{
				for(int j=0; j<i; j++)
				{
					if(A[i]<A[j] )
					{
						temp=A[j];
						A[j]= A[i];
						A[i]=temp;
					}			
				}

			}

	}
	static def Insercion( A, n)
	{
		int temp,j,i
		for(i=1; i<n;i++)
		{
			temp=A[i]
			j=i-1
			while(A[j]>temp && j>=0) 
			{
				A[j+1]=A[j]
				j--
			}
			A[j+1]=temp
		}
	}
	static def Ordena(int a,int b,int c)
	{
		if(a>b)
			if (a>c)
				if(b>c)
					this.salida(a,b,c) 
				else
					this.salida(a,c,b)
			else
				this.salida(c,a,b)
		else
			if(b>c)
				if(a>c)
					this.salida(b,a,c)
				else
					salida(b,c,a)
			else
			salida(c,b,a)
	}
	static def Selecion( A, n)
	{
		int k,i,temp,p
		for(i=0; k<n-1;k++)
		{
			p=k
			for(i=k+1; k<n-1;k++)
			{
				if (A[i]<A[p]) {
					p=i
				}
				if (p!=k) {
					temp =A[p]
					A[p]=A[k]
					A[k]=temp
				}
			}
		}
	}
	static def salida(a,b,c)
	{
		print "$a , $b, $c"
	}
	static main(args)
	{
		int i,j,k 
		for(j=10;j<45000;j+=2500)
		{

			def arr 	= []
			def arr2 	= []
			for(i=0;i<j;i++)
			{
				arr << (Math.abs(new Random().nextInt() % 600) + 1)
			}

			for(k=0;k<j;k++)
			{
				arr2 << (Math.abs(new Random().nextInt() % 23993842) + 1)
			}
		println "------------------con $j elementos"	
		println "Insercion:"
		long startTime = System.currentTimeMillis();
		this.Insercion(arr, j)
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);

      	println "BurbujaSimple"
		startTime = System.currentTimeMillis();
		this.BurbujaSimple(arr, j)
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
      	println "BurbujaMejorada"

      	startTime = System.currentTimeMillis();
		this.BurbujaMejorada(arr, j)
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);

      	println "Ordena"
      	startTime = System.currentTimeMillis();
		this.Ordena(4,7,3)
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);

      	println "Selecion"
      	startTime = System.currentTimeMillis();
		this.Selecion(arr, j)
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
		

		}
	}

}