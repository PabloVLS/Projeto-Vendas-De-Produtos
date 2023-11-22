
package dao;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import factory.ConnectionFactory;
import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;



public class ProdutoDao {
    
    private Connection connection;
    
    private int    idProduto;
    private String nomeProduto;
    private String descricao;
    private double valor;
    private int estoque;
    
    
    public ProdutoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarProduto(Produto produto){
        String sql = ("INSERT INTO produto (nomeProduto,descricao,valor,estoque) VALUES(?,?,?,?)");
        
        try {
            PreparedStatement stml1 = connection.prepareStatement(sql);
            stml1.setString(1,produto.getNomeProduto());
            stml1.setString(2,produto.getDescricao());
            stml1.setDouble(3,produto.getValor());
            stml1.setInt(4, produto.getEstoque());
            stml1.execute();
            stml1.close();
                    
        } catch (Exception e) {
            
        }  
    }
    
    public List<Produto> leitura1 (){
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt1 = connection.prepareStatement("SELECT * FROM produto");
            rs = stmt1.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setDescricao(rs.getNString("descricao"));
                produto.setValor(rs.getDouble("valor"));
                produto.setEstoque(rs.getInt("estoque"));
                produtos.add(produto);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ViewProduto possui um erro !!!!");
        }
        return produtos;
    }

     public void delete1(Produto produto) {
        String sql = "DELETE FROM produto WHERE idProduto = ?";
        try {
            PreparedStatement stmt1 = connection.prepareStatement(sql);
            stmt1.setInt(1, produto.getIdProduto());
            stmt1.execute();
            stmt1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o Produto !");
        }

    }

    public void editar1(Produto produto) {
        String sql1 = "UPDATE produto SET nomeProduto = ? , descricao = ? , valor = ? , estoque = ?  WHERE idProduto = ?";
        
        try {
            PreparedStatement stmt1 = connection.prepareStatement(sql1);
            stmt1.setString(1, produto.getNomeProduto());
            stmt1.setString(2, produto.getDescricao());
            stmt1.setDouble(3, produto.getValor());
            stmt1.setInt(4, produto.getEstoque());
            stmt1.setInt(5, produto.getIdProduto());

            stmt1.execute();
            stmt1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Produto !!!!");
        }
    }
    
    
}
