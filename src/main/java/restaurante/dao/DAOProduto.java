package restaurante.dao;

import restaurante.jdbcConnection.ConnectionJdbc;
import restaurante.model.*;
import restaurante.validation.ProdutoNaoEncontradoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProduto {

    private static ArrayList<Produto> array = new ArrayList<Produto>();
    private Connection connectionJdbc;

    public DAOProduto() {
        super();
    }

    public void povoarArrayProdutos() throws Exception {
        addProdutos(new Cerveja(1,5, "Skol"));
        addProdutos(new Baiao(2,10, "De Dois"));
        addProdutos(new Linguica(3,15, "Calabresa"));
        addProdutos(new Sorvete(4,20, "Kibom de Morango"));
    }

//    public void adicionarProduto(Produto produto) {
//        array.add(produto);
//    }

    public boolean addProdutos(Produto produto) throws Exception {
        String sql = "INSERT INTO produto(codigo_produto, valor_unitario, tipo_produto, nome_produto) VALUES (?, ?, ?, ?)";
        this.connectionJdbc =  new ConnectionJdbc().getConexao();

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connectionJdbc.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, produto.getCodigoProduto());
            stmt.setDouble(2, produto.getValorUnitario());
            stmt.setString(3, produto.getTipoProduto());
            stmt.setString(4, produto.getNomeProduto());

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();

            if (qtdRowsAffected > 0) return true;

            return false;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                this.connectionJdbc.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }

//    public void deletarProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
//        for(Produto produto : array) {
//            if(produto.getCodigoProduto() == codigoProduto) {
//                array.remove(produto);
//                System.out.println("\nProduto deletado!!!\n");
//                return;
//            }
//        }
//        throw new ProdutoNaoEncontradoException(codigoProduto);
//    }

    public boolean deletProduto(int codigoProduto) throws Exception, ProdutoNaoEncontradoException {
        String sql = "DELETE FROM produto WHERE codigo_produto = ? ";

        this.connectionJdbc = new ConnectionJdbc().getConexao();

        try {
            PreparedStatement stmt = connectionJdbc.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigoProduto);

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();

            if (qtdRowsAffected > 0) return true;

            return false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }finally {
            try {
                this.connectionJdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


//    public Produto procurarProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
//        for(Produto produto : array) {
//            if(produto.getCodigoProduto() == codigoProduto) {
//                return produto;
//            }
//        }
//        throw new ProdutoNaoEncontradoException(codigoProduto);
//    }

    public Produto procurarProdutoPorCodigo(int codigoProduto) throws Exception {
        String sql = "SELECT * FROM produto where codigo_produto = ?;";

        this.connectionJdbc = new ConnectionJdbc().getConexao();

        Produto produto = null;

        try {
            PreparedStatement stmt = connectionJdbc.prepareStatement(sql);
            stmt.setInt(1, codigoProduto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //int dia = String.parseInt(rs.getString("dia"));

                if(codigoProduto == rs.getInt("codigo_produto" )) {

                    int codigoProdutoo = rs.getInt("codigo_produto");
                    double valor_unitario = rs.getDouble("valor_unitario");
                    String tipo_produto = rs.getString("tipo_produto");
                    String nome_produto = rs.getString("nome_produto");

                    if (tipo_produto.equals("Baião")) {
                        produto = new Baiao(codigoProdutoo, valor_unitario, nome_produto);
                    } else if (tipo_produto.equals("Cerveja")) {
                        produto = new Cerveja(codigoProdutoo, valor_unitario, nome_produto);
                    } else if (tipo_produto.equals("Linguiça")) {
                        produto = new Linguica(codigoProdutoo, valor_unitario, nome_produto);
                    } else if (tipo_produto.equals("Sorvete")) {
                        produto = new Sorvete(codigoProdutoo, valor_unitario, nome_produto);
                    }

                    break;
                }
            }
            stmt.close();

            System.out.println(produto.toString());
            return produto;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                this.connectionJdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produto ;
    }

//    public void alterarDadosProduto(int codigoProduto, double valorProduto) throws ProdutoNaoEncontradoException {
//        for(Produto produto : array) {
//            if(produto.getCodigoProduto() == codigoProduto) {
//                produto.setValorUnitario(valorProduto);
//                return;
//            }
//        }
//        throw new ProdutoNaoEncontradoException(codigoProduto);
//    }

    public boolean alteraValorDoProduto(int codigoProduto, double valorProduto) throws Exception {
        String sql = "update produto set valor_unitario = ?" + "where codigo_produto = ?";
        this.connectionJdbc = new ConnectionJdbc().getConexao();

        //Produto produto = procurarProdutoPorCodigo(codigoProduto);

        try{
            PreparedStatement stmt = connectionJdbc.prepareStatement(sql);

            stmt.setDouble(1, valorProduto);
            stmt.setInt(2, codigoProduto);

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();

            if (qtdRowsAffected > 0)
                return true;

            return false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }finally {
            try {
                this.connectionJdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

//    public String listarProdutosDisponiveis(){
//        System.out.println("-----PRODUTOS DISPONIVEIS----- ");
//        for(Produto produto : array) {
//            System.out.println(produto.toString());
//        }
//        return null;
//    }

    public ArrayList<Produto> listProdutosDisponiveis() throws Exception {
        String sql = "SELECT * FROM produto ORDER BY codigo_produto ASC";
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        this.connectionJdbc = new ConnectionJdbc().getConexao();

        try {
            PreparedStatement stmt = connectionJdbc.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //int dia = String.parseInt(rs.getString("dia"));
                int codigoProduto = rs.getInt("codigo_produto");
                double valor_unitario = rs.getDouble("valor_unitario");
                String tipo_produto = rs.getString("tipo_produto");
                String nome_produto = rs.getString("nome_produto");

                Produto produto = null;

                if(tipo_produto.equals("Baião")){
                    produto = new Baiao(codigoProduto, valor_unitario, nome_produto);
                }else if(tipo_produto.equals("Cerveja")){
                    produto = new Cerveja(codigoProduto, valor_unitario, nome_produto);
                }else if(tipo_produto.equals("Linguiça")){
                    produto = new Linguica(codigoProduto, valor_unitario, nome_produto);
                }else if(tipo_produto.equals("Sorvete")){
                    produto = new Sorvete(codigoProduto, valor_unitario, nome_produto);
                }


                listaProdutos.add(produto);
            }
            stmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                this.connectionJdbc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        printarProdutos(listaProdutos);
        return listaProdutos;
    }

    private void printarProdutos(ArrayList<Produto> listaProdutos){
        System.out.println("-----PRODUTOS DISPONIVEIS----- ");
        for(Produto produto : listaProdutos) {
            System.out.println(produto.toString());
        }
    }

    public int getTamanhoArray(){
        return array.size();
    }

}
