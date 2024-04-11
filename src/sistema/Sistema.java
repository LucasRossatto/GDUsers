package sistema;

import java.util.Scanner;

import service.HandleMenu;

public class Sistema {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		do {
			System.out.print("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n9 - Sair\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1: {
				hm.criar();
				break;
			}
			default:
				System.out.println("Opção inválida");
			}
		} while (opcao != 9);
		sc.close();
	}

}
