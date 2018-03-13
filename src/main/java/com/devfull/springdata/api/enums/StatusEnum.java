package com.devfull.springdata.api.enums;

public enum StatusEnum {

	NOVO,
	ACEITO,
	RESOLVIDO,
	APROVADO,
	RECUSADO,
	FECHAR;
	
	public static StatusEnum getStatus(String status) {
		switch (status) {
		case "NOVO":return NOVO;
		case "ACEITO" : return ACEITO ;
		case "RESOLVIDO" : return RESOLVIDO;
		case "APROVADO" : return APROVADO;
		case "RECUSADO" : return RECUSADO;
		case "FECHAR" : return FECHAR;
			
		default: return NOVO;
		}
	}
}
