public class PruebasInteger {
    public static void main(String[] args) {
        Integer numero = 5;
        numero+= 3;  // Se puede hacer lo mismo que con un int
        System.out.println("numero: " + numero);
        String texto = "27";
        int valorTexto = Integer.parseInt(texto);
        System.out.println("valorTexto: " + valorTexto);
        int minimo = Integer.min(numero, valorTexto);
        System.out.println("mínimo: " + minimo);

    }
}
