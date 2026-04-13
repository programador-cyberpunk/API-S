
public interface Pagamento {
    void realizarPagamento(double valorTotal);
}

class PagamentoDinheiro implements Pagamento {
    private double valorRecebido;

    public PagamentoDinheiro(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    @Override
    public void realizarPagamento(double valorTotal) {
        if (this.valorRecebido >= valorTotal) {
            double troco = this.valorRecebido - valorTotal;
            System.out.println("Pagamento em grana realizado");
            System.out.printf("Troco: R$ %.2f\n", troco);
        } else {
            System.out.println("Erro: Dinheiro insuficiente para pagar a conta,seu fudido.");
        }
    }
}