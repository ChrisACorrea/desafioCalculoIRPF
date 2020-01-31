package br.com.techsoft.calculoirpf;


public class App 
{
    public static void main( String[] args )
    {
        double salario = 3000;
        int quantidadeDependentes = 2;
        Imposto imposto = new Imposto(salario, quantidadeDependentes);

        System.out.println("INSS: " + imposto.getImpostoINSS());
        System.out.println("IRPF: " + imposto.getImpostoIRPF());
        System.out.println("Desconto total: " + imposto.getDescontoTotal());
        System.out.println("Salário Final: " + imposto.getSalarioFinal());
    }
}
