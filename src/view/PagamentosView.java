package view;

import dao.LoggerUtil;
import dao.HistoricoDao;
import dao.VendasDao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import view.VendasView;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Historico;

public class PagamentosView extends javax.swing.JFrame {

    private HistoricoView historicoView;
    private VendasView vView;
    private String valor;

    private static VendasView obterInstanciaVendasView() {
        return new VendasView();
    }

    private static HistoricoView obterInstanciaHistoricoView() {
        return new HistoricoView();
    }

    public PagamentosView(VendasView vendasView, HistoricoView historicoView) {
        initComponents();
        this.vView = vendasView;
        this.historicoView = historicoView;
    }

    PagamentosView() {
        initComponents();
        this.vView = obterInstanciaVendasView();
        this.historicoView = obterInstanciaHistoricoView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlValorTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jbPagamentoCredito = new javax.swing.JButton();
        jbPagamentoDebito = new javax.swing.JButton();
        jbAbrirPagamentoVale = new javax.swing.JButton();
        jBConcluirPagamento = new javax.swing.JButton();
        jBAbrirPagamentoPix = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlValorTotal.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jlValorTotal.setForeground(new java.awt.Color(51, 51, 51));
        jlValorTotal.setText("00,00");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Total a Pagar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(193, 193, 193))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/Dinheiro.png"))); // NOI18N
        jButton1.setText("   Dinheiro                                                                                                           ");

