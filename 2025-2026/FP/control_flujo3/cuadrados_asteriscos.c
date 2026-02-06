#include <stdlib.h>
#include <stdio.h>


int main(){
	

	int altura, anchura;
	printf("Dime altura del cuadrado");
	scanf("%d",&altura);
	printf("Dime la anchura del cuadrado");
	scanf("%d",&anchura);

	for(int i = 0; i<altura; i++){
		for(int j =0; j<anchura;j++)
			printf("*");
		printf("\n");
	}


return 0;
}
