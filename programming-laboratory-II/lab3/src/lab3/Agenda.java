package lab3;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class Agenda {
	private Map<Integer, Contato> contatos = new TreeMap<Integer, Contato>();
	
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.contatos.put(posicao, new Contato(nome, sobrenome, telefone));
	}
	
	public String exibirContato(int posicao) {
		return this.contatos.get(posicao).toString();
	}

	public Set<Integer> getPosicoes() {
		Set<Integer> posicoes = contatos.keySet();
		return posicoes;
	}
	
	public String listarContato(int posicao) {
		
	}
	
}
