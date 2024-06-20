import java.util.Scanner;

public class ContaBancaria {
    private String nome;
    private String tipo;
    private double saldo;

    public void consultarDados(){
        System.out.println(String.format("""
                ***********************
                Dados iniciais do cliente:
                Nome: %s
                Tipo conta: %s
                Saldo: R$ %.2f
                ***********************
                """,nome, tipo, saldo));
    }

    private void receberValor(double valor) {
        saldo += valor;
        System.out.println("Valor recebido: R$ " + valor);
        System.out.println("Saldo atualizado: R$ " + saldo + "\n");
    }

    private void transferirValor(double valor){
        if (saldo >= valor){
            saldo -= valor;
            System.out.println("Valor transferido: R$ " + valor);
            System.out.println("Saldo atualizado: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    private void consultarSaldos(){
        System.out.println("Saldo atualizado: R$ " + saldo + "\n");
    }

    public static void main(String[] args) {
        boolean iniciou = true;
        int opcao;
        double valor;

        //variavel para ler as opções do menu
        Scanner scan = new Scanner(System.in);

        //novo objeto
        ContaBancaria conta = new ContaBancaria();

        //setando valores
        conta.nome = "Natan Mendes";
        conta.tipo = "Corrente";
        conta.saldo = 2500.0;
        System.out.println(conta.saldo);

        while (iniciou){

            //exibe os dados do usuário
            conta.consultarDados();

            System.out.println("""
                    Operações
                    
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    Digite a opção desejada:""");

            //lê a opção do usuário
            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    conta.consultarSaldos();
                    break;

                case 2:
                    System.out.println("Informe o valor a receber: ");
                    valor = scan.nextDouble();
                    conta.receberValor(valor);
                    break;

                case 3:
                    System.out.println("Informe o valor a transferir: ");
                    valor = scan.nextDouble();
                    conta.transferirValor(valor);
                    break;

                case 4:
                    System.out.println("Adeus!");
                    iniciou = false;
                    break;
            }
        }

    }

}
