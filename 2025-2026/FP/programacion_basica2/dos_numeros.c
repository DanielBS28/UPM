#include <stdio.h>

int main(){

	int numero1, numero2;
	printf("Dime un número y te diré si es mayor que el segundo");
	scanf("%d",&numero1);
	printf("Dime el segundo número");
	scanf("%d",&numero2);
	
	if(numero2>numero1)
	printf("El número mayor es %d", numero2);
	else
	printf("El número mayor es: %d", numero1);
	
	// res=(n1>n2)? n1: n2;
	//printf("El número mayor es: %d", (n1>n2)? n1: n2);
	
	return 0;
}
