import java.util.ArrayList;
import java.util.Random;

class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private Loja[] lojas;
    private Random random;

    public Cliente(String nome, Loja[] lojas) {
        this.nome = nome;
        this.conta = new Conta(1000);
        this.lojas = lojas;
        this.random = new Random();
    }

    @Override
    public void run() {
     ArrayList<Double> valoresCompras = new ArrayList<>();
     valoresCompras.add(100.00);
     valoresCompras.add(200.00);
     boolean comprou = false;
      while (true) {
     double valorCompra = valoresCompras.get(random.nextInt(valoresCompras.size())); 
     if (conta.getSaldo() >= valorCompra) {
       comprou = true;
      for (Loja loja : lojas) {
            synchronized (loja.getConta()) {
         if (conta.getSaldo() >= valorCompra) {
          Banco.transferir(conta, loja.getConta(), valorCompra);
                System.out.println(nome + " Efetuou uma compra de R$" + valorCompra + " na loja " + loja.getNome());
                        }
                    }
                }
            } else {
                break; 
            }
        }
        conta.debitar(conta.getSaldo());
        System.out.println(nome + " Finalizou suas compras. Saldo final: R$" + conta.getSaldo());
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }
}
