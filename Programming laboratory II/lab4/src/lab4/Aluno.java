package lab4;

public class Aluno {
	private String nome;
	private String matricula;
	private String curso;
	
	public Aluno(String nome, String matricula, String curso) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio!");
		} else {
			this.nome = nome.trim();
		}
		
		if (matricula == null) {
			throw new NullPointerException("Matrícula nula!");
		} else if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matrícula nula!");
		} else {
			this.matricula = matricula.trim();
		}
		
		if (curso == null) {
			throw new NullPointerException("Curso nulo!");
		} else if (curso.trim().equals("")) {
			throw new IllegalArgumentException("Curso vazio!");
		} else {
			this.curso = curso.trim();
		}
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getCurso() {
		return this.curso;
	}
	
	@Override
	public String toString() {
		return this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}
}
