#include <stdlib.h>
#include <stdio.h>


int main(){
	
	int altura = 0; 
	printf("Dime la altura de la piramide");
	scanf("%d", &altura);
	
	for(int i = 0; i <altura; i++){
		for(int j = altura*2-i; j<altura*2; j++)
			printf(" ");
		for(int j = 0; j<(altura*2-(i*2))-1;j++)
			printf("*");
		printf("\n");
	}
return 0;
}
