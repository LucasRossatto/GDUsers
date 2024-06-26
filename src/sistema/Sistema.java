package sistema;

import java.util.Scanner;

import service.HandleMenu;
import service.HandleMenuProduto;

public class Sistema {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		HandleMenuProduto hp = new HandleMenuProduto();
		int opcao = 0;
		do {
			System.out.print(
					"1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Listar Usuário especifico\n6 - login \n7 - Contar Produtoslogin \n8 - Trocar Senha \n9 - Sair\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1: {
				hm.criar();
				break;
			}
			case 2: {
				hm.editar();
				break;
			}

			case 3: {
				hm.deletar();
				break;
			}

			case 4: {
				hm.listar();
				break;
			}
			case 5: {
				hm.listarEspecifico();
				break;
			}
			case 6: {
				hm.login();
				break;
			}
			case 7: {
				hp.ContarProdutos();
				break;
			}
			case 8: {
				hm.TrocarSenha();
				break;
			}
			default:
				System.out.println("Opção inválida");
			}
		} while (opcao != 9);
		sc.close();
	}

}
