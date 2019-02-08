
public class Pokemon {

	// Variables de la clase
	private String nombre;
	private double fuerza;

	// Constructor
	public Pokemon(int huevo) {
		
		if (huevo == 0) {
			nombre = "Pikachu";
			fuerza = Math.random() * (60 - 30) + 30;
		} else if (huevo == 1) {
			nombre = "Squirtle";
			fuerza = Math.random() * (50 - 40) + 40;
		} else if (huevo == 2) {
			nombre = "Charmander";
			fuerza = Math.random() * (55 - 45) + 45;
		}
	}
	
	// Metodos get
	public String getNombre() {
		return nombre;
	}
	
	public double getFuerza() {
		return fuerza;
	}

	// Metodo combatir
	public double combatir() {
		return fuerza;
	}

	// Metodo entrenar
	public double entrenar() {
		return (fuerza += Math.random() * 5);
	}

	// Metodo nivel
	public int nivel() {
		int nivel;

		if (fuerza >= 0 && fuerza <= 20) {
			nivel = 1;
		} else if (fuerza > 20 && fuerza <= 40) {
			nivel = 2;
		} else if (fuerza > 40 && fuerza <= 50) {
			nivel = 3;
		} else if (fuerza > 50 && fuerza <= 60) {
			nivel = 4;
		} else {
			nivel = 5;
		}

		return nivel;
	}
	
	// Metodo extra (solo para evolucionar)
	public void evolucion(String nombre) {
		this.nombre = nombre;
	}
}
