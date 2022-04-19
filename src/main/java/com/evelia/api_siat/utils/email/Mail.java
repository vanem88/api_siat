package com.evelia.api_siat.utils.email;

import java.util.Date;
import java.util.Vector;

import org.springframework.core.io.FileSystemResource;

public class Mail {
	
	private String username;
    private String to;
    private String subject;
    private String text;
    private Vector files;
    private Date sendDate;
    
    public Mail(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Vector getFile() {
		return files;
	}

	public void setFile(Vector file) {
		this.files = file;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
    
    

}
