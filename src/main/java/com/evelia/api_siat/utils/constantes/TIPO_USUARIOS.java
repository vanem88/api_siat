package com.evelia.api_siat.utils.constantes;

import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class TIPO_USUARIOS {

  public TIPO_USUARIOS() { }
  
  public static String TUTOR = "Tutor";
  public static String DOCENTE = "Docente";
  public static String ALUMNO = "Alumno";
  public static String VEEDOR = "Veedor";
  public static String ADMINISTRADOR = "Administrador";
  public static String ADMINISTRADOR_AUXILIAR = "Administrador Auxiliar";
  public static String ADMINISTRADOR_MATERIALES = "Administrador de Materiales";
  public static String DIRECTOR = "Director";
  public static String MONITOR_SIAT = "Monitor Siat";
  public static String WEBMASTER = "Web Master";
  public static String RESPONSABLE = "Responsable";  
  public static String INVITADO = "Invitado";
  public static String COLABORADOR = "Colaborador";
  public static String COORDINADOR = "Coordinador";
  public static String ASESOR_PEDAGOGICO = "Asesor Pedagogico";
  public static String LECTOR_MATERIALES = "Lector de Materiales";
  public static String SECRETARIO_ACADEMICO = "Secretario Academico";
  
  /*CODIGO AGREGADO POR GRUPO CONDE-PEREYRA - TEMA: GRUPOS*/
  public static String LIDER = "Lider";
  public static String LIDER_SUPLENTE = "Lider Suplente";
  public static String PARTICIPANTE_INVITADO_O_INTERESADO = "Participante Invitado O Interesado";
  public static String PARTICIPANTE = "Participante";
  public static String USUARIO_PUBLICO = "Usuario Publico";
  
  public static Vector LISTA_DE_ROLES_DEL_AULA_ACTUAL = null; /*de tipo: TIPO_USUARIO*/
        
  public static String [] LISTA_DE_ROLES = {
	    LIDER,
	    LIDER_SUPLENTE,
	    PARTICIPANTE,
	    PARTICIPANTE_INVITADO_O_INTERESADO,
	    USUARIO_PUBLICO
	    };
  
  public static String [] LISTA_DE_SIGNIFICADO_DE_LOS_ROLES= {
	    "Alumno con mas permisos sobre los compañeros del grupo",
	    "Alumno suplente del lider",
	    "Demas alumnos del grupo",
	    "Alumnos que fueron integrandose al grupo mediante invitaciones o solicitud",
	    "Usuario ayudante de la materia",
	    "Docente encargado de la materia",
	    "Alumnos de la materia que no son integrantes del grupo pero pueden ingresar a ver cosas del grupo"
	    };
 

}