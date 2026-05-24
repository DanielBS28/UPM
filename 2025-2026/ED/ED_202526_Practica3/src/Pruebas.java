public class Pruebas {
    public static void main(String[] args) {
        String exprInfija = "((5+2) * (8-3))/4";
        String exprPostFija = Utilidades.infijaAPostFija(exprInfija);
        System.out.printf("Infija: %s\nPostfija:%s\n", exprInfija, exprPostFija);
    }
}
