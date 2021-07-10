package unitTests.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.model.Produto;
import restaurante.model.Sorvete;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {

    private Produto sorveteTest;

    @BeforeEach
    public void init(){
        this.sorveteTest = new Sorvete(1, 2.5);
    }

    @Test
    @DisplayName("Verifica se o produto criado retorna os valores corretamente")
    public void verificar_se_dados_do_produto_criado_retorna_corretamente(){

        assertEquals(1, sorveteTest.getCodigoProduto());
        assertEquals(2.5, sorveteTest.getValorUnitario(), 0.1);

    }

    @Test
    @DisplayName("Verifica se as informações do produto criado são retornados corretamente")
    public void descobrir_se_informacoes_do_produto_sao_retornados_corretamente(){

        assertEquals("\nCodigo do Produto = 1" +
                "\nValor Unitario = 2.5", sorveteTest.toString());
    }

}
