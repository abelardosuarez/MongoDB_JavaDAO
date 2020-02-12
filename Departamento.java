package profesores;

public class Departamento implements IDepartamento {

	private String nombreDep;

	
	public Departamento() {
	}
	
	/**
	 * @param nombreDep
	 */
	public Departamento(String nombreDep) {
		this.nombreDep = nombreDep;
	}

	public String getNombreDep() {
		return nombreDep;
	}

	public void setNombreDep(String nombreDep) {
		this.nombreDep = nombreDep;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (nombreDep == null) {
			if (other.nombreDep != null)
				return false;
		} else if (!nombreDep.equals(other.nombreDep))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [nombreDep=" + nombreDep + "]";
	}
	
	
	
	
}
