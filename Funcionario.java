class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;
    private String nome;
    private double salarioTotal;

    public Funcionario(Conta contaSalario, Conta contaInvestimento, String nome) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.nome = nome;
        this.salarioTotal = 1400.00;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (contaSalario) {
                if (contaSalario.getSaldo() >= salarioTotal) {
                    double valorInvestimento = salarioTotal * 0.20;
                    Banco.transferir(contaSalario, contaInvestimento, valorInvestimento);
                    double saldoRestanteSalario = contaSalario.getSaldo();
                    double saldoRestante = salarioTotal - valorInvestimento;
                    System.out.println("Saldo final da conta de salário do funcionário " + nome + ": R$" + saldoRestante);
                }
            }
            if (contaSalario.getSaldo() < salarioTotal) break;
        }
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public String getNome() {
        return nome;
    }
}
