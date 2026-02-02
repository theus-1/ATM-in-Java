import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private String senha;
    private BigDecimal saldo;
    private List<Transacao> historico;

    public Conta(String numero, String senha, double saldoInicial) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = BigDecimal.valueOf(saldoInicial);
        this.historico = new ArrayList<>();
        registrarTransacao("Abertura", this.saldo);
    }

    public String getNumero() { return numero; }
    public BigDecimal getSaldo() { return saldo; }
    public boolean validarSenha(String senha) { return this.senha.equals(senha); }

    private void registrarTransacao(String tipo, BigDecimal valor) {
        historico.add(new Transacao(tipo, valor));
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
            registrarTransacao("Deposito", valor);
        }
    }

    public boolean sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(valor);
            registrarTransacao("Saque", valor.negate());
            return true;
        }
        return false;
    }

    public boolean transferir(BigDecimal valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            // Registros manuais para detalhar a transferência no extrato
            this.registrarTransacao("Transf. Enviada", valor.negate());
            destino.registrarTransacao("Transf. Recebida", valor);
            return true;
        }
        return false;
    }

    public void imprimirExtrato() {
        System.out.println("\n=== EXTRATO DA CONTA: " + numero + " ===");
        for (Transacao t : historico) {
            System.out.println(t);
        }
        System.out.println("-------------------------------------------");
        System.out.println("SALDO ATUAL: R$ " + saldo);
    }
}