import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveNotificarUmCliente() {
        Produto ps5 = new Produto("PlayStation 5", 4500.00);

        Cliente cliente = new Cliente("Jorge");
        cliente.registrarInteresse(ps5);
        ps5.setEmEstoque(true);

        assertEquals("Olá Jorge, o produto Produto{nome='PlayStation 5', preco=4500.0} está de volta ao estoque!", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        // 1. Cria o Subject
        Produto ps5 = new Produto("PlayStation 5", 4500.00);

        // 2. Cria os Observers
        Cliente cliente1 = new Cliente("Jorge");
        Cliente cliente2 = new Cliente("Marcela");

        cliente1.registrarInteresse(ps5);
        cliente2.registrarInteresse(ps5);

        ps5.setEmEstoque(true);

        assertEquals("Olá Jorge, o produto Produto{nome='PlayStation 5', preco=4500.0} está de volta ao estoque!", cliente1.getUltimaNotificacao());
        assertEquals("Olá Marcela, o produto Produto{nome='PlayStation 5', preco=4500.0} está de volta ao estoque!", cliente2.getUltimaNotificacao());
    }
    @Test
    void naoDeveNotificarClienteNaoRegistrado() {
        Produto ps5 = new Produto("PlayStation 5", 4500.00);

        Cliente cliente = new Cliente("Jorge");
        ps5.setEmEstoque(true);
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteProdutoA() {
        Produto ps5 = new Produto("PlayStation 5", 4500.00);
        Produto xbox = new Produto("Xbox Series X", 4000.00);

        Cliente cliente1 = new Cliente("Jorge (interessado no PS5)");
        Cliente cliente2 = new Cliente("Marcela (interessado no Xbox)");

        cliente1.registrarInteresse(ps5);
        cliente2.registrarInteresse(xbox);

        ps5.setEmEstoque(true);

        assertEquals("Olá Jorge (interessado no PS5), o produto Produto{nome='PlayStation 5', preco=4500.0} está de volta ao estoque!", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }
    @Test
    void naoDeveNotificarClienteAoSairDeEstoque() {
        Produto ps5 = new Produto("PlayStation 5", 4500.00);
        Cliente cliente = new Cliente("Jorge");
        cliente.registrarInteresse(ps5);

        ps5.setEmEstoque(true);
        String primeiraNotificacao = cliente.getUltimaNotificacao();
        assertNotNull(primeiraNotificacao);

        ps5.setEmEstoque(false);
        assertEquals(primeiraNotificacao, cliente.getUltimaNotificacao());
    }
}