package br.com.techsoft.calculoirpf;

public class Inss {
    private final double SALARIO_FAIXA_1 = 1751.81;
    private final double SALARIO_FAIXA_2 = 2919.72;
    private final double SALARIO_FAIXA_3 = 5839.45;
    private final double salario;
    private double descontoMaximo;
    private double aliquota;
    private double impostoINSS;

    public Inss(double salario) {
        this.salario = salario;
        calculaAliquota();
        this.descontoMaximo = this.SALARIO_FAIXA_3 * this.aliquota;
        calculaImpostoINSS();
    }

    private void calculaAliquota() {
        if (this.salario <= this.SALARIO_FAIXA_1) {
            this.aliquota = 0.08;
        } else if (this.salario <= this.SALARIO_FAIXA_2) {
            this.aliquota = 0.09;
        } else {
            this.aliquota = 0.11;
        }
    }

    private void calculaImpostoINSS() {
        if (this.salario <= this.SALARIO_FAIXA_3) {
            this.impostoINSS = this.salario * this.aliquota;
        } else {
            this.impostoINSS = this.descontoMaximo;
        }
    }

    public double calculaSalario(){
        return this.salario - this.impostoINSS;
    }

    public double getImpostoINSS(){
        return this.impostoINSS;
    }
}