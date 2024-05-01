package com.galeria.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Service;

import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.CategoriaEntity;

@Service
public interface IProductosService {
	
	public List<ProductosDTO> buscarProductos(Integer id, String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProductos(String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProductos(Integer id, String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException;

}
