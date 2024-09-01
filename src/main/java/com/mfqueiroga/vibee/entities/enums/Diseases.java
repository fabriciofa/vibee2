package com.mfqueiroga.vibee.entities.enums;

public enum Diseases {

	CRIA_PUTRIDA_AMERICANA(1),
	CRIA_PUTRIDA_EUROPEIA(2),
	CRIA_ENSACADA(3),
	CRIA_GIZ(4),
	NOSEMOSE(5),
	ACARIOSE(6),
	VAROATOSE(7),
	INFESTACAO_AETHINA_TUMIDA(8),
	INFESTACAO_TROPILAELAPS_SPP(9);
	
	private int code;
	
	private Diseases (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Diseases valueOf (int code) {
		for (Diseases value : Diseases.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Disease code!");
	}
}
