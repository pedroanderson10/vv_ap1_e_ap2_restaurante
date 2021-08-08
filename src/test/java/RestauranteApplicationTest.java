import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.repository.BDProduto;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteApplicationTest {

    @Test
    @DisplayName("Verificar se lista de produtos está sendo povoada com os 4 produtos pré-selecionados")
    public void descobrir_se_lista_produtos_esta_sendo_povoado() throws Exception {
        BDProduto BDProduto = new BDProduto();
        BDProduto.povoarArrayProdutos();

        assertEquals(4, BDProduto.getTamanhoArray());
    }

}
