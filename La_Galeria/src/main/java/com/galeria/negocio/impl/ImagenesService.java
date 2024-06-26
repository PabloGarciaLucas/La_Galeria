package com.galeria.negocio.impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IImagenesDAO;
import com.galeria.dtos.ImagenesDTO;
import com.galeria.negocio.IImagenesService;

@Component
public class ImagenesService implements IImagenesService {
	
	@Autowired
	IImagenesDAO imagenesDAO;

	@Override
	public List<ImagenesDTO> buscarImagenes(Integer idImagen, String descripcion, byte[] imagen)
			throws ClassNotFoundException, SQLException, NamingException {
		return imagenesDAO.buscarImagenes(idImagen, descripcion, imagen);
	}

	@Override
	public Integer insertarImagenes(String descripcion, byte[] imagen)
			throws ClassNotFoundException, SQLException, NamingException {
		return imagenesDAO.insertarImagenes(descripcion, imagen);
	}

	@Override
	public Integer actualizarImagenes(Integer idImagen, String descripcion, byte[] imagen)
			throws ClassNotFoundException, SQLException, NamingException {
		return imagenesDAO.actualizarImagenes(idImagen, descripcion, imagen);
	}
	


}
