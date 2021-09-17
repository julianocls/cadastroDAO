package com.connect.jdbc.dao.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connect.jdbc.dao.exception.DAOException;
import com.connect.jdbc.model.Produto;

public class ProdutoDAOJdbc implements ProdutoDAO {

	private Connection connection;

	public ProdutoDAOJdbc(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(Produto produto) {
		String sql = String.format("insert into produto (nome, preco) values('%s', %s)", produto.getNome(), produto.getPreco());

		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erro salvando produto", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
			}
		}
	}

}
