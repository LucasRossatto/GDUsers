package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class GerenciadorDeProdutos {
	private static final String NOME_ARQUIVO = "produtos.txt";

	// verificar a existencia do nosso Banco de Dados e criar caso nao exista
	public void verificaECria(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// verificar se o arquivo existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando");
		} else {
			try {
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso");
			} catch (IOException e) {
				System.out.println("Erro ao criar arquivo: " + e.getMessage());
			}
		}
	}

	public void adicionarProduto(Produto produto) {
		// Writer
		// BuffereWriter, proporciona escrita eficiente
		// FileWriter, escreve dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(produto.toString());
			bw.newLine();
			System.out.println("Produto adicionado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public List<Produto> lerProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => id;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");// dividir em tres partes
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void deletarProduto(long Produtoid) {
		List<Produto> produtos = lerProdutos();
		if (produtos.removeIf(produto -> produto.getProdutoid() == Produtoid)) {
			reescreverArquivo(produtos);
			System.out.println("Produto deletado com sucesso");
		} else {
			System.out.println("Produto não encontrado");
		}
	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarProdutos() {
		List<Produto> produtos = lerProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		} else {
			System.out.println("Lista de Produtos");
			for (Produto produto : produtos) {
				System.out.println("ID: " + produto.getProdutoid() + ", Nome: " + "" + produto.getStrNome()
						+ ", Preço: " + produto.getDoublePreco() + ", Quantidade: " + produto.getIntQuantidade());
			}
		}
	}

	public void listarProdutoEspecifico(long Produtoid) {
		List<Produto> produtos = lerProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		} else {
			System.out.println("Produto:");
			for (Produto produto : produtos) {
				if (produto.getProdutoid() == Produtoid) {
					System.out.println("ID: " + produto.getProdutoid() + ", Nome: " + "" + produto.getStrNome()
							+ ", Preço: " + produto.getDoublePreco() + ", Quantidade: " + produto.getIntQuantidade());
				}
			}
		}
	}

	public void editarProduto(int id, String novoNome, double novoPreco, int novaQuantidade) {
		List<Produto> produtos = lerProdutos();
		boolean encontrado = false;
		for (Produto produto : produtos) {
			if (produto.getProdutoid() == id) {
				produto.setStrNome(novoNome);
				produto.setDoublePreco(novoPreco);
				produto.setIntQuantidade(novaQuantidade);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(produtos);
			System.out.println("Produto editado com sucesso!");
		} else {
			System.out.println("Produto não encontrado");
		}
	}

	public void SomarPrecos() {
		List<Produto> produtos = lerProdutos();
		double soma = 0.0;
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto encontrado");
		} else {
			System.out.println("Preços somados");
			for (Produto produto : produtos) {
				soma += produto.getDoublePreco();
			}
			System.out.println("Soma total: " + soma);
		}
	}

	public void ContarProdutos() {
		List<Produto> produtos = lerProdutos();
		int soma = 0;
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto encontrado");
		} else {
			int tamanho = produtos.size();
			for (Produto produto : produtos) {
				soma += produto.getIntQuantidade();
			}
			System.out.println("Quantidade de Produtos Cadastrados: "+ tamanho);
			System.out.println("Quantidade de Produtos no Estoque: "+ soma);
		}
	}
	/*
	 * public void login(String strNome, double doublePreco) { List<Produto>
	 * produtos = lerProdutos(); boolean encontrado = false; for (Produto produto :
	 * produtos) { if (produto.getStrNome().equals(strNome) &&
	 * produto.getPreco().equals(doublePreco)) { encontrado = true; } } if
	 * (encontrado) { System.out.println("Logado com sucesso!"); } else {
	 * System.out.println("Usuário não encontrado ou senha incorreta"); } }
	 */
}
