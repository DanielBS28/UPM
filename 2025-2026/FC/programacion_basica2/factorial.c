#include <stdio.h>


int main(){

	int numero;
	int res = 1;
	printf("Dime un número y te daré su factorial");
	scanf("%d",&numero);
	
	for(int i=1; i<=numero;i++)
	res*=i;
	
	printf("El factorial del número %d es %d", numero,res);
	
	return 0;
	
	
}
