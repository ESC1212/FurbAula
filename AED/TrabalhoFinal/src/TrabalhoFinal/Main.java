package TrabalhoFinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Formula: ");
        String expressao = scanner.nextLine();
        
        Calculadora c = new Calculadora();
        Fila<String> termosInfixada = c.extrairTermos(expressao);
        Fila<String> termosPosfixada = c.gerarExprPosfixada(termosInfixada);
        double resultado = c.calcularExprPosfixada(termosPosfixada);
        
        System.out.println("Resultado: " + resultado);
        
        scanner.close();
    }
}