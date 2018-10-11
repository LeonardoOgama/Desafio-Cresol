package br.com.cresol.desafio;

public class Aplicacao {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String destinoEmprestimo = "dados.txt";
	       Emprestimo m = new Emprestimo(destinoEmprestimo);

	        try {
	            m.criarEmprestimo(destinoEmprestimo);
	        } catch (Exception e) {
	            System.out.println("Erro ao tentar criar um emprestimo: " + e.getMessage());
	            System.exit(0);
	        }

	        String opcao = "\\c";

	        String nome;
	        double capital, taxaJuros;
	        int tempoTotal, numCliente = 1;

	        String linhaEmprestimo;

	        try {
	            while (!opcao.equalsIgnoreCase("\\q")) {
	                switch (opcao) {
	                    case "\\c":
	                        Cliente c = new Cliente();

	                        System.out.println("Cliente " + numCliente + ":");

	                        // Entrada de dados
	                        System.out.println("Por favor, informe o nome e sobrenome do cliente:");
	                        c.setNome(sc.nextLine());

	                        System.out.println("Por favor, informe o valor do capital do cliente:");
	                        c.setCapital(sc.nextDouble());

	                        System.out.println("Por favor, informe a taxa de juros a.m (%) do cliente:");
	                        c.setTaxaJuros(sc.nextDouble());

	                        System.out.println("Por favor, informe o tempo total da aplicação (meses) do cliente:");
	                        c.setTempoTotal(sc.nextInt());
	                        
	                        sc.nextLine(); // Scanner reset

	                        // Cálculo do montante e juros
	                        c.calcularTransferencia();
	                        c.calcularJuros();

	                        // Escrever dados no arquivo .txt
	                        OutputStream outArq = (OutputStream) m.editarEmprestimo();

	                        OutputStreamWriter escritor = new OutputStreamWriter(outArq);
	                        BufferedWriter bufferEscrita = new BufferedWriter(escritor);

	                        linhaArquivo = String.format("Cliente %d: %s; ", numCliente, c.getNome());
	                        linhaArquivo += String.format("M: %.2f; ", c.getTransferencia());
	                        linhaArquivo += String.format("J: %.2f", c.getJuros());

	                        m.escreverEmprestimo(bufferEscrita, linhaArquivo);

	                        bufferEscrita.close();
	                        break;

	                    case "\\i":
	                        InputStream inputArq = (InputStream) m.verificarEmprestimo();
             
}
