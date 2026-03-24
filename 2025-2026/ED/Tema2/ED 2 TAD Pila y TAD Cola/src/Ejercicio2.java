public class Ejercicio2 {

    public static void verOrdenados(int [] datos){

        Pila pila = new Pila();
        int tope = Integer.MAX_VALUE;

        for(int i = datos.length-1; i>=0; i--){

            if(datos[i] <= tope){
                pila.apilar(datos[i]);
                tope = datos[i];
            }
        }

            while(!pila.vacia()){
                System.out.println(pila.desapilar());
            }
    }
    static void main() {

        int[] valores = new int []{1,5,3,8,4,10};
        verOrdenados(valores);
    }
}
