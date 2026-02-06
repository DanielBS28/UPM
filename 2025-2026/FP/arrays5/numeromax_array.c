#include <stdlib.h>
#include <stdio.h>

int max_array(int array[], int tamaño){

	int max = array[0];

	for(int i = 0; i<tamaño; i++){
		if(array[i]>max)
		max = array[i];
	}
	return max;
}

int main(){

	int array[]={1,6,8,4,3,9,5,3};
	int array2[]={-4,6,3,10};

	printf("El número máximo del array 1 es: %d:", max_array(array,8));
	printf("\nEl número máximo del array 2 es: %d:", max_array(array2,4));

return 0;
}
