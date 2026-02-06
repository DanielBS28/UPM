#include <stdlib.h>
#include <stdio.h>


int main(){

	int n;
	printf("Dime un número y te daré la tabla de multiplicar de ese número hasta el 9");
	scanf("%d",&n);
	
	for(int i = 1; i<10;i++)
		printf("%d x %d = %d\n",i,n,i*n);
return 0;
}
