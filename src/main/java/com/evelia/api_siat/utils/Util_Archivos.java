package com.evelia.api_siat.utils;

import com.evelia.api_siat.entity.PersonaEntity;

public class Util_Archivos {
	
	 public static String obtenerNombreArchivo(PersonaEntity pers,String recurso, String nombreArchivo){
	     if (nombreArchivo!=null) {
	      // obtener el nombre sin extension
	      String nombre = nombreArchivo;
	      String extension = "";
	      if (nombreArchivo.indexOf(".")!=-1){
	         nombre = nombreArchivo.substring(0,nombreArchivo.indexOf("."));
	         extension = nombreArchivo.substring(nombreArchivo.indexOf("."),nombreArchivo.length());
	      }
	      return eliminarCaractaresRaros(pers.getApellido()+"_"+pers.getNombre()+"_Doc"+pers.getNumeroDoc()+"_"+recurso+"_"+nombre+"_"+Util_Fechas.hoyFechaHoraString()+extension);
	    }
	    return null;
	  }
	 	 
	 public static String eliminarCaractaresRaros(String string) {
	    if (string == null)
	      return null;

	    String stringRetorno = "";
	    int len = string.length();
	    for (int i=0;i<len;i++){ 
	    	char c = string.charAt(i);
	    	if(c == 'Ñ')stringRetorno+='N';
	    	else if(c == 'ñ')stringRetorno+='n';
	    	else if(c == 'Á')stringRetorno+='A';
	    	else if(c == 'É')stringRetorno+='E';
	    	else if(c == 'Í')stringRetorno+='I';
	    	else if(c == 'Ó')stringRetorno+='O';
	    	else if(c == 'Ú')stringRetorno+='U';
	    	else if(c == 'á')stringRetorno+='a';
	    	else if(c == 'é')stringRetorno+='e';
	    	else if(c == 'í')stringRetorno+='i';
	    	else if(c == 'ó')stringRetorno+='o';
	    	else if(c == 'ú')stringRetorno+='u';
	    	else if(c == ' ')stringRetorno+='_';
	    	else if ((c<=127) &&(!(c>33 && c<45)) && (c!=47) && (!(c>58 && c<64)) && (c!=96) && (!(c>123 && c<127)))
	    		stringRetorno+=string.charAt(i);
	    }
	    
	    return stringRetorno;
	  }
	  

}
