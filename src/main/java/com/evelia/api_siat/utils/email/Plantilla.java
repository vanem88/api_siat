package com.evelia.api_siat.utils.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import com.evelia.api_siat.utils.Util;
import persistencia.dominio.DatosGenerales;

public class Plantilla {
	
	void Pantilla() {}
	
	public MimeMultipart plantillaMail(String titulo, String text,DatosGenerales datos,String CIDimagenCabecera, String urlSIAT){
		MimeMultipart multipart = new MimeMultipart();
		try {					  	  			
			String htmlMail = contenidoHTMLPlantillaMail(titulo, text,datos,CIDimagenCabecera, urlSIAT);
			//texto html con imagenes
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(htmlMail, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);
			return multipart;
		} catch (MessagingException e) {
			e.printStackTrace();
			return multipart;
		}

	  }
	
	
	private String contenidoHTMLPlantillaMail(String titulo, String contenido,DatosGenerales datos,String CIDimagenCabecera, String urlSIAT){
		String htmlPlantilla = "";
		htmlPlantilla += "<div style=\"background-color: #fff;\">";	
		htmlPlantilla += "<table align=\"center\" ";
		htmlPlantilla += "style=\"border-collapse: collapse; table-layout: fixed; Margin-left: auto; Margin-right: auto; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #ffffff;\">";
		htmlPlantilla += "	<tbody>";
		htmlPlantilla += "		<tr>";
		htmlPlantilla += "			<td class=\"column\" style='font-size: 14px; line-height: 21px; padding: 0; text-align: left; vertical-align: top; color: #60666d; font-family:\"Open Sans\", sans-serif;' width=\"600\">";
		htmlPlantilla += "				<div style=\"font-size: 12px; font-style: normal; font-weight: 400;\" align=\"center\">";
		htmlPlantilla += "					<a href=\""+urlSIAT+"\" style=\"text-decoration: underline; transition: opacity 0.1s ease-in; color: #5c91ad;\">";
		htmlPlantilla += "						<img src=\""+CIDimagenCabecera+"cabecera.png"+"\" class=\"gnd-corner-image gnd-corner-image-center gnd-corner-image-top\"";
		htmlPlantilla += "							style=\"display: block; border: 0; max-width: 900px;\"";
		htmlPlantilla += "							 width=\"600\" height=\"39\" /></a>";
		htmlPlantilla += "				</div>";
		htmlPlantilla += "				<div style=\"Margin-left: 20px; Margin-right: 20px; Margin-top: 5px;\">";
		htmlPlantilla += "				</div>";
		htmlPlantilla += "				<div style=\"Margin-left: 20px; Margin-right: 20px;\">";
		htmlPlantilla += "					<p style=\"Margin-top: 0; Margin-bottom: 0; font-style: normal; font-weight: bold; font-size: 24px; line-height: 32px; color: #44a8c7; text-align: center;\">";
		htmlPlantilla += 						titulo;
		htmlPlantilla += "					</p>";
		htmlPlantilla += "					<p style=\"font-size: 16px; line-height: 24px;\">"; 
		htmlPlantilla += 						contenido;
		htmlPlantilla += "					</p>";
		htmlPlantilla += "					<br>";
		htmlPlantilla += "				</div>";
		htmlPlantilla += "			</td>";
		htmlPlantilla += "		</tr>";
		htmlPlantilla += "	</tbody>";
		htmlPlantilla += "</table>";

		htmlPlantilla += "<table style=\"border-collapse: collapse; table-layout: fixed; Margin-right: auto; Margin-left: auto; border-spacing: 0;\"";
		htmlPlantilla += "width=\"600\" align=\"center\">";
		htmlPlantilla += "	<tbody>";
		htmlPlantilla += "		<tr>";
		htmlPlantilla += "			<td style=\"padding: 0 0 40px 0;\">";
		
		htmlPlantilla += "<table width=\"400\" style='border-collapse: collapse; table-layout: fixed; border-spacing: 0; color: #b9b9b9; font-family:\"Open Sans\",sans-serif;'>";
		htmlPlantilla += "	<tbody>";
		htmlPlantilla += "		<tr>";
		htmlPlantilla += "			<td style=\"padding: 0; font-size: 12px; line-height: 19px;\">";
		
		htmlPlantilla += "				<div style=\"Margin-top: 26px;\">";
		htmlPlantilla += "					<div>";
		htmlPlantilla += "						Nos puede contactar por los siguiente medios:<br />";
		htmlPlantilla += "						tel&#233;fono:"+datos.getTelefonoOficina()+"<br />";
		htmlPlantilla += "						correo: "+datos.getMailContacto()+"<br /> o en nuestra oficina: "+Util.convert(datos.getUbicacionOficina())+" Campus de la "+datos.getSiglaInstitucion()+".";
		htmlPlantilla += "					</div>";
		htmlPlantilla += "				</div>";
		
		htmlPlantilla += "				<div class=\"footer__permission\" style=\"Margin-top: 18px;\">";
		htmlPlantilla += "					<div>&#169; 2001-"+utils.Utils.anioHoy()+"&nbsp;"+Util.convert(datos.getNombreInstitucion())+"&nbsp;&#8226; Versión; "+datos.getVersionSistema()+"&nbsp;</div>";
		htmlPlantilla += "				</div>";
		
		htmlPlantilla += "			</td>";
		htmlPlantilla += "		</tr>";
		htmlPlantilla += "	</tbody>";
		htmlPlantilla += "</table>";
		
		htmlPlantilla += "</td>";
		htmlPlantilla += "</tr>";
		htmlPlantilla += "</tbody>";
		htmlPlantilla += "</table>";
				
		htmlPlantilla += "</div>";
				
		return htmlPlantilla;
	}

}
