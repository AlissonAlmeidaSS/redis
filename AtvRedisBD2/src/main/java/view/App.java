package view;

import com.google.gson.Gson;
import controller.banco.JedisFactory;
import controller.dao.ProdutoDao;
import model.Produto;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       ProdutoDao produtoDao = new ProdutoDao();
       Gson gson = new Gson();
       Jedis jedis = new Jedis("localhost", 6379);

        List<Produto> produtos = Arrays.asList(
            new Produto(2,"feijao",5),
            new Produto (1,"Arroz",3));

        produtoDao.salvar((Produto) produtos);

        System.out.println(jedis.set(String.valueOf(((Produto) produtos).getCodigo()), gson.toJson(produtos),
                SetParams.setParams().ex(7200).nx()));





    }
}
