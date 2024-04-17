package com.galeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.UsersDTO;

public interface IUsersDAO {
	
	public List<UsersDTO> buscarUsuarios(Integer userID, String userName, String userPasswd, String userEmail)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarUsuarios(String userName, String userPasswd, String userEmail) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarUsuarios(Integer userID, String userName, String userPasswd, String userEmail) throws ClassNotFoundException, SQLException, NamingException;
}
