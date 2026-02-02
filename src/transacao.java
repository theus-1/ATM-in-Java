import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo;
    private BigDecimal valor;
    private LocalDateTime data;

    public Transacao(String tipo, BigDecimal valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %-15s: R$ %10.2f", data.format(fmt), tipo, valor);
    }
}