import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.model.Produto;
import restaurante.repository.BDProduto;
import restaurante.validation.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteApplicationTest {

    @Test
    @DisplayName("Verificar se lista de produtos está sendo povoada")
    public void descobrir_se_lista_produtos_esta_sendo_povoado() throws ProdutoNaoEncontradoException {
        BDProduto bdProduto = new BDProduto();
        bdProduto.povoarArrayProdutos();

        Produto produto = bdProduto.procurarProduto(1);

        assertEquals(1, produto.getCodigoProduto());
    }

}
