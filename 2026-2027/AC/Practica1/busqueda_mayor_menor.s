; ==============================================================================
; APARTADO 5: Búsqueda del Máximo y Mínimo en un vector de 8 bytes
; ==============================================================================

; Dirección de comienzo de las variables
    .data
    .org 0x200
vector:     .byte   14, 5, 82, 3, 47, 99, 1, 26   ; Vector de 8 enteros positivos
    .org 0x210
MIN:        .byte   255                           ; Inicializado al valor más alto posible (0xFF)
MAX:        .byte   0                             ; Inicializado al valor más bajo posible (0x00)

; Dirección de comienzo del código
    .text
    .org 0x0

MAIN:       daddi   r1, r0, 8           ; i = 8 (índice/desplazamiento en bytes)

DOWHILE:    lbu     r10, MIN(r0)        ; { r10 = MIN
            lbu     r11, MAX(r0)        ;   r11 = MAX
            daddi   r1, r1, -1          ;   i = i - 1
            lbu     r2, vector(r1)      ;   r2 = vector[i]

            ; if (vector[i] < MIN)
            sltu    r5, r2, r10         ;   r5 = 1 si r2 < r10 (vector[i] < MIN)
            beqz    r5, ES_MAYOR        ;   si no es menor, salta a comprobar si es mayor
            sb      r2, MIN(r0)         ;   MIN = vector[i]

ES_MAYOR:   ; if (vector[i] > MAX) <=> if (MAX < vector[i]) puedo poner una etiqueta y después la instrucción perfectamente. 
            sltu    r5, r11, r2         ;   r5 = 1 si r11 < r2 (MAX < vector[i])
            beqz    r5, CONT            ;   si no es mayor, salta al control del bucle
            sb      r2, MAX(r0)         ;   MAX = vector[i]

CONT:       bnez    r1, DOWHILE         ; } do while (i > 0)
            halt