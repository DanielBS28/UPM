#include <stdio.h>

int main(){

	int numero1, numero2, numero3;
	printf("Dime un número y te diré si es mayor que el segundo");
	scanf("%d",&numero1);
	printf("Dime el segundo número");
	scanf("%d",&numero2);
	printf("Dime el tercer número");
	scanf("%d",&numero3);
	
	printf("El número mayor es: %d", (numero1>numero2 && numero1>numero3) ? numero1 : (numero2>numero3) ? numero2 : numero3);
	
	
	return 0;
}
