package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;

public class VendasDao {

    private Connection connection;

    private int idCliente;
    private String nome;
    private String cpf;
    private int idProduto;
    private String nomeProduto;
    private String descricao;
    private double valor;
    private int estoque;

    public VendasDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Produto> leitura1() {
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt1 = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt1 = connection.prepareStatement("SELECT * FROM produto");
            rs = stmt1.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setDescricao(rs.getNString("descricao"));
                produto.setValor(rs.getDouble("valor"));
                produto.setEstoque(rs.getInt("estoque"));
                produtos.add(produto);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ViewVendasDao possui um erro !!!!");
        }
        return produtos;
    }

    public class ProdutoHistorico {

        private int idProduto;
        private String nomeProduto;
        private String descricao;
        private double valor;
        private int estoque;
        private int quantidadeVendida;

        public int getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }

        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }

        public int getQuantidadeVendida() {
            return quantidadeVendida;
        }

        public void setQuantidadeVendida(int quantidadeVendida) {
            this.quantidadeVendida = quantidadeVendida;
        }

    }

    public int obterIdClientePorCpf(String cpfCliente) {
        Connection connection = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        int idCliente = -1; // Valor que indica que o cliente não foi encontrado

        try {
            connection = new ConnectionFactory().getConnection();
            // Use uma consulta SQL para buscar o ID do cliente com base no CPF
            String sql = "SELECT idCliente FROM cliente WHERE cpf = ?";
            stmt1 = connection.prepareStatement(sql);
            stmt1.setString(1, cpfCliente);
            ResultSet resultSet = stmt1.executeQuery();

            if (resultSet.next()) {
                idCliente = resultSet.getInt("idCliente"); // ID do cliente encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar os recurso de conexão
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt1 != null) {
                try {
                    stmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return idCliente;
    }

    public int obterIdClientePorNome(String nomeCliente) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int idCliente = -1; // Valor padrão para indicar que o cliente não foi encontrado

        try {
            connection = new ConnectionFactory().getConnection();
            String sql = "SELECT idCliente FROM cliente WHERE nome = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeCliente);

            rs = stmt.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("idCliente"); // ID do cliente encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Feche os recursos (stmt, rs e conexão) aqui
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return idCliente;
    }

    private boolean clienteExisteNoBancoDeDados(String nomeCliente) {
        // Lógica de consulta ao banco de dados para verificar se o cliente com o nome fornecido existe.
        // Se o cliente existir, retorne true; caso contrário, retorne false.
        // Aqui você deve usar uma consulta SQL para verificar a existência do cliente no banco de dados.
        // Se você estiver usando um sistema de banco de dados, pode usar PreparedStatement e ResultSet para fazer a consulta.

        // Exemplo de lógica fictícia para verificar a existência do cliente:
        connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id FROM clientes WHERE nome = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeCliente);
            rs = stmt.executeQuery();
            return rs.next(); // Retorna true se o cliente existe no banco de dados.

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }

    

    public List<ProdutoHistorico> vendido(int idProduto, int quantidadeComprada) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ProdutoHistorico> produtosHistorico = new ArrayList<>();

        try {
            connection = new ConnectionFactory().getConnection();

            // Procura o produto no banco de dados
            String consultaProduto = "SELECT * FROM produto WHERE idProduto = ?";
            stmt = connection.prepareStatement(consultaProduto);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                return produtosHistorico;
            }

            int estoqueAtual = rs.getInt("estoque");

            // Atualiza o estoque depois da venda
            int novoEstoque = estoqueAtual - quantidadeComprada;
            String atualizaEstoque = "UPDATE produto SET estoque = ? WHERE idProduto = ?";
            stmt = connection.prepareStatement(atualizaEstoque);
            stmt.setInt(1, novoEstoque);
            stmt.setInt(2, idProduto);
            int linhasAtualizadas = stmt.executeUpdate();

            if (linhasAtualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
                
                /* ERA UMA TEORIA DE REALIZAR O HISTORICO DE VENDAS AQUI , MAS NAO DEU
                
                // Registrando a venda na tabela historico_de_vendas
                String insereHistorico = "INSERT INTO historico_de_vendas (id_produto, quantidade_vendida) VALUES (?, ?)";
                stmt = connection.prepareStatement(insereHistorico);
                stmt.setInt(1, idProduto);
                stmt.setInt(2, quantidadeComprada);
                stmt.executeUpdate();

                // Criando a venda
                ProdutoHistorico produtoHistorico = new ProdutoHistorico();
                produtoHistorico.setIdProduto(idProduto);
                produtoHistorico.setQuantidadeVendida(quantidadeComprada);
                produtoHistorico.setEstoque(novoEstoque);
                System.out.println("Atualizou a tabela de vendas , o quantidade foi atualziada");
                produtosHistorico.add(produtoHistorico);
                */
            } else {
                JOptionPane.showMessageDialog(null, "Falha na atualização da quantidade.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + ex.getMessage());
            }
        }
        return produtosHistorico;
    }

    
    public List<String> leituraCliente(String cpf) {
        Connection connection = null;
        PreparedStatement stm3 = null;
        ResultSet rs = null;

        List<String> clientesEncontrados = new ArrayList<>();

        try {
            connection = new ConnectionFactory().getConnection();
            stm3 = connection.prepareStatement("SELECT cpf FROM cliente WHERE cpf = ?");
            stm3.setString(1, cpf);
            rs = stm3.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuario encontrado no sistema !");

                clientesEncontrados.add(rs.getString("cpf"));
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não encontrado no sistema !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "View possui um erro !!!!");
        }
        return clientesEncontrados;
    }

}
