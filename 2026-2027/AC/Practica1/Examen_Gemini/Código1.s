	.data
	.org 0x150
medidas:	.word32 10,20,30,40,50,60

	.text
	.org 0x0

INICIO:     daddi   r1, r0, 15                  ; Constante a sumar (15)
            daddi   r2, r0, 24                  ; Tope: 6 elem * 4 bytes = 24 bytes
            daddi   r8, r0, 0                   ; Índice de inicio (offset en bytes = 0)

BUCLE:      lw      r3, medidas(r8)             ; Lee palabra de 32 bits (4 bytes)
            dadd    r3, r3, r1                  ; dadd (r3 = r3 + r1) registro + registro
            sw      r3, medidas(r8)             ; Guarda palabra de 32 bits
            daddi   r8, r8, 4                   ; Paso: avanza 4 bytes (.word32)
            slt     r4, r8, r2                  ; ¿r8 < 24?
            bnez    r4, BUCLE                   ; Si cumple (r4 == 1), repite

FIN:        halt