#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main(){

	char * mem_dinamic = NULL;

	{
	char buffer[99+1];	
	printf("Dime una frase menos de 100 caracteres");
	fgets(buffer, 100*sizeof(char),stdin);

	int tam=strlen(buffer);
	mem_dinamic = (char*)malloc((tam+1)*sizeof(char));

	
	for(int i = 0; i<tam+1;i++)
	*(mem_dinamic + i) = *(buffer+i);

	}
	
	printf("%s",mem_dinamic);
	
	free(mem_dinamic);
	mem_dinamic = NULL;

	
		
	
return 0;
}
