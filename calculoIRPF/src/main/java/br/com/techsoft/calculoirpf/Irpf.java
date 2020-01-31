package br.com.techsoft.calculoirpf;

public class Irpf{
    private final double SALARIO_FAIXA_1 = 1903.98;
    private final double SALARIO_FAIXA_2 = 2826.65;
    private final double SALARIO_FAIXA_3 = 3751.05;
    private final double SALARIO_FAIXA_4 = 4664.68;
    private final double VALOR_DEPENDENTE = 189.59;
    private final double salario;
    private double descontoDependentes;
    private double desconto;
    private double aliquota;
    private double impostoIRPF;

    public Irpf(double salario, int quantidadeDependentes) {
        this.descontoDependentes = this.VALOR_DEPENDENTE * quantidadeDependentes;
        this.salario = salario - this.descontoDependentes;
        calculaAliquotaEDesconto();
        calculaImpostoIRPF();
    }

    private void calculaAliquotaEDesconto() {
        if (this.salario <= this.SALARIO_FAIXA_1) {
            this.aliquota = 0;
            this.desconto = 0;
        } else if (this.salario <= this.SALARIO_FAIXA_2) {
            this.aliquota = 0.075;
            this.desconto = 142.80;
        } else if (this.salario <= this.SALARIO_FAIXA_3) {
            this.aliquota = 0.15;
            this.desconto = 354.80;
        } else if (this.salario <= this.SALARIO_FAIXA_4) {
            this.aliquota = 0.225;
            this.desconto = 636.13;
        } else {
            this.aliquota = 0.275;
            this.desconto = 869.36;
        }
    }
 
    private void calculaImpostoIRPF(){
        this.impostoIRPF = this.salario * this.aliquota;
        this.impostoIRPF -= this.desconto;
    }

    public double calculaSalario(){
        return this.salario - this.impostoIRPF;
    }

    public double getImpostoIRPF(){
        return this.impostoIRPF;
    }
}