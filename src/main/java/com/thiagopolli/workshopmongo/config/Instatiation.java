package com.thiagopolli.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagopolli.workshopmongo.domain.Post;
import com.thiagopolli.workshopmongo.domain.User;
import com.thiagopolli.workshopmongo.dto.AuthorDTO;
import com.thiagopolli.workshopmongo.dto.CommentDTO;
import com.thiagopolli.workshopmongo.repository.PostRepository;
import com.thiagopolli.workshopmongo.repository.UserRepository;

//classe responsavel por instanciar base de dados 

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("09/01/2019"), "Partiu Viagem", "Vou viajar abraços",new AuthorDTO(maria ));
		Post post4 = new Post(null, sdf.parse("19/01/2019"), "sao paulo", "indo para sao paulo",new AuthorDTO(maria ));
		Post post2 = new Post(null, sdf.parse("17/04/2018"), "Salve ", "salve galera teste ",new AuthorDTO(alex));
		Post post3 = new Post(null, sdf.parse("20/02/2019"), "trabalhar", "Trabalhar e o que tem pra hoje",new AuthorDTO(bob)); 
		
		CommentDTO c1 = new CommentDTO("Boa viagem ",sdf.parse("21/01/2019"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("te vejo lla",sdf.parse("20/01/2019"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("tudo bem ",sdf.parse("25/04/2018"), new AuthorDTO(maria));
		
		post1.getComment().addAll(Arrays.asList(c1,c2));
		post2.getComment().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2,post3,post4));
		
		maria.getPosts().addAll(Arrays.asList(post1));
		maria.getPosts().addAll(Arrays.asList(post4));
		alex.getPosts().addAll(Arrays.asList(post2));
		bob.getPosts().addAll(Arrays.asList(post3));
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		
	}

}
