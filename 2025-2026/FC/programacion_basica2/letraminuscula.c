#include <stdio.h>

int main()
{
	char letra_minus, letra_mayus;
	printf("Dime una letra minuscula y te daré la mayuscula");
	scanf("%c",&letra_minus);
	
	letra_mayus = 'A'-'a';

	printf("%c", letra_mayus+letra_minus);
	
	return 0;

}



