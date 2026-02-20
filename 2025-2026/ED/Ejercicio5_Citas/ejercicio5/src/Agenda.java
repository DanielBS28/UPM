public class Agenda {

    private final int CITAS_DEFECTO = 20;
    private String mes;
    private Cita[] citas;
    private int numeroCitas;

    public Agenda(String mes, int maximoCitas){

        this.mes = mes;
        citas = new Cita[maximoCitas];
        numeroCitas = 0;
    }

    public Agenda(String mes){

        this.mes = mes;
        citas = new Cita[CITAS_DEFECTO];
        numeroCitas = 0;

    }

    public boolean insertarCita(Cita cita){

        if(citas.length > numeroCitas){
            citas[numeroCitas] = cita;
            numeroCitas++;
            return true;
        }

        return false;
    }

    public void mostrar(){

        System.out.println(mes + " (" +  numeroCitas+ ") :");

        int contador = 1;

        for (Cita c : citas){
            System.out.println("\t" +" " + contador +  c.toString());
            contador++;
        }

    }

    public void mostrarCitas2(){

        System.out.println(mes + " (" +  numeroCitas+ ") :");
        for (int i = 0; i < numeroCitas; i++) {
            System.out.println("\t" + (i+1) + " " + this.citas[i].toString());

        }
    }

    public int numeroCitasPaciente(String paciente){
        int resultado = 0;
        for (int i = 0; i < numeroCitas; i++) {
            if(paciente.equals(citas[i].getPaciente())){
                resultado++;
            }
        }
        return  resultado;
    }

    public void mostrarCitasDia(int dia){
        System.out.println(dia + " de " + mes +":");

        int contador =1;
        for (int i = 0; i < numeroCitas; i++) {

            if(citas[i].getDia() == dia){
                System.out.println("\t" + contador++ + ". " + citas[i].toString());
            }

        }
    }

    public boolean eliminarCita(int posicion){

        boolean resultado = false;
        if(posicion>= 1 && posicion<=numeroCitas) {

            for (int i = posicion; i < numeroCitas; i++) {
                    citas[i-1] = citas[i];
            }
            numeroCitas--;
            resultado = true;
        }

        return resultado;
    }
}
