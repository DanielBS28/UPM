#include <stdlib.h>
#include <stdio.h>


//Prototipo de una función 

// int max(int n1, int n2, int n3); Esto sirve para que si pongo las funciones abajo no me de error si las pongo debajo del main 

int max_tres(int n1, int n2, int n3){ 

	if(n1 > n2 && n1 > n3)
		return n1;
	else if(n2 > n3)
		return n2;
	else 
		return n3;

}



int max_tresPRO(int n1, int n2, int n3){ 

	return (n1 > n2 && n1 > n3) ? n1 : (n2 > n3) ? n2 : n3;

}

int main(){
	
	printf("El número mayor es %d\n", max_tres(1,2,3));
	printf("El número mayor es %d\n", max_tres(1,3,1));
	printf("El número mayor es %d\n", max_tres(3,1,2));

	printf("El número mayor es %d\n", max_tresPRO(1,2,3));
	printf("El número mayor es %d\n", max_tresPRO(1,3,1));
	printf("El número mayor es %d\n", max_tresPRO(3,1,2));


return 0;
}

