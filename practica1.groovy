class practica1{

	
	static def Producto2Mayores(A,int n)
	{
		int mayor1,mayor2,i;

		if(A[1] > A[2])
		{
			mayor1 = A[1];
			mayor2 = A[2];
		}
		else
		{
			mayor1 = A[2];
			mayor2 = A[1];
		}
		i = 3
		println "mayor1 $mayor1 "
		println "mayor2 $mayor2"
		while(i<n){

			if(A[i] > mayor1)
			{	

			mayor2 = mayor1;

			mayor1 = A[i];

			}

			else if (A[i] > mayor2)
			{
				mayor2 = A[i];
			}

			i++;

			}

		return  mayor1 * mayor2;


	}

	static def OrdenamientoIntercambio( A,int n)
	{

	int temp,i,j

	for ( i=1; i<n; i++)
		for ( j=i+1; j<n;j++)

			if (A[ j ] < A[ i ]){

				temp=A[ i ];

				A[ i ]=A[ j ];

				A[ j ]=temp;

			}

	}
	static def  MaximoComunDivisor(int m, int n)
	{
		int a,b,residuo;
			a=this.max(n,m);
			b=this.min(n,m);
			residuo=1;
		while(residuo > 0)

		{
			residuo=a % b;
			a=b;
			b=residuo;
		}

		return a;

	}

	static def max(int n,int m)
	{
		if(n>m)
			return n;

		else
			return m;	
	}

	static def min(int n , int m)
	{
		if(n<m)
			return n;

		else
			return m;
	}		


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



			println "---------------------------------"
			println "con $j elementos"
			println "Producto2Mayores"
			long startTime = System.currentTimeMillis();
		this.Producto2Mayores(arr, j)
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
		//
		println "OrdenamientoIntercambio"
		 startTime = System.currentTimeMillis();
		this.OrdenamientoIntercambio(arr2, j)
		 stopTime = System.currentTimeMillis();
		 elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);

		//
		println "MaximoComunDivisor"
		 startTime = System.currentTimeMillis();
		this.MaximoComunDivisor((Math.abs(new Random().nextInt() % 10000) + 1), (Math.abs(new Random().nextInt() % 10000) + 1))
		 stopTime = System.currentTimeMillis();
		 elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
		//
		println "BurbujaSimple"
		 startTime = System.currentTimeMillis();
		this.BurbujaSimple(arr, j)
		 stopTime = System.currentTimeMillis();
		 elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
		
		//
		println "BurbujaMejorada"
		 startTime = System.currentTimeMillis();
		this.BurbujaMejorada(arr, j)
		 stopTime = System.currentTimeMillis();
		 elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
      	println "----------------------------------------"
      }
	}
}