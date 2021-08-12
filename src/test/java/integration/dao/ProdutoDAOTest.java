package integration.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import restaurante.dao.ProdutoDAO;
import restaurante.model.produto.*;
import restaurante.validation.ProdutoNaoEncontradoException;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoDAOTest {

    @Mock
    ProdutoDAO produtoDAOMock;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this); //Ler anotações do mockito
    }

    @Test
    @DisplayName("Deveria adicionar um produto no banco")
    void adicionarProdutosBanco() throws Exception {

        boolean resultadoAddProduto = true; // Setado com true para provar que abaixo ele recebe o resultado que manipulei pelo mockito
        assertTrue(resultadoAddProduto);

        Produto produto = new Cerveja(1, 10, "Skol");

        resultadoAddProduto = produtoDAOMock.addProdutos(produto);
        assertFalse(resultadoAddProduto);

    }

    @Test
    @DisplayName("Não deveria adicionar um produto no banco, retornando SQLexception")
    void naoAdicionarProdutosBanco() throws Exception {

        Produto produto = new Cerveja(1, 10, "Skol");

        //Manipular para receber uma SQLexception
        Mockito.when(produtoDAOMock.addProdutos(Mockito.any())).thenThrow(SQLException.class);

        try {
            produtoDAOMock.addProdutos(produto);
        }catch (SQLException e){}

    }

    @Test
    @DisplayName("Deveria deletar um produto do banco")
    void deletarProdutoDoBanco() throws Exception {

        boolean resultadoDelProduto = true; // Setado com true para provar que abaixo ele recebe o resultado que manipulei pelo mockito
        assertTrue(resultadoDelProduto);

        resultadoDelProduto = produtoDAOMock.deletProduto(1);
        assertFalse(resultadoDelProduto);
    }

    @Test
    @DisplayName("Não deveria deletar um produto do banco, retornando SQLexception")
    void naoDeletarProdutoDoBanco() throws Exception {

        //Manipular para receber uma SQLexception
        Mockito.when(produtoDAOMock.deletProduto(1)).thenThrow(SQLException.class);

        try {
            produtoDAOMock.deletProduto(1);
        }catch (SQLException e){}

    }

    @Test
    @DisplayName("Deveria buscar um produto por código")
    void buscarProdutoPorCodigo() throws Exception {

        Produto produto = new Cerveja(1, 10, "Skol");

        Mockito.when(produtoDAOMock.buscarProdutoPorCodigo(1)).thenReturn(produto);

        Produto produtoBuscado = null;
        assertNull(produtoBuscado); // Setado com nulo para provar que abaixo ele recebe o objeto que manipulei pelo mockito

        produtoBuscado = produtoDAOMock.buscarProdutoPorCodigo(1);

        assertEquals(1, produtoBuscado.getCodigoProduto());
        assertEquals("Skol", produtoBuscado.getNomeProduto());
        assertEquals(10, produtoBuscado.getValorUnitario());
    }

    @Test
    @DisplayName("Não deveria retornar um produto por código, retornando SQLexception")
    void naoBuscarProdutoPorCodigo() throws Exception {

        Produto produto = new Cerveja(1, 10, "Skol");

        //Manipular para receber uma SQLexception
        Mockito.when(produtoDAOMock.buscarProdutoPorCodigo(1)).thenThrow(SQLException.class);

        try {
            produtoDAOMock.buscarProdutoPorCodigo(1);
        }catch (SQLException e){}

    }

    @Test
    @DisplayName("Deveria alterar um produto do banco")
    void alterarProdutoDoBanco() throws Exception {

        boolean resultadoAlterarProduto = true; // Setado com true para provar que abaixo ele recebe o resultado que manipulei pelo mockito
        assertTrue(resultadoAlterarProduto);

        resultadoAlterarProduto = produtoDAOMock.alteraValorDoProduto(1, 45);
        assertFalse(resultadoAlterarProduto);
    }

    @Test
    @DisplayName("Não deveria alterar um produto do banco, retornando SQLexception")
    void naoAlterarProdutoDoBanco() throws Exception {

        //Manipular para receber uma SQLexception
        Mockito.when(produtoDAOMock.alteraValorDoProduto(1, 45)).thenThrow(SQLException.class);

        try {
            produtoDAOMock.alteraValorDoProduto(1, 45);
        }catch (SQLException e){}

    }

    @Test
    @DisplayName("Deveria buscar lista de produtos no banco")
    void buscarProdutosBanco() throws Exception {

        Mockito.when(produtoDAOMock.listProdutosDisponiveis()).thenReturn(criarListaProdutos());

        ArrayList<Produto> arrayProdutos = null;
        assertNull(arrayProdutos); // Setado com nulo para provar que abaixo ele recebe os objetos do array que manipulei pelo mockito

        arrayProdutos = produtoDAOMock.listProdutosDisponiveis();

        assertFalse(arrayProdutos.isEmpty());
        assertEquals("Kibom", arrayProdutos.get(0).getNomeProduto());
        assertEquals("De dois", arrayProdutos.get(1).getNomeProduto());

    }

    @Test
    @DisplayName("Não deveria retornar lista de produtos do banco, retornando SQLexception")
    void naoBuscarProdutosBanco() throws Exception {

        //Manipular para receber uma SQLexception
        Mockito.when(produtoDAOMock.listProdutosDisponiveis()).thenThrow(SQLException.class);

        try {
            produtoDAOMock.listProdutosDisponiveis();
        }catch (SQLException e){}

    }

    private ArrayList<Produto> criarListaProdutos(){
        ArrayList<Produto> arrayProdutos = new ArrayList<>();

        arrayProdutos.add(new Sorvete(1, 5, "Kibom"));
        arrayProdutos.add(new Baiao(2, 20, "De dois"));
        arrayProdutos.add(new Cerveja(3, 10, "Skol"));

        return arrayProdutos;
    }

}
