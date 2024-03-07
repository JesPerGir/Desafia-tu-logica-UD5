package retoUD5;
import java.io.*;
import java.util.Scanner;
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreArchivo1, nombreArchivo2, directorioActual, rutaCompletaFich1, rutaCompletaFich2;
		
		File archivo1 = null, archivo2=null;
		Scanner entrada = new Scanner(System.in);
		do {
			do {
				System.out.println("Introduce el nombre del primer archivo a crear: ");
				nombreArchivo1 = entrada.nextLine();
			}while(nombreArchivo1.length()<3);
			System.out.println("El nombre del fichero " + nombreArchivo1 + " es válido.");
			directorioActual = System.getProperty("user.dir");
			rutaCompletaFich1=directorioActual + File.separator + nombreArchivo1;
			archivo1 = new File(rutaCompletaFich1);
			if(archivo1.exists()) {
				System.out.println("El fichero ya existe y no se puede crear.");
			}
		}while(archivo1.exists());
		
		try {
			archivo1.createNewFile();
		}
		catch(Exception ex) {
			System.out.println("El fichero no se ha podido crear.");
		}
		
		do {
			do {
				System.out.println("Introduce el nombre del segundo archivo a crear: ");
				nombreArchivo2 = entrada.nextLine();
			}while(nombreArchivo2.length()<3);
			System.out.println("El nombre del fichero " + nombreArchivo2 + " es válido.");
			directorioActual = System.getProperty("user.dir");
			rutaCompletaFich2=directorioActual + File.separator + nombreArchivo2;
			archivo2 = new File(rutaCompletaFich2);
			if(archivo2.exists()) {
				System.out.println("El fichero ya existe y no se puede crear.");
			}
		}while(archivo2.exists());
		try {
			archivo2.createNewFile();
		}
		catch(IOException ex) {
			System.out.println("El fichero no se ha podido crear.");
		}
		entrada.close();
		
		if(comprobarExiste(archivo1)) {
			escribirEnFichero(archivo1);
		}
		if(comprobarExiste(archivo1)) {
			leerDeFichero(archivo1);
		}
		if(comprobarExiste(archivo1)) {
			try {
				System.out.println("Nombre: " + archivo1.getName());
				System.out.println("Ruta absoluta: " + archivo1.getAbsolutePath());
				System.out.println("Ruta del directorio padre: " + archivo1.getParent());
				System.out.println("Tamaño: " + archivo1.length() + " bytes.");
				System.out.println("Es un fichero: " + archivo1.isFile());
				System.out.println("Es un directorio: " + archivo1.isDirectory());
				System.out.println("Permiso de lectura: " + archivo1.canRead());
				System.out.println("Permiso de escritura: " + archivo1.canWrite());
				System.out.println("Permiso de ejecución: " + archivo1.canExecute());
				System.out.println("Está oculto: " + archivo1.isHidden());
			}
			catch(Exception ex) {
				System.out.println("Ha sucedido un problema mostrando algunos parámetros.");
			}
		}
		else {
			System.out.println("El fichero no existe y no se pueden mostrar sus propiedades.");
		}
		
		duplicarFicheros(archivo1,archivo2);
		borrarFichero(archivo1);
		leerDeFichero(archivo2);
		File directorio = new File(directorioActual + File.separator + "dirEjer1");
		if(comprobarExiste(directorio)==false) {
			directorio.mkdir();
		}
		
		
	}
	
public static boolean leerDeFichero(File miFichero){
	int leido;
	try {
		FileReader lectura = new FileReader(miFichero);
		while((leido=lectura.read())!=-1) {
			System.out.print((char)leido);
		}
		lectura.close();
		return true;
	}
	catch(Exception ex) {
		System.out.println("El archivo indicado no ha podido ser encontrado.");	
		return false;
	}
}

public static boolean escribirEnFichero(File miFichero) {
	try {
		FileWriter escritura = new FileWriter(miFichero);
		for(int i=0; i<=10; i++) {
			escritura.write(i + "\n");
		}
		escritura.close();
		return true;
	}
	catch(Exception ex){
		System.out.println("El archivo indicado no ha podido ser encontrado.");	
		return false;
	}
	
}

public static boolean borrarFichero(File miFichero) {
	return miFichero.delete();
}
public static boolean comprobarExiste(File miFichero) {
	return miFichero.exists();
}
public static void duplicarFicheros(File origen, File destino){
	int leido;
	try {
		FileReader lectura = new FileReader(origen);
		FileWriter escritura = new FileWriter(destino);
		while((leido=lectura.read())!=-1) {
			escritura.write(leido);
		}
		lectura.close();
		escritura.close();
	}
	catch(Exception ex) {
		System.out.println("No se han podido encontrar los ficheros.");
	}
}

}