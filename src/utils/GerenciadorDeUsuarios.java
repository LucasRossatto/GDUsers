package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class GerenciadorDeUsuarios {
	private static final String NOME_ARQUIVO = "usuarios.txt";

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

	public void adicionarUsuario(Usuario usuario) {
		// Writer
		// BuffereWriter, proporciona escrita eficiente
		// FileWriter, escreve dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString());
			bw.newLine();
			System.out.println("Usuário adiciona com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public List<Usuario> lerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => id;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");// dividir em tres partes
				usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}
		return usuarios;
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = lerUsuarios();
		if (usuarios.removeIf(usuario -> usuario.getIntId() == id)) {
			reescreverArquivo(usuarios);
			System.out.println("Usuário deletado com sucesso");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarUsuarios() {
		List<Usuario> usuarios = lerUsuarios();
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado");
		} else {
			System.out.println("Lista de usuários");
			for (Usuario usuario : usuarios) {
				System.out.println("ID: " + usuario.getIntId() + ", Nome: " + "" + usuario.getStrNome() + ", Senha: "
						+ usuario.getStrSenha());
			}
		}
	}

	public void listarEspecifico(int id) {
		List<Usuario> usuarios = lerUsuarios();
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado");
		} else {
			System.out.println("Usuário:");
			for (Usuario usuario : usuarios) {
				if (usuario.getIntId() == id) {
					System.out.println("ID: " + usuario.getIntId() + ", Nome: " + "" + usuario.getStrNome()
							+ ", Senha: " + usuario.getStrSenha());
				}
			}
		}
	}

	public void editarUsuario(int id, String novoNome, String novaSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean encontrado = false;
		for (Usuario usuario : usuarios) {
			if (usuario.getIntId() == id) {
				usuario.setStrNome(novoNome);
				usuario.setStrSenha(novaSenha);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuário editado com sucesso!");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

	public void login(String strNome, String strSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean encontrado = false;
		for (Usuario usuario : usuarios) {
			if (usuario.getStrNome().equals(strNome) && usuario.getStrSenha().equals(strSenha)) {
				encontrado = true;
			}
		}
		if (encontrado) {
			System.out.println("Logado com sucesso!");
		} else {
			System.out.println("Usuário não encontrado ou senha incorreta");
		}
	}
}