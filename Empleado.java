package profesores;


public class Empleado  implements IEmpleado{

	private Fecha anioIncorporacion;
	private String numDespacho;


	public Empleado() {
	}
	
	/**
	 * @param anioIncorporacion
	 * @param numDespacho
	 */
	public Empleado(Fecha anioIncorporacion, String numDespacho) {

		this.anioIncorporacion = anioIncorporacion;
		this.numDespacho = numDespacho;
	}

	public Fecha getAnioIncorporacion() {
		return anioIncorporacion;
	}

	public void setAnioIncorporacion(Fecha anioIncorporacion) {
		this.anioIncorporacion = anioIncorporacion;
	}

	public String getNumDespacho() {
		return numDespacho;
	}

	public void setNumDespacho(String numDespacho) {
		this.numDespacho = numDespacho;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (anioIncorporacion == null) {
			if (other.anioIncorporacion != null)
				return false;
		} else if (!anioIncorporacion.equals(other.anioIncorporacion))
			return false;
		if (numDespacho == null) {
			if (other.numDespacho != null)
				return false;
		} else if (!numDespacho.equals(other.numDespacho))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [anioIncorporacion=" + anioIncorporacion.toString() + ", numDespacho=" + numDespacho + "]";
	}
	
}