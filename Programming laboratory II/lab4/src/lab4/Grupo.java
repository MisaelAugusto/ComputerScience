package lab4;

import java.util.HashSet;

public class Grupo {
	private HashSet<Aluno> alunos;
	
	private String nome;
	
	public Grupo(String nome) {	
		if (nome == null) {
			throw new NullPointerException("Nome Nulo!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome Vazio!");
		} else {
			this.nome = nome;
		}
			
		this.alunos = new HashSet<>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public HashSet<Aluno> getAlunos() {
		return this.alunos;
	}
	
	public void adicionaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public String imprimeAlunos() {
		String listaAlunos = "Alunos do grupo " + this.getNome() + ":\n";
		
		for (Aluno aluno : alunos) {
			listaAlunos += "* " + aluno.toString() + "\n";
		}
		
		return listaAlunos;
	}
	
	@Override
	public String toString() {
		return "Nome do grupo: " + this.getNome() + "\n" + "Quantidade de alunos: " + this.alunos.size();
	}
}
