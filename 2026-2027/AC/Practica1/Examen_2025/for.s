; ==============================================================================
; Examen implementado con bucle FOR (Ascendente)
; ==============================================================================

; Dirección de comienzo de las variables
    .data
    .org 0x110

vector:     .word16 0, 1, 2, 3, 4       ; 5 elementos de 16 bits

; Dirección de comienzo del código
    .text
    .org 0x0

MAIN:       daddi   r3, r0, 10          ; Constante a restar (10)
            daddi   r1, r0, 0           ; i = 0 (inicialización del for)

FOR:        slti    r8, r1, 10          ; for (i = 0; i < 10; i += 2) {
            beqz    r8, FIN             ; Si i >= 10, termina el for
            lh      r2, vector(r1)      ; Cuerpo del bucle: lee elemento
            dsub    r2, r2, r3          ; Resta 10
            sh      r2, vector(r1)      ; Guarda resultado
            daddi   r1, r1, 2           ; Paso del bucle: i += 2
            j       FOR                 ; }

FIN:        halt