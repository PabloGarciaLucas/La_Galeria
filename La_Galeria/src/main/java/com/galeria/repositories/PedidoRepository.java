package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.entities.PedidoEntity;



public interface PedidoRepository extends CrudRepository<PedidoEntity, String>{

}
