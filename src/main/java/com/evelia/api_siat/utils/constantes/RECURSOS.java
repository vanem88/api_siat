package com.evelia.api_siat.utils.constantes;

public class RECURSOS {


public RECURSOS() {}

  public static String CHAT = "Chat";
  public static String INICIO= "Inicio";
  public static String FAQ = "Faq";
  public static String PIZARRON = "Pizarrón";
  public static String CORREO__ = "Correo"; //No se usaria mas
  public static String FORO_OPINION = "ForoOpinion";
  public static String FORO_ASUNTO = "ForoAsunto";
  public static String ESTADISTICAS = "Estadisticas";
  public static String ESTADISTICAS_ACCESO = "EstadisticasAcceso";
  public static String ESTADISTICAS_CORREO = "EstadisticasCorreo";
  public static String ESTADISTICAS_LISTADOS = "EstadisticasListados";
  public static String ESTADISTICAS_INFORMES = "EstadisticasInformes";
  public static String GRUPO = "Grupo";
  public static String ADMINISTRACION_DE_GRUPOS = "AdministracionDeGrupos";
  public static String CONFIGURACION_DE_GRUPOS = "ConfiguracionDeGrupos";
  public static String ANOTADOR = "Anotador";
  public static String GESTION_INTEGRANTES = "GestionIntegrantes";
  public static String INVITACION = "Invitacion";
  public static String SOLICITUD = "Solicitud";
  public static String FORO = "Foro";//Es usado unicamente para mostrar el listado de herramientas que se pueden
  									 //configurar en la interfaz de la configuraci�n de grupos, NO SE USA como RECURSO.
  public static String SECRETARIA_GRUPO = "SecretariaGrupo";
  /*HASTA ACA*/
  
  // envio de actividades y correcciones
  public static String ACTIVIDADES = "Actividades";
  public static String ENVIAR_ACTIVIDADES_Y_VER_CALIFICACIONES = "EnviarActividadesYVerCalificaciones";
  public static String RECIBIR_Y_EVALUAR_ACTIVIDADES = "RecibirYEvaluarActividades";
  // a su ves el permiso RECIBIR_Y_EVALUAR_ACTIVIDADES se particiona en
  // EVALUAR_ACTIVIDAD Y CREACION_ACTIVIDAD
  public static String EVALUAR_ACTIVIDADES = "EvaluarActividades";
  public static String CREAR_ACTIVIDADES = "CrearActividades";

  public static String CALIFICACIONES_VISTA_TUTOR = "CalificacionesVistaTutor";
  public static String CALIFICACIONES_VISTA_ALUMNO = "CalificacionesVistaAlumno";

  // rfecursos para el manejo de materiales
  public static String MATERIALES = "Materiales";
  public static String MATERIALES_ADICIONALES = "MaterialesAdicionales";
  public static String SOFTWARE = "Sofware";
  public static String BIBLIOGRAFIA = "Bibliografia";
  public static String ENLACES = "Enlaces";
  public static String MIS_MATERIALES = "MisMateriales";
  public static String MATERIALES_COMPARTIDOS = "MaterialesCompartidos";


  public static String NOTICIAS = "Noticias";
  public static String SECRETARIA = "Secretaria";
  public static String ADMINISTRACION = "Administracion";
  public static String ACCESO_FUERA_DE_LINEA = "AccesoFueraDeLinea";
  public static String VISUALIZACION_MINIMA_AULAS = "VisualizacionMinimaAulas";
  
  public static String DATOS_PERSONALES = "DatosPersonales"; //No se usaria mas
  public static String INFORMACION = "InformacionCarrera";
  public static String CALENDARIO = "Calendario";
  public static String ALERTAS = "Alertas";
  public static String CONTACTOS = "Contactos";
  public static String SEGUIMIENTO = "Seguimiento";
  public static String SOLICITUD_DE_AULA = "SolicitudAula";
  public static String INSCRIPCION_ON_LINE = "Inscripcion Online";
  public static String INSCRIPCION_AGIL = "Inscripcion Agil";
  public static String ACTUALIZACIONES = "Actualizaciones";
  
