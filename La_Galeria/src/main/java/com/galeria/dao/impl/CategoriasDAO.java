package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.ICategoriasDAO;
import com.galeria.dtos.CategoriasDTO;
import com.galeria.entities.CategoriaEntity;
import com.galeria.repositories.CategoriasRepository;

@Component("CategoriaDAO")
public class CategoriasDAO implements ICategoriasDAO {

	@Autowired
	CategoriasRepository categoriasRepository;
	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		return categoriasRepository.buscarCategorias(id, nombre, descripcion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		CategoriaEntity categoriaEntity = new CategoriaEntity(nombre, descripcion, Integer.parseInt(activo));
		categoriasRepository.save(categoriaEntity);
		
		return Integer.parseInt(categoriaEntity.getId()) ;
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		CategoriaEntity categoriaEntity = new CategoriaEntity(id, nombre, descripcion, Integer.parseInt(activo));
		categoriasRepository.save(categoriaEntity);
		
		return Integer.parseInt(categoriaEntity.getId()) ;
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {

		CategoriaEntity categoriaEntity = categoriasRepository.findById(id).get();
		categoriaEntity.setActivo(0);
		categoriasRepository.save(categoriaEntity);
		
		return Integer.parseInt(categoriaEntity.getId()) ;
	}

}
