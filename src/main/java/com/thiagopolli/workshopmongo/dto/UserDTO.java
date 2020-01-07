package com.thiagopolli.workshopmongo.dto;

import java.io.Serializable;

import com.thiagopolli.workshopmongo.domain.User;


//classe responsavel por carregar os dados de forma simples podendo  inclusive ate carregar so alguns dados  
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	//copia dos atributos da classe User
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
		
	}
	
	//forma automatizada para instanciar DTO apartir User
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
