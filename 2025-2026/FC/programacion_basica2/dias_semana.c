#include <stdio.h>


int main(){

	int dia;
	printf("Dime un número y te diré el día");
	scanf("%d",&dia);
	
	if(dia==1)
	printf("Lunes");
	
	else if(dia==2)
	printf("Martes");
	
	else if(dia==3)
	printf("Miércoles");
	
	else if(dia==4)
	printf("Jueves");
	
	else if(dia==5)
	printf("Viernes");
	
	else if(dia==6)
	printf("Sábado");
	
	else if(dia==7)
	printf("Domingo");
	
	return 0;
}
