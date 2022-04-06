package com.evelia.api_siat.utils;

import java.text.SimpleDateFormat;

public class Util_Fechas {
	
	/**
	 * convierte la fecha y hora actual al formato con separadores
	 * @param separadorFecha
	 * @param separadorHora
	 * @return
	 */
	  public static String hoyFechaHoraString(){
	    //COMENTADO PARA QUE COMPILE
	    java.sql.Timestamp hoyTimeStamp = hoySqlDate();
	    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss a");
	    return formatDate.format(hoyTimeStamp);
	  }
	  
	  public static java.sql.Timestamp hoySqlDate(){
	    return new java.sql.Timestamp((new java.util.Date().getTime()));
	  }

}
