package view;

import controller.dao.ProdutoDao;
import model.Produto;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Produto produto = new Produto(2,"feijao",5);
        Produto produto1 = new Produto(1,"Arroz",3);
        ProdutoDao produtoDao = new ProdutoDao();

        produtoDao.salvar(produto);
        produtoDao.salvar(produto1);






    }
}
