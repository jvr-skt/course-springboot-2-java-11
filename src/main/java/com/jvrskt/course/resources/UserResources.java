package com.jvrskt.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvrskt.course.entities.User;
import com.jvrskt.course.services.UserService;

@RestController //Anotação para marcar a classe como um recurso web implementado por controlador rest
@RequestMapping(value = "/users") //nome do recurso com o caminho
public class UserResources {

	@Autowired
	private UserService service;
	
	//Metodo para acessar os usuarios do tipo ResponseEntity para retornar respostas de requisições web
	@GetMapping //indica que o metodo responde a requisições HTTP
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
