; Suma de dos vectores de 8 elementos de 32 bits (.word32)
; Versión con bucle FOR (ascendente)

    .data
    .org 0x200

vectorA:    .word32 0, 1, 2, 3, 4, 5, 6, 7
vectorB:    .word32 1, 1, 1, 1, 1, 1, 1, 1
vectorSum:  .space  32                   ; 8 elementos * 4 octetos = 32 octetos

    .text
    .org 0x0

MAIN:       daddi   r1, r0, 0           ; i = 0 (offset inicial en octetos)

FOR:        slti    r5, r1, 32          ; for (i = 0; i < 32; i += 4) {
            beqz    r5, FIN             ; Si r1 >= 32 (r5 == 0), termina
            lw      r2, vectorA(r1)     ; Carga vectorA[i]
            lw      r3, vectorB(r1)     ; Carga vectorB[i]
            dadd    r4, r2, r3          ; r4 = vectorA[i] + vectorB[i]
            sw      r4, vectorSum(r1)   ; vectorSum[i] = r4
            daddi   r1, r1, 4           ; } i = i + 4 octetos
            j       FOR

FIN:        halt