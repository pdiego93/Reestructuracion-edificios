package objetos;

public class Material {
	
	String desc;
	int cod;
	
	public Material(int cod, String desc) {
		this.desc = desc;
		this.cod = cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getCod() {
		return cod;
	}
	
}
