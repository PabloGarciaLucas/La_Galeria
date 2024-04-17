package com.galeria.dao.impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IImagenesDAO;
import com.galeria.dtos.ImagenesDTO;
import com.galeria.entities.ImagenEntity;
import com.galeria.repositories.ImagenesRepository;

@Component("ImagenesDAO")
public class ImagenesDAO implements IImagenesDAO {
	
	@Autowired
	ImagenesRepository imagenesRepository;
	
	@Override
	public List<ImagenesDTO> buscarImagenes(Integer idImagen, String descripcion, Blob imagen)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return imagenesRepository.buscarImagenes(idImagen, descripcion, imagen);
	}

	@Override
	public Integer insertarImagenes(String descripcion, Blob imagen)
			throws ClassNotFoundException, SQLException, NamingException {
		
		ImagenEntity imagenEntity = new ImagenEntity(descripcion, imagen);
		imagenesRepository.save(imagenEntity);
		
		return imagenEntity.getIdImagen();
	}

	@Override
	public Integer actualizarImagenes(Integer idImagen, String descripcion, Blob imagen)
			throws ClassNotFoundException, SQLException, NamingException {
		
		ImagenEntity imagenEntity = new ImagenEntity(descripcion, imagen);
		imagenesRepository.save(imagenEntity);
		
		return imagenEntity.getIdImagen();
	}

}
