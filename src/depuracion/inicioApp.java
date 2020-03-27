package depuracion;
import java.util.Scanner;
public class inicioApp {
	
	static Scanner teclado = new Scanner(System.in);
	static int [] contadorVecesRepetida;
	static char[] arrayLetrasRepetidas;
	
	public static void main(String[] args) {
	       System.out.print("Introduce una frase: ");
	       String frase = teclado.nextLine();
	   	contadorVecesRepetida = new int[frase.length()];
		arrayLetrasRepetidas = new char[frase.length()];
		contarPalabra(frase);
		int totalCaracter = contarCaracter(frase);
		int contadorPalabras = contarPalabra(frase);
		int i = 0;
		contarTodosCaracteres(frase);
		System.out.println(textoCaracteresTotal(totalCaracter)); 
		System.out.println(textoNumeroPalabras(contadorPalabras));
		for(i=0;i<contadorVecesRepetida.length;i++) {
			if (contadorVecesRepetida[i] >=1 && arrayLetrasRepetidas[i]!=' ')
				System.out.println(textoTodosCaracteres(i));
			
		}	
			
	}//main
	
	static String textoCaracteresTotal(int contadorCaracter) {
		return "Hay "+contadorCaracter+" caracteres";		
	}//textoCaracteresTotal
	
	static String textoNumeroPalabras (int contadorPalabras) {
		return "Hay "+contadorPalabras+" palabras";
	}//textoNumeroPalabras
	
	static String textoTodosCaracteres (int i) {
		return "La letra "+ arrayLetrasRepetidas[i] +" se repite "+ contadorVecesRepetida[i];
	}
	
	//contar palabras
	static int contarPalabra(String frase) {
		int contadorPalabras=1;
		for(int i=0;i<frase.length();i++) {
			if(frase.charAt(i) == ' ')
				contadorPalabras++;
		}
		return contadorPalabras;
	}//contarPalabra
	
	//contar caracteres
	static int contarCaracter(String frase) {
		int contadorCaracter=1;
		for(int i=0;i<frase.length();i++) {
			if(frase.charAt(i) != ' ')
				contadorCaracter++;
		}
		return contadorCaracter;
	}//contarPalabra
	//contar cada letra
	static int[]contarTodosCaracteres(String frase) {
		
		for(int i=0;i<frase.length();i++) {
			char letraActual = frase.charAt(i);
			boolean letraEncontrada = false;
			int j = 0;
			while(j<arrayLetrasRepetidas.length && letraEncontrada == false) {
				//Inserto en el array la letra e inicializo el contadorVeces Repetida
				if (letraEncontrada == false && contadorVecesRepetida[j]==0) {
					arrayLetrasRepetidas[j]= letraActual;
					contadorVecesRepetida[j]++;
					letraEncontrada = true;
				}else {
				//Búsqueda de una letra en una array
					if(letraActual == arrayLetrasRepetidas[j]) {
						contadorVecesRepetida[j]++;
						letraEncontrada = true;
					}
				}
				j++;
			}
			
		}return contadorVecesRepetida;	
	}//contarTodosCaracteres
}
		

