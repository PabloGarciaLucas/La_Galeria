package com.galeria.negocio;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.ImagenesDTO;


public interface IImagenesService {
	public List<ImagenesDTO> buscarImagenes(Integer idImagen, String descripcion, byte[] imagen)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarImagenes(String descripcion, byte[] imagen) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarImagenes(Integer idImagen, String descripcion, byte[] imagen) throws ClassNotFoundException, SQLException, NamingException;
}
