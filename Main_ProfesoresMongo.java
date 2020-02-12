package profesores;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.MalformedJsonException;

public class Main_ProfesoresMongo {

	public static void main(String[] args) throws MalformedJsonException {
		// TODO Auto-generated method stub
		
		MongoDAO coleccion = new MongoDAO("mongodb://localhost","facultad","profesores");

		//coleccion.drop();
		System.out.println("coleccion.drop()");
		
		List< Profesor> profesores = new ArrayList<Profesor>();		
		
		profesores.add(new Profesor(
				new Persona("Luis", "Rodriguez", "Albiol", "21544454", "Soltero"),
				new Empleado(new Fecha(12,10,2000), "100"),
				new Departamento("Informatica")));
		
		profesores.add( new Profesor(
				new Persona("Maria", "Perez", "Mayor", "312545", "Soltero"),
				new Empleado(new Fecha(10,2,2012), "200"),
				new Departamento("Historia")));
		
		profesores.add( new Profesor(
				new Persona("Ana", "Perez", "Casa", "312", "Casado"),
				new Empleado(new Fecha(15,1,2010), "300"),
				new Departamento("Ingles")));

		System.out.println("for(Profesor profesor : profesores) {if (coleccion.registrar(profesor))}");
		for(Profesor profesor : profesores) {
			if (coleccion.registrar(profesor));
			}

		coleccion.listarResultados();

		profesores = coleccion. obtener();
				
		System.out.println("profesores.get(1).setApellido2(\"Peraza\")");

		profesores.get(1).setApellido2("Peraza");
		
		System.out.println("coleccion.actualizar(profesores.get(1))");
		if (coleccion.actualizar(profesores.get(1))) {};
		coleccion.listarResultados();

		
		System.out.println("coleccion.eliminar(profesores.get(2))");
		coleccion.eliminar(profesores.get(2));
		coleccion.listarResultados();

	}
}
