package com.evelia.api_siat.utils.constantes;


public class TIPO_PERMISOS {

  public TIPO_PERMISOS() {
  }

  public static String NINGUNO = "Ninguno";
  public static String LECTURA = "Lectura";
  public static String ESCRITURA = "Escritura";

  public static String maximoPermiso(String tipoPermiso1, String tipoPermiso2)
  {
    // si aumenta el numero de tipos de permisos habria que repensar la logica
    // lo hago asi para que sea rapido y funcione de una
    if (tipoPermiso1 == null)
      return tipoPermiso2;

    if (tipoPermiso2 == null)
      return tipoPermiso1;

   if (tipoPermiso1.compareTo(ESCRITURA) == 0)
     return tipoPermiso1;

   if (tipoPermiso2.compareTo(ESCRITURA) == 0)
     return tipoPermiso2;

   if (tipoPermiso1.compareTo(LECTURA) == 0)
     return tipoPermiso1;

   if (tipoPermiso2.compareTo(LECTURA) == 0)
     return tipoPermiso2;

   return tipoPermiso1;
  }

}