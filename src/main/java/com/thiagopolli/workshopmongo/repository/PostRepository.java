package com.thiagopolli.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiagopolli.workshopmongo.domain.Post;


// interface responsavel por gerenciar salvar recuperar deletar etc. classse User
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	

}
