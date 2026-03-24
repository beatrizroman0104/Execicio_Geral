public class Estacionamento {
    Carro carro;
    String horaEntrada;
    String horaSaida;
    Proprietario proprietario;



    public void Registros(Carro carro, String horaEntrada){
        this.carro = carro;
        this.horaEntrada = horaEntrada;
    }
}
