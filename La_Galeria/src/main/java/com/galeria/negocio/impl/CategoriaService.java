package com.galeria.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.ICategoriasDAO;
import com.galeria.dtos.CategoriasDTO;
import com.galeria.negocio.ICategoriaService;

@Component
public class CategoriaService implements ICategoriaService {

	//@Autowired (con autowired no funciona el programa, hay que ponerlo sin el autowired)
	ICategoriasDAO categoriaDAO;
	
	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriaDAO.buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriaDAO.insertarCategorias(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriaDAO.actualizarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		return categoriaDAO.borrarCategorias(id);
	}

}
