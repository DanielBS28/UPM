; ==============================================================================
; Examen: Modificación de un vector de enteros de 16 bits (.word16)
; Operación: vector[i] = vector[i] - 10
; Estructura de control: Bucle Do-While ascendente (0 a 10 bytes)
; ==============================================================================

; Dirección de comienzo de las variables
    .data
    .org 0x110

vector:     .word16 0, 1, 2, 3, 4       ; Vector de 5 elementos de 16 bits (2 bytes c/u)

; Dirección de comienzo del código
    .text
    .org 0x0

MAIN:       daddi   r3, r0, 10          ; r3 = 10 (constante a restar)
            daddi   r10, r0, 10         ; r10 = 10 (límite en bytes: 5 elem * 2 bytes)
            daddi   r1, r0, 0           ; r1 = 0 (offset/desplazamiento inicial en bytes)

DOWHILE:    lh      r2, vector(r1)      ; { r2 = vector[i] (lee 16 bits con signo)
            dsub    r2, r2, r3          ;   r2 = vector[i] - 10
            sh      r2, vector(r1)      ;   vector[i] = r2 (guarda 16 bits modificados)
            daddi   r1, r1, 2           ;   i = i + 2 bytes (salto de elemento .word16)
            slt     r8, r1, r10         ;   ¿r1 < 10? -> r8 = 1 si es cierto, 0 si fin
            bnez    r8, DOWHILE         ; } do while (r1 < 10)

FIN:        halt                        ; Fin de la ejecución
