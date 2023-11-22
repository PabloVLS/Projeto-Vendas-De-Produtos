package view;

import dao.HistoricoDao;
import dao.ProdutoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Produto;
import model.Vendas;
import dao.VendasDao;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

public class VendasView extends javax.swing.JFrame {

    private HistoricoView historicoView;
    private boolean chaveCompra = false;
    double totalCompra = 0.0;
    double valorTotal = 0.0;

    public VendasView(HistoricoView historicoView) {
        this.historicoView = historicoView;
        initComponents();
        leiaJtableProduto();
    }

    

    public String getTxfDadosProdutoIdCodigoText() {
        return txfDadosProdutoIdCodigo.getText();
    }

    public String getTxfDadosProdutoQuantidadeText() {
        return txfDadosProdutoQuantidade.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBPesquisarCliente = new javax.swing.JButton();
        txfCpf = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txfDadosProdutoIdCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfDadosProdutoNomeProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txfDadosProdutoPreco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txfDadosProdutoQuantidade = new javax.swing.JTextField();
        jbAdicionarCarrinho = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaProdutosVendendo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txfTotalCalculoItensAdicionados = new javax.swing.JTextField();
        jbComprar = new javax.swing.JButton();
        jbCancelarVenda = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vendas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel2.setText("Nome:");

        jLabel3.setText("Cpf:");

        jBPesquisarCliente.setBackground(new java.awt.Color(51, 51, 51));
        jBPesquisarCliente.setForeground(new java.awt.Color(204, 204, 204));
        jBPesquisarCliente.setText("🔎 Pesquisar");
        jBPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarClienteActionPerformed(evt);
            }
        });

        txfCpf.setBackground(new java.awt.Color(255, 255, 255));
        txfCpf.setForeground(new java.awt.Color(51, 51, 51));
        try {
            txfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txfCpf)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jBPesquisarCliente)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBPesquisarCliente)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel4.setText("Código:");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Pesquisar");

        jLabel5.setText("Produto:");

        txfDadosProdutoNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDadosProdutoNomeProdutoActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço:");

        jLabel7.setText("Quantidade:");

        jbAdicionarCarrinho.setBackground(new java.awt.Color(51, 51, 51));
        jbAdicionarCarrinho.setForeground(new java.awt.Color(204, 204, 204));
        jbAdicionarCarrinho.setText("Adicionar Item");
        jbAdicionarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txfDadosProdutoIdCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfDadosProdutoQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                            .addComponent(txfDadosProdutoNomeProduto))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txfDadosProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAdicionarCarrinho)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfDadosProdutoIdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txfDadosProdutoNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfDadosProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txfDadosProdutoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jbAdicionarCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jScrollPane2.setBackground(new java.awt.Color(255, 0, 0));
        jScrollPane2.setForeground(new java.awt.Color(51, 51, 51));

        jtProduto.setBackground(new java.awt.Color(204, 204, 204));
        jtProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtProduto.setForeground(new java.awt.Color(51, 51, 51));
        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Produto", "Nome Produto", "Categoria", "Preço", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProduto.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jtProduto.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtProduto);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jtTabelaProdutosVendendo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Preço", "Quantidade"
            }
        ));
        jtTabelaProdutosVendendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaProdutosVendendoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabelaProdutosVendendo);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setText("TOTAL DE VENDAS:");

        txfTotalCalculoItensAdicionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTotalCalculoItensAdicionadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfTotalCalculoItensAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfTotalCalculoItensAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jbComprar.setBackground(new java.awt.Color(51, 51, 51));
        jbComprar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbComprar.setForeground(new java.awt.Color(204, 204, 204));
        jbComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/icons8-carrinho-de-compras-60.png"))); // NOI18N
        jbComprar.setText("Adicionar no Carrinho");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jbCancelarVenda.setBackground(new java.awt.Color(51, 51, 51));
        jbCancelarVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbCancelarVenda.setForeground(new java.awt.Color(204, 204, 204));
        jbCancelarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/icons8-cancelar-48.png"))); // NOI18N
        jbCancelarVenda.setText("Cancelar Venda");
        jbCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarVendaActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Dados do Cliente");

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Dados do Produto");

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Tabela de Compras");

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Total das Vendas ");

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("🤵 Cadastrar Clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(204, 204, 204));
        jButton4.setText(" 📑 Cadastrar Produtos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setForeground(new java.awt.Color(204, 204, 204));
        jButton5.setText("📈  Historico Vendas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/icons8-dinheiro-48.png"))); // NOI18N
        jButton3.setText("Finalizar Compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jbComprar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                                .addComponent(jbCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(239, 239, 239))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void leiaJtableProduto() {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao dao1 = new ProdutoDao();

        for (Produto produto : dao1.leitura1()) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getEstoque()
            });
        }
    }


    private void jtProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseClicked

        if (jtProduto.getSelectedRow() != -1) {
            txfDadosProdutoIdCodigo.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txfDadosProdutoNomeProduto.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            txfDadosProdutoPreco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());

        }
        
       
    }//GEN-LAST:event_jtProdutoMouseClicked

    private void jbAdicionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarCarrinhoActionPerformed
        /* int quantidadeUsuario = Integer.parseInt((String) txfDadosProdutoQuantidade.getText());
        int linhaSelecionada = jtProduto.getSelectedRow();

        if (chaveCompra == true) {
            if (txfDadosProdutoQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite a quantidade!");
            } else {
                if (jtProduto.getSelectedRow() != -1) {
                    int quantidadeNoEstoque = (int) jtProduto.getValueAt(linhaSelecionada, 4);

                    if (quantidadeNoEstoque < quantidadeUsuario) {
                        JOptionPane.showMessageDialog(null, "Não temos essa quantidade disponível!");
                    } else {
                        int idProduto = (int) jtProduto.getValueAt(linhaSelecionada, 0);
                        double precoReferenteQuantidade = (double) jtProduto.getValueAt(linhaSelecionada, 3);
                        double totalVendasAdicionadas = quantidadeUsuario * precoReferenteQuantidade;

                        String codigoProdutoVendendo = txfDadosProdutoIdCodigo.getText();
                        String nomeProdutoVendendo = txfDadosProdutoNomeProduto.getText();
                        String precoProdutoVendendo = txfDadosProdutoPreco.getText();
                        String quantidadeProdutoVendendo = txfDadosProdutoQuantidade.getText();

                        VendasDao vDao = new VendasDao();

                        // Obtenha o CPF do cliente da interface, você já fez isso
                        String cpfCliente = txfCpf.getText();
                        // Use o método para obter o idCliente com base no CPF
                        int idCliente = -1; // Valor padrão para indicar que o cliente não foi encontrado
                        idCliente = vDao.obterIdClientePorCpf(cpfCliente);

                        if (idCliente != -1) {
                            HistoricoDao historicoDao = new HistoricoDao();
                           

                            DefaultTableModel jtModelo = (DefaultTableModel) jtTabelaProdutosVendendo.getModel();
                            Object[] tabelaProdutosVendendo = {codigoProdutoVendendo, nomeProdutoVendendo, precoProdutoVendendo, quantidadeProdutoVendendo};
                            jtModelo.addRow(tabelaProdutosVendendo);

                            for (int i = 0; i < jtModelo.getRowCount(); i++) {
                                int quantidade = Integer.parseInt(jtModelo.getValueAt(i, 3).toString()); // Pega a quantidade na coluna 3
                                double preco = Double.parseDouble(jtModelo.getValueAt(i, 2).toString()); // Pega o preço na coluna 2

                                double subtotal = quantidade * preco; // Calcula o subtotal para esse item
                                totalCompra += subtotal; // Adiciona o subtotal ao total da compra
                                txfTotalCalculoItensAdicionados.setText("R$" + totalCompra);
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cpf não deferido!");
        }*/

        int quantidadeUsuario = Integer.parseInt((String) txfDadosProdutoQuantidade.getText());
        int linhaSelecionada = jtProduto.getSelectedRow();

        if (chaveCompra) {
            if (txfDadosProdutoQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite a quantidade!");
            } else {
                if (jtProduto.getSelectedRow() != -1) {
                    int quantidadeNoEstoque = (int) jtProduto.getValueAt(linhaSelecionada, 4);

                    if (quantidadeNoEstoque < quantidadeUsuario) {
                        JOptionPane.showMessageDialog(null, "Não temos essa quantidade disponível!");
                    } else {
                        int idProduto = (int) jtProduto.getValueAt(linhaSelecionada, 0);
                        double precoReferenteQuantidade = (double) jtProduto.getValueAt(linhaSelecionada, 3);
                        double subtotal = quantidadeUsuario * precoReferenteQuantidade;

                        String codigoProdutoVendendo = txfDadosProdutoIdCodigo.getText();
                        String nomeProdutoVendendo = txfDadosProdutoNomeProduto.getText();
                        String precoProdutoVendendo = txfDadosProdutoPreco.getText();
                        String quantidadeProdutoVendendo = txfDadosProdutoQuantidade.getText();

                        DefaultTableModel jtModelo = (DefaultTableModel) jtTabelaProdutosVendendo.getModel();
                        Object[] tabelaProdutosVendendo = {codigoProdutoVendendo, nomeProdutoVendendo, precoProdutoVendendo, quantidadeProdutoVendendo};
                        jtModelo.addRow(tabelaProdutosVendendo);

                        totalCompra += subtotal; // Adiciona o subtotal ao total da compra
                        txfTotalCalculoItensAdicionados.setText("R$" + totalCompra);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cpf não deferido!");
        }


    }//GEN-LAST:event_jbAdicionarCarrinhoActionPerformed

    // Essa parte abaixo esta em teste , tive uma ideia mais ainda e incabivel
    
   /* private void jbFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // Aqui você registra a venda no histórico de vendas, pois o cliente está finalizando a compra.
        HistoricoDao historicoDao = new HistoricoDao();
        VendasDao vDao = new VendasDao();
        for (int i = 0; i < jtTabelaProdutosVendendo.getRowCount(); i++) {
            int idProduto = Integer.parseInt(jtTabelaProdutosVendendo.getValueAt(i, 0).toString());
            int quantidadeComprada = Integer.parseInt(jtTabelaProdutosVendendo.getValueAt(i, 3).toString());
            // Obtenha o idCliente com base no CPF do cliente
            int idCliente = vDao.obterIdClientePorCpf(txfCpf.getText());
            historicoDao.cadastrarHistorico(idProduto, nomeProduto, quantidadeComprada, idCliente);
        }
        historicoView.atualizarTabelaHistorico();
        txfTotalCalculoItensAdicionados.setText("R$0.0"); // Reinicialize o total após a compra.
        jtTabelaProdutosVendendo.setModel(new DefaultTableModel()); // Limpe o carrinho de compras.
    }*/


    private void jbCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarVendaActionPerformed
        txfDadosProdutoIdCodigo.setText("");
        txfDadosProdutoNomeProduto.setText("");
        txfDadosProdutoPreco.setText("");
        txfDadosProdutoQuantidade.setText("");
        txfTotalCalculoItensAdicionados.setText("");
        JOptionPane.showMessageDialog(null, "Venda Cancelada !");

        VendasDao vendasDao = new VendasDao();
        DefaultTableModel produtosCancelados = (DefaultTableModel) jtTabelaProdutosVendendo.getModel();
        produtosCancelados.setRowCount(0);
    }//GEN-LAST:event_jbCancelarVendaActionPerformed

    private int idClienteVenda = -1;

    private void jBPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarClienteActionPerformed
        String cpfCliente = txfCpf.getText();
        String nomeCliente = txfNome.getText();
        if (!cpfCliente.isEmpty()) {
            VendasDao vDao = new VendasDao();
            int idCliente = vDao.obterIdClientePorCpf(cpfCliente); // Método para obter o ID do cliente pelo CPF
            int idClientePorNome = vDao.obterIdClientePorNome(nomeCliente);
            if (idCliente > 0 && idCliente == idClientePorNome) {
                // Cliente encontrado, você pode usar o idCliente na venda
                chaveCompra = true;
                idClienteVenda = idCliente; // Armazena o ID do cliente para uso posterior
                JOptionPane.showMessageDialog(null, "Cliente Encontrado no sistema !");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente com CPF ou nome não encontrado ou não correspondem..");
                chaveCompra = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, digite um CPF e um nome válidos.");
            chaveCompra = false;
        }
    }//GEN-LAST:event_jBPesquisarClienteActionPerformed

    private void txfDadosProdutoNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDadosProdutoNomeProdutoActionPerformed

    }//GEN-LAST:event_txfDadosProdutoNomeProdutoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ClienteView cView = new ClienteView();

        cView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ProdutosView produtosView = new ProdutosView();
        produtosView.setVisible(true);
        this.dispose();    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
        String idProdutoTexto = txfDadosProdutoIdCodigo.getText();
        String quantidadeCompradaTexto = txfDadosProdutoQuantidade.getText();
        String dadosProdutoIdCodigo = txfDadosProdutoIdCodigo.getText();

        try {
            int idProduto = Integer.parseInt(idProdutoTexto);
            int produto = Integer.parseInt(dadosProdutoIdCodigo);
            int quantidadeComprada = Integer.parseInt(quantidadeCompradaTexto);
            String nomeCliente = txfNome.getText();

            VendasDao vDao = new VendasDao();
            int idCliente = vDao.obterIdClientePorNome(nomeCliente);

            HistoricoDao hDao = new HistoricoDao();
            String nomeProduto = hDao.obterNomeProdutoPorId(produto);

            if (idCliente > 0) {
                if (!quantidadeCompradaTexto.isEmpty()) {
                    HistoricoDao historico = new HistoricoDao();
                    historico.cadastrarHistorico(idProduto, nomeProduto, quantidadeComprada, idCliente);
                    historicoView.atualizarTabelaHistorico();
                    txfDadosProdutoIdCodigo.setText("");
                    txfDadosProdutoQuantidade.setText("");
                    vDao.vendido(idProduto, quantidadeComprada);

                } else {
                    JOptionPane.showMessageDialog(this, "Digite a quantidade !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para o ID do produto e a quantidade.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar a venda no banco de dados.");
        }
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        HistoricoView hView = new HistoricoView();
        hView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        PagamentosView pagView = new PagamentosView();
        pagView.setVisible(true);
        String totalidade = obterValorTotal();
        
        pagView.valorPagar(totalidade);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txfTotalCalculoItensAdicionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTotalCalculoItensAdicionadosActionPerformed
  
    }//GEN-LAST:event_txfTotalCalculoItensAdicionadosActionPerformed

    private void jtTabelaProdutosVendendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaProdutosVendendoMouseClicked
         if (jtTabelaProdutosVendendo.getSelectedRow() != -1) {
            txfDadosProdutoIdCodigo.setText(jtTabelaProdutosVendendo.getValueAt(jtTabelaProdutosVendendo.getSelectedRow(), 0).toString());
            txfDadosProdutoNomeProduto.setText(jtTabelaProdutosVendendo.getValueAt(jtTabelaProdutosVendendo.getSelectedRow(), 1).toString());
            txfDadosProdutoQuantidade.setText(jtTabelaProdutosVendendo.getValueAt(jtTabelaProdutosVendendo.getSelectedRow(), 3).toString());

        }
    }//GEN-LAST:event_jtTabelaProdutosVendendoMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoricoView historicoView = new HistoricoView(); // Crie uma instância de HistoricoView
                VendasView vendasView = new VendasView(historicoView); // Passe a instância de HistoricoView como argumento
                vendasView.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBPesquisarCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAdicionarCarrinho;
    private javax.swing.JButton jbCancelarVenda;
    private javax.swing.JButton jbComprar;
    private javax.swing.JTable jtProduto;
    private javax.swing.JTable jtTabelaProdutosVendendo;
    private javax.swing.JFormattedTextField txfCpf;
    private javax.swing.JTextField txfDadosProdutoIdCodigo;
    private javax.swing.JTextField txfDadosProdutoNomeProduto;
    private javax.swing.JTextField txfDadosProdutoPreco;
    private javax.swing.JTextField txfDadosProdutoQuantidade;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfTotalCalculoItensAdicionados;
    // End of variables declaration//GEN-END:variables

    Object getTxfDadosProdutoIdCodigo() {
        return txfDadosProdutoIdCodigo.getText();
    }

    Object getTxfDadosProdutoQuantidade() {
        return txfDadosProdutoQuantidade.getText();
    }

    public JTextField getTxfTotalCalculoItensAdicionados() {
        return txfTotalCalculoItensAdicionados;
    }

    public void setTxfTotalCalculoItensAdicionados(JTextField txfTotalCalculoItensAdicionados) {
        this.txfTotalCalculoItensAdicionados = txfTotalCalculoItensAdicionados;
    }
    public String obterValorTotal() {
        String totalidade = txfTotalCalculoItensAdicionados.getText();
        System.out.println("totalidade:"+totalidade);
        return totalidade;
    }
    
    
    
}
