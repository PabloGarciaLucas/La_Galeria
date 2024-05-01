package com.galeria.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IUsersDAO;
import com.galeria.dtos.UsersDTO;
import com.galeria.negocio.IUsersService;

@Component
public class UsersService implements IUsersService {
	
	@Autowired
	IUsersDAO usuarioDAO;
	
	@Override
	public List<UsersDTO> buscarUsuarios(Integer userID, String userName, String userPasswd, String userEmail, String userRole)
			throws ClassNotFoundException, SQLException, NamingException {

		return usuarioDAO.buscarUsuarios(userID, userName, userPasswd, userEmail, userRole);
	}

	@Override
	public Integer insertarUsuarios(String userName, String userPasswd, String userEmail)
			throws ClassNotFoundException, SQLException, NamingException {

		return usuarioDAO.insertarUsuarios(userName, userPasswd, userEmail);
	}

	@Override
	public Integer actualizarUsuarios(Integer userID, String userName, String userPasswd, String userEmail)
			throws ClassNotFoundException, SQLException, NamingException {

		return usuarioDAO.actualizarUsuarios(userID, userName, userPasswd, userEmail);
	}

}
