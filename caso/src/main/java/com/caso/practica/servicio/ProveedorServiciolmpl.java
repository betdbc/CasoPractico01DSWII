package com.caso.practica.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caso.practica.entidad.Proveedor;
import com.caso.practica.repositorio.ProveedorRepositorio;

@Service
public class ProveedorServiciolmpl implements ProveedorServicio {

	@Autowired
	private ProveedorRepositorio repositorio;
	
	@Override
	public Proveedor insertaProveedor(Proveedor obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

}
