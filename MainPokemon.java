import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;

public class MainPokemon {
	
	/*** Menú ***/
	public static void menu(){
	
		System.out.println("Introduzca PokeOpcion: \n1: Encontrar nuevo Pokemon"
				+ "\n2: Entrenar \n3: Combatir" + "\n4: Evolucionar \n5: Ver Pokedex"
				+ "\n6: Salir");
		}
	
	/*** Metodo 1 - Encontrar nuevo Pokemon ***/
	public static void encontrarPokemon(ArrayList<Pokemon> pokemon) {
		
		// Buscamos nuevo Pokemon
		Pokemon nuevoPokemon = new Pokemon((int)Math.floor(Math.random() * 3));
		
		 // Añadimos nuevo Pokemon	
		pokemon.add(nuevoPokemon);
		
		// Mensaje para el usuario
		System.out.println("Pokemon encontrado!");
		
		// Si se desea comprobar el pokemon encontrado
		/* System.out.println("Nombre: " + nuevoPokemon.getNombre() + " / Fuerza: " 
				+ nuevoPokemon.getFuerza() + " / Nivel: " + nuevoPokemon.nivel());	
		*/
	}
	
	/*** Metodo 2 - Entrenar ***/
	public static void entrenarPokemon(ArrayList<Pokemon> pokemon) throws Exception {
		
		// Variables locales
		Scanner entrada = new Scanner(System.in);
		int pokemonElegido;
		
		// Elegimos Pokemon a entrenar
		System.out.println("Introduzca el numero del Pokemon a entrenar: ");
		pokemonElegido = entrada.nextInt();
		
		// Excepcion
		if (pokemonElegido >= pokemon.size()) {
			throw new Exception("Error: el Pokemon no se ha encontrado en la lista");
		}
			
		// Buscamos al Pokemon elegido
		Pokemon pokemonEntrenar = pokemon.get(pokemonElegido);
		
		// Entrenamos al Pokemon
		pokemonEntrenar.entrenar();		
		
		// Mensaje para el usuario
		System.out.println("Pokemon entrenado!");
		
		// Si se desea mostrar al Pokemon tras entrenamiento
		/*System.out.println("Nombre: " + pokemonEntrenar.getNombre() + " / Fuerza: " 
				+ pokemonEntrenar.getFuerza() + " / Nivel: " + pokemonEntrenar.nivel());	
		*/
	}

	/*** Metodo 3 - Combatir ***/
	public static Pokemon combatir(Pokemon luchadorPokemon1, Pokemon luchadorPokemon2){
		
		//Variables locales
		Pokemon ganador;	
		
		// Si gana el primer Pokemon
		if (luchadorPokemon1.combatir() > luchadorPokemon2.combatir()) {	
			ganador = luchadorPokemon1;	
			
		// Si gana el segundo Pokemon
		} else {			
			ganador = luchadorPokemon2;
		}
		return ganador;				
	}
	
