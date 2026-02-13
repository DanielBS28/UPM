class Intervalo {

    private double minimo;
    private double maximo;

    public Intervalo(double minimo, double maximo) {
        this.minimo = minimo;
        if (minimo <= maximo) {
            this.maximo = maximo;
        } else {
            System.out.println("El m�nimo no puede ser superior al m�ximo");
            this.maximo = minimo;
        }
    }

    public Intervalo() {
        minimo = 0;
        maximo = 0;
    }

    public Intervalo(String cadena) {
        minimo = Double.parseDouble(cadena.substring(1, cadena.indexOf(",")));
        cadena = cadena.substring(cadena.indexOf(",") + 1, cadena.length() - 1);
        maximo = Double.parseDouble(cadena);
        if (minimo > maximo){
            System.out.println("El valor m�nimo no puede ser superior al valor m�ximo");
            maximo = minimo;
        }
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMinimo(double minimo) {
        if (minimo <= maximo) {
            this.minimo = minimo;
        } else {
            System.out.println("El valor mínimo no puede ser superior al valor máximo");
        }
    }

    public void setMaximo(double maximo) {
        if (maximo >= minimo) {
            this.maximo = maximo;
        } else {
            System.out.println("El valor máximo no puede ser inferior al valor mínimo");
        }
    }

    public double longitud() {
        return maximo - minimo;
    }

    public double puntoMedio() {
        return (maximo + minimo) / 2;
    }

    public void desplazar(double cantidad) {
        minimo += cantidad;
        maximo += cantidad;
    }

    public String toString() {
        return "[" + minimo + ", " + maximo + "]";
    }

    public void escalar(double escala) {
        double nuevaLongitud = this.longitud() * escala;
        double puntoMedio = this.puntoMedio();
        minimo = puntoMedio - nuevaLongitud / 2;
        maximo = puntoMedio + nuevaLongitud / 2;
    }

    public boolean incluye(double punto) {
        return minimo <= punto && punto <= maximo;
    }

    private Intervalo copia() {
        return new Intervalo(minimo, maximo);
    }

    public Intervalo simetrico() {
        return new Intervalo(-maximo, -minimo);
    }

    public Intervalo desplazado(double cantidad) {
        Intervalo intervalo = this.copia();
        intervalo.desplazar(cantidad);
        return intervalo;
    }

    public boolean incluye(Intervalo intervalo) {
        return this.incluye(intervalo.minimo)
                && this.incluye(intervalo.maximo);
    }

    public boolean iguales(Intervalo intervalo) {
        return minimo == intervalo.minimo
                && maximo == intervalo.maximo;
    }

}
