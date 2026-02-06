#include <stdio.h>

int main()
{
	float altura, base;
	printf("Dime la altura del triángulo: \n");
	scanf("%f",&altura);
	printf("Dime la base del triangulo:\n");
	scanf("%f",&base);
	printf("El area de un triangulo es: %f", (float)(altura*base)/2);
	return 0;

}



