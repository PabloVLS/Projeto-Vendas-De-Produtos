package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Historico;
import model.Produto;
import view.HistoricoView;

public class HistoricoDao {

    private Connection connection;

    public HistoricoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    /* public void cadastrarHistorico(int idProduto, int quantidadeVendida) throws SQLException {
        String sql = "INSERT INTO historico_vendas (id_produto, quantidade_vendida, data_venda) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, idProduto);
        statement.setInt(2, quantidadeVendida);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataVenda = dateFormat.format(new Date());
        statement.setString(3, dataVenda);

        statement.executeUpdate();
        System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
        statement.close();
    }*/
    public void cadastrarHistorico(int idProduto, String nomeProduto , int quantidadeVendida, int idCliente  ) throws SQLException {
        try {
            String sql = "INSERT INTO historico_de_vendas (id_produto, nomeProduto, quantidade_vendida, id_cliente, data_venda) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, idProduto);
            statement.setString(2, nomeProduto);
            statement.setInt(3, quantidadeVendida);
            statement.setInt(4, idCliente);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /*public List<Historico> atualizarHistorico() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt1 = null;
        ResultSet rs = null;

        List<Historico> historico = new ArrayList<>();

        try {
            stmt1 = connection.prepareStatement("SELECT * FROM historico_de_vendas");
            rs = stmt1.executeQuery();

            while (rs.next()) {
                Historico historicoItem = new Historico();

                historicoItem.setId(rs.getInt("id"));
                historicoItem.setId_produto(rs.getInt("id_produto"));
                historicoItem.setQuantidade_vendida(rs.getInt("quantidade_vendida"));
                historicoItem.setData_venda(rs.getTimestamp("data_venda"));

                historico.add(historicoItem);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ViewVendasDao possui um erro !!!");
        }
        return historico;
    }*/
    public List<Historico> atualizarHistorico() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt1 = null;
        ResultSet rs = null;

        List<Historico> historico = new ArrayList<>();

        try {
            stmt1 = connection.prepareStatement("SELECT * FROM historico_de_vendas");
            rs = stmt1.executeQuery();

            while (rs.next()) {
                Historico historicoItem = new Historico();

                historicoItem.setId(rs.getInt("id"));
                historicoItem.setId_produto(rs.getInt("id_produto"));
                
                //Pegando o nome do produto
                int idProduto = rs.getInt("id_produto");
                String nomeProduto = obterNomeProdutoPorId(idProduto);
                historicoItem.setNomeProduto(nomeProduto);
                
                historicoItem.setQuantidade_vendida(rs.getInt("quantidade_vendida"));
                historicoItem.setData_venda(rs.getTimestamp("data_venda"));

                

                // Aqui pega o idCliente da tabela historico_de_vendas
                int idCliente = rs.getInt("id_cliente");

                // E aqui pega o nome do amigao com base no idCliente dele da tabela Cliente
                String nomeCliente = obterNomeClientePorId(idCliente);
                historicoItem.setNomeCliente(nomeCliente);

                historico.add(historicoItem);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ViewVendasDao possui um erro !!!");
        }
        return historico;
    }

    public String obterNomeClientePorId(int idCliente) {
        // realize uma consulta ao banco de dados para obter o nome do cliente com base no idCliente
        // cria a consulta SQL e obtenha o resultado da consulta
        String nomeCliente = ""; // Aqui armazena o nome

        try {
            connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT nome FROM cliente WHERE idCliente = ?");
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomeCliente = rs.getString("nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções, como SQLException, adequadamente
        }
        // Retorna o nome do cliente
        return nomeCliente;
    }

    public String obterNomeProdutoPorId(int idProduto) {
        String nomeProduto = null;
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT nomeProduto FROM produto WHERE idProduto = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nomeProduto = rs.getString("nomeProduto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomeProduto;
    }

    public static void main(String[] args) throws SQLException {

    }
}
