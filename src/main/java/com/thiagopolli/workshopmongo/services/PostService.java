package com.thiagopolli.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagopolli.workshopmongo.domain.Post;
import com.thiagopolli.workshopmongo.repository.PostRepository;
import com.thiagopolli.workshopmongo.services.exception.ObjectNotFoundException;

//classe de servico responsavel por trabalhar com o usuario 

@Service
public class PostService  {
	
	@Autowired
	private PostRepository repo;
	
	//metodo responsavel por retornar os usuarios por Id
	public Post findById(String id) {
		
		Optional<Post> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(" Objeto não encontrado!"));
		
	}
	
	

}
