package profesores;

public class Fecha {

	private int dia;
	private int mes;
	private int anio;
	
	public Fecha() {
		dia = 0;
		mes = 0;
		anio = 0;
	}
	
	public Fecha(String fecha) {
		String diaFecha = fecha.substring(0,fecha.indexOf("/"));
		String restoFecha = fecha.substring(fecha.indexOf("/")+1,fecha.length());
		String mesFecha = restoFecha.substring(0,restoFecha.indexOf("/"));
		restoFecha = restoFecha.substring(restoFecha.indexOf("/")+1,restoFecha.length());
		String anioFEcha = restoFecha.substring(0,restoFecha.length());
		dia = Integer.parseInt(diaFecha);
		mes = Integer.parseInt(mesFecha);
		anio = Integer.parseInt(anioFEcha);
	}
	
	public Fecha(int unDia, int unMes, int unAnio){
		dia = unDia;
		mes = unMes;
		anio = unAnio;
	}
	
	public void setDia(int unDia){
		dia = unDia;
	}
	
	public void setMes(int unMes){
		mes = unMes;
	}
	
	public void setAnio(int unAnio){
		anio = unAnio;
	}

	public int getDia(){
		return dia;
	}
	
	public int getMes(){
		return mes;
	}
	
	public int getAnio(){
		return anio;
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + anio ;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		if (anio != other.anio)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}




}


