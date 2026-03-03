
class Salgado extends ItemVenda {
    String massa, recheio, assado;

    public Salgado(String nome, double preco, String validade, double peso) {
        super(nome, preco, dataValidade, peso);
    }

    @Override
    public double getPreco() { return this.precoVenda; }
}

class Pizza extends ItemVenda {
    String molho, recheio, borda;

    public Pizza(String nome, double preco, Date dataValidade, double peso) {
        super(nome, preco, dataValidade, peso);
    }

    @Override
    public double getPreco() { return this.precoVenda; }
}

class Lanche extends ItemVenda {
    String pao, recheio, molho;

    public Lanche(String nome, double preco, String validade, double peso) {
        super(nome, preco, validade, peso);
    }

    @Override
    public double getPreco() { return this.precoVenda; }
}