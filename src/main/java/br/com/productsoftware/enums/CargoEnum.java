package br.com.productsoftware.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CargoEnum {
	
	ADM(1, "Administrador");
	
	private Integer id;
	private String descricao;
	
	private CargoEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	@JsonValue
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static CargoEnum getById(final Integer id) {
		if(id != null) {
			for(CargoEnum type : CargoEnum.values()) {
				if(id.equals(type.getId())){
					return type;
				}
			}
		}
		return null;
	}
	
	@JsonCreator
	public static CargoEnum getByDescricao(final String descricao) {
		if(descricao != null) {
			for(CargoEnum type : CargoEnum.values()) {
				if(descricao.equals(type.getDescricao())){
					return type;
				}
			}
		}
		return null;
	}

}
