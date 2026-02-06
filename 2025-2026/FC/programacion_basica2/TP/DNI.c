#include <stdlib.h>
#include <stdio.h>


int main() {
    char letra;
    int p1,p2,p3,p4,p5,p6,p7,p8, DNI, num;
    
    printf("Dime el primer digito: ");
    scanf("%d",&p1);
    printf("Dime el segundo digito: ");
    scanf("%d",&p2);
    printf("Dime el tercer digito: ");
    scanf("%d",&p3);
    printf("Dime el cuarto digito: ");
    scanf("%d",&p4);
    printf("Dime el quinto digito: ");
    scanf("%d",&p5);
    printf("Dime el sexto digito: ");
    scanf("%d",&p6);
    printf("Dime el septimo digito: ");
    scanf("%d",&p7);
    printf("Dime el octavo digito: ");
    scanf("%d",&p8);
    
    DNI = p1*10000000 + p2*1000000 +p3*100000+p4*10000+p5*1000+p6*100+p7*10+p8;
    
    num = DNI%23;


    if (num == 0) {
        letra = 'T';
    }
    else if (num == 1) {
        letra = 'R';
    }
    else if (num == 2) {
        letra = 'W';
    }
    else if (num == 3) {
        letra = 'A';
    }
    else if (num == 4) {
        letra = 'G';
    }
    else if (num == 5) {
        letra = 'M';
    }
    else if (num == 6) {
        letra = 'Y';
    }
    else if (num == 7) {
        letra = 'F';
    }
    else if (num == 8) {
        letra = 'P';
    }
    else if (num == 9) {
        letra = 'D';
    }
    else if (num == 10) {
        letra = 'X';
    }
    else if (num == 11) {
        letra = 'B';
    }
    else if (num == 12) {
        letra = 'N';
    }
    else if (num == 13) {
        letra = 'J';
    }
    else if (num == 14) {
        letra = 'Z';
    }
    else if (num == 15) {
        letra = 'S';
    }
    else if (num == 16) {
        letra = 'Q';
    }
    else if (num == 17) {
        letra = 'V';
    }
    else if (num == 18) {
        letra = 'H';
    }
    else if (num == 19) {
        letra = 'L';
    }
    else if (num == 20) {
        letra = 'C';
    }
    else if (num == 21) {
        letra = 'K';
    }
    else if (num == 22) {
        letra = 'E';
    }
    
    printf("Tu DNI es: %d%c",DNI,letra);

return 0;
}
