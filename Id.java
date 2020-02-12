package profesores;
public class Id implements IId {
	
	String $oid;

	public Id() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Id(String $oid) {
		super();
		this.$oid = $oid;
	}

	public String get_id() {
		return $oid;
	}

	public void set_id(String $oid) {
		this.$oid = $oid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (($oid == null) ? 0 : $oid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		if ($oid == null) {
			if (other.$oid != null)
				return false;
		} else if (!$oid.equals(other.$oid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Id [$oid=" + $oid + "]";
	}

}
