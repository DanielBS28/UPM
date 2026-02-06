#include <stdlib.h>
#include <stdio.h>

void intercambiar(int array[], int tamaño){

	int n1 = array[0];
	int n2 = array[tamaño -1];

	array[0] = n2;
	array[tamaño-1] = n1;
	
}

void imprimir_array(int array[], int tamaño){

	for(int i=0; i<tamaño;i++)
		printf("%d ", array[i]);
	printf("\n");
}

int main(){

	int array[]={1,6,8,4,3,9,5,3};
	imprimir_array(array,8);
	intercambiar(array,8);
	imprimir_array(array,8);
return 0;
}
