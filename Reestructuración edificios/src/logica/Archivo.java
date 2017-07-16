package logica;

import objetos.Material;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Archivo {
	
	/***Escritura de archivo***/
	public static void escribir(String ruta, String dato) {
	
		try {
			RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
			raf.seek(raf.length());			
			raf.write((dato+System.lineSeparator()).getBytes());
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/***Lectura de archivo***/
	public static Material buscar(String ruta, int cod) {
			
		try {
			RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
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
	
	public static void actualizar(String ruta, int cod, String desc) throws Exception {
	/*
		try {
			RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
			ArrayList<Material> matList = new ArrayList<Material>();
			Material matAux;
			String linea;
			String [] split; 
			
			while((linea=raf.readLine())!= null) {
				linea = linea.toString();
				split = linea.split("\\|");
				if(Integer.parseInt(split[0]) == cod) {
					matAux = new Material(cod, desc);	
				}
				else
					matAux = new Material(Integer.parseInt(split[0]), split[1]);
			
				matList.add(matAux);
			}
			
			
			for (Material mat : matList) {
				raf.write((mat.getCod()+"|"+mat.getDesc()+System.lineSeparator()).getBytes());
			}
			
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
        try {
        	File file = new File(ruta);
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
			
			FileWriter writer = new FileWriter(ruta);
			
			for (Material mat : matList) {
				writer.write((mat.getCod()+"|"+mat.getDesc()+System.lineSeparator()));
			}

            writer.close();
			
		} catch (Exception e) {
			throw new Exception("Error al actualizar el archivo: " + e.getMessage());
		}
        
	}
	
	
}
