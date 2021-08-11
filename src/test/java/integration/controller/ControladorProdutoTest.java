package integration.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import restaurante.controller.ControladorProduto;
import restaurante.dao.ProdutoDAO;
import restaurante.model.produto.Baiao;
import restaurante.model.produto.Cerveja;
import restaurante.model.produto.Produto;
import restaurante.model.produto.Sorvete;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControladorProdutoTest {

    @Mock
    ProdutoDAO produtoDAOMock;

    private ControladorProduto controladorProduto;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this); //Ler anotações do mockito
        this.controladorProduto = new ControladorProduto(produtoDAOMock);
    }

    @Test
    @DisplayName("Deveria adicionar um produto no banco (Sendo chamado pelo controlador)")
    void adicionarProdutosBanco() throws Exception {

        Produto produto = new Cerveja(1, 10, "Skol");

        Mockito.when(produtoDAOMock.addProdutos(produto)).thenReturn(false);

        boolean resultadoAddProduto = true; // Setado com true para provar que abaixo ele recebe o resultado que manipulei pelo mockito
        assertTrue(resultadoAddProduto);

        resultadoAddProduto = controladorProduto.adicionarProduto(produto);
        assertFalse(resultadoAddProduto);

    }

    @Test
    @DisplayName("Deveria deletar um produto do banco (Sendo chamado pelo controlador)")
    void deletarProdutoDoBanco() throws Exception {

        Mockito.when(produtoDAOMock.deletProduto(1)).thenReturn(false);

        boolean resultadoDelProduto = true; // Setado com true para provar que abaixo ele recebe o resultado que manipulei pelo mockito
        assertTrue(resultadoDelProduto);

        resultadoDelProduto = controladorProduto.deletarProduto(1);
        assertFalse(resultadoDelProduto);
    }

    @Test
    @DisplayName("Deveria buscar um produto por código (Sendo chamado pelo controlador)")
    void buscarProdutoPorCodigo() throws Exception {

        ArrayList<Produto> listaProdutos = criarListaProdutos();
        Produto produto = listaProdutos.get(0); // Código desse produto é 1

        Mockito.when(produtoDAOMock.buscarProdutoPorCodigo(produto.getCodigoProduto())).thenReturn(produto);

        Produto produtoBuscado = null;
        assertNull(produtoBuscado); // Setado com nulo para provar que abaixo ele recebe o objeto que manipulei pelo mockito

        produtoBuscado = controladorProduto.buscarProdutoPorCodigo(1);
        assertEquals(1, produtoBuscado.getCodigoProduto());
        assertEquals("Kibom", produtoBuscado.getNomeProduto());
        assertEquals(5, produtoBuscado.getValorUnitario());
    }

    @Test
    @DisplayName("Deveria alterar um produto do banco (Sendo chamado pelo controlador)")
    void alterarProdutoDoBanco() throws Exception {

        Mockito.when(produtoDAOMock.alteraValorDoProduto(1, 20)).thenReturn(false);

        boolean resultadoAlterarProduto = true; // Setado com true para provar que abaixo ele recebe o resultado que manipulei pelo mockito
        assertTrue(resultadoAlterarProduto);

        resultadoAlterarProduto = controladorProduto.alterarDadosProduto(1, 20);
        assertFalse(resultadoAlterarProduto);
    }

    @Test
    @DisplayName("Deveria buscar lista de produtos no banco (Sendo chamado pelo controlador)")
    void buscarProdutosBanco() throws Exception {

        Mockito.when(produtoDAOMock.listProdutosDisponiveis()).thenReturn(criarListaProdutos());

        ArrayList<Produto> arrayProdutos = null;
        assertNull(arrayProdutos); // Setado com nulo para provar que abaixo ele recebe os objetos do array que manipulei pelo mockito

        arrayProdutos = controladorProduto.listarProdutos();
        assertFalse(arrayProdutos.isEmpty());
        assertEquals("Kibom", arrayProdutos.get(0).getNomeProduto());
        assertEquals("De dois", arrayProdutos.get(1).getNomeProduto());

    }

    private ArrayList<Produto> criarListaProdutos(){
        ArrayList<Produto> arrayProdutos = new ArrayList<>();

        arrayProdutos.add(new Sorvete(1, 5, "Kibom"));
        arrayProdutos.add(new Baiao(2, 20, "De dois"));
        arrayProdutos.add(new Cerveja(3, 10, "Skol"));

        return arrayProdutos;
    }

}
