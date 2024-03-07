package retoUD5;

import java.io.File;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String directorioActual;

		System.out.println(directorioActual = System.getProperty("user.dir"));
		File fichero = new File(directorioActual + File.separator + "persona.dat");
		try {
			fichero.createNewFile();
		}
		catch(Exception ex) {
			System.out.println("Ha sucedido un error");
		}
		Persona manolo = new Persona("Manolo", "Español", 25, 174.3, 75.5);
		Persona fatema = new Persona("Fatema", "Marroquí", 38, 165.1, 60.0);
		Persona charles = new Persona("Charles", "Estadounidense", 65, 184.5, 80.3);
		
		guardarObjeto(fichero, manolo, fatema, charles);
		leerObjeto(fichero);
		
		
	}

	public static void guardarObjeto(File archivo, Persona persona1, Persona persona2, Persona persona3) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(persona1);
			oos.writeObject(persona2);
			oos.writeObject(persona3);
			oos.close();
		}
		catch(Exception ex){
			System.out.println("Ha sucedido un error");
		}
	}

	public static void leerObjeto(File archivo) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream (archivo));
			Persona persona4, persona5, persona6;
			persona4 = (Persona)ois.readObject();
			persona5= (Persona)ois.readObject();
			persona6=(Persona)ois.readObject();
			System.out.println("Nombre: " + persona4.getNombre()+ ", Nacionalidad: " + persona4.getNacionalidad() +  ", Edad: " + persona4.getEdad() + ", Estatura: " + persona4.getEstatura() + ", Peso: " + persona4.getPeso());
			System.out.println("Nombre: " + persona5.getNombre() + ", Nacionalidad: " + persona5.getNacionalidad() +  ", Edad: " + persona5.getEdad() + ", Estatura: " + persona5.getEstatura() + ", Peso: " + persona5.getPeso());
			System.out.println("Nombre: " + persona6.getNombre() + ", Nacionalidad: " + persona6.getNacionalidad() +  ", Edad: " + persona6.getEdad() + ", Estatura: " + persona6.getEstatura() + ", Peso: " + persona6.getPeso());
			ois.close();
		}
		catch(Exception ex){
			System.out.println("Ha sucedido un error");
		}
	}	
}

class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8751109845746072646L;
	
	String nombre, nacionalidad;
	int edad;
	double estatura, peso;
	
	public Persona(String nombre, String nacionalidad, int edad, double estatura, double peso){
		
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
		this.edad = edad;
		this.estatura=estatura;
		this.peso=peso;
		
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getNacionalidad(){
		return nacionalidad;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public double getEstatura(){
		return estatura;
	}
	
	public double getPeso(){
		return peso;
	}
	
}

