import java.util.Observable;

public class Produto extends Observable {
    private String nome;
    private double preco;
    private boolean emEstoque;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.emEstoque = false;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean novoStatus) {
        if (!this.emEstoque && novoStatus) {
            this.emEstoque = novoStatus;

            System.out.println("AVISO SISTEMA: " + this.nome + " está em estoque. Notificando clientes...");

            setChanged();
            notifyObservers();
        } else {
            this.emEstoque = novoStatus;
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
