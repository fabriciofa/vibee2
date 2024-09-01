package com.mfqueiroga.vibee.entities.enums;

public enum Bees {

	ABELHA_EUROPEIA_APIS_MELLIFERA(1),
	ABELHA_AFRICANIZADA(2),
	ABELHA_NATIVA_SEM_FERRAO_MELIPONINEOS(3);
	
	private int code;
	
	private Bees (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Bees valueOf (int code) {
		for (Bees value : Bees.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Disease code!");
	}
}
