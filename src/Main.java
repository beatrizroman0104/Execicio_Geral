import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Carro[] carro = new Carro[5];
    static int indexCarro;
    static Estacionamento[] registro = new Estacionamento[20];
    static int indexRegistro;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("[1] Entrada de veículos");
            System.out.println("[2] Saída de veículo");
            System.out.println("[3] Imprimir veículos estacionados");
            System.out.println("[4] Imprimir receita");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> registrarEntrada();
            case 2 -> registrarSaida();
            case 3 -> estacionados();
            case 4 -> receita();
            case 5 -> System.out.println("ParkEasy agradece!");
            default -> System.out.println("Opção inválida!");
            }
            System.out.println();
        }while(opcao !=5);

    }

    private static void receita() {
        double valor = 0;
        for (int i =0; i< indexRegistro;i++){
            if (registro[i].horaSaida != null){
                valor += registro[i].calcularValor();
            } else {
                System.out.println("A receita atual é R$ 0.00");
            }
        }
        System.out.println("Receita total: " + valor);
    }

    private static void estacionados() {
        for (int i =0; i< indexRegistro;i++){
            if (registro[i].horaSaida == null){
                System.out.println(registro[i].carro.placa);
            }
        }
    }

    private static void registrarSaida() {
        String horaSaida;
        double valor;

        Estacionamento  registro = pesquisarRegistro();

        if (registro != null){
            System.out.println("Hora de saída (hh:mm): ");
            horaSaida = sc.next();

            registro.horaSaida = horaSaida;

            valor = registro.calcularValor();

            System.out.println("Valor total a pagar R$ " + valor);
        }
    }

    private static Estacionamento pesquisarRegistro(){
        String placa;
        System.out.println("Placa para pesquisa: ");
        placa = sc.next().toUpperCase();

        for (int i = 0; i < indexRegistro; i++){
            if(registro[i].carro.placa.equals(placa)){
                return registro[i];
            }
        }
        System.out.println("Veículo não encontrado!");
        return null;
    }

    private static void registrarEntrada() {
        String marca;
        String modelo;
        String placa;
        String nome;
        long cpf;
        String horaEntrada;

        Carro carroEncontrado = pesquisar();
        
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
            carroEncontrado = new Carro(marca, modelo, placa, proprietario);
            carro[indexCarro] = carroEncontrado;
            indexCarro++;
        }
            System.out.print("Hora de entrada(HH:mm): ");
            horaEntrada = sc.next();
            registro[indexRegistro] = new Estacionamento(carroEncontrado, horaEntrada);
            indexRegistro++;
    }

    private static Carro pesquisar(){
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