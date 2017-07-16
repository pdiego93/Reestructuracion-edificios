package logica;

import objetos.Material;
import objetos.Tap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Archivo {
	
	private static String pathMaterial;
	private static String pathTap;
	private static Archivo arch = null;
	
	public Archivo(){
		if(arch==null){
			arch = this;
			cargarRutas();
		}
	}
	
	private void cargarRutas(){
		String ruta ="";
		RandomAccessFile conf;
		try {
			conf = new RandomAccessFile("config", "r");
			String confLinea;
			String confSplit[];
			while((confLinea=conf.readLine())!= null) {
				confLinea=confLinea.toString();
				confSplit = confLinea.split("\\|");
				if(confSplit[0].equals("material")) {
					pathMaterial = confSplit[1];
				}
				if(confSplit[0].equals("tap")){
					pathTap = confSplit[1];
				}
			}
			conf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/***Escritura de archivo***/
	public void escribirMaterial(String dato) throws Exception {
		
		
		try {
			RandomAccessFile raf = new RandomAccessFile(pathMaterial, "rw");
			raf.seek(raf.length());			
			raf.write((dato+System.lineSeparator()).getBytes());
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/***Lectura de archivo***/
	public Material buscarMaterial(int cod) {
			
		try {
			RandomAccessFile raf = new RandomAccessFile(pathMaterial, "rw");
			String linea;
			String [] split; 
			while((linea=raf.readLine())!= null) {
				linea=linea.toString();
				split = linea.split("\\|");
				if(Integer.parseInt(split[0]) == cod) {
					Material m1 = new Material(Integer.parseInt(split[0]), split[1]);
					return m1;
				}
			}
			if (raf != null)
				raf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public void actualizarMaterial(int cod, String desc) throws Exception {
		
        try {
        	File file = new File(pathMaterial);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			ArrayList<Material> matList = new ArrayList<Material>();
			Material matAux;
			String linea;
			String [] split; 
			
			while((linea=reader.readLine())!= null) {
				split = linea.split("\\|");
				if(Integer.parseInt(split[0]) == cod) {
					matAux = new Material(cod, desc);	
				}
				else
					matAux = new Material(Integer.parseInt(split[0]), split[1]);
			
				matList.add(matAux);
			}
			reader.close();
			
			FileWriter writer = new FileWriter(pathMaterial);
			
			for (Material mat : matList) {
				writer.write((mat.getCod()+"|"+mat.getDesc()+System.lineSeparator()));
			}

            writer.close();
			
		} catch (Exception e) {
			throw new Exception("Error al actualizar el archivo: " + e.getMessage());
		}
        
	}
	
	public HashMap<String, Tap> leerTaps(){
		HashMap<String, Tap> mapTap = new HashMap<String, Tap>(); 
		String linea;
		String [] split; 
		Tap t = null;
		
		try {
			RandomAccessFile raf = new RandomAccessFile(pathTap, "r");

			while((linea=raf.readLine())!= null) {
				linea=linea.toString();
				split = linea.split("\\|");
				t = new Tap(split[0], Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]),(float)Double.parseDouble(split[4]),(float)Double.parseDouble(split[5]));
				mapTap.put(t.getModelo(), t);
			}
			if (raf != null)
				raf.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} 
		return mapTap;
	}
	
	
}
