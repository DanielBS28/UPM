#include <stdlib.h>
#include <stdio.h>


int main(){

	struct Alumno{
	char nombre[30];
	float n1, n2,n3;
	};

	struct Alumno alumnos[50];


	for(int i = 0; i<50;i++){
		printf("Pon el nombre del alumno");
		scanf("%s",alumnos[i].nombre);
	
		printf("Indica las notas del alumno");
		scanf("%f %f %f", &alumnos[i].n1,&alumnos[i].n2,&alumnos[i].n3);
	}

	struct DNI {
		unsigned num;
		char letra;
	};

	struct DNI dni[50];

	//Para inicializar un struct struct DNI dni_base = {0000000001, 'A'};
	//O también para inicalizarlo todo

	/*
	
	struct DNI dnis[100];
	for(int i=0;i<100;i++){
		dnis[i] = dni_base;
	}

	En el caso de que queramos inicalizar 2 por ejemplo:

	struct DNI dnis[2] = {{111111111,'A'},{12222222222,'B'}};
	
	*/
return 0;
}
