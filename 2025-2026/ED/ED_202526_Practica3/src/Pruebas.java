public class Pruebas {
    public static void main(String[] args) {

        /*
        TODO ESTE CÓDIGO SON PRUEBAS QUE HE RELIZADO, EL ENUNCIADO INDICABA QUE LAS COMENTEMOS PARA
        NO BORRARLAS.

        String exprInfija = "((5+2) * (8-3))/4";
        String exprPostFija = Utilidades.infijaAPostFija(exprInfija);
        System.out.printf("Infija: %s\nPostfija:%s\n", exprInfija, exprPostFija);

        System.out.println("  BATERÍA DE PRUEBAS: CALCULADORA DE EXPRESIONES ");

        // Pruebas Ejercicios 1, 2 y 3: Parseo, Mostrar y Calcular
        System.out.println("\n[ TEST EJERCICIOS 1, 2 y 3 ] Construcción y Evaluación");
        String infija1 = "((5+2)*(8-3))/4";
        String postfija1 = Utilidades.infijaAPostFija(infija1);
        ArbolExpresion arbol1 = new ArbolExpresion(postfija1);

        System.out.println("Expresión infija original : " + infija1);
        System.out.println("Notación postfija (Ej 1)  : " + postfija1);
        System.out.print("Reconstrucción (Ej 2)     : ");
        arbol1.mostrarExpresion();
        System.out.println("Cálculo matemático (Ej 3) : " + arbol1.calcularValor());
        // Esperado: (7 * 5) / 4 = 35 / 4 = 8.75


        // Prueba Ejercicio 4: Validación de división por cero
        System.out.println("\n[ TEST EJERCICIO 4 ] División por cero");
        // Caso A: Denominador explícito que evalúa a cero
        String infijaDiv0 = "7/(2-2)";
        ArbolExpresion arbolDiv0 = new ArbolExpresion(Utilidades.infijaAPostFija(infijaDiv0));
        System.out.print("Evaluando expresión       : ");
        arbolDiv0.mostrarExpresion();
        System.out.println("¿Existe división por cero?: " + arbolDiv0.hayDivisionPorCero());
        // Esperado: true

        // Caso B: Expresión matemática segura
        String infijaSana = "7/(2+2)";
        ArbolExpresion arbolSano = new ArbolExpresion(Utilidades.infijaAPostFija(infijaSana));
        System.out.println("¿Existe división en " + infijaSana + "?: " + arbolSano.hayDivisionPorCero());
        // Esperado: false


        // Prueba Ejercicio 5: Simplificación por Identidades
        System.out.println("\n[ TEST EJERCICIO 5 ] Simplificación Algebraica");
        String infijaSimp = "((5+0)*1)/(2/1)";
        ArbolExpresion arbolSimp = new ArbolExpresion(Utilidades.infijaAPostFija(infijaSimp));

        System.out.print("Árbol original            : ");
        arbolSimp.mostrarExpresion();

        arbolSimp.simplificarIdentidades();

        System.out.print("Estructura simplificada   : ");
        arbolSimp.mostrarExpresion();
        // Esperado: 5/2


        System.out.println("\n[ TEST EJERCICIO 6 ] Poda de subárboles");
        String infijaPoda = "(5+2)+((8-3)*0)";
        ArbolExpresion arbolPoda = new ArbolExpresion(Utilidades.infijaAPostFija(infijaPoda));

        System.out.print("Árbol antes de la poda    : ");
        arbolPoda.mostrarExpresion();

        arbolPoda.podarAnulaciones();

        System.out.print("Árbol tras la mutación    : ");
        arbolPoda.mostrarExpresion();
        // Esperado: (5+2)+0


        // Prueba Ejercicio 7: Sustitución de Incógnitas
        System.out.println("\n[ TEST EJERCICIO 7 ] Sustitución Profunda de 'x'");
        String infijaBase = "x*4";
        String infijaSust = "(5+3)";
        ArbolExpresion arbolBase = new ArbolExpresion(Utilidades.infijaAPostFija(infijaBase));
        ArbolExpresion arbolSust = new ArbolExpresion(Utilidades.infijaAPostFija(infijaSust));

        System.out.print("Árbol receptor            : ");
        arbolBase.mostrarExpresion();
        System.out.print("Subárbol a inyectar       : ");
        arbolSust.mostrarExpresion();

        arbolBase.sustituirIncognita(arbolSust);

        System.out.print("Árbol combinado final     : ");
        arbolBase.mostrarExpresion();
        // Esperado: ((5+3)*4)

        // Prueba Ejercicio 8: Búsqueda de Proximidad en ABB Estadístico
        System.out.println("\n[ TEST EJERCICIO 8 ] Búsqueda de Proximidad en ABB");

        try {

            TablaEstadistica tabla = TablaEstadistica.cargarDesdeFichero("normal_distribution.csv");

            if (tabla != null && !tabla.vacio()) {
                System.out.println("Tabla estadística cargada con éxito. Total elementos: " + tabla.getNumElementos());

                double claveBuscadaA = 2.00;
                double probA = tabla.consultarMasCercano(claveBuscadaA);
                System.out.println("\n--- Caso A: Búsqueda de aproximación ---");
                System.out.println("Clave objetivo     : " + claveBuscadaA);
                System.out.println("Probabilidad devuelta: " + probA);
                // Esperado: 0.475 (Se aproxima a la clave 1.96 porque la distancia 0.04 es menor que la distancia 0.05 hacia el 2.05)

                // Prueba B: Búsqueda de una clave que existe exactamente en el CSV
                double claveBuscadaB = 1.64;
                double probB = tabla.consultarMasCercano(claveBuscadaB);
                System.out.println("\n--- Caso B: Búsqueda exacta ---");
                System.out.println("Clave objetivo     : " + claveBuscadaB);
                System.out.println("Probabilidad devuelta: " + probB);
                // Esperado: 0.4495 (Al existir exactamente el 1.64 en la tabla, el método debe cortar la recursividad y devolverlo directamente)

            } else {
                System.out.println("Error: La tabla se ha instanciado pero está vacía.");
            }

        } catch (Exception e) {
            System.out.println("Excepción durante la lectura del CSV: " + e.getMessage());
            System.out.println("Revisa que el archivo 'normal_distribution.csv' se encuentre en el mismo nivel que la carpeta 'src'.");
        }

        System.out.println("\n[ TEST EJERCICIO 8 ] Búsqueda de Proximidad (Árbol del PDF)");

        TablaEstadistica tablaPrueba = new TablaEstadistica();

        tablaPrueba.insertar(1.64, 0.44950);
        tablaPrueba.insertar(1.28, 0.39973);
        tablaPrueba.insertar(1.96, 0.47500);
        tablaPrueba.insertar(0.67, 0.24857);
        tablaPrueba.insertar(1.44, 0.42507);
        tablaPrueba.insertar(1.88, 0.46995);
        tablaPrueba.insertar(2.05, 0.47982);

        double claveBuscada = 2.00;
        double resultado = tablaPrueba.consultarMasCercano(claveBuscada);

        System.out.println("Clave objetivo         : " + claveBuscada);
        System.out.println("Probabilidad devuelta  : " + resultado);
        System.out.println("Probabilidad esperada  : 0.475");

        // Prueba Ejercicio 8: Búsqueda de Proximidad (Datos del CSV)
        System.out.println("\n[ TEST EJERCICIO 8 ] Búsqueda de Proximidad en ABB Datos CSV Reales");

        try {
            // Carga del diccionario completo desde el sistema de archivos
            TablaEstadistica tablaCSV = TablaEstadistica.cargarDesdeFichero("normal_distribution.csv");

            if (tablaCSV != null && !tablaCSV.vacio()) {
                System.out.println("Tabla estadística cargada con éxito. Nodos indexados: " + tablaCSV.getNumElementos());

                //Coincidencia Exacta
                double claveExacta = 1.96;
                System.out.println("\n-> Caso 1: Búsqueda exacta (Z = " + claveExacta + ")");
                System.out.println("Probabilidad devuelta : " + tablaCSV.consultarMasCercano(claveExacta));
                System.out.println("Probabilidad esperada : 0.975");

                //  Aproximación por Distancia Mínima ---
                // 1.962 está más cerca de 1.96 (distancia 0.002) que de 1.97 (distancia 0.008)
                double claveAprox = 1.962;
                System.out.println("\n-> Caso 2: Aproximación (Z = " + claveAprox + ")");
                System.out.println("Probabilidad devuelta : " + tablaCSV.consultarMasCercano(claveAprox));
                System.out.println("Probabilidad esperada : 0.975 (Debe aproximar al nodo 1.96)");

                // Resolución de Empates
                // 1.965 está a 0.005 de distancia tanto de 1.96 como de 1.97
                double claveEmpate = 1.965;
                System.out.println("\n-> Caso 3: Empate geométrico (Z = " + claveEmpate + ")");
                System.out.println("Probabilidad devuelta : " + tablaCSV.consultarMasCercano(claveEmpate));
                System.out.println("Probabilidad esperada : 0.975 (El algoritmo debe desempatar eligiendo la clave inferior: 1.96)");

            } else {
                System.out.println("Error: La tabla se ha instanciado pero el archivo no contiene datos.");
            }

        } catch (Exception e) {
            System.out.println("Excepción durante la lectura del archivo: " + e.getMessage());
        }
    }
    */
    }
}
