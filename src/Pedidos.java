import java.util.ArrayList;

public class Pedidos {
    String nomeCliente;
    double taxaServico = 0.10; // 10% de taxa

    ArrayList<ItemVenda> itensConsumidos = new ArrayList<>();
    public Pedidos(String nome) {
        this.nomeCliente = nome;
    }

    public double calculaTotal() {
        double totalItens = 0;

        for (ItemVenda item : itensConsumidos) {
            totalItens += item.getPreco(); // Chama o getPreco polimórfico
        }

        return totalItens + (totalItens * taxaServico);
    }

    public void gerarNotaFiscal() {
        System.out.println("### NOTA FISCAL - LANCHONETE ###");
        System.out.println("Cliente: " + this.nomeCliente);
        System.out.println("-------------------------------");

        for (ItemVenda item : itensConsumidos) {
            System.out.println(item.getNome() + " - R$ " + item.getPreco());
        }

        System.out.println("-------------------------------");
        System.out.printf("TOTAL (com taxas): R$ %.2f\n", calculaTotal());
    }
}
