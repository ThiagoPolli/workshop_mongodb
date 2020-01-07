package com.thiagopolli.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagopolli.workshopmongo.domain.User;
import com.thiagopolli.workshopmongo.dto.UserDTO;
import com.thiagopolli.workshopmongo.repository.UserRepository;
import com.thiagopolli.workshopmongo.services.exception.ObjectNotFoundException;

//classe de servico responsavel por trabalhar com o usuario 

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repo;
	
	//metodo responsavel por retornar todos os usuarios do banco
	public List<User> findAll(){
		return repo.findAll();
		
	}
	
	//metodo responsavel por retornar os usuarios por Id
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(" Objeto não encontrado!"));
		
	}
	// inserir usuario
	public User insert(User obj) {
		return repo.insert(obj);
		
	}
	//Deletar Usuario
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
	
	

}
