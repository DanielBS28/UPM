#include <stdlib.h>
#include <stdio.h>


int main(){
	
	int n1, n2;
	printf("Dime un número y te diré cual es mayor luego te pedire otro");
	scanf("%d",&n1);
	printf("Dime el otro número");
	scanf("%d",&n2);
	
	if(n1>n2)
	printf("El número %d es mayor que %d", n1,n2);
	else 
	printf("El número %d es mayor que %d", n2,n1);
return 0;
}
