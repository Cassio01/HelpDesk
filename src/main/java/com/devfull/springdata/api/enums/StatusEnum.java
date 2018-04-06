package com.devfull.springdata.api.enums;

public enum StatusEnum {

	New,
	Assinged,
	Resolved,
	Aproved,
	Disaproved,
	Closed;
	
	public static StatusEnum getStatus(String status) {
		switch (status) {
		case "New":return New;
		case "Assinged" : return Assinged ;
		case "Resolved" : return Resolved;
		case "Aproved" : return Aproved;
		case "Disaproved" : return Disaproved;
		case "Closed" : return Closed;
			
		default: return New;
		}
	}
}
