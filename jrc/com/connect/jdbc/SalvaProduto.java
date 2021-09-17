package com.connect.jdbc;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.connect.jdbc.dao.DAOFactory;
import com.connect.jdbc.dao.cadastro.ProdutoDAO;
import com.connect.jdbc.model.Produto;

public class SalvaProduto {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		Produto produto = new Produto();
		
		String nome = JOptionPane.showInputDialog(null, "Nome do produto" , "Cadastro de produto", JOptionPane.QUESTION_MESSAGE);
		String preco = JOptionPane.showInputDialog(null, "Preco do produto" , "Cadastro de produto", JOptionPane.QUESTION_MESSAGE);
				
		if (nome != null) {
			produto.setNome(nome);
			produto.setPreco(Double.valueOf(preco));
		
			ProdutoDAO produtoDAO = DAOFactory.getDAOFactory().getProdutoDAO();
			produtoDAO.salvar(produto);
			System.out.println("Produto salvo com sucesso.");
		}
	}
	
}