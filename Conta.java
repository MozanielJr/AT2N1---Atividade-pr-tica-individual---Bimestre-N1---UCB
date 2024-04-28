class Conta {
    private double saldo;

    public Conta() {
        this.saldo = 0.0;
    }

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void creditar(double valor) {
        saldo += valor;
    }

    public synchronized void debitar(double valor) {
        saldo -= valor;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}
