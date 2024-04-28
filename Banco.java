class Banco {
    public static void transferir(Conta origem, Conta destino, double valor) {
        origem.debitar(valor);
        destino.creditar(valor);
    }

    public static void exibirSaldosFinais(Loja[] lojas, Funcionario[][] funcionarios, Cliente[] clientes) {
        
        System.out.println("\nSaldos finais das contas das lojas:");
        for (Loja loja : lojas) {
            System.out.println("Saldo da conta da " + loja.getNome() + ": " + loja.getConta().getSaldo());
        }
        
        System.out.println("\nSaldos finais das contas dos funcionários:");
        for (Funcionario[] funcionariosLoja : funcionarios) {
            for (Funcionario funcionario : funcionariosLoja) {
                System.out.println("Saldo da conta de salário do funcionário " + funcionario.getNome() + ": " + funcionario.getContaSalario().getSaldo());
                System.out.println("Saldo da conta de investimento do funcionário " + funcionario.getNome() + ": " + funcionario.getContaInvestimento().getSaldo());
            }
        }
        System.out.println("\nSaldos finais das contas dos clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Saldo da conta do cliente " + cliente.getNome() + ": " + cliente.getConta().getSaldo());
        }
    }
}
