package com.devfull.springdata.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devfull.springdata.api.enums.StatusEnum;

@Document
public class AlteraStatus {

	@Id
	private String id;

	@DBRef
	private Ticket ticket;

	private Usuario usuarioAlteraStatus;

	private Date dataAlteraStatus;

	private StatusEnum status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Usuario getUsuarioAlteraStatus() {
		return usuarioAlteraStatus;
	}

	public void setUsuarioAlteraStatus(Usuario usuarioAlteraStatus) {
		this.usuarioAlteraStatus = usuarioAlteraStatus;
	}

	public Date getDataAlteraStatus() {
		return dataAlteraStatus;
	}

	public void setDataAlteraStatus(Date dataAlteraStatus) {
		this.dataAlteraStatus = dataAlteraStatus;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
