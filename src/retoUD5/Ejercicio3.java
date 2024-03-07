package retoUD5;
import java.io.*;
import java.util.Scanner;
public class Ejercicio3 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101832950261692360L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String directorioActual;

		System.out.println(directorioActual = System.getProperty("user.dir"));
		File fichero = new File(directorioActual + File.separator + "tres.dat");
		try {
			fichero.createNewFile();
		}
		catch(Exception ex) {
			System.out.println("Ha sucedido un error");
		}
		introducirNumeros(fichero);
		leerArchivo(fichero);

		
	}
	
	public static void introducirNumeros(File archivo) {
		Scanner lectura = new Scanner(System.in);
		int numero;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			do{
				System.out.println("Introduce un nombre (Introduce un '-' guión para dejar de introducir: ");
				numero = lectura.nextInt();
				if(numero>=0) {
					oos.write(numero);
				}
			}while(numero>=0);
			lectura.close();
			oos.close();
		}
		catch(Exception ex){
			System.out.println("Ha sucedido un error");
		}
	}
	
	public static void leerArchivo(File archivo) {
		int numero;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			while((numero=ois.read())!=-1) {
				System.out.println(numero);
			}
			ois.close();
		} catch (Exception ex) {

		} 

	}

}