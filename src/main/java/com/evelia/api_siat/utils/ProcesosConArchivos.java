package com.evelia.api_siat.utils;

import java.io.File;
import com.evelia.api_siat.utils.constantes.CONSTANTES_SO;


public class ProcesosConArchivos {
	
	ProcesosConArchivos(){}
	
	 public static String consultarSistemaOperativo(){
		  String OS = System.getProperty("os.name").toLowerCase();
		  if (OS.indexOf("windows 10") > -1 ||OS.indexOf("windows 9") > -1 || (OS.indexOf("nt") > -1) || (OS.indexOf("windows 2000") > -1 ) || (OS.indexOf("windows 7") > -1 ) || (OS.indexOf("windows xp") > -1))
			  return CONSTANTES_SO.WINDOWS;		  
		  else if (OS.indexOf("mac") > -1)
			  return CONSTANTES_SO.WINDOWS;
		  else return CONSTANTES_SO.LINUX;	    
	  } 
	 
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
	 
	 public static int ejecutarProceso(String sentencia) throws Exception{		
		  Process process = Runtime.getRuntime().exec(sentencia);
		  //Espera hasta que el proceso termine
		  process.waitFor();
		  //Codigo de salida del proceso.
		  return process.exitValue();	  
      }
	 
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
