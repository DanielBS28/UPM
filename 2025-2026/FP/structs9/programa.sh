#/bin/bash

NOMBRE_ARCHIVO=""

read -p "Dime el nombre del archivo: " NOMBRE_ARCHIVO
echo -e "#include <stdlib.h>\n#include <stdio.h>\n\n\nint main(){\n\n\nreturn 0;\n}" >> $NOMBRE_ARCHIVO.c

nano $NOMBRE_ARCHIVO.c

