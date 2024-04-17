package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IUsersDAO;
import com.galeria.dtos.UsersDTO;
import com.galeria.entities.User;
import com.galeria.repositories.UserRepository;

@Component("UsersDAO")
public class UsersDAO implements IUsersDAO {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UsersDTO> buscarUsuarios(Integer userID, String userName, String userPasswd, String userEmail)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return userRepository.buscarUsuarios(userID, userName, userPasswd, userEmail);
	}

	@Override
	public Integer insertarUsuarios(String userName, String userPasswd, String userEmail)
			throws ClassNotFoundException, SQLException, NamingException {
		User userEntity = new User(userName, userPasswd, userEmail);
		userRepository.save(userEntity);
		
		return userEntity.getId();
	}

	@Override
	public Integer actualizarUsuarios(Integer userID, String userName, String userPasswd, String userEmail)
			throws ClassNotFoundException, SQLException, NamingException {
		User userEntity = new User(userName, userPasswd, userEmail);
		userRepository.save(userEntity);
		
		return userEntity.getId();
	}

}
