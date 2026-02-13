public class Alumno {

    private String nombre;
    private String matricula;
    private double parcial1, parcial2, entregaPr2, examenPr2, entregaPr3, examenPr3;

    public Alumno(String nombre, String matricula){

        this.nombre = nombre;
        this.matricula = matricula;
        parcial1 = 0.0;
        parcial2 = 0.0;
        entregaPr2 = 0.0;
        examenPr2 = 0;
        entregaPr3 = 0.0;
        examenPr3 = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void calificarParcial1(double parcial1){
        this.parcial1 = parcial1;
    }

    public void calificarPractica2(double entregaPr2, double examenPr2){

        this.entregaPr2 = entregaPr2;
        this.examenPr2 = examenPr2;
    }

    public void calificarParcial2(double parcial2){
        this.parcial2 = parcial2;
    }

    public void calificarPractica3(double entregaPr3, double examenPr3){

        this.entregaPr3 = entregaPr3;
        this.examenPr3 = examenPr3;
    }
    // METHODS //
    public double notaTeoria() {
        return (parcial1 + parcial2)/2;
    }
    public double notaPractica2() {
        if (parcial2 >= 5) {
            return 0.6 * parcial2 + 0.4 * entregaPr2;
        } else {
            return 0.6 * parcial2;
        }
    }
    public double notaPractica3() {
        if (parcial2 >= 5) {
            return 0.6 * examenPr3 + 0.4 * entregaPr3;
        } else {
            return 0.6 * examenPr3;
        }
    }
    // If you don't add before this Java implicitly adds it because methods require the instance they're being called on
    public double notaPracticas() {
        return (this.notaPractica2() + this.notaPractica3())/2;
    }
    public double notaFinal() {
        double nota = 0.7 * + this.notaTeoria() + 0.3 * notaPracticas();
        if (this.notaPracticas() < 3.5 || this.notaTeoria() < 3.5)
            nota = Math.min(4, nota);
        return Math.floor(nota*100)/100;
    }

    public void mostrarDetalleNotas(){

        System.out.println(nombre + " ("+ matricula+" )" + "NOTA FINAL: " + this.notaFinal());
        System.out.println("\tTeoria: "+ this.notaTeoria());
        System.out.println("\t\tParcial1: " + parcial1);
        System.out.println("\t\tParcial2: " + parcial2);
        System.out.println("\tPracticas: "+ this.notaPracticas());
        System.out.println("\t\tPráctica 2: " + this.notaPractica2());
        System.out.println("\t\t\tExamen: " + examenPr2);
        System.out.println("\t\t\tEntrega: " + entregaPr2);
        System.out.println("\t\tPráctica 3: " + this.notaPractica3());
        System.out.println("\t\t\tExamen: " + examenPr3);
        System.out.println("\t\t\tEntrega: " + entregaPr3);

    }

}
