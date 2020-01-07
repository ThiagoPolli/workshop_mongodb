package com.thiagopolli.workshopmongo.services.exception;


//classe responsavel por disparar exceção na busca por Id incorreto
public class ObjectNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException(String msg) {
		super();
		
	}

}
