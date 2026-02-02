import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
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
        if (contaLogada == null) System.out.println("Erro: Dados inválidos.");
    }

    private static void menuPrincipal() {
        System.out.println("\n1-Saldo | 2-Saque | 3-Depósito | 4-Transferir | 5-Extrato | 6-Sair");
        System.out.print("Opção: ");
        try {
            int op = sc.nextInt();
            switch (op) {
                case 1 -> System.out.println("Saldo: R$ " + contaLogada.getSaldo());
                case 2 -> {
                    System.out.print("Valor saque: ");
                    if (contaLogada.sacar(sc.nextBigDecimal())) System.out.println("Sucesso!");
                    else System.out.println("Saldo insuficiente.");
                }
                case 3 -> {
                    System.out.print("Valor depósito: ");
                    contaLogada.depositar(sc.nextBigDecimal());
                    System.out.println("Sucesso!");
                }
                case 4 -> {
                    System.out.print("Conta destino: ");
                    Conta dest = banco.buscarConta(sc.next());
                    if (dest != null && !dest.equals(contaLogada)) {
                        System.out.print("Valor: ");
                        if (contaLogada.transferir(sc.nextBigDecimal(), dest)) System.out.println("Sucesso!");
                        else System.out.println("Saldo insuficiente.");
                    } else {
                        System.out.println("Conta inválida.");
                    }
                }
                case 5 -> contaLogada.imprimirExtrato();
                case 6 -> {
                    contaLogada = null;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Inválido.");
            }
        } catch (Exception e) {
            System.out.println("Erro na entrada.");
            sc.next();
        }
    }
}