package com.connect.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.connect.jdbc.dao.cadastro.ClienteDAO;
import com.connect.jdbc.dao.cadastro.ClienteDAOJdbc;
import com.connect.jdbc.dao.cadastro.ProdutoDAO;
import com.connect.jdbc.dao.cadastro.ProdutoDAOJdbc;

public class DAOFactoryJdbc extends DAOFactory {

	private Connection connection;

	public DAOFactoryJdbc() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_cliente", "root", "rootroot");
		} catch (Exception e) {
			throw new RuntimeException("Erro recuperando conexao com o banco de dados", e);
		}

	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new ClienteDAOJdbc(connection);
	}

	@Override
	public ProdutoDAO getProdutoDAO() {
		return new ProdutoDAOJdbc(connection);
	}
	
	

}
