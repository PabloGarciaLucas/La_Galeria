package com.galeria.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.galeria.dao.ICategoriasDAO;
import com.galeria.dtos.CategoriasDTO;
import com.galeria.negocio.impl.ICategoriasService;

@Component
public class CategoriasService implements ICategoriasService {

	@Autowired
	@Qualifier("JPACategorias")
	ICategoriasDAO categoriasDAO;

	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.insertarCategorias(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.actualizarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.borrarCategorias(id);
	}

}
