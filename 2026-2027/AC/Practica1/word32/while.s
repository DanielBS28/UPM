; Suma de dos vectores de 8 elementos de 32 bits (.word32)
; Versión con bucle WHILE (precondicional)

    .data
    .org 0x200

vectorA:    .word32 0, 1, 2, 3, 4, 5, 6, 7
vectorB:    .word32 1, 1, 1, 1, 1, 1, 1, 1
vectorSum:  .space  32                   ; 8 elementos * 4 octetos = 32 octetos

    .text
    .org 0x0

MAIN:       daddi   r1, r0, 32          ; i = 32 octetos

WHILE:      beqz    r1, FIN             ; while (i > 0) { si i == 0 sale a FIN
            daddi   r1, r1, -4          ; i = i - 4 (pasa a 28, 24, ..., 0)
            lw      r2, vectorA(r1)     ; r2 = vectorA[i]
            lw      r3, vectorB(r1)     ; r3 = vectorB[i]
            dadd    r4, r2, r3          ; r4 = vectorA[i] + vectorB[i]
            sw      r4, vectorSum(r1)   ; vectorSum[i] = r4
            j       WHILE               ; }

FIN:        halt