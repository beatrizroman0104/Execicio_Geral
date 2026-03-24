import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Carro[] carro = new Carro[5];
    static int indexCarro;
    static Estacionamento[] resgistro = new Estacionamento[20];
    static int indexEstacionamento;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("[1] Entrada de veículos");
            System.out.println("[2] Saída de veículo");
            System.out.println("[3] Imprimir veículos estacionados");
            System.out.println("[4] Imprimir receita");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();
        } while(opcao != 5);

        switch (opcao){
            case 1 -> registrarEntrada();
            case 2 -> registrarSaida();
            case 3 -> carrosEstacionados();
            case 4 -> receita();
            case 5 -> finalizar();
        }
    }

    private static void finalizar() {
    }

    private static void receita() {
    }

    private static void carrosEstacionados() {
        for (int i =0; i<indexEstacionamento;i++){
            System.out.println(resgistro[i].carro.placa);
        }
    }

    private static void registrarSaida() {
        Carro carroEncontrado = pesquisar();

    }

    private static void registrarEntrada() {
        Carro carroEncontrado = pesquisar();
        String marca;
        String modelo;
        String placa;
        String nome;
        long cpf;
        Estacionamento estacionamento;
        String horaEntrada;
        
        if (carroEncontrado == null){
            System.out.println("Marca: " );
            marca = sc.next();
            System.out.println("Modelo: ");
            modelo = sc.next();
            System.out.println("Placa: ");
            placa = sc.next();
            System.out.println("Nome: ");
            nome = sc.next();
            System.out.println("CPF: ");
            cpf = sc.nextLong();
            Proprietario proprietario = new Proprietario(nome, cpf);
            carro[indexCarro] = new Carro(marca, modelo, placa, proprietario);
            indexCarro++;
        }
        else{
            System.out.print("Hora de entrada(HH:mm): ");
            horaEntrada = sc.next();
            estacionamento[indexEstacionamento] = new Estacionamento(carroEncontrado, horaEntrada);
            indexEstacionamento++;
        }
    }

    private static carro pesquisar(){
        String placa;
        System.out.println("Placa para pesquisa: ");
        placa = sc.next().toUpperCase();

        for (int i = 0; i < indexCarro; i++){
            if(carro[i].placa.equals(placa)){
                return carro[i];
            }
        }
        System.out.println("Placa não encontrada!");
        return null;
    }
}