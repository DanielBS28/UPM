; Suma de dos vectores de 8 elementos de 32 bits (.word32)
; Versión con bucle Do-While descendente

    .data
    .org 0x200

vectorA:    .word32 0, 1, 2, 3, 4, 5, 6, 7
vectorB:    .word32 1, 1, 1, 1, 1, 1, 1, 1
vectorSum:  .space  32                    ; 8 elementos * 4 octetos = 32 octetos

    .text
    .org 0x0

MAIN:       daddi   r1, r0, 32           ; Desplazamiento inicial: 8 * 4 = 32 octetos

DOWHILE:    daddi   r1, r1, -4           ; Decrementa en 4 octetos (tamaño de .word32)
            lw      r2, vectorA(r1)      ; Lee palabra de 32 bits de vectorA
            lw      r3, vectorB(r1)      ; Lee palabra de 32 bits de vectorB
            dadd    r4, r2, r3           ; r4 = vectorA[i] + vectorB[i]
            sw      r4, vectorSum(r1)    ; Guarda la palabra de 32 bits en vectorSum
            bnez    r1, DOWHILE          ; Si r1 != 0, continúa el bucle
            halt