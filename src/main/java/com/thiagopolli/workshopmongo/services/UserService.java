package com.thiagopolli.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagopolli.workshopmongo.domain.User;
import com.thiagopolli.workshopmongo.repository.UserRepository;

//classe de servico responsavel por trabalhar com o usuario 

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repo;
	
	//metodo responsavel por retornar todos os usuarios do banco
	public List<User> findAll(){
		return repo.findAll();
		
	}

}
