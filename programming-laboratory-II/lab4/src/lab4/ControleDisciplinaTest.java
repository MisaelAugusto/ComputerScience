package lab4;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControleDisciplinaTest {

	private ControleDisciplina programacaoII;
	
	@Before
	public void criaControleDisciplina() {
		programacaoII = new ControleDisciplina();
		programacaoII.cadastraAluno("999999999", "Misael", "Computação");
		programacaoII.cadastrarGrupo("Listas");
		programacaoII.cadastrarGrupo("ExCeÇõEs");
	}
	
	@Test
	public void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!", programacaoII.cadastraAluno("111111111", "Pedro", "Engenharia Civil"));
	}

	@Test
	public void testCadastraAlunoExistente() {
		assertEquals("MATRÍCULA JÁ CADASTRADA!", programacaoII.cadastraAluno("999999999", "Misael", "Computação"));
	}
	
	@Test
	public void testCadastraMatriculaExistente() {
		assertEquals("MATRÍCULA JÁ CADASTRADA!", programacaoII.cadastraAluno("999999999", "Sophia", "Matemática"));
	}
	
	@Test
	public void testExibeAluno() {
		assertEquals("Aluno: 999999999 - Misael - Computação", programacaoII.exibeAluno("999999999"));
	}
	
	@Test
	public void testExibeAlunoInexistente() {
		assertEquals("Aluno não cadastrado!", programacaoII.exibeAluno("555555555"));
	}
	
	@Test
	public void testCadastrarGrupo() {
		assertEquals("CADASTRO REALIZADO!", programacaoII.cadastrarGrupo("Coleções"));
	}
	
	@Test
	public void testCadastrarGrupoExistente() {
		assertEquals("GRUPO JÁ CADASTRADO!", programacaoII.cadastrarGrupo("Listas"));
	}
	
	@Test
	public void testCadastrarGrupoExistente2() {
		assertEquals("GRUPO JÁ CADASTRADO!", programacaoII.cadastrarGrupo("exceções"));
	}
	
	@Test
	public void testAlocarAluno() {
		assertEquals("ALUNO ALOCADO!", programacaoII.alocarAluno("999999999", "Listas"));
	}
	
	@Test
	public void testAlocarAlunoExistente() {
		programacaoII.alocarAluno("999999999", "Listas");
		assertEquals("ALUNO ALOCADO!", programacaoII.alocarAluno("999999999", "Listas"));		
	}
	
	@Test
	public void testAlocarAlunoNaoCadastrado() {
		assertEquals("Aluno não cadastrado!", programacaoII.alocarAluno("111111111", "Listas"));
	}
	
	@Test
	public void testAlocarAlunoGrupoNaoCadastrado() {
		assertEquals("Grupo não cadastrado!", programacaoII.alocarAluno("999999999", "Polimorfismo"));
	}
}
