package com.galeria.controllers.rest;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.entities.User;
import com.galeria.repositories.UserRepository;

@RestController
@RequestMapping("/v1")
public class UsersControllerRest {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public Iterable<User> obtenerTodosUsers() {
		Iterable<User> users = userRepository.findAll();

		return users;
	}

	//error
	@PostMapping("/users")
	public ResponseEntity insertarUsers(@RequestBody User user)
			throws ClassNotFoundException, SQLException, NamingException {

		userRepository.save(user);

		return new ResponseEntity<>("Usuario insertado correctamente", HttpStatus.OK);
	}

	@PutMapping("/users")
	public ResponseEntity actualizarUsers(@RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity<>("Usuario actualizado con éxito", HttpStatus.OK);
	}

}
