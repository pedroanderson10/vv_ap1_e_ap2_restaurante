package unitTests.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.model.produto.Produto;
import restaurante.repository.BDProduto;
import restaurante.validation.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BDProdutoTest {

    private static BDProduto bdProduto;
    private static Produto produto;

    @BeforeAll
    public static void init() throws Exception {
        bdProduto = new BDProduto();
        bdProduto.povoarArrayProdutos();
    }

    @Test
    @DisplayName("Verificar se uma lista de produtos está sendo povoada apenas com os produtos pré-selecionados")
    public void descobrir_se_lista_produtos_esta_sendo_povoado() throws ProdutoNaoEncontradoException {

        assertEquals(1, bdProduto.procurarProduto(1).getCodigoProduto());
        assertEquals(2, bdProduto.procurarProduto(2).getCodigoProduto());
        assertEquals(3, bdProduto.procurarProduto(3).getCodigoProduto());
        assertEquals(4, bdProduto.procurarProduto(4).getCodigoProduto());
    }

    @Test
    @DisplayName("Verificar se um código de produto não está contido no banco povoado")
    public void descobrir_se_produto_nao_esta_contido_no_banco() throws ProdutoNaoEncontradoException {

        assertThrows(ProdutoNaoEncontradoException.class, () -> bdProduto.procurarProduto(5));

    }

    @Test
    @DisplayName("Verificar se um produto foi deletado do banco")
    public void descobrir_se_produto_foi_deletado() throws ProdutoNaoEncontradoException {

        bdProduto.listarProdutosDisponiveis();
        bdProduto.deletarProduto(1);
        assertThrows(ProdutoNaoEncontradoException.class, () -> bdProduto.procurarProduto(1));
        bdProduto.listarProdutosDisponiveis();

    }

    @Test
    @DisplayName("Procurar um produto específico no banco")
    public void descobrir_se_produto_esta_no_banco() throws ProdutoNaoEncontradoException {

        produto = bdProduto.procurarProduto(3);
        assertEquals(3, produto.getCodigoProduto());

    }

    @Test
    @DisplayName("Verificar se um produto foi alterado corretamente")
    public void descobrir_se_produto_foi_alterado() throws ProdutoNaoEncontradoException {

        bdProduto.alterarDadosProduto(3, 200);
        produto = bdProduto.procurarProduto(3);

        assertEquals(200, produto.getValorUnitario());

    }

}
