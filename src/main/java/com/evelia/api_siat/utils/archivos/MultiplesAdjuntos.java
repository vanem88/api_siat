package com.evelia.api_siat.utils.archivos;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.apache.commons.fileupload.FileItem;
import persistencia.dominio.Archivo;

public class MultiplesAdjuntos{
	
	//static final String PATH_TEMPORAL = Singleton.HOME_DIR_ANTIVIRUS;

	// Retorna un vector de string con los nombres de los archivos - los archivos se suben en una carpeta temporal
	public static Vector subirArchivosYObtenerDatos(List fileItems,String filePath,String parametro,Long idUsuario,String HOME_DIR_ANTIVIRUS) throws Exception{
		if(filePath == null || filePath.compareTo("")==0){
			filePath = HOME_DIR_ANTIVIRUS+idUsuario;
			File f = new File(filePath);
			if (!f.exists() && !f.mkdirs())
				throw new Exception("No se pudo crear la carpeta "+filePath);
		}else{
			File f = new File(filePath);
			if (!f.exists() && !f.mkdirs())
				throw new Exception("No se pudo crear la carpeta "+filePath);
		}
		Vector archivos=new Vector();
		// Process the uploaded file items
		File file ;
		Iterator i = fileItems.iterator();
		if(fileItems.size()>0){
			while ( i.hasNext () ){
				FileItem fi = (FileItem)i.next();
				if ( !fi.isFormField () ){
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					if (fieldName.equals(parametro)) {
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();

						// Write the file
						String nombreArch="";
						if(fileName.compareTo("")!=0){
							fileName = fileName.replaceAll(" ","_");
							if( fileName.lastIndexOf("\\") >= 0 ){
								nombreArch = filePath +"/"+ fileName.substring( fileName.lastIndexOf("\\"));
								file = new File( filePath +"/"+ fileName.substring( fileName.lastIndexOf("\\"))) ;
							}else{
								nombreArch = filePath +"/"+ fileName.substring( fileName.lastIndexOf("\\")+1);
								file = new File( filePath +"/"+ fileName.substring(fileName.lastIndexOf("\\")+1)) ;
							}
							if(nombreArch.compareTo("")!=0){
								archivos.add(nombreArch);
								fi.write(file);
							}
						}
					}
				}
			}
		}
		return archivos;
	}
	
	// Retorna un vector de Archivos con los nombres y nombres reales de los archivos - los archivos se suben en una carpeta temporal
	public static Vector subirArchivosYObtenerDatosConNombreReal(List fileItems,String filePath,String parametro,Long idUsuario,String HOME_DIR_ANTIVIRUS) throws Exception{
		if(filePath == null || filePath.compareTo("")==0){
			filePath = HOME_DIR_ANTIVIRUS+idUsuario;
			File f = new File(filePath);
			if (!f.exists() && !f.mkdirs())
				throw new Exception("No se pudo crear la carpeta "+filePath);
		}else{
			File f = new File(filePath);
			if (!f.exists() && !f.mkdirs())
				throw new Exception("No se pudo crear la carpeta "+filePath);
		}
		Vector archivos=new Vector();
		// Process the uploaded file items
		File file ;
		Iterator i = fileItems.iterator();
		if(fileItems.size()>0){
			while ( i.hasNext () ){
				FileItem fi = (FileItem)i.next();
				if ( !fi.isFormField () ){
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					if (fieldName.equals(parametro)) {
						String fileName = fi.getName();
						String nombreOrig =  fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						// Write the file
						String nombreArch="";
						if(fileName.compareTo("")!=0){
							fileName = fileName.replaceAll(" ","_");
							if( fileName.lastIndexOf("\\") >= 0 ){
								nombreArch = filePath+"/" + fileName.substring( fileName.lastIndexOf("\\"));
								file = new File( filePath+"/" + fileName.substring( fileName.lastIndexOf("\\"))) ;
							}else{
								nombreArch = filePath+"/" + fileName.substring( fileName.lastIndexOf("\\")+1);
								file = new File( filePath+"/" + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
							}
							if(nombreArch.compareTo("")!=0){
								archivos.add(nombreArch);
								archivos.add(nombreOrig);
								fi.write(file);
							}
						}
					}
				}
			}
		}
		return archivos;
	}

	//Analizado en donde se usa.
	// Retorna un vector de Archivos con path, nombre y nombreReal de los archivos - los archivos se suben en una carpeta temporal
	public static Vector subirArchivosYObtenerDatosMail(List fileItems,String parametro,String filePath,String HOME_DIR_TEMPORAL) throws Exception{
		if(filePath == null || filePath.compareTo("")==0){
			filePath = HOME_DIR_TEMPORAL;
			File f = new File(filePath);
			if (!f.exists() && !f.mkdirs())
				throw new Exception("No se pudo crear la carpeta "+filePath);
		}else{
			File f = new File(filePath);
			if (!f.exists() && !f.mkdirs())
				throw new Exception("No se pudo crear la carpeta "+filePath);
		}
		Vector archivos=new Vector();
		// Process the uploaded file items
		File file ;
		Iterator i = fileItems.iterator();
		if(fileItems.size()>0){
			while ( i.hasNext () ){
				FileItem fi = (FileItem)i.next();				
				if ( !fi.isFormField () ){
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					if (fieldName.equals(parametro)) {
						String fileName = fi.getName();
						String nombreOrig =  fi.getName();
						// Write the file
						String nombreArch="";
						if(fileName.compareTo("")!=0){
							fileName = fileName.replaceAll(" ","_");
							if( fileName.lastIndexOf("\\") >= 0 ){
								nombreArch = filePath + fileName.substring( fileName.lastIndexOf("\\"));
								file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
							}else{
								nombreArch = filePath + fileName.substring( fileName.lastIndexOf("\\")+1);
								file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
							}
							if(nombreArch.compareTo("")!=0){
								Archivo archivoAdjunto = new Archivo();
								archivoAdjunto.setPath(filePath);
								archivoAdjunto.setNombre(nombreArch);  //El nombre del archivo incluye el path
								archivoAdjunto.setNombreReal(nombreOrig);
								archivos.add(archivoAdjunto);
								fi.write(file);
							}
						}
					}
				}
			}
		}
		return archivos;
	}
}
