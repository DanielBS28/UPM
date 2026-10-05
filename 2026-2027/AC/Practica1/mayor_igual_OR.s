; mayor_igual_OR.s

MAIN:   daddi r1, r0, 8         ; r1 = A = 8
        daddi r2, r0, 8         ; r2 = B = 8

        slt   r5, r1, r2         ; ¿r1 < r2? -> r5 = 1 si A < B
        bnez  r5, MNR_IGL        ; Si A < B ya se cumple (r5 == 1), salta a MNR_IGL

        slt   r6, r2, r1         ; ¿r2 < r1? -> r6 = 1 si A > B
        or    r7, r6, r5         ; Combina ambos: r7 = (A < B) OR (A > B)
        beqz  r7, MNR_IGL        ; Si r7 == 0 significa que A no es menor ni mayor, luego A == B.
                                 ; Salta a MNR_IGL

        daddi r8, r0, 1          ; Caso restante (A > B): r8 = 1
        j     FIN

MNR_IGL:daddi r8, r0, 2          ; Caso (A <= B): r8 = 2
FIN:    halt


;OTRO CASO:

; Comprobar si r1 <= r2
slt  r5, r2, r1         ; r5 = 1 si (r2 < r1) <=> (r1 > r2)
beqz r5, ES_MENOR_IGUAL ; Si r5 == 0, significa que NO es mayor, por tanto r1 <= r2