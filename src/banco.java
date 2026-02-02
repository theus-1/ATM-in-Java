import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Conta> contas = new HashMap<>();

    public Banco() {
        // Contas padrão para teste
        contas.put("123", new Conta("123", "1111", 500.00));
        contas.put("456", new Conta("456", "2222", 1500.00));
    }

    public Conta autenticar(String numero, String senha) {
        Conta conta = contas.get(numero);
        if (conta != null && conta.validarSenha(senha)) {
            return conta;
        }
        return null;
    }

    public Conta buscarConta(String numero) {
        return contas.get(numero);
    }
}