	/*** Metodo 4 - Evolucionar ***/
	/* Si el pokemon está a su nivel máximo (5), podemos hacer que evolucione */
	/* Charmander y Squirtle pueden evolucionar 2 veces y Pikachu solo 1*/
	public static void evolucion(ArrayList<Pokemon> pokemon) throws Exception{
		
		// Variables
		Scanner entrada = new Scanner(System.in);
		int pokemonAEvolucionar;
		
		// Pregunta
		System.out.println("Que pokemon desea evolucionar?");
		pokemonAEvolucionar = entrada.nextInt();
		
		// Excepcion 1 (no hay Pokemon)
		if (pokemonAEvolucionar > pokemon.size()) {
			throw new Exception("Error: no se ha encontrado pokemon");
		}
		
		if (pokemon.get(pokemonAEvolucionar).nivel() == 5) {
			if (pokemon.get(pokemonAEvolucionar).getNombre() == "Pikachu") {
				// Pikachu evoluciona a Raichu
				pokemon.get(pokemonAEvolucionar).evolucion("Raichu");
			}else 
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Squirtle") {
					// Squirtle evoluciona a Wartortle
					pokemon.get(pokemonAEvolucionar).evolucion("Wartortle");
			} else 
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Charmander") {
					// Charmander evolcuiona a Charmeleon
					pokemon.get(pokemonAEvolucionar).evolucion("Charmeleon");		
			} else 
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Wartortle") {
					// Wartortle evoluciona a Blastoise
					pokemon.get(pokemonAEvolucionar).evolucion("Blastoise");
			} else 
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Charmeleon") {
					// Charmeleon evoluciona a Charizard
					pokemon.get(pokemonAEvolucionar).evolucion("Charizard");				
			}else 
				// Excepcion 2 (Raichu es ultima evolucion)
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Raichu") {
					throw new Exception("Error: Raichu no puede evolucionar"); 
			} else 
				// Excepcion 3 (Blastoise es ultima evolucion)
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Blastoise") {
					throw new Exception("Error: Blastoise no puede evolucionar"); 
			} else 
				// Excepcion 4 (Charizard es ultima evolucion)
				if (pokemon.get(pokemonAEvolucionar).getNombre() == "Charizard") {
					throw new Exception("Error: Charizard no puede evolucionar"); 			
			} 	
		} else {
			// Excepcion 5 (Si no es nivel 5, no evoluciona)
			throw new Exception("Error: No tiene nivel para evolucionar"); 
		}
	}
			
	/*** Metodo 5 - Ver Pokedex ***/
	public static void verPokedex(ArrayList<Pokemon> pokemon) {
		
		// Comprobamos si hay algun Pokemon
		if (0 == pokemon.size()) {
			System.out.println("No hay Pokemon en la Pokedex");
		}
		
		// Ciclo para sacar los Pokemon
		for (int i = 0; i < pokemon.size(); i++) {
			
			Pokemon pokedexPkm = pokemon.get(i);
			
			// Mostrar Pokemon
			System.out.println("Numero : " + i + " / Nombre: " + pokedexPkm.getNombre() + "\n   / Fuerza: " 
			+ pokedexPkm.getFuerza() + " / Nivel: " + pokedexPkm.nivel() + "\n");		
		}
	}

	/*** Main ***/
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub

		ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		boolean opcionCorrecta;

		// Menu
		do {
					
			// Llamamos al metodo menu
			menu();

			// Excepcion para obtener una opcion valida - Alejandro Fandila Cano.
			do {
				try {
					opcion = entrada.nextInt();
					} catch (InputMismatchException ex) {
						opcionCorrecta = false;
						System.out.println("PokeOpcion Erronea");
					}
				opcionCorrecta = true;
			} while (opcionCorrecta == false);


			entrada.nextLine();

			// Se busca la opcion en el menu
			switch (opcion) {
			
			case 1: // Encontrar nuevo Pokemon
				
				// Llenamos al metodo
				encontrarPokemon(pokemon);
				
				// Salto de linea
				System.out.println();
				
				break;

			case 2: // Entrenar
				
				// Llamamos al metodo
				try {
					entrenarPokemon(pokemon);
				} catch (InputMismatchException ex){
					// Si se introduce un caracter
					System.out.println("Error: caracter no valido");
				} catch (Exception ex) {
					// Si se introduce una posicion que no hay
					System.out.println("Error: no se ha encontrado pokemon");
				}
				
				// Salto de linea
				System.out.println();
				
				break;

			case 3: // Combatir
				
				// Variables locales
				int luchador1 = -1, luchador2 = -1;
				Pokemon ganador;
				
				// Introducimos Pokemon 1
				System.out.println("Primer Pokemon a combatir: ");
				try {
					luchador1 = entrada.nextInt();
				} catch (InputMismatchException ex) {
					System.out.println("Caracter no valido");
				}  catch (Exception ex){
					System.out.println("Pokemon no encontrado");
				}

				// Introducimos Pokemon 2
				System.out.println("Segundo Pokemon a combatir: ");
				try {
					luchador2 = entrada.nextInt();
				} catch (InputMismatchException ex) {
					System.out.println("Caracter no valido");
				}  catch (Exception ex){
					System.out.println("Pokemon no encontrado");
				}
	
				// Llamamos al metodo
				try {
					// Se buscan en el ArrayList
					Pokemon luchadorPokemon1 = pokemon.get(luchador1);
					Pokemon luchadorPokemon2 = pokemon.get(luchador2);
						
					// Presentacion
					System.out.println("Nombre: " + luchadorPokemon1.getNombre() + " / Fuerza: " 
							+ luchadorPokemon1.getFuerza() + " / Nivel: " + luchadorPokemon1.nivel());	
						
					System.out.println("----------- VS ----------- ");
						
					System.out.println("Nombre: " + luchadorPokemon2.getNombre() + " / Fuerza: " 
							+ luchadorPokemon2.getFuerza() + " / Nivel: " + luchadorPokemon2.nivel());	
					
					// Llamamos al metodo combatir
					ganador = combatir(luchadorPokemon1, luchadorPokemon2);
					
					// Tenemos ganados!
					System.out.println("\nEl gandor es: ");
					System.out.println("Nombre: " + ganador.getNombre() + " / Fuerza: " 
							+ ganador.getFuerza() + " / Nivel: " + ganador.nivel());
					
				}  catch (InputMismatchException ex){
					System.out.println("Caracter no valido");
				} catch (Exception ex){
					System.out.println("Error: no hay Pokemon dispuestos a luchar");
				}
	
				// Salto de linea
				System.out.println();
				
				break;
				
			case 4: // Evolucionar
				
				// Llamamos al metodo
				try {
					evolucion(pokemon);
				} catch (InputMismatchException ex){
					// Si se introduce un caracter
					System.out.println("Error: caracter no valido");
				} catch (IndexOutOfBoundsException ex) {
					// Si se introduce una posicion que no hay
					System.out.println("Error: no se ha encontrado pokemon");
				} catch (Exception ex) {
					// Otra excepcion
					System.out.println(ex.getMessage());
				}
				
				// Salto de linea
				System.out.println();
				
				break;
				
			case 5: // Ver Pokedex
				
				// Llamamos al metodo
				verPokedex(pokemon);
				
				// Salto de linea
				System.out.println();
				
				break;
			
			case 6: // Salir
				
				System.out.println("Fin del PokePrograma\n");
				System.out.println("(\\__/)\r\n" + 
						"(>’.’<)\r\n" + 
						"(\")_(\")");
				
				break;
			
			default: // Por defecto
				
				System.out.println("PokeOpcion Erronea\n");
				
				break;
			}
		} while (opcion != 6);
	}
}