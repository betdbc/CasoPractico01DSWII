package com.caso.practica.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caso.practica.entidad.Categoria;
import com.caso.practica.entidad.Proveedor;
import com.caso.practica.servicio.CategoriaServicio;
import com.caso.practica.servicio.ProveedorServicio;

@Controller
public class ProveedorControlador {
	
	@Autowired
	private CategoriaServicio categoriaServicio;

	@Autowired
	private ProveedorServicio proveedorServicio;

	@RequestMapping("/verProveedor")
	public String ver() {
		return "registraProveedor";
	}

	
	@RequestMapping("/cargaCategoria")
	@ResponseBody
	public List<Categoria> lista() {
		return categoriaServicio.listaCategoria();
	}
	
	@RequestMapping(value="/registraProveedor")
	public String regCategoria(Proveedor proveedor, HttpSession session) {
		Proveedor aux = proveedorServicio.insertaProveedor(proveedor);
		if(aux == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitoso");
		}
		return "redirect:verProveedor";
	}

}
