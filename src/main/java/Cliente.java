import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    /**
     * Método para se inscrever e "observar" o produto.
     * Corresponde ao 'matricular(Turma turma)' do 'Aluno'.
     */
    public void registrarInteresse(Produto produto) {
        produto.addObserver(this);
    }

    @Override
    public void update(Observable produtoObservado, Object arg) {
        this.ultimaNotificacao = "Olá " + this.nome + ", o produto " + produtoObservado.toString() + " está de volta ao estoque!";
    }
}
