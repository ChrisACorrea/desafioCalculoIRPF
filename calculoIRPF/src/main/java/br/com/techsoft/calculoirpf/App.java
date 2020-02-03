package br.com.techsoft.calculoirpf;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Por favor digite seu salário: ");
        double salario = teclado.nextDouble();
        System.out.print("Agora digite quantos dependentes você possui: ");
        int quantidadeDependentes = teclado.nextInt();
        Imposto imposto = new Imposto(salario, quantidadeDependentes);
        teclado.close();

        System.out.println();
        System.out.println("Aqui está o calculo do seu imposto.");
        System.out.println();
        System.out.println("INSS: " + imposto.getImpostoINSS());
        System.out.println("IRPF: " + imposto.getImpostoIRPF());
        System.out.println("Desconto total: " + imposto.getDescontoTotal());
        System.out.println("Salário Final: " + imposto.getSalarioFinal());
    }
}
