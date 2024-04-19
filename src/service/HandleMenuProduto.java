package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import utils.GerenciadorDeProdutos;

public class HandleMenuProduto {
	Scanner sc = new Scanner(System.in);

	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public HandleMenuProduto() {
		gp.verificaECria("produtos.txt");
	}

	public void criarProduto() {
		System.out.println("Digite o nome");
		String strNome = sc.next();
		System.out.println("Digite o preço");
		double doublePreco = sc.nextDouble();
		System.out.println("Digite a quantidade");
		int intQuantidade = sc.nextInt();
		long Produtoid = getNextIdProduto();
		Produto p = new Produto(Produtoid, strNome, doublePreco, intQuantidade);
		gp.adicionarProduto(p);
	}

	public void editarProduto() {
		System.out.println("Digite o ID do Produto: ");
		int Produtoid = sc.nextInt();
		System.out.println("Digite o novo nome");
		String strNome = sc.next();
		System.out.println("Digite o novo preço");
		double doublePreco = sc.nextDouble();
		System.out.println("Digite a nova quantidade");
		int intQuantidade = sc.nextInt();
		gp.editarProduto(Produtoid, strNome, doublePreco, intQuantidade);
	}

	public void deletarProduto() {
		System.out.println("Digite o ID do Produto a ser deletado");
		long Produtoid = sc.nextLong();
		gp.deletarProduto(Produtoid);
	}

	public void listarProduto() {
		gp.listarProdutos();
	}

	public void listarEspecificoProduto() {
		System.out.println("Digite o ID do usuário que deseja listar: ");
		long Produtoid = sc.nextLong();
		gp.listarProdutoEspecifico(Produtoid);
	}
	
	public void SomarPrecos() {
		gp.SomarPrecos();
	}
	
	public void ContarProdutos() {
		gp.ContarProdutos();
	}

	/*
	 * public void loginProduto() { System.out.println("Digite o nome:"); String
	 * strNome = sc.next(); System.out.println("Digite a senha:"); String strSenha =
	 * sc.next(); gs.login(strNome, strSenha); }
	 */
	private long getNextIdProduto() {
		List<Produto> produtos = gp.lerProdutos();
		long maxId = 0;
		for (Produto produto : produtos) {
			long Produtoid = produto.getProdutoid();
			if (Produtoid > maxId) {
				maxId = Produtoid;
			}
		}
		return maxId + 1;
	}
}
