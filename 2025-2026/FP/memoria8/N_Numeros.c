#include <stdlib.h>
#include <stdio.h>


int main(){

	int tamaño = 0;
	
	printf("Dame el tamaño de números que quieres introducir");
	scanf("%d",&tamaño);
	int *numeros = (int*) malloc(tamaño*sizeof(int));
	
	if(numeros != NULL){
		for(int i = 0; i<tamaño; i++){
			printf("Dime el número [%d]: ",i+1);
			scanf("%d", &numeros[i]); //O también (numeros+i) al ser un puntero
		}
	}else{
	printf("Error");
	return 1;
	}
	for(int i = 0; i<tamaño; i++)
		printf("Numero [%d]:  %d\n",i+1,numeros[i]);
	

	free(numeros);
	numeros = NULL;
return 0;
}
	
