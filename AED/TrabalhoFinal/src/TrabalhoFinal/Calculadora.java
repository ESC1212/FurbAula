package TrabalhoFinal;

public class Calculadora {

    public Fila<String> extrairTermos(String expresao) {
        Fila<String> fila = new Fila<>(100);
        expresao = expresao.replaceAll("\\s+", "");
        int i = 0;
        
        while (i < expresao.length()) {
            char c = expresao.charAt(i);
            
            if (c == '(' || c == ')' || c == '+' || c == '*' || c == '/') {
                fila.inserir(String.valueOf(c));
                i++;
            } else if (c == '-') {
                if (i == 0 || isOperadorOuAbertura(expresao.charAt(i - 1))) {
                    int start = i;
                    i++;
                    while (i < expresao.length() && (Character.isDigit(expresao.charAt(i)) || expresao.charAt(i) == ',')) {
                        i++;
                    }
                    fila.inserir(expresao.substring(start, i));
                } else {
                    fila.inserir(String.valueOf(c));
                    i++;
                }
            } else if (Character.isDigit(c) || c == ',') {
                int start = i;
                while (i < expresao.length() && (Character.isDigit(expresao.charAt(i)) || expresao.charAt(i) == ',')) {
                    i++;
                }
                fila.inserir(expresao.substring(start, i));
            } else {
                i++;
            }
        }
        return fila;
    }

    private boolean isOperadorOuAbertura(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(';
    }

    public Fila<String> gerarExprPosfixada(Fila<String> exprInfixada) {
        Fila<String> c = new Fila<>(100);
        Pilha<String> b = new Pilha<>();

        while (!exprInfixada.estaVazia()) {
            String termo = exprInfixada.retirar();
            
            if (termo.equals("(")) {
                b.empilhar(termo);
            } else if (termo.equals(")")) {
                while (!b.estaVazia() && !b.olhar().equals("(")) {
                    c.inserir(b.desempilhar());
                }
                if (!b.estaVazia()) {
                    b.desempilhar();
                }
            } else if (isOperador(termo)) {
                while (!b.estaVazia() && !b.olhar().equals("(") && precedencia(b.olhar()) >= precedencia(termo)) {
                    c.inserir(b.desempilhar());
                }
                b.empilhar(termo);
            } else {
                c.inserir(termo);
            }
        }

        while (!b.estaVazia()) {
            c.inserir(b.desempilhar());
        }

        return c;
    }

    private boolean isOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int precedencia(String op) {
        if (op.equals("*") || op.equals("/")) {
            return 2;
        }
        if (op.equals("+") || op.equals("-")) {
            return 1;
        }
        return 0;
    }

    public double calcularExprPosfixada(Fila<String> exprPosfixada) {
        Pilha<Double> pilha = new Pilha<>();

        while (!exprPosfixada.estaVazia()) {
            String termo = exprPosfixada.retirar();
            
            if (isOperador(termo)) {
                double v2 = pilha.desempilhar();
                double v1 = pilha.desempilhar();
                double res = 0;
                
                switch (termo) {
                    case "+": res = v1 + v2; break;
                    case "-": res = v1 - v2; break;
                    case "*": res = v1 * v2; break;
                    case "/": res = v1 / v2; break;
                }
                pilha.empilhar(res);
            } else {
                termo = termo.replace(',', '.');
                pilha.empilhar(Double.parseDouble(termo));
            }
        }

        return pilha.desempilhar();
    }
}