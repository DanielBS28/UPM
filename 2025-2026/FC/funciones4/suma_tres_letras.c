#include <stdlib.h>
#include <stdio.h>

int suma_letras(char c1, char c2, char c3){

	return (int)c1 + (int)c2 + (int)c3;
	//return (int)(c1+c2+c3);

}	


int main(){

	printf("La suma de las letras %c, %c, %c es: %d", 'c','q','s', suma_letras('c','q','s'));	

return 0;
}
