package profesores;

public class Profesor implements IProfesor {

	private Id _id;     //==============================================
	private Persona pers;
	private Empleado empl;
	private Departamento dept;
	
	
	public Profesor() {
		this._id = new Id();    //==============================================
		this.pers = new Persona();
		this.empl = new Empleado();
		this.dept = new Departamento();
	}
	
	@Override
	public String get_id() {       //==============================================
		// TODO Auto-generated method stub
		return this._id.get_id();
	}

	@Override
	public void set_id(String id) {     //==============================================
		// TODO Auto-generated method stub
		this._id.set_id(id);
	}	
	
	/**
	 * @param pers - Persona
	 * @param empl - Empleado
	 * @param dept - Departamento
	 */
	public Profesor(Persona pers, Empleado emp, Departamento departamentos) {
		this.pers = pers;
		this.empl = emp;
		this.dept = departamentos;
	}

	//Persona
	
	@Override
	public String getNombre() {
		return pers.getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		pers.setNombre(nombre);
	}

	@Override
	public String getApellido1() {
		return pers.getApellido1();
	}

	@Override
	public void setApellido1(String apellido1) {
		pers.setApellido1(apellido1);
		
	}

	@Override
	public String getApellido2() {
		return pers.getApellido2();
	}

	@Override
	public void setApellido2(String apellido2) {
		pers.setApellido2(apellido2);
		
	}

	@Override
	public String getDni() {
		return pers.getDni(); 
	}

	@Override
	public void setDni(String dni) {
		pers.setDni(dni);
		
	}

	@Override
	public String getEstadoCivil() {
		return pers.getEstadoCivil();
	}

	@Override
	public void setEstadoCivil(String estadoCivil) {
		pers.setEstadoCivil(estadoCivil);
		
	}

	//fin Persona

	//Empleado

	@Override
	public Fecha getAnioIncorporacion() {
		return empl.getAnioIncorporacion();
	}
	
	@Override
	public void setAnioIncorporacion(Fecha anioIncorporacion) {
		empl.setAnioIncorporacion(anioIncorporacion); 
	}

	@Override
	public String getNumDespacho() {
		return empl.getNumDespacho();
	}

	@Override
	public void setNumDespacho(String numDespacho) {
		empl.setNumDespacho(numDespacho);
	}

	
	//fin Empelado
	
	//Departamento
	

	@Override
	public String getNombreDep() {
		return dept.getNombreDep();
	}

	@Override
	public void setNombreDep(String nombreDep) {
		dept.setNombreDep(nombreDep);
		
	}


	
	//fin Departamento

    //==============================================
	@Override
	public String toString() {
		return "Profesor [pers=" + pers.toString() + ", mpl=" + empl.toString() + ", dept=" + dept.toString() + "]";
	}

	



}