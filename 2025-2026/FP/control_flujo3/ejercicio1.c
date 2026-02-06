#include <stdlib.h>
#include <stdio.h>


int main(){

	char c;
	printf("Dame un caracter y te diré si es minuscula, mayuscula u otro caracter");
	scanf("%c", &c);
	
	if(c >= 'a' && c <='z')
		printf("La letra que has introducido es minuscula");
	else if(c >= 'A' && c <='Z')
		printf("La letra que has introducido es mayuscula");
	else if(c >= '0' && c<='9')
		printf("El caracter que has introducido es un digito");
	else 
		printf("El caracter que has introducido es de otro tipo");

return 0;
}

