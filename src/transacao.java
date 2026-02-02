package log;

import java.math.BigDecimal;
import java.util.Scanner;

public class  {
    private static Scanner sc = new Scanner(System.in);
    private static Banco banco = new Banco();
    private static Conta contaLogada = null;

    public static void main(String[] args) {
        System.out.println("=== BEM-VINDO AO JAVA BANK ===");

        while (true) {
            if (contaLogada == null) {
                menuLogin();
            } else {
                menuPrincipal();
            }
        }
    }

    private static void menuLogin() {
        System.out.print("\nNúmero da Conta: ");
        String num = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();

        contaLogada = banco.autenticar(num, senha);

        if (contaLogada == null) {
            System.out.println("Erro: Conta ou senha inválidos.");
        } else {
            System.out.println("Login realizado com sucesso!");
        }
    }

    private static void menuPrincipal() {
        System.out.println("\n1- Saldo | 2- Saque | 3- Depósito | 4- Extrato | 5- Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Saldo atual: R$ " + contaLogada.getSaldo());
                break;
            case 2:
                System.out.print("Valor do saque: ");
                BigDecimal vSaque = sc.nextBigDecimal();
                if (contaLogada.sacar(vSaque)) {
                    System.out.println("Saque realizado!");
                } else {
                    System.out.println("Saldo insuficiente ou valor inválido.");
                }
                break;
            case 3:
                System.out.print("Valor do depósito: ");
                BigDecimal vDep = sc.nextBigDecimal();
                contaLogada.depositar(vDep);
                System.out.println("Depósito realizado!");
                break;
            case 4:
                contaLogada.imprimirExtrato();
                break;
            case 5:
                contaLogada = null;
                System.out.println("Sessão encerrada.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}