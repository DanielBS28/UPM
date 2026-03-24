public class AlgoritmoCambiarBase {

    public static String cambiarBase(int numero, int base) {
        String resultado = "";
        if (numero > 0 && base >= 2 && base <= 9) {
            Pila restos = new Pila();
            while (numero > 0) {
                restos.apilar(numero % base);
                numero = numero / base;
            }
            while (!restos.vacia()) {
                resultado += restos.desapilar();
            }
        }
        return resultado;
    }


    public static void main(String[] args) {
        int valor = 18;
        int base = 2;
        System.out.println("El número " + valor + " en base " + base +
                " es: " + cambiarBase(valor, base));
    }




}
