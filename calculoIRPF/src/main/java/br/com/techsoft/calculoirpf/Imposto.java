package br.com.techsoft.calculoirpf;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Imposto{
    private final double descontoTotal;
    private final double impostoINSS;
    private final double impostoIRPF;
    private double salario;

    public Imposto(double salario, int quantidadeDependentes){
        this.salario = salario;
        Inss inss = new Inss(salario);
        Irpf irpf = new Irpf(inss.calculaSalario(), quantidadeDependentes);
        this.impostoINSS = inss.getImpostoINSS();
        this.impostoIRPF = irpf.getImpostoIRPF();
        this.descontoTotal = this.impostoINSS + this.impostoIRPF;
        this.salario -= this.descontoTotal;
    }

    private String arredondar(double valor){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(valor);
    }

    public String getSalarioFinal() {
        return arredondar(salario);
    }

    public String getDescontoTotal() {
        return arredondar(descontoTotal);
    }

    public String getImpostoINSS() {
        return arredondar(impostoINSS);
    }

    public String getImpostoIRPF() {
        return arredondar(impostoIRPF);
    }

    
}