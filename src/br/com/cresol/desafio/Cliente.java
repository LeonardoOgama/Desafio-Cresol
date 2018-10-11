package br.com.cresol.desafio;

public class Cliente {

    private String nome;
    private double capital;
    private double taxaJuros;
    private int tempoTotal;
    private double transferencia;
    private double juros;

    public Cliente() {
    }

    public Cliente(String nome, double capital, double taxaJuros, int tempoTotal) throws Exception {
        this.setNome(nome);
        this.setCapital(capital);
        this.setTaxaJuros(taxaJuros);
        this.setTempoTotal(tempoTotal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() > 2 && nome != null) {
            this.nome = nome;
        } else {
            throw new Exception("Nome inválido.");
        }
    }
    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) throws Exception {
        if (capital > 0.0) {
            this.capital = capital;
        } else {
            throw new Exception("Atençã: Valor do capital inválido. Por favor, informe somente valores positivos.");
        }
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) throws Exception {
        if (taxaJuros >= 0.0 && taxaJuros <= 100.0) {
            this.taxaJuros = taxaJuros;
        } else {
            throw new Exception("Atenção: Taxa de juros a.m inválida. Por favor, informe somente valores entre 0.0 e 100.0");
        }
    }
    
    public void calculartransferencia() {
        
        double taxa = (this.getTaxaJuros() / 100);
        double transferecia = this.getCapital() * Math.pow((1 + taxa), this.getTempoTotal());
        
        this.setTransferencia(transferencia);
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) throws Exception {
        if (tempoTotal > 0) {
            this.tempoTotal = tempoTotal;
        } else {
            throw new Exception("Atenção: Tempo total da aplicação inválido. Por favor, informe somente valores positivos.");
        }
    }

    public void calcularJuros() {
        
        double juros = this.getTransferencia() - this.getCapital();
        
        this.setJuros(juros);
    }
}
