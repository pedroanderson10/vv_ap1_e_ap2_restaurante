package restaurante.jdbcConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {

    private Connection conexao;
    //url e composta por: jdbc:postgresql://<host>:<port>/<database>
    private String URL_CONEXAO = "jdbc:postgresql://ec2-3-226-59-11.compute-1.amazonaws.com:5432/d4b9j3st6iv684";
    private String USUARIO = "pocrkejjzbithz";
    private String SENHA = "52255740bbd5f427fad24a7e9e907c435146a727c3ae3235fd1a01b7b1018bd7";

    public Connection getConexao() throws Exception {
        if (conexao == null){
            try{
                System.out.println("Conexao realizada com sucesso!!");
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (ClassNotFoundException | SQLException ex){
                throw new Exception("Conexao invalida " + ex.getMessage());
            }
        }
        return conexao;
    }


}
