import java.util.ArrayList;
import java.util.List;

public class Exercicio {

    static class Produto {
        String nome;
        double preco;
        String categoria;

        public Produto(String nome, double preco, String categoria) {
            this.nome = nome;
            this.preco = preco;
            this.categoria = categoria;
        }
    }

    public List<String> findFeaturedProductNames(List<Produto> listaProdutos) {
        List<String> nomesSelecionados = new ArrayList<>();

        for (Produto p : listaProdutos) {
            if (p.categoria.equals("Eletronicos")) { //equals pra facilitar a minha vida
                nomesSelecionados.add(p.nome);
            } else {

                System.out.println("Produto " + p.nome + " ignorado (Categoria: " + p.categoria + ")");
            }
        }

        return nomesSelecionados;
    }
}