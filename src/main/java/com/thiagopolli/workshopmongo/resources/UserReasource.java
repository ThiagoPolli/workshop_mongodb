package com.thiagopolli.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thiagopolli.workshopmongo.domain.Post;
import com.thiagopolli.workshopmongo.domain.User;
import com.thiagopolli.workshopmongo.dto.UserDTO;
import com.thiagopolli.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserReasource {
	
	@Autowired
	private UserService service;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<UserDTO>> findAll(){
		
		List <User> list = service.findAll();
		
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//Recusos de busca do ususario
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <UserDTO> findById(@PathVariable String id){
		
		User obj = service.findById(id);
				
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//Recursos para inserir usuario
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(" /{id}").buildAndExpand(obj.getId()).toUri();
				
		return ResponseEntity.created(uri).build();
	}
	
	//Recursos para deletar usuario
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		
		service.delete(id);
				
		return ResponseEntity.noContent().build();
	}
	//Recurso para atualizar usuario
	@RequestMapping( value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
		
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	//Recurso para retornar os posts de um usuario
	@RequestMapping(value="/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity <List<Post>> findPosts(@PathVariable String id){
		
		User obj = service.findById(id);
				
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
	

