import java.util.HashMap;
import java.util.Map;

public class Aluno {
	//public Map<String, Integer> contasLaboratorios = new HashMap<String, Integer>();
	//public Map disciplinas = new HashMap();
	//public Map contasCantinas = new HashMap();
	public Saude saude = new Saude();
	public String nomeAluno;
	
	public Aluno(String nome) {
		this.nomeAluno = nome;
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio) {
		ContaLaboratorio contaLab = new ContaLaboratorio(nomeLaboratorio);
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		ContaLaboratorio contaLab = new ContaLaboratorio(nomeLaboratorio, cota);
	}
	
	public void consomeEspaco(ContaLaboratorio contaLab, int mbytes) {
		contaLab.consomeEspaco(mbytes);
	}
	
	public void liberaEspaco(ContaLaboratorio contaLab, int mbytes) {
		contaLab.liberaEspaco(mbytes);
	}
	
	public boolean atingiuCota(ContaLaboratorio contaLab) {
		return contaLab.atingiuCota(); 
	}
	
	public String laboratorioToString(ContaLaboratorio contaLab) {
		return contaLab.toString();
	}
	
	public void cadastraDisciplina(String nomeDisciplina) {
		Disciplina disciplina = new Disciplina(nomeDisciplina);
	}
	
	public void cadastraDisciplina(String nomeDisciplina, int provas) {
		Disciplina disciplina = new Disciplina(nomeDisciplina, provas);
	}
	
	public void cadastraDisciplina(String nomeDisciplina, int provas, int[] pesos) {
		Disciplina disciplina = new Disciplina(nomeDisciplina, provas, pesos);
	}
	
	public void cadastraHoras(Disciplina disciplina, int horas) {
		disciplina.cadastraHoras(horas);
	}
	
	public void cadastraNota(Disciplina disciplina, int nota, double valorNota) {
		disciplina.cadastraNota(nota, valorNota);
	}
	
	public String disciplinaToString(Disciplina disciplina) {
		return disciplina.toString();
	}
	
	public void cadastraCantina(String nomeCantina) {
		ContaCantina contaCantina = new ContaCantina(nomeCantina);
	}

	public void cadastraLanche(ContaCantina contaCantina, int quantidade, int valorCentavos, String detalhes) {
		contaCantina.cadastraLanche(quantidade, valorCentavos, detalhes);
	}
	
	public void pagarConta(ContaCantina contaCantina, int valorCentavos) {
		contaCantina.pagaConta(valorCentavos);
	}
	
	public String cantinaToString(ContaCantina contaCantina) {
		return contaCantina.toString();	
	}
	
	public void defineSaudeMental(String valor) {
		saude.defineSaudeMental(valor);
	}
	
	public void defineSaudeFisica(String valor) {
		saude.defineSaudeFisica(valor);
	}
	
	public String geral() {
		return saude.toString();
	}
}
