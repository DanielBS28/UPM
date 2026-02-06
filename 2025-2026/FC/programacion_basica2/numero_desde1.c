#include <stdio.h>


int main(){

	int numero;
	printf("Dime un número y te daré los números desde el 1 hasta ese");
	scanf("%d",&numero);
	
	for(int i=1;i<=numero; i++)
		printf("%d ", i);
	
	return 0;
	
}
