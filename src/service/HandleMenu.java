package service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {

	Scanner sc = new Scanner(System.in);

	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();

	public HandleMenu() {
		gs.verificaECria("usuarios.txt");
	}

	public void criar() {
		System.out.println("Digite o nome");
		String strNome = sc.next();
		System.out.println("Digite a senha");
		String strSenha = sc.next();
		int id = getNextId();
		Usuario u = new Usuario(id, strNome, strSenha);
		gs.adicionarUsuario(u);
	}

	public void editar() {

	}

	public void deletar() {
		System.out.println("Digite o ID do usuário a ser deletado");
		int id = sc.nextInt();
	}

	public void listar() {

	}

	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		for (Usuario usuario : usuarios) {
			int id = usuario.getIntId();
			if (id > maxId) {
				maxId = id;
			}
		}
		return maxId + 1;
	}
}