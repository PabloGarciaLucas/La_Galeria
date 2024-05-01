package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IProductosDAO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.CategoriaEntity;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;
import com.galeria.repositories.ProductoRepository;

@Component("ProductosDAO")

public class ProductosDAO implements IProductosDAO{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<ProductosDTO> buscarProductos(Integer id, String nombre, String descripcion, Double precio,
			Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productoRepository.buscarProductos(id, nombre, descripcion, precio, cantidadEnStock, categoria);
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria)
			throws ClassNotFoundException, SQLException, NamingException {

		ProductoEntity productoEntity = new ProductoEntity(nombre, descripcion, precio, cantidadEnStock, categoria);
		productoRepository.save(productoEntity);
		
		return productoEntity.getId();
	}

	@Override
	public Integer actualizarProductos(Integer id, String nombre, String descripcion, Double precio,
			Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		ProductoEntity productoEntity = new ProductoEntity(id, nombre, descripcion, precio, cantidadEnStock, categoria);
		productoRepository.save(productoEntity);
		
		return productoEntity.getId() ;
	}

}
