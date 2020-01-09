package com.thiagopolli.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagopolli.workshopmongo.domain.Post;
import com.thiagopolli.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostReasource {
	
	@Autowired
	private PostService service;
	

	
	//Recusos de busca do ususario
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Post> findById(@PathVariable String id){
		
		Post obj = service.findById(id);
				
		return ResponseEntity.ok().body(obj);
	}
	
}
	

