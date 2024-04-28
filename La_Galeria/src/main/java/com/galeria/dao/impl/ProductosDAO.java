package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IProductosDAO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;
import com.galeria.repositories.ProductoRepository;

@Component("ProductosDAO")

public class ProductosDAO implements IProductosDAO{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productoRepository.buscarProductos(id, nombre, descripcion, precio, cantidadEnStock);
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidadEnStock)
			throws ClassNotFoundException, SQLException, NamingException {

		ProductoEntity productoEntity = new ProductoEntity(nombre, descripcion, precio, cantidadEnStock);
		productoRepository.save(productoEntity);
		
		return Integer.parseInt(productoEntity.getId());
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
