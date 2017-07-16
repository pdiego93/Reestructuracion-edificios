package objetos;

public class Tap {
	
	private String modelo;
	private int atenuaH;
	private int atenuaL;
	private int salidas;
	private float insertionH;
	private float insertionL;
	
	
	public Tap(String modelo, int atenuaH, int atenuaL, int salidas, float insertionH, float insertionL){
		this.modelo = modelo;
		this.atenuaH = atenuaH;
		this.salidas = salidas;
		this.atenuaL = atenuaL;
		this.insertionH = insertionH;
		this.insertionL = insertionL;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public int getAtenuaH(){
		return atenuaH;
	}
	
	public int getAtenuaL(){
		return atenuaL;
	}
	
	public int getSalidas(){
		return salidas;
	}
	
	public float getInsertionH(){
		return insertionH;
	}
	
	public float getInsertionL(){
		return insertionL;
	}
	
	
	

}
