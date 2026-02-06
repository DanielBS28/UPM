#include <stdlib.h>
#include <stdio.h>

void ordenar(int array[], int tamaño){

	int min = array[0];

	for(int i = 0; i<tamaño;i++){
		int k = i;
		for(int j = i; j<tamaño;j++){
		if(array[j]<array[k])
			j = k;
		}
	}
	
}

void intercambiar(int array[], int i, int k){



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
