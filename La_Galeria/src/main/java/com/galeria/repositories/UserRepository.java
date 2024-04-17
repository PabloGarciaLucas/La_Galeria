
package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galeria.dtos.UsersDTO;
import com.galeria.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	@Query(value= "select new com.galeria.dtos.UsersDTO (u.userID, u.userName, u.userPasswd, u.userEmail) "
			+ " from com.galeria.entities.User u "
			+ " where  u.userID = :userID "
			+ " and u.userName like CONCAT ('%',:userName,'%') "
			+ " and u.userPasswd like CONCAT ('%',:userPasswd,'%') "
			+ " AND u.userEmail like CONCAT ('%',:userEmail,'%') ")
	List<UsersDTO>buscarUsuarios(@Param("userID") Integer userID,
			@Param("userName") String userName,
			@Param("userPasswd") String userPasswd,
			@Param("userEmail") String userEmail);
	
	@Query(value="select new com.galeria.dtos.UsersDTO (u.userID, u.userName) "
			+ " from com.galeria.entities.User u ")
	List<UsersDTO>buscarUsuariosParaCombo(@Param("userID") Integer userID,
			@Param("userName") String userName);
}
