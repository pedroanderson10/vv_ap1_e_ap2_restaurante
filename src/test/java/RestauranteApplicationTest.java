import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.dao.DAOProduto;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteApplicationTest {

    @Test
    @DisplayName("Verificar se lista de produtos está sendo povoada com os 4 produtos pré-selecionados")
    public void descobrir_se_lista_produtos_esta_sendo_povoado() throws Exception {
        DAOProduto DAOProduto = new DAOProduto();
        DAOProduto.povoarArrayProdutos();

        assertEquals(4, DAOProduto.getTamanhoArray());
    }

}
