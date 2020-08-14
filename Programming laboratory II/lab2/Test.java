
		Scanner sc = new Scanner(System.in);
		
		int n1 = 0, n2 = 0, n3 = 0; 
		
		while (n1 == 0) {
			System.out.println("Digite o seu nome: ");
			
			String nomeAluno = sc.nextLine();
			
			Aluno aluno = new Aluno(nomeAluno);
			
			System.out.println("Digite o número de acordo com a aba que deseja acessar:");
			System.out.println("1) Contas dos Laboratórios");
			System.out.println("2) Disciplinas em curso");
			System.out.println("3) Contas das Cantinas");
			System.out.println("4) Saúde");
			System.out.println("5) Sair");
			System.out.print("Digite aqui: ");
			
			String numeroOperacao = sc.nextLine();
			
			if (numeroOperacao.equals("1")) {
				System.out.println("--------------------------------------------------");
				System.out.println("Bem-vindo(a) " + nomeAluno + ", esta é a aba de administração das contas dos laboratórios");
					
				System.out.println("Primeiramente cadastre alguma conta de Laboratório");
				System.out.println("Digite as informações do Laboratório: ");
					
				String[] infoLaboratorio = sc.nextLine().split(" ");
				int tamanho = infoLaboratorio.length;
					
				if (tamanho == 1) {
					aluno.cadastraLaboratorio(infoLaboratorio[0]);
				} else {
					aluno.cadastraLaboratorio(infoLaboratorio[0], infoLaboratorio[1]);
				}
			
				System.out.println(infoLaboratorio[0] + ":");
				System.out.println("--------------------------------------------------");
				System.out.println("Digite o número de acordo com a ação desejada: ");
				System.out.println("1) Consumir Espaço");
				System.out.println("2) Liberar Espaço");
				System.out.println("3) Verificar se atingiu a cota");
				System.out.println("4) Detalhes");
				System.out.print("Digite aqui: ");
				
				int numeroOperacaoLab = sc.nextInt();
				
				if (numeroOperacaoLab == 1) {
					System.out.print("Digite a quantidade: ");
					
					int quantidade = nextInt();
					
					aluno.consomeEspaco(quantidade);		
				} else if (numeroOperacaoLab == 2) {
					System.out.print("Digite a quantidade: ");
					
					int quantidade = nextInt();
					
					aluno.liberaEspaco(quantidade);
				} else if (numeroOperacaoLab == 3) {
					if (aluno.atingiuCota) {
						System.out.println("A sua conta atingiu a cota limite!");
						System.out.println("--------------------------------------------------");
						System.out.println("Para realizar mais operações reinicie o programa!");
						break;
					} else {
						System.out.println("A sua conta ainda não atingiu a cota limite!");
						System.out.println("--------------------------------------------------");
						System.out.println("Para realizar mais operações reinicie o programa!");						
						break;
					}
				} else if (numeroOperacao == 4) {			
					String mensagem = aluno.laboratorioToString(infoLaboratorio[0]);
					
					System.out.println(mensagem);
					
				} else {
					System.out.println("Ação Inválida! O programa será finalizado!");
					break;
				}
				
			} else if (numeroOperacao.equals("2")) {
				System.out.println("--------------------------------------------------");
				System.out.println("Bem-vindo(a) " + nomeAluno + ", esta é a aba de administração das disciplinas");
				
				System.out.println("Primeiramente cadastre alguma Disciplina");
				System.out.println("Digite as informações da Disciplina: ");
					
				String[] infoDisciplina = sc.nextLine().split(" ");
				int tamanho = infoDisciplina.length;
					
				if (tamanho == 1) {
					aluno.cadastraDisciplina(infoDisciplina[0]);
				} else if (tamanho == 2) {
					aluno.cadastraDisciplina(infoDisciplina[0], infoDisciplina[1]);
				} else {
					aluno.cadastraDisciplina(infoDisciplina[0], infoDisciplina[1], infoDisciplina[2]);
				}
				
				System.out.println(infoDisciplina[0] + ":");
				System.out.println("Digite o número de acordo com a ação desejada: ");
				System.out.println("1) Cadastrar Horas");
				System.out.println("2) Cadastrar Nota");
				System.out.println("3) Detalhes");
				System.out.print("Digite aqui: ");
				
				int numeroOperacaoDisc = sc.nextInt();
				
				if (numeroOperacaoDisc == 1) {
					System.out.print("Digite o número de horas: ");
					
					int horas = sc.nextInt();
					
					aluno.cadastraHoras(horas);
					
				} else if (numeroOperacaoDisc == 2) {
					System.out.print("Digite o número da nota: ");
					int prova = sc.nextInt();
					
					System.out.print("Digite o valor da nota: ");
					double valorNota = sc.nextDouble();
					
					aluno.cadastraNota(prova, valorNota);
					
				} else if (numeroOperacaoDisc == 3) {
					
				} else {
					System.out.println("Ação Inválida! O programa será finalizado!");
					break;
				}
			} else if (numeroOperacao.equals("3")) {
				System.out.println("--------------------------------------------------");
				System.out.println("Bem-vindo(a) " + nomeAluno + ", esta é a aba de administração das contas das cantinas");
				System.out.println("");
			} else if (numeroOperacao.equals("4")) {
				System.out.println("--------------------------------------------------");
				System.out.println("Bem-vindo(a) " + nomeAluno + ", esta é a aba de administração das contas dos laboratórios");
				System.out.println("");		
			} else if (numeroOperacao.equals("5")) {
				break;
			} else {
				System.out.println("Comando desconhecido! O programa será finalizado!");
				break;
		}		
	}		
}

}
