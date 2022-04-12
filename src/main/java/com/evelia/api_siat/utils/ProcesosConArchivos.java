package com.evelia.api_siat.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;
import persistencia.dominio.Persona;
import utils.Utils;


public class ProcesosConArchivos {
	
	ProcesosConArchivos(){}
	
	/*
	  * Renombra un archivo
	  * */
	 public static boolean renombrarArchivo(String archivoOrigen, String archivoDestino) throws Exception{	  
		  try{			
		    File oldfile = new File(archivoOrigen);
	        File newfile = new File(archivoDestino);	        
	        if(newfile.exists())newfile.delete();	        
	        if (oldfile.renameTo(newfile)) return true;
	         else return false;	  	        				    
		  }catch(Exception ex){
			  System.out.println("Exception");
			  return false;
		  }		 
	  }	 
	 
	
	 
	 /*
	  *  Comprime un directorio y luego lo elimina. 
	  *  */
	 public static boolean comprimeArchivos(List<MultipartFile> archivosTmp,Persona persona, String pathArchivoAbsoluto,String nombreArchivoZip,String deRecurso) throws Exception{ 
		 	boolean almacenando = true;	 
		 	try {
		 		File f = new File(pathArchivoAbsoluto+"/"+nombreArchivoZip);	
				if (!f.exists() && !f.mkdirs())
					throw new Exception("No se pudo crear la carpeta "+pathArchivoAbsoluto);
			 	for (MultipartFile mf : archivosTmp) {
		            if (!mf.isEmpty()) {
		                // Obtener el nombre del archivo cargado actualmente
		                String myFileName = mf.getOriginalFilename();
		                // Si el nombre no es "", el archivo existe, de lo contrario el archivo no existe.
		                if (myFileName.trim() != "") {
		                    // Cambiar el nombre del archivo cargado
		                    String filename =  Utils.obtenerNombreArchivo(persona, deRecurso, myFileName);
		                    String path = pathArchivoAbsoluto+"/"+nombreArchivoZip+"/"+filename;		                    
		                    File localFile = new File(path);
		                    mf.transferTo(localFile);		                    
		                }
		            }
		        }
		 	}catch(Exception ex) {
		 		almacenando = false;	 
		 	}
		 			 	
			if(almacenando){
				boolean sePuedeComprimir = comprimirArchivoZip(pathArchivoAbsoluto,nombreArchivoZip);			
				if(sePuedeComprimir){
					File directorio = new File(pathArchivoAbsoluto+"/"+nombreArchivoZip);					
					File[] ficheros = directorio.listFiles();
    				for (int x=0;x<ficheros.length;x++)
    					ficheros[x].delete();									
					if(!directorio.delete()) 
						almacenando = false;
				}else
					almacenando = false;
			}
			return almacenando;
		} 
	 
	 /*
	  * Comprime los archivos que estan dentro de una carpeta
	  * */
	 public static boolean comprimirArchivoZip(String pathAcomprimir, String pathConNombreZip) throws Exception {
		 try {			 
		    File file=new File(pathAcomprimir+"/"+pathConNombreZip);
		    File zipFile=new File(pathAcomprimir+"/"+pathConNombreZip+".zip");			
			InputStream input=null;
			ZipOutputStream zipOut =new ZipOutputStream(new FileOutputStream(zipFile));
			int temp=0;
			if(file.isDirectory()){
				File[] lists = file.listFiles(); // Regresar a todas las carpetas
				for(int i=0;i<lists.length;i++)	{
					input=new FileInputStream(lists[i]);
					zipOut.putNextEntry(new ZipEntry(file.getName()+File.separator+lists[i].getName()));
					while((temp=input.read())!=-1)
						zipOut.write(temp);
					input.close();
				}						
			}			
			zipOut.close();
			return true;
		 }catch(Exception ex) {
			return false;
		 }
	  }
	 
	 
	 /*
		 * Consulta el sistema operativo
		 * */
	/*	 public static String consultarSistemaOperativo(){
			  String OS = System.getProperty("os.name").toLowerCase();
			  if (OS.indexOf("windows 10") > -1 ||OS.indexOf("windows 9") > -1 || (OS.indexOf("nt") > -1) || (OS.indexOf("windows 2000") > -1 ) || (OS.indexOf("windows 7") > -1 ) || (OS.indexOf("windows xp") > -1))
				  return CONSTANTES_SO.WINDOWS;		  
			  else if (OS.indexOf("mac") > -1)
				  return CONSTANTES_SO.WINDOWS;
			  else return CONSTANTES_SO.LINUX;	    
		  } */
	 
	 /*
	  * Ejecuta un proceso y espera hasta que termine
	  * */
/*	 public static int ejecutarProceso(String sentencia) throws Exception{		
		  Process process = Runtime.getRuntime().exec(sentencia);
		  //Espera hasta que el proceso termine
		  process.waitFor();
		  //Codigo de salida del proceso.
		  return process.exitValue();	  
      }*/
	 
	 /*
	  * Ejecuta un proceso y no espera a que finalice
	  * */
/*	 public static int ejecutarProcesoSinEsperar(String sentencia) throws Exception{		
		 try{
			  Runtime.getRuntime().exec(sentencia);
		 }catch(Exception ex){
			  throw new ExceptionArchivos("No se pudo ejecutar el comando.","ProcesosConArchivos.java","ejecutarProcesoSinEsperar");
		 }
		 return 1;   
      }
	 */
	 
	 
	 /* public static boolean copiarArchivo(String archivoOrigen, String carpetaDestino) throws Exception{	  
	  try{
		  String sentencia = "";
		  if(consultarSistemaOperativo().compareTo(CONSTANTES_SO.LINUX)==0)
			  sentencia = "cp "+" "+archivoOrigen+" "+carpetaDestino;
		  if(consultarSistemaOperativo().compareTo(CONSTANTES_SO.WINDOWS)==0) 
			  sentencia = "cmd /c copy \""+archivoOrigen+"\" \""+carpetaDestino+"\"";				 
		  if(sentencia.compareTo("")!=0) {
		      int exitCode = ejecutarProceso(sentencia);
			  if(exitCode==0) return true;
			   else{
				  System.out.println("Algo mal hubo en el copiar archivo:"+exitCode);
				  return false;
			  }
		  }else{
			  System.out.println("No se puede mover o renombrar el archivo porque el sistema no está corriendo sobre Linux ni windows");
			  return true; 
		  }			  
	  }catch(Exception ex){
		  System.out.println("Exception");
		  return false;
	  }		 
 }*/


}
