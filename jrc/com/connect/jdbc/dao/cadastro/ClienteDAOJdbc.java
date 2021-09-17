package com.connect.jdbc.dao.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connect.jdbc.dao.exception.DAOException;
import com.connect.jdbc.model.Cliente;

public class ClienteDAOJdbc implements ClienteDAO {

	private Connection connection;

	public ClienteDAOJdbc(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(Cliente cliente) {
		String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());

		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erro salvando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public Cliente buscarPeloCodigo(long codigo) {
		Cliente cliente = null;

		try {
			String sql = String.format("select * from cliente where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		Cliente cliente = null;

		List<Cliente> clientes = new ArrayList<>();

		try {
			String sql = "select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return clientes;
	}

}
