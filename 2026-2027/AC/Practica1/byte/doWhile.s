; APARTADO 4.1.1
; Suma de dos vectores de tamano BYTE, dejando el resultado en un tercero.

; Direccion de comienzo de las variables
    .data
    .org 0x200
	
vectorA:	.byte  0, 1, 2, 3, 4, 5, 6, 7
; short int vectorA[] = {0, 1, 2, 3, 4, 5, 6, 7}

vectorB:	.byte  1, 1, 1, 1, 1, 1, 1, 1
; short int vectorB[] = {1, 1, 1, 1, 1, 1, 1, 1}

vectorSum:  .space 8
; short int vectorSum [8]

; El simulador WinMIPS no permite dar a las constantes un nombre (etiqueta),
; lo que obliga a utilizar la constante (8) en el codigo

;  Direccion de comienzo del codigo
	.text
    .org 0x0

MAIN: 	 daddi	r1,r0,8		; i = 8

;IMPORTANTE, Vamos al reves, es decir recorreremos el array así: 7-6-5-4-3-2-1-0

DOWHILE: daddi	r1,r1,-1        ; { i = i - 1
	     lb	r2,vectorA(r1)		; r2 = vectorA[i]
  	     lb	r3,vectorB(r1)		; r3 = vectorB [i]
	     dadd r4,r2,r3		    ; r4 = r2 + r3 = vectorA[i] + vectorB[i]
	     sb	r4,vectorSum(r1)	; vectorSum [i] = r4
	     bnez	r1,DOWHILE		; } do while (i > 0), la última vuelta será cuando i valga 1, arriba hará 1-1 = 0 por tanto cuando luego llegue a bnez saltará a halt.
         halt

