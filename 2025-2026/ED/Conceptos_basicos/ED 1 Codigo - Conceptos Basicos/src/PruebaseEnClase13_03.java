public class PruebaseEnClase13_03 {

    public static void main(String[] args) {
        Intervalo horario = new Intervalo(9,15);
        Intervalo otroHorario = new Intervalo(9,14);

        if(horario.iguales(otroHorario))
            System.out.println("Son iguales");
        else
            System.out.println("Son distintos");
    }
}
