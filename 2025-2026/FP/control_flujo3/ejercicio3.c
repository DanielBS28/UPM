#include <stdlib.h>
#include <stdio.h>


int main(){
	int n1, abs;
	printf("Dime un número y te daré su valor absoluto");
	scanf("%d",&n1);
	if(n1 < 0)
	abs=n1*-1;
	else 
	abs = n1;
	printf("El número en valor absoluto del número %d es: %d",n1,abs);

return 0;
}
