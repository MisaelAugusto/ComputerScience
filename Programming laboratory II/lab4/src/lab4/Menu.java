package lab4;

import java.util.Scanner;

public class Menu {

	private static ControleDisciplina programacaoII = new ControleDisciplina();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			imprimeMenu();
			
			selecionaOperacao(recebeOperacao());
		}
	}
	
	public static void imprimeMenu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistar Resposta de Aluno");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.println("");
		System.out.print("Opção> ");
	}
	
	public static String recebeOperacao() {		
		return scanner.next();
	}
	
	public static void selecionaOperacao(String operacao) {
		switch (operacao) {
			
			case "C":
				cadastrarAluno();
				break;

			case "E":
				exibirAluno();
				break;

			case "N":
				cadastrarGrupo();
				break;
				
			case "A":
				alocarAlunoImprimirGrupo();
				break;
				
			case "R":
				registrarAlunoRespondao();
				break;
				
			case "I":
				imprimirAlunosRespondoes();
				break;
				
			case "O":
				System.exit(0);
				
			default:
				System.out.println("OPERAÇÃO INVÁLIDA!");
		}
		System.out.println("");
	}
		
	public static void cadastrarAluno() {
		System.out.print("Matrícula: ");
		String matricula = scanner.next();
		
		System.out.print("Nome: ");
		String nome = scanner.next();
		
		System.out.print("Curso: ");
		String curso = scanner.next();
		
		if (!programacaoII.verificaAlunoExistente(matricula)) {
			programacaoII.cadastraAluno(matricula, nome, curso);				
			System.out.println("CADASTRO REALIZADO!");
		} else {
			System.out.println("MATRÍCULA JÁ CADASTRADA!");
		}
	}
	
	public static void exibirAluno() {
		System.out.print("Matrícula: ");
		String matricula = scanner.next();
		
		if (programacaoII.verificaAlunoExistente(matricula)) {
			System.out.println(programacaoII.exibeAluno(matricula));
		} else  {
			System.out.println("Aluno não cadastrado!");
		}
	}
	
	public static void cadastrarGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.next();
		
		if (!programacaoII.verificaGrupoExistente(nomeGrupo)) {
			programacaoII.cadastrarGrupo(nomeGrupo);
			System.out.println("CADASTRO REALIZADO!");
		} else {
			System.out.println("GRUPO JÁ CADASTRADO!");
		}
	}
	
	public static void alocarAlunoImprimirGrupo() {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String opcao = scanner.next();
		
		if (opcao.equals("A")) {
			System.out.print("Matrícula: ");
			String matricula = scanner.next();
			
			System.out.print("Grupo: ");
			String nomeGrupo = scanner.next();
			
			if (programacaoII.verificaGrupoExistente(nomeGrupo)) {
				if (programacaoII.verificaAlunoExistente(matricula)) {	
					programacaoII.alocarAluno(matricula, nomeGrupo);
					System.out.println("ALUNO ALOCADO!");
				} else {
					System.out.println("Aluno não cadastrado!");
				}
			} else {
				System.out.println("Grupo não cadastrado!");
			}
			
		} else if (opcao.equals("I")) {
			System.out.print("Grupo: ");
			String nomeGrupo = scanner.next();
			
			if (programacaoII.verificaGrupoExistente(nomeGrupo)) {
				System.out.println(programacaoII.imprimirGrupo(nomeGrupo));
			} else {
				System.out.println("Grupo não cadastrado!");
			}
		}
	}
	
	public static void registrarAlunoRespondao() {
		System.out.print("Matrícula: ");
		String matricula = scanner.next();
		
		if (programacaoII.verificaAlunoExistente(matricula)) {
			programacaoII.registraAlunoRespondao(matricula);
			System.out.println("ALUNO REGISTRADO!");
		} else {
			System.out.println("Aluno não cadastrado!");
		}
	}
	
	public static void imprimirAlunosRespondoes() {
		System.out.println(programacaoII.imprimeAlunosRespondoes());
	}
}
