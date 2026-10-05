#DO WHILE usando dsub

MAIN:       daddi   r1, r0, 32          ; i = 32
            daddi   r6, r0, 4           ; r6 = 4 (constante de paso para dsub)

DOWHILE:    dsub    r1, r1, r6          ; r1 = r1 - r6 (equivale a r1 = r1 - 4)
            lw      r2, vectorA(r1)     ; r2 = vectorA[i]
            lw      r3, vectorB(r1)     ; r3 = vectorB[i]
            dadd    r4, r2, r3          ; r4 = vectorA[i] + vectorB[i]
            sw      r4, vectorSum(r1)   ; vectorSum[i] = r4
            bnez    r1, DOWHILE         ; } do while (i > 0)
            halt