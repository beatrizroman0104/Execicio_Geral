public class Carro {
    String marca;
    String modelo;
    String placa;
    Proprietario proprietario;


    public Carro(String marca, String modelo, String placa, Proprietario proprietario){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.proprietario =  proprietario;
    }
}
