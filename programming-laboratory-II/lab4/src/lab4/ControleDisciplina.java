package lab4;

import java.util.HashMap;

import java.util.ArrayList;

public class ControleDisciplina {
	
	private HashMap<String, Aluno> alunos;
	
	private HashMap<String, Grupo> grupos;
	
	private ArrayList<Aluno> alunosRespondoes;
	
	public ControleDisciplina() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosRespondoes = new ArrayList<>();
	}
	
	public boolean verificaAlunoExistente(String matricula) {
		
		for (String matriculaCadastrada : this.alunos.keySet()) {
			if (matriculaCadastrada.equals(matricula)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void cadastraAluno(String matricula, String nome, String curso) {
		this.alunos.put(matricula, new Aluno(nome, matricula, curso));
	}
	
	public String exibeAluno(String matricula) {
		return "Aluno: " + this.alunos.get(matricula).toString();
	}
	
	public boolean verificaGrupoExistente(String nomeGrupo) {
		
		for (String grupoCadastrado : this.grupos.keySet()) {
			if (grupoCadastrado.toLowerCase().equals(nomeGrupo.toLowerCase())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void cadastrarGrupo(String nomeGrupo) {
		this.grupos.put(nomeGrupo, new Grupo(nomeGrupo));
	}
	
	public void alocarAluno(String matricula, String nomeGrupo) {
		this.grupos.get(nomeGrupo).adicionaAluno(alunos.get(matricula));
	}
	
	public String imprimirGrupo(String nomeGrupo) {
		return this.grupos.get(nomeGrupo).imprimeAlunos();
	}
	
	public String registraAlunoRespondao(String matricula) {
		if (this.verificaAlunoExistente(matricula)) {	
			this.alunosRespondoes.add(this.alunos.get(matricula));
			return "ALUNO REGISTRADO!";
		}
		
		return "Aluno não cadastrado!";
	}
	
	public String imprimeAlunosRespondoes() {
		String listaAlunosRespondoes = "Alunos:\n";
		
		int i = 1;
		for (Aluno aluno : this.alunosRespondoes) {
			listaAlunosRespondoes += i + ". " + aluno.toString();
			i++;
		}
		
		return listaAlunosRespondoes;
	}
	
	private int getQuantidadeAlunos() {
		return this.alunos.keySet().size();
	}
	
	private int getQuantidadeGrupos() {
		return this.grupos.keySet().size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (objeto == null)
			return false;
		if (getClass() != objeto.getClass())
			return false;
		ControleDisciplina other = (ControleDisciplina) objeto;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quantidade de alunos: " + this.getQuantidadeAlunos() + "\n" + "Quantidade de grupos: " + this.getQuantidadeGrupos();
	}
}
