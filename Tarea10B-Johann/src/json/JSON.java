package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {

	public void crearFichero() {

		PedirAlumnos pal = new PedirAlumnos();
		JSONArray listaAlumno = new JSONArray();
		try {

			Alumnos[] alumnos = pal.pedir();

			for (Alumnos alumno : alumnos) {

				JSONObject aniadirAlumno = new JSONObject();

				aniadirAlumno.put("NIA", alumno.getNia());
				aniadirAlumno.put("nombre", alumno.getNombre());
				aniadirAlumno.put("apellidos", alumno.getApellidos());
				aniadirAlumno.put("genero", String.valueOf(alumno.getGenero()));
				aniadirAlumno.put("nacimiento", alumno.getNacimiento().toString());
				aniadirAlumno.put("ciclo", alumno.getCiclo());
				aniadirAlumno.put("curso", alumno.getCurso());
				aniadirAlumno.put("grupo", alumno.getGrupo());

				listaAlumno.add(aniadirAlumno);
			}

			FileWriter fw = new FileWriter("alumnos.json");
			fw.write(listaAlumno.toJSONString());
			System.out.println("Archivo alumnos.json creado correctamente.");

			fw.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void pedirFichero() {
		JSONParser parser = new JSONParser();

		try {
			FileReader fr = new FileReader("alumnos.json");
			Object alumno = parser.parse(fr);
			JSONArray listaAlumnos = (JSONArray) alumno;

			for (Object o : listaAlumnos) {
				JSONObject alumnoJson = (JSONObject) o;

				String NIA = String.valueOf(alumnoJson.get("NIA"));
				String nombre = String.valueOf(alumnoJson.get("nombre"));
				String apellidos = String.valueOf(alumnoJson.get("apellidos"));
				String genero = String.valueOf(alumnoJson.get("genero"));
				String nacimiento = String.valueOf(alumnoJson.get("nacimiento"));
				String ciclo = String.valueOf(alumnoJson.get("ciclo"));
				String curso = String.valueOf(alumnoJson.get("curso"));
				String grupo = String.valueOf(alumnoJson.get("grupo"));

				System.out.println("  NIA: " + NIA);
				System.out.println("  Nombre: " + nombre);
				System.out.println("  Apellidos: " + apellidos);
				System.out.println("  Género: " + genero);
				System.out.println("  Fecha de nacimiento: " + nacimiento);
				System.out.println("  Ciclo: " + ciclo);
				System.out.println("  Curso: " + curso);
				System.out.println("  Grupo: " + grupo);
			}

			fr.close();

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Error al parsear el archivo JSON: " + e.getMessage());
		}
	}

}
