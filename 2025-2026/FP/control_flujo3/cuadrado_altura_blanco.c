#include <stdlib.h>
#include <stdio.h>


int main(){

	int altura, anchura;
	printf("Dime la altura del rectangulo");
	scanf("%d", &altura);	
	printf("Dime la anchura del rectangulo");
	scanf("%d", &anchura);


	for(int i =0; i<altura; i++){
		for(int j = 0; j<anchura;j++){
			if(i == 0 || i == altura -1 || j == 0 || j == anchura-1)
				printf("*");
			else 
				printf(" ");
		}
		printf("\n");
	}

return 0;
}
