#include <stdlib.h>
#include <stdio.h>


int main(){

	int n;
	printf("Dime la altura de la piramide");
	scanf("%d", &n);

	for(int i=1; i<=n;i++){	
		for(int j = 1; j<=n-i;j++)
			printf(" ");
		
	/*Podría usar j en vez de z*/			
		for(int z = 1; z<=2*i-1;z++)
			printf("*");

	printf("\n");
				
	}	

return 0;
}
