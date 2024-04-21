
package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galeria.dtos.UsersDTO;
import com.galeria.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value= "select new com.galeria.dtos.UsersDTO (u.userID, u.userName, u.userPasswd, u.userEmail, u.user_role) "
			+ " from com.galeria.entities.User u "
			+ " WHERE  u.userID = :userID "
			+ " AND u.userName like CONCAT ('%',:userName,'%') "
			+ " AND u.userPasswd like CONCAT ('%',:userPasswd,'%') "
			+ " AND u.userEmail like CONCAT ('%',:userEmail,'%') "
			+ " AND u.user_role like CONCAT ('%',:user_role,'%')")
	List<UsersDTO>buscarUsuarios(@Param("userID") Integer userID,
			@Param("userName") String userName,
			@Param("userPasswd") String userPasswd,
			@Param("userEmail") String userEmail,
			@Param("user_role") List<String> user_role);
	
	@Query(value="select new com.galeria.dtos.UsersDTO (u.userID, u.userName) "
			+ " from com.galeria.entities.User u ")
	List<UsersDTO>buscarUsuariosParaCombo(@Param("userID") Integer userID,
			@Param("userName") String userName);
}
