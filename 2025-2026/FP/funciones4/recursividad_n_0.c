#include <stdlib.h>
#include <stdio.h>

void recursividad(int n){
	
	if(n == 0)
		printf("0");
	else {
		printf("%d ", n);
		recursividad(n-1);
	}
}

int main(){

	recursividad(50);

return 0;
}
