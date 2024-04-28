class Loja {
    private String nome;
    private Conta conta;

    public Loja(String nome) {
        this.nome = nome;
        this.conta = new Conta();
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }
}
