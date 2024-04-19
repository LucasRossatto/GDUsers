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
		System.out.println("Digite o ID do usuário: ");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String strNome = sc.next();
		System.out.println("Digite a nova senha:");
		String strSenha = sc.next();
		gs.editarUsuario(id, strNome, strSenha);
	}

	public void deletar() {
		System.out.println("Digite o ID do usuário a ser deletado");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
	}

	public void listar() {
		gs.listarUsuarios();
	}

	public void listarEspecifico() {
		System.out.println("Digite o ID do usuário que deseja listar: ");
		int id = sc.nextInt();
		gs.listarEspecifico(id);
	}

	public void login() {
		System.out.println("Digite o nome:");
		String strNome = sc.next();
		System.out.println("Digite a senha:");
		String strSenha = sc.next();
		gs.login(strNome, strSenha);
	}

	public void TrocarSenha() {
		gs.listarCadastrados();
		System.out.println("Digite o id do usuario que deseja trocar a senha:");
		int id = sc.nextInt();
		System.out.println("Digite a senha atual");
		String strSenha = sc.next();
		System.out.println("Digite a nova senha");
		String novaSenha = sc.next();
		gs.TrocarSenha(id, strSenha, novaSenha);
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