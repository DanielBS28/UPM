#include <stdlib.h>
#include <stdio.h>

void area_triangulo(float altura, float base);

int main(){

	area_triangulo(3.5,2);

return 0;
}

void area_triangulo(float altura, float base){

	printf("El area del triangulo es: %f", (base*altura)/2);
}
