package com.galeria.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.ImagenesDTO;

public interface IImagenesDAO {
	public List<ImagenesDTO> buscarImagenes(Integer idImagen, String descripcion, Blob imagen)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarImagenes(String descripcion, Blob imagen) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarImagenes(Integer idImagen, String descripcion, Blob imagen) throws ClassNotFoundException, SQLException, NamingException;
}
