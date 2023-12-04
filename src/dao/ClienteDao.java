package dao;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import model.Cliente;
import java.sql.Connection;
import factory.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDao {

    private Connection connection;

    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insert(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome,cpf,email,telefone) VALUES(?,?,?,?)";

        try ( Connection connection = new ConnectionFactory().getConnection();  PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.execute();
        } catch (SQLException e) {
            // Tratar a exceção ,imprimindo no console ou registrando em um sistema de log
            e.printStackTrace();
        }
    }

    public List<Cliente> leitura() {
        List<Cliente> clientes = new ArrayList<>();

        try ( Connection connection = new ConnectionFactory().getConnection();  PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cliente");  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "View possui um erro !!!!");
            e.printStackTrace();
        }
        return clientes;
    }

    public void delete(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try ( Connection connection = new ConnectionFactory().getConnection();  PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getIdCliente());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o Cliente !");
            e.printStackTrace();
        }
    }

    public void editar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE idCliente = ?";

        try ( Connection connection = new ConnectionFactory().getConnection();  PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(5, cliente.getIdCliente());

            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Cliente !!! !");
            e.printStackTrace();
        }
    }
}
