package lab4;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoTest {

	private Aluno aluno;
	
	@Before
	public void criaAluno() {
		aluno = new Aluno("Misael", "100", "Computação");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCriaAlunoNomeNulo() {
		Aluno alunoInvalido = new Aluno(null, "111111111", "Computação");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeVazio() {
		Aluno alunoInvalido = new Aluno("  ", "111111111", "Computação");
	}

	@Test(expected=NullPointerException.class)
	public void testCriaAlunoMatriculaNula() {
		Aluno alunoInvalido = new Aluno("Misael", null, "Computação");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoMatriculaVazia() {
		Aluno alunoInvalido = new Aluno("Misael", "   ", "Computação");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCriaAlunoCursoNulo() {
		Aluno alunoInvalido = new Aluno("Misael", "111111111", null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoCursoVazio() {
		Aluno alunoInvalido = new Aluno("Misael", "111111111", "    ");
	}
	
	@Test
	public void testToString() {
		String msg = "Olá";
		
		assertEquals(msg, "100 - Misael - Computação", aluno.toString());
	}
	
}