        jbPagamentoCredito.setBackground(new java.awt.Color(204, 204, 204));
        jbPagamentoCredito.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbPagamentoCredito.setForeground(new java.awt.Color(51, 51, 51));
        jbPagamentoCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/icons8-frente-do-cartão-de-crédito-50.png"))); // NOI18N
        jbPagamentoCredito.setText("    Cartão de Crédito                                                                                           ");
        jbPagamentoCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagamentoCreditoActionPerformed(evt);
            }
        });

        jbPagamentoDebito.setBackground(new java.awt.Color(204, 204, 204));
        jbPagamentoDebito.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbPagamentoDebito.setForeground(new java.awt.Color(51, 51, 51));
        jbPagamentoDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/CartaoZinhoVermei.png"))); // NOI18N
        jbPagamentoDebito.setText("    Cartão de Debito                                                                                            ");
        jbPagamentoDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagamentoDebitoActionPerformed(evt);
            }
        });

        jbAbrirPagamentoVale.setBackground(new java.awt.Color(204, 204, 204));
        jbAbrirPagamentoVale.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbAbrirPagamentoVale.setForeground(new java.awt.Color(51, 51, 51));
        jbAbrirPagamentoVale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/1034362_payment_bank_card_credit_finance_icon.png"))); // NOI18N
        jbAbrirPagamentoVale.setText("    Vale Alimentação                                                                                          ");

        jBConcluirPagamento.setBackground(new java.awt.Color(0, 102, 204));
        jBConcluirPagamento.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBConcluirPagamento.setForeground(new java.awt.Color(204, 204, 204));
        jBConcluirPagamento.setText("Concluir");
        jBConcluirPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConcluirPagamentoActionPerformed(evt);
            }
        });

        jBAbrirPagamentoPix.setBackground(new java.awt.Color(204, 204, 204));
        jBAbrirPagamentoPix.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBAbrirPagamentoPix.setForeground(new java.awt.Color(51, 51, 51));
        jBAbrirPagamentoPix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/Pix.png"))); // NOI18N
        jBAbrirPagamentoPix.setText("   Pix                                                                                                                    ");
        jBAbrirPagamentoPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirPagamentoPixActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Formas de Pagamento:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/OperadorCartao (1).png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/OperadorCartao (2).png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/OperadorCartao (3).png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/OperadorCartao (4).png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImg/OperadorCartao5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbPagamentoCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbPagamentoDebito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAbrirPagamentoVale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAbrirPagamentoPix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBConcluirPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel7)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel8)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel9)
                                .addGap(145, 145, 145))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPagamentoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbPagamentoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAbrirPagamentoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBAbrirPagamentoPix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jBConcluirPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPagamentoCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagamentoCreditoActionPerformed
        PagCred pagCredito = new PagCred();
        pagCredito.setVisible(true);
    }//GEN-LAST:event_jbPagamentoCreditoActionPerformed

    private void jBConcluirPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConcluirPagamentoActionPerformed
        try {
            String nomeCliente = vView.getTxfNome();
            VendasDao vDao = new VendasDao();
            HistoricoDao hDao = new HistoricoDao();
            int idCliente = vDao.obterIdClientePorNome(nomeCliente);

            if (idCliente > 0) {
                javax.swing.JTable tabelaProdutosVendendo = vView.getTabelaProdutosVendendo();

                for (int i = 0; i < tabelaProdutosVendendo.getRowCount(); i++) {
                    String idProdutoTexto = tabelaProdutosVendendo.getValueAt(i, 0).toString();
                    String nomeProduto = tabelaProdutosVendendo.getValueAt(i, 1).toString();
                    String quantidadeCompradaTexto = tabelaProdutosVendendo.getValueAt(i, 3).toString();

                    int idProduto = Integer.parseInt(idProdutoTexto);
                    int quantidadeComprada = Integer.parseInt(quantidadeCompradaTexto);

                    int ultimoIdHistorico = hDao.cadastrarHistorico(idProduto, nomeProduto, quantidadeComprada, idCliente);

                    if (ultimoIdHistorico > 0) {
                        LoggerUtil.registrarLog("Venda concluída - Produto: " + nomeProduto + ", Quantidade: " + quantidadeComprada);
                        // Operações adicionais após o cadastro do histórico
                        vDao.vendido(idProduto, quantidadeComprada);
                    } else {
                        System.out.println("Falha ao obter o último ID de histórico para o produto: " + nomeProduto);
                    }
                }
                String valores = jlValorTotal.getText();
                LoggerUtil.registrarLog(" Valor da Venda : " + valores);
                // Obter o histórico e atualizar a tabela
                historicoView.atualizarTabelaHistorico(hDao.atualizarHistorico());
                JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
                // Limpar campos TXF Vendas
                vView.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para a quantidade.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar a venda no banco de dados.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBConcluirPagamentoActionPerformed

    private void jBAbrirPagamentoPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirPagamentoPixActionPerformed
        PagPix pgPix = new PagPix(this);
        pgPix.setVisible(true);
        String totalidade = pegarValor();
        pgPix.valorPagarPagPix(totalidade);
    }//GEN-LAST:event_jBAbrirPagamentoPixActionPerformed

    private void jbPagamentoDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagamentoDebitoActionPerformed
        PagCred pagCredito = new PagCred();
        pagCredito.setVisible(true);
    }//GEN-LAST:event_jbPagamentoDebitoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VendasView vendasView = obterInstanciaVendasView();
                HistoricoView historicoView = obterInstanciaHistoricoView();
                PagamentosView pagamentosView = new PagamentosView(vendasView, historicoView);
                pagamentosView.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAbrirPagamentoPix;
    private javax.swing.JButton jBConcluirPagamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbAbrirPagamentoVale;
    private javax.swing.JButton jbPagamentoCredito;
    private javax.swing.JButton jbPagamentoDebito;
    private javax.swing.JLabel jlValorTotal;
    // End of variables declaration//GEN-END:variables

    void valorPagar(String totalidade) {
        try {
            String valorSemSimbolo = totalidade.replaceAll("[^\\d.]", "");
            System.out.println("Valor Total: " + valorSemSimbolo);

            double valorNumerico = Double.parseDouble(valorSemSimbolo);

            // Formata o número para exibir "R$" e apenas duas casas decimais
            DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");
            String valorFormatado = decimalFormat.format(valorNumerico);

            System.out.println("Valor Total: " + valorFormatado);

            // Define o valor formatado no componente jlValorTotal
            jlValorTotal.setText(valorFormatado);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public String pegarValor() {
        String totalidade = jlValorTotal.getText();
        return totalidade;
    }

    public void setValor(String valor) {
        this.valor = jlValorTotal.getText();
    }
}
