class PruebasIntervalo {
    public static void main(String[] args) {
        Intervalo intervalo = new Intervalo(3, 8);
        System.out.println("Intervalo: " + intervalo.toString());
        System.out.println("Longitud" + ": " + intervalo.longitud());
        System.out.println("Punto medio: " + intervalo.puntoMedio());
        intervalo.desplazar(3);
        System.out.println("Al desplazarlo 3 unidades: " + intervalo.toString());
        intervalo.escalar(3);
        System.out.println("Al triplicarlo: " + intervalo.toString());
        if (intervalo.incluye(19)) {
            System.out.println("El 19 está incluido");
        } else {
            System.out.println("El 19 no está incluido");
        }
    }
}
