package com.connect.jdbc.dao.cadastro;

import java.util.List;

import com.connect.jdbc.model.Cliente;

public interface ClienteDAO {
	
	public void salvar(Cliente cliente);

	public Cliente buscarPeloCodigo(long codigo);

	public List<Cliente> buscarTodos();

}
