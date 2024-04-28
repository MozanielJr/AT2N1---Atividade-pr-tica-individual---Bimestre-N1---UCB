public class Main {
    public static void main(String[] args) {
        Loja loja1 = new Loja("Loja 1");
        Loja loja2 = new Loja("Loja 2");

        Loja[] lojas = {loja1, loja2};

        Cliente[] clientes = {
                new Cliente("Cliente 1", lojas),
                new Cliente("Cliente 2", lojas),
                new Cliente("Cliente 3", lojas),
                new Cliente("Cliente 4", lojas),
                new Cliente("Cliente 5", lojas)
        };

        Funcionario[] funcionariosLoja1 = {
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 1"),
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 2")
        };

        Funcionario[] funcionariosLoja2 = {
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 3"),
                new Funcionario(new Conta(1400.00), new Conta(), "Funcionário 4")
        };

        for (Cliente cliente : clientes) {
            cliente.start();
        }
        for (Funcionario funcionario : funcionariosLoja1) {
            funcionario.start();
        }

        for (Funcionario funcionario : funcionariosLoja2) {
            funcionario.start();
        }

        try {
            for (Cliente cliente : clientes) {
                cliente.join();
            }

            for (Funcionario funcionario : funcionariosLoja1) {
                funcionario.join();
            }

            for (Funcionario funcionario : funcionariosLoja2) {
                funcionario.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Cliente cliente : clientes) {
            cliente.getConta().debitar(cliente.getConta().getSaldo());
        }

        Banco.exibirSaldosFinais(new Loja[]{loja1, loja2}, new Funcionario[][]{funcionariosLoja1, funcionariosLoja2}, clientes);
    }
}
