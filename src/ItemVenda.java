import java.util.Date;

public abstract class ItemVenda {
    protected String nome;
    protected double precoVenda;
    protected Date dataValidade;
    protected double peso;

    public ItemVenda(String nome, double precoVenda, Date dataValidade, double peso) {
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    // Método que as filhas (Pizza, Salgado) vão implementar
    public abstract double getPreco();

    public String getNome() {
        return nome;
    }
}