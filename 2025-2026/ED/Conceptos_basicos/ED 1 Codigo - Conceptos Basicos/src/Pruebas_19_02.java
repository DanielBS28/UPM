public class Pruebas_19_02 {

    static void main() {
        Intervalo horario = new Intervalo(9,15);
        Intervalo otroHorario = horario; //No hay otro objeto mientras que no haya un new

        otroHorario.desplazar(6);
        System.out.println(otroHorario); //Por defecto se le aplica el método toString
        //Seria lo mismo que si hago otroHorario.toString();
        prueba(horario); //Le he pasado la referencia.
        System.out.println(horario);
        if(horario == otroHorario)
            System.out.println("Horario y otro horario son iguales");
        Intervalo horas = new Intervalo(12,18);
        if(horario == horas)
            System.out.println("Horario y horas son iguales"); //No son el mismo objeto

        if(horario.iguales(horas)){
            System.out.println("Son iguales en el mismo intervalo");
        }

        int [] enteros = new int[10];
        for (int i = 0; i < 10; i++) {
            enteros[i] = i*2;
        }

        for (int i = 0; i < enteros.length; i++) {
            System.out.print((enteros[i])+" ");
        }

        for (int n : enteros)
        System.out.println(n);

        System.out.println(enteros);

        Intervalo[] intervalos = new Intervalo[3];
        intervalos[1].desplazar(4);
    }

    public static void prueba(Intervalo dato){

        dato.desplazar(-3);
    }
}
