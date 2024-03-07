package retoUD5;

import java.io.*;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String directorioActual, directorioDestino;

		System.out.println(directorioActual = System.getProperty("user.dir"));
		File directorio = new File(directorioActual + File.separator + "dirEjer2");
		directorio.mkdir();
		directorioDestino=directorio.getPath();
		crearFichero(new File(directorioDestino + File.separator + "uno.txt"));
		crearFichero(new File(directorioDestino + File.separator + "dos.txt"));
		introducirNombre(new File(directorioDestino + File.separator + "dos.txt"));
		leerFichero(new File(directorioDestino + File.separator + "dos.txt"));
	}


public static void introducirNombre(File archivo) {
	BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
	String nombre=null;
	try {
		BufferedWriter out = new BufferedWriter(new FileWriter(archivo));
		do {
			System.out.println("Introduce un nombre (Introduce un '-' guión para dejar de introducir: ");
			nombre = lectura.readLine();
			if(nombre.equals("-")==false) {
				out.write(nombre + "\n");
			}
		}while(nombre.equals("-")==false);
		lectura.close();
		out.close();
	}
	catch(Exception ex){
		System.out.println("Ha sucedido un error");
	}
}

public static void leerFichero(File archivo) {
	try {
		BufferedReader in = new BufferedReader(new FileReader(archivo));
		while(in.ready()) {
			System.out.println(in.readLine());
		}
		in.close();
	}catch(Exception ex) {
		System.out.println("Ha sucedido un error.");
	}
	
}

public static void crearFichero(File archivo) {
	if(archivo.exists()==false) {
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			System.out.println("Ha sucedido un error");
		}
	}
	else {
		System.out.println("El archivo ya existe, no se puede crear.");
	}
}








}
