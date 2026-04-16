public class Pruebas {
    public static void main(String[] args) {
        ArbolBinarioBusqueda datosOrdenados = new ArbolBinarioBusqueda();
        datosOrdenados.insertar(7);
        datosOrdenados.insertar(17);
        datosOrdenados.insertar(1);
        datosOrdenados.insertar(27);
        if (datosOrdenados.contiene(17)) {
            System.out.println("Datos contienen el 17");
        } else {
            System.out.println("Datos no contienen el 17");
        }
        if (datosOrdenados.contiene(11)) {
            System.out.println("Datos contienen el 11");
        } else {
            System.out.println("Datos no contienen el 11");
        }
    }

}
