import java.time.Duration;
import java.time.LocalTime;

public class Registro {
    Veiculo veiculo;
    String horaEntrada;
    String horaSaida;

    public Registro(Veiculo veiculo, String horaEntrada) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
    }

    public double calcularValor() {
        LocalTime inicio, fim;
        double valor;
        long minutos;

        /// n usa objeto, usa método sem onjeto, logo são métodos marcado por static
        /// +1 método = sobrecarga / diferença nos parâmetros
        inicio = LocalTime.parse(horaEntrada);
        fim = LocalTime.parse(horaSaida);
        minutos = Duration.between(inicio, fim).toMinutes();
        valor = minutos * 0.75;
        return valor;
    }
}
