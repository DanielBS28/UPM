import java.util.Stack;

import java.util.Stack;


public class Ejercicio1 {

    public static boolean parentesisEquilibrados(String expresion){

        PilaArray pila = new PilaArray();

        int posicion = 0;

        boolean error = false;

        while(posicion < expresion.length() && !error){

            char car = expresion.charAt(posicion);

            if(car == '('){

                pila.apilar((int)car);

            } else if (car == ')'){

                if(!pila.vacia()){

                    pila.desapilar();

                }else{

                    error = true;

                }

            }

            posicion++;

        }

        if(!pila.vacia()){

            error = true;
        }

        return !error;

    }


    //---------------------------------------------------------

    public static boolean parentesisEquilibrados2(String expresion){

        Stack<Character> pila = new Stack<Character>();

        int posicion = 0;

        boolean error = false;

        while(posicion < expresion.length() && !error){

            char car = expresion.charAt(posicion);

            if(car == '('){

                pila.push(car);

            } else if (car == ')'){

                if(!pila.empty()){

                    pila.pop();

                }else{

                    error = true;

                }

            }

            posicion++;

        }

        if(!pila.empty()){

            error = true;
        }

        return !error;

    }


    static void main() {

        String expresion = "((a+b)*c)";

        if(parentesisEquilibrados2(expresion)){

            System.out.println("Estructura equilibrada");

        }else{

            System.out.println("No equilibrada");

        }

    }
}