  /*SubRecursos de la Secretaria*/
  public static String ADMINISTRACION_PLATAFORMA = "AdministracionPlataforma";//WebMaster
  public static String BUSCAR_USUARIO = "BuscarUsuario";
  public static String AGREGAR_USUARIO = "AgregarUsuario";
  public static String ASIGNAR_USUARIO_A_UN_AULA = "AsignarUsuarioAula";
  public static String CARGA_ALUMNOS_DESDE_ARCHIVO = "CargaAlumnosDesdeArchivo";
  public static String ASIGNAR_MIEMBROS_EQUIPO_DOCENTE = "AsignarMiembrosEquipoDocente";
  public static String ASIGNAR_ALUMNOS_COMISIONES = "AsignarAlumnosComisiones";
  public static String LISTADO_ALUMNOS = "ListadoAlumnos";
  public static String USUARIOS_ACTIVOS = "UsuariosActivos"; 
  public static String AULAS_DE_UN_USUARIO = "AulasDeUnUsuario";
  public static String ADMINISTRAR_SOLICITUDES_AULAS = "AdministrarSolicitudesAulas";//WebMaster
  public static String CAMBIAR_ESTADO_AULAS = "CambiarEstadoAulas";//WebMaster
  public static String CREAR_COMISIONES = "CrearComisiones";
  public static String CREAR_ORGANIZACION = "CrearOrganizacion";
  public static String AGREGAR_O_QUITAR_TIPO_DE_USUARIO = "AgregarQuitarTipoUsuario";
  public static String CONFIGURACION_AULA = "ConfiguracionAula";
  public static String CONFIGURACION_PERMISOS_AULA = "ConfiguracionPermisosAula";
  public static String PLANTILLA_PERMISOS = "PlantillaPermisos";
  public static String EDITAR_NOMBRES_USUARIOS = "EditarNombresTipoUsuario";
  public static String GESTION_RECURSOS = "GestionRecurso";
  /*Evaluaciones*/
  public static String EVALUACIONES = "Evaluaciones"; /*modoescr doc - lect alumno*/
  public static String GESTION_EXAMEN = "Gestion_Examen";
  public static String CORRECCION_EXAMEN = "Correccion_Examen";
  public static String GESTION_AUTOEXAMEN = "Gestion_Autoexamen";
  public static String GESTION_CUESTIONARIO = "Gestion_Cuestionario";
  public static String REALIZAR_EXAMEN = "Realizar_Examen";
  public static String REALIZAR_AUTOEXAMEN = "Realizar_Autoexamen";
  public static String REALIZAR_CUESTIONARIO = "Realizar_Cuestionario";
  public static String UNIFICAR_USUARIOS = "Unificar_Usuarios";
  public static String GESTIONAR_USUARIOS = "Gestionar_Usuarios";
  /*fin Evaluaciones*/
  
  public static String ADMINISTRAR_SOLICITUDES_CLAVES = "Administrar_Solicitudes_Claves";
  
  public static String CREAR_SALAS = "CrearSalas";
  public static String VER_SALAS = "VerSalas";
  
  public static String []LISTA_DE_SUBRECURSOS_SECRETARIA = {
	    ADMINISTRACION_PLATAFORMA,BUSCAR_USUARIO,AGREGAR_USUARIO,ASIGNAR_USUARIO_A_UN_AULA,CARGA_ALUMNOS_DESDE_ARCHIVO,
	    ASIGNAR_MIEMBROS_EQUIPO_DOCENTE,ASIGNAR_ALUMNOS_COMISIONES,LISTADO_ALUMNOS,USUARIOS_ACTIVOS,AULAS_DE_UN_USUARIO,
	    ADMINISTRAR_SOLICITUDES_AULAS,CAMBIAR_ESTADO_AULAS,CREAR_COMISIONES,AGREGAR_O_QUITAR_TIPO_DE_USUARIO,CONFIGURACION_AULA
  };
  
