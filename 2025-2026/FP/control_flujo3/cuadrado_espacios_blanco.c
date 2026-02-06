#include <stdlib.h>
#include <stdio.h>


int main(){

	int n=0;
	printf("Dime un número y te daré un cuadrado hueco de altura");
	scanf("%d", &n);

	for(int i =0; i<n; i++){
		for(int j = 0; j<n;j++){
			if(i == 0 || i == n -1 || j == 0 || j == n-1)
				printf("*");
			else 
				printf(" ");
		}
		printf("\n");
	}

return 0;
}
