// No necesario importar java.lang.String
class PruebasString {
    public static void main(String[] args){
        String cadena = "competencia";
        String otraCadena = new String("desleal");
        String cadenaTotal = cadena + " " + otraCadena;
        System.out.println(cadenaTotal + ": comienza por " + cadenaTotal.charAt(0));
        int posicion = cadenaTotal.indexOf("pe");
        System.out.println(cadenaTotal + ": la posición de 'pe' es " + cadenaTotal.indexOf("pe"));
        System.out.println(cadenaTotal + ": caracteres 5 al 8 es " + cadenaTotal.substring(5,8));
        int numLetrasE = 0;
        for (int i = 0; i < cadenaTotal.length(); i++) {
            if (cadenaTotal.charAt(i) == 'e' || cadenaTotal.charAt(i) == 'E') {
                numLetrasE++;
            }
        }
        System.out.println(cadenaTotal + ": tiene " + numLetrasE + " letras e");

        if(posicion != 1){
            System.out.println(cadenaTotal + ": la posición de 'pe' es " + posicion);
        }

    }

}