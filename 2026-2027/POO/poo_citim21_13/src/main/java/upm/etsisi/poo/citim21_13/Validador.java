package upm.etsisi.poo.citim21_13;

public class Validador {
	public static boolean validarDNI(String dni) {
		
        if (dni == null || dni.length() != 9) {
            return false;
        }

        final String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }

        //Importante dni.substring(0, 8), ya que al parsearlo a entero la letra no la necesitamos.
        int numeroDni = Integer.parseInt(dni.substring(0, 8));
        char letraCalculada = letrasDNI.charAt(numeroDni % 23);
        char letraEntrada = Character.toUpperCase(dni.charAt(8));

        return letraEntrada == letraCalculada;
    }
	
	public static boolean validarCorreo(String correo) {
		if (correo == null) {
			return false;
		}
		
		int indiceArroba = correo.indexOf('@');
		int indicePunto = correo.indexOf('.');
		
		return indiceArroba > 0
			&& indicePunto > indiceArroba + 1
			&& indiceArroba == correo.lastIndexOf('@')
			&& indicePunto == correo.lastIndexOf('.')
			&& correo.length() - indicePunto - 1 == 3;
	}
	public static boolean validarTarjeta(String tarjeta) {
		if (tarjeta == null || tarjeta.length() != 16) {
			return false;
		}
		for (int i = 0; i < tarjeta.length(); i++) {
			char numero = tarjeta.charAt(i);
			if (numero < '0' || numero > '9') {
				return false;
			}
		}
		return true;
	}

	public static boolean validarContraseña(String contraseña) {

		// La contraseña debe cumplir el mínimo de longuitud 4 (Condición minima)
		if (contraseña == null || contraseña.length() < 4) {

			return false;
		}

		boolean tieneMayuscula,tieneMinuscula,tieneDigito,tieneSimbolo;

		tieneMayuscula = tieneMinuscula = tieneDigito = tieneSimbolo = false;


		for (int i = 0; i < contraseña.length(); i++) {

			char character = contraseña.charAt(i);

			if(Character.isUpperCase(character)){

				tieneMayuscula = true;

			}else if (Character.isLowerCase(character)){

				tieneMinuscula = true;

			}else if (Character.isDigit(character)){

				tieneDigito = true;

			}else{
				// Por descartes, el único que queda sera un simbolo
				tieneSimbolo = true;

			}
			// Si se cumple las 4 condiciones, no tenemos porque recorrer toda la contraseña
			if(tieneMayuscula && tieneMinuscula && tieneDigito && tieneSimbolo){

				return true;
			}
		}

		// Claramente, si ha fallado alguna de las 4 anteriores, directamente retorna un false
		return false;
    }
	
}

