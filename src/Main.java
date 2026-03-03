public class Main {
    public static void main(String[] args) {

        Pizza p1 = new Pizza("Calabresa", 45.0, "10/2026", 0.8);
        Salgado s1 = new Salgado("Coxinha", 8.0, "05/2026", 0.2);
        Lanche l1 = new Lanche("X-Salada", 25.0, "04/2026", 0.4);

        Pedidos meuPedido = new Pedidos("Niggito");

        meuPedido.itensConsumidos.add(p1);
        meuPedido.itensConsumidos.add(s1);
        meuPedido.itensConsumidos.add(l1);
        meuPedido.gerarNotaFiscal();
        double totalComTaxa = meuPedido.calculaTotal();
        double valorPago = 100.0;

        System.out.println("Valor entregue pelo cliente: R$ " + valorPago);
        Pagamento formaPagamento = new PagamentoDinheiro(valorPago);
        formaPagamento.realizarPagamento(totalComTaxa);
    }
}