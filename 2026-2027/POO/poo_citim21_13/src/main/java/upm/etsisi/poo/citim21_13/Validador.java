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

	    // Comprobar que existe exactamente un caracter '@'
	    int indiceArroba = correo.indexOf('@');
	    if (indiceArroba <= 0 || indiceArroba != correo.lastIndexOf('@')) {
	        return false;
	    }

	    // Parte local antes de la @
	    String parteLocal = correo.substring(0, indiceArroba);
	    // Parte del dominio completo despues de la @
	    String parteDominio = correo.substring(indiceArroba + 1);

	    if (parteLocal.isEmpty()) {
	        return false;
	    }

	    // Aquí obtenemos el último punto que aparezca en el correo. 
	    int ultimoPunto = parteDominio.lastIndexOf('.');
	    if (ultimoPunto <= 0) {
	        // Si no hay punto o está en la primera posición por ejemplo . @.com, no está bien.
	        return false;
	    }

	    // Aquí comprobamos que el dominio entre la @ y el último . no este vacío.
	    String dominio = parteDominio.substring(0, ultimoPunto);
	    if (dominio.isEmpty()) {
	        return false;
	    }

	    // Esto es para comprobar que el dominio sea de 3 caracteres
	    String extension = parteDominio.substring(ultimoPunto + 1);
	    if (extension.length() != 3) {
	        return false;
	    }

	    return true;
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

