package com.thiagopolli.workshopmongo.dto;

import java.io.Serializable;

import com.thiagopolli.workshopmongo.domain.User;

//classe para carregar so alguns dados do usuario no post, nao todos os dados
public class AuthorDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	
	public AuthorDTO() {
		
	}
	//construtor que recebe um usuario como argumento
		public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

}
