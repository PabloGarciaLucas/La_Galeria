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
import com.galeria.negocio.impl.UsersService;
import com.galeria.repositories.UserRepository;

@RestController
@RequestMapping("/v1")
public class UsersControllerRest {

	@Autowired
	UsersService usuariosServicio;
	@Autowired
	UserRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public Iterable<User> obtenerTodosUsuarios(){
		Iterable<User> usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity insertarUsuarios(@RequestBody User user) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = usuariosServicio.insertarUsuarios(user.getUserName(), user.getUserPasswd(), user.getUserEmail());
		return new ResponseEntity<>("Usuario insertado correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/usuarios")
	public ResponseEntity actualizarUsuarios(@RequestBody User user) {
		usuarioRepository.save(user);
		
		return new ResponseEntity<>("Usuario actualizado correctamente", HttpStatus.OK);
	}

}
