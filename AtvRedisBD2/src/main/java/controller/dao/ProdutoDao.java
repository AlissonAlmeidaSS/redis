package controller.dao;

import com.google.gson.Gson;
import controller.banco.JedisFactory;
import controller.banco.PostgresFactory;
import model.Produto;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao {
    private PostgresFactory postgresFactory;
    private Jedis jedis;
    private Gson gson;

    public ProdutoDao(){

        postgresFactory = new PostgresFactory();
        JedisFactory jedisFactory = new JedisFactory();
        jedis = jedisFactory.getJedis();
        gson = new Gson();
    }

    public boolean salvar(Produto produto) throws SQLException, ClassNotFoundException {
        try(Connection con = PostgresFactory.getConnection()){
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO produto(codigo,descricao, preco) VALUES (?,?,?)");

            stmt.setString(1,produto.getDescricao());
            stmt.setFloat(2, produto.getPreco());

            return stmt.executeUpdate()>0;
        }
    }
}
