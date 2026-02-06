#include <stdlib.h>
#include <stdio.h>


int main(){

	int n1,n2;
	printf("Dime un numero y te diré si es divisor de otro");
	scanf("%d",&n1);
	printf("Dime el otro número y te diré si es divisor");
	scanf("%d",&n2);
	
	if(n1 % n2 == 0)
	printf("El número %d es divisor de %d",n1,n2);
	else 
	printf("El número %d no es divisor de %d",n1,n2);
return 0;
}
