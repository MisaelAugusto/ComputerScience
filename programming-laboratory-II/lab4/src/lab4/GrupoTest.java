package lab4;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrupoTest {

	private Grupo grupoVazio;
	
	private Grupo grupo;
	
	@Before
	public void criaGrupo() {
		grupoVazio = new Grupo("Coleções");
		grupo = new Grupo("Listas");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCriaGrupoNomeNulo() {
		Grupo grupoInvalido = new Grupo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaGrupoNomeVazio() {
		Grupo grupoInvalido = new Grupo("    ");
	}	
	
	@Test
	public void testImprimeAlunos() {	
		grupo.adicionaAluno(new Aluno("Misael", "999999999", "Computação"));
		grupo.adicionaAluno(new Aluno("Pedro", "111111111", "Engenharia Civil"));
		
		assertEquals("Alunos do grupo Listas:\n* 999999999 - Misael - Computação\n* 111111111 - Pedro - Engenharia Civil\n", grupo.imprimeAlunos());
	}
	
	@Test
	public void testImprimeAlunosGrupoVazio() {
		assertEquals("Alunos do grupo Coleções:\n", grupoVazio.imprimeAlunos());
	}
	
	@Test
	public void testToString() {
		grupo.adicionaAluno(new Aluno("Misael", "999999999", "Computação"));
		grupo.adicionaAluno(new Aluno("Pedro", "111111111", "Engenharia Civil"));
		
		assertEquals("Nome do grupo: Listas\nQuantidade de alunos: 2", grupo.toString());
	}
	
	@Test
	public void testToStringGrupoVazio() {
		assertEquals("Nome do grupo: Coleções\nQuantidade de alunos: 0", grupoVazio.toString());
	}
}
