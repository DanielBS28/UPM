; ==============================================================================
; Examen implementado con bucle WHILE (Precondicional ascendente)
; ==============================================================================

; Dirección de comienzo de las variables
    .data
    .org 0x110

vector:     .word16 0, 1, 2, 3, 4       ; 5 elementos de 16 bits (2 bytes c/u)

; Dirección de comienzo del código
    .text
    .org 0x0

MAIN:       daddi   r3, r0, 10          ; Constante a restar (10)
            daddi   r10, r0, 10         ; Límite superior: 5 elem * 2 bytes = 10 bytes
            daddi   r1, r0, 0           ; i = 0 (offset inicial en bytes)

WHILE:      slt     r8, r1, r10         ; while (r1 < 10) {
            beqz    r8, FIN             ; Si r8 == 0 (no cumple r1 < 10), salta a FIN
            lh      r2, vector(r1)      ; Lee elemento de 16 bits
            dsub    r2, r2, r3          ; Resta 10
            sh      r2, vector(r1)      ; Escribe el resultado modificado
            daddi   r1, r1, 2           ; i = i + 2 bytes
            j       WHILE               ; }

FIN:        halt