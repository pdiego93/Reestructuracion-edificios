package logica;

public class Main {

	public static void main(String[] args) {

		Archivo.escribir("materiales", "hola" + System.lineSeparator());
		System.out.println("listo");
	}

}
