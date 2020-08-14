package lab5;

public enum Estado {
	
	NAO_FINALIZADO("Nao finalizado"), 
	
	FINALIZADO_OCORREU("Finalizado (ocorreu)"), 
	
	FINALIZADO_NAO_OCORREU("Finalizado (n ocorreu)");
	
	private String mensagem;
	
	private Estado(String msg) {
		this.mensagem = msg;
	}
	
	@Override
	public String toString() {
		return this.mensagem;
	}
}
