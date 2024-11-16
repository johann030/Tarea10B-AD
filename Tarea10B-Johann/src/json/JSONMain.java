
package json;

public class JSONMain {

	public static void main(String[] args) {
		JSON js = new JSON();
		js.crearFichero();
		System.out.println("----------------------------");
		js.pedirFichero();
		System.out.println("----------------------------");
	}
}
