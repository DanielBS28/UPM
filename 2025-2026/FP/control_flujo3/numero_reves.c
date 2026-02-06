#include <stdlib.h>
#include <stdio.h>


int main(){

	int numero;
	int aux_num;
	int reves = 0;
	int digito = 0;
	printf("Dime el número y le daremos la vuelta");
	scanf("%d",&numero);
	aux_num = numero;

	while(numero != 0){
	
		digito=numero%10;
		reves= reves*10+ digito;
		numero/=10;
	
	}

	printf("El número %d al reves es: %d", aux_num, reves);

return 0;
}
