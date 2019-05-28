package callCenter;

/**
 * DTO de empleado
 * @author Juan Pablo Camacho
 *
 */
public class Employee {
	
	private String type;

	private boolean isFree;
	
	private String name;

	public Employee(String type, boolean isFree, String name) {
		super();
		this.type = type;
		this.isFree = isFree;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	

}
