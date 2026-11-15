package upm.etsisi.poo.citim21_13;

public enum ComandoApp {
	

		USER_CREATE,
		USER_DELETE,
		USER_UPDATE,
		
		SYSTEM_DATE,
		SYSTEM_PRICE,
		
		GROUP_CREATE,
		GROUP_ADD,
		GROUP_REMOVE,
		GROUP_DELETE,
		
		TICKET_CREATE,
		TICKET_DELETE,
		GROUPTICKET_CREATE,
		GROUPTICKET_DELETE,
		
		ATTRACTION_CREATE,
		ATTRACTION_ENTER,
		ATTRACTION_EXIT,
		ATTRACTION_LIST,
		ATTRACTION_STATUS,
		
		HELP;
		

		public static ComandoApp obtenerComando(String textoComando) {
			if (textoComando == null || textoComando.trim().isEmpty()) {
				return null;
			}
			
			try {
				// Convierte a mayúsculas y reemplaza espacios por "_" (ej. "SYSTEM DATE" -> "SYSTEM_DATE")
				String comandoTransformado = textoComando.trim().toUpperCase().replace(" ", "_");
				return ComandoApp.valueOf(comandoTransformado);
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
	}


