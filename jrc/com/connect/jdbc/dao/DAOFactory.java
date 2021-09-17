package com.connect.jdbc.dao;

import com.connect.jdbc.dao.cadastro.ClienteDAO;
import com.connect.jdbc.dao.cadastro.ProdutoDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory() {
		return new DAOFactoryJdbc();
	}
	
	public abstract ClienteDAO getClienteDAO();

	public abstract ProdutoDAO getProdutoDAO();

}