  public static String []LISTA_DE_RECURSOS_PARA_ESTADISTICAS = {
    INICIO,
    FORO_OPINION,
    NOTICIAS,
    PIZARRON,
    FAQ,
    CALENDARIO,
    MATERIALES,
    MATERIALES_ADICIONALES,
    SOFTWARE,
    ENLACES,
    CONTACTOS,
    ACTIVIDADES,    
    ENVIAR_ACTIVIDADES_Y_VER_CALIFICACIONES,
    RECIBIR_Y_EVALUAR_ACTIVIDADES,    
    //ML Para mayor control sobre el recurso actividades
    ENVIAR_ACTIVIDADES_Y_VER_CALIFICACIONES,RECIBIR_Y_EVALUAR_ACTIVIDADES,
    CALIFICACIONES_VISTA_TUTOR,
    CALIFICACIONES_VISTA_ALUMNO,
    ESTADISTICAS,
    INFORMACION,
    EVALUACIONES,
    REALIZAR_EXAMEN,
    REALIZAR_AUTOEXAMEN,
    REALIZAR_CUESTIONARIO,
    VER_SALAS
  };
  
  /*CODIGO AGREGADO POR GRUPO CONDE-PEREYRA - TEMA: GRUPOS*/
  
  /*Ojo, estos dos arreglos estan ligados, si uno se cambia tener en cuenta el otro. Esta ligaci�n la hizo juli�n para 
   * la configuraci�n de herramientas, para que aparezca escrito FORO pero se configuren FORO_ESTADO, ASUNTO Y OPINION*/
  
  /*eSTA LISTA SE MUESTRA EN LA INTERFAZ DE CONFIGURACI�N, DONDE UNO PUEDE TILDAR LAS HERRAMIENTAS QUE DESEA CONFIGURAR*/
  public static String []LISTA_PARA_LA_VISTA_DE_RECURSOS_PARA_CONFIGURACION_GRUPO = {
	    //CHAT,
	    FORO,
	    //FAQ,
	    ANOTADOR,
	    CALENDARIO,
	    //MATERIALES,
	    //MATERIALES_ADICIONALES,
	    //CONTACTOS,
	    ACTIVIDADES,
	    GESTION_INTEGRANTES,
	    CALIFICACIONES_VISTA_ALUMNO,
	    SECRETARIA_GRUPO
};

  
public static String []LISTA_DE_RECURSOS_PARA_CONFIGURACION_GRUPO = {
	    //CHAT,
	    FORO_ASUNTO,
	    FORO_OPINION,
	    //FAQ,
	    ANOTADOR,
	    CALENDARIO,
	    //MATERIALES,
	    //MATERIALES_ADICIONALES,
	    //CONTACTOS,
	    ACTIVIDADES,
	    CALIFICACIONES_VISTA_ALUMNO,
	    GESTION_INTEGRANTES,
	    SECRETARIA_GRUPO
	    //SOLICITUD, 
	    //INVITACION
};


public static String []LISTA_DE_OPCIONES_DEL_RECURSO_FORO = {
	    FORO_OPINION,
	    FORO_ASUNTO,
};
/*HASTA ACA*/

/*SolicitudAula*/
public static String []LISTA_DE_RECURSOS_POSIBLES_DE_UTILIZAR = {
    NOTICIAS,
    PIZARRON,
    FAQ,
    CALENDARIO,
    MATERIALES,
    CONTACTOS,
    ACTIVIDADES,
    ESTADISTICAS,
    INFORMACION,
    FORO_ASUNTO,
};

public static String []LISTA_DE_RECURSOS_POSIBLES_DE_UTILIZAR_PARA_SOLICITUDES = {
    NOTICIAS,
    PIZARRON,
    FAQ,
    CALENDARIO,
    MATERIALES,
    CONTACTOS,
    ACTIVIDADES,
    CREAR_ACTIVIDADES,
	ENVIAR_ACTIVIDADES_Y_VER_CALIFICACIONES,
	EVALUAR_ACTIVIDADES,
	RECIBIR_Y_EVALUAR_ACTIVIDADES,
	CALIFICACIONES_VISTA_ALUMNO,
	CALIFICACIONES_VISTA_TUTOR,
    ESTADISTICAS,
    INFORMACION,
	FORO_OPINION,
	FORO,
    FORO_ASUNTO,
};


}