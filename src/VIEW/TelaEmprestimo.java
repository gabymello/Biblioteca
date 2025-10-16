/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.ConexaoDAO;
import DAO.EmprestimoDAO;
import static VIEW.TelaLivro.txtAno;
import static VIEW.TelaLivro.txtAutor;
import static VIEW.TelaLivro.txtGenero;
import static VIEW.TelaLivro.txtIDlivro;
import static VIEW.TelaLivro.txtQuantidade;
import static VIEW.TelaLivro.txtTitulo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;

/**
 *
 * @author usuario
 */
public class TelaEmprestimo extends javax.swing.JFrame {
      Connection conexao = null;
      PreparedStatement pst = null;
      ResultSet rs = null;
    //public JTextField txtIdLivro;

    /**
     * Creates new form TelaEmprestimo
     */
    public TelaEmprestimo() {
        initComponents();
        pesquisaAuto();
        setLocationRelativeTo(null);
        
        
        conexao = ConexaoDAO.conector();
        //EmprestimoDAO ojbEmprestimoDAO = new EmprestimoDAO();
        
    }
        
    

  public void pesquisaAuto() {
    // Consulta SQL com JOIN para trazer o nome do cliente e o nome do livro
    String sql = "SELECT e.id_emprestimo, e.id_usuario, e.id_livro, "
               + "c.nome AS nome_cliente, l.titulo AS nome_livro, "
               + "e.data_emprestimo, e.data_devolucao, e.status "
               + "FROM emprestimos e "
               + "INNER JOIN livros l ON e.id_livro = l.id_livro "
               + "INNER JOIN clientes c ON e.id_usuario = c.id_cliente"; // Join para pegar o nome do cliente e livro

    conexao = ConexaoDAO.conector();

    try {
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[] {
                "ID do Empréstimo", "Nome do Cliente","ID do Livro", "Nome do Livro", 
                "Data do Empréstimo", "Data de Devolução", "Status"
            }
        );
        tbEmprestimos.setModel(model);

        while (rs.next()) {
            int idEmprestimo = rs.getInt("id_emprestimo");
            String nomeCliente = rs.getString("nome_cliente");  // Nome do cliente
            int idLivro = rs.getInt("id_livro");
            String nomeLivro = rs.getString("nome_livro");  // Nome do livro vindo do JOIN

            Date dataEmprestimo = rs.getDate("data_emprestimo");
            Date dataDevolucao = rs.getDate("data_devolucao");
            String status = rs.getString("status");

            // Adiciona a linha na tabela
            model.addRow(new Object[]{
                idEmprestimo,
                nomeCliente,  // Exibe o nome do cliente no lugar do id_usuario
                idLivro,
                nomeLivro,    // Exibe o nome do livro, que já vem da consulta
                dataEmprestimo,
                dataDevolucao,
                status
            });
        }

        conexao.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro no método pesquisaAuto: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdLivro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmprestimo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDevolucao = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEmprestimos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel1.setText("Tela Emprestimo");

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel3.setText("ID Livro");

        jLabel4.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel4.setText("Cliente");

        jLabel5.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel5.setText("Data Emprestimo");

        jLabel6.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel6.setText("Data Devolução");

        jLabel7.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel7.setText("Status Emprestimo");

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        tbEmprestimos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        tbEmprestimos.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        tbEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_Livro", "Cliente", "Data Emprestimo", "Nome Livro", "Data Devolução", "Status Emprestimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbEmprestimos);
        if (tbEmprestimos.getColumnModel().getColumnCount() > 0) {
            tbEmprestimos.getColumnModel().getColumn(0).setResizable(false);
            tbEmprestimos.getColumnModel().getColumn(1).setResizable(false);
            tbEmprestimos.getColumnModel().getColumn(2).setResizable(false);
            tbEmprestimos.getColumnModel().getColumn(3).setResizable(false);
            tbEmprestimos.getColumnModel().getColumn(4).setResizable(false);
            tbEmprestimos.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/divida.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 435, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(109, 109, 109)
                        .addComponent(btnPesquisar)
                        .addGap(98, 98, 98)
                        .addComponent(btnVoltar)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel6)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnVoltar))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    
    
    
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
                                         


try {
    int idLivro = 0;
    if (!txtIdLivro.getText().trim().isEmpty()) {
        try {
            idLivro = Integer.parseInt(txtIdLivro.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do Livro inválido! Digite apenas números.");
            txtIdLivro.requestFocus();
            return;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Preencha o campo ID do Livro");
        return;
    }

    int idUsuario = 0;
    if (txtCliente.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha o campo Cliente (ID do Usuário)");
        return;
    } else {
        try {
            idUsuario = Integer.parseInt(txtCliente.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do Cliente inválido! Digite apenas números.");
            txtCliente.requestFocus();
            return;
        }
    }

    // Data de Empréstimo
    String dataEmprestimo = txtEmprestimo.getText().trim();
    if (dataEmprestimo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha o campo Data de Empréstimo");
        return;
    }

    String dataDevolucao = txtDevolucao.getText().trim();
    if (dataDevolucao.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha o campo Data de Devolução");
        return;
    }

    // Tentar converter as datas usando SimpleDateFormat
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date utilDataEmprestimo = null;
    java.util.Date utilDataDevolucao = null;
    
    try {
        utilDataEmprestimo = sdf.parse(dataEmprestimo);  // Converter data do Empréstimo
        utilDataDevolucao = sdf.parse(dataDevolucao);    // Converter data de Devolução
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato dd/MM/yyyy.");
        return;
    }

    // Convertendo para java.sql.Date para inserção no banco
    java.sql.Date sqlDataEmprestimo = new java.sql.Date(utilDataEmprestimo.getTime());
    java.sql.Date sqlDataDevolucao = new java.sql.Date(utilDataDevolucao.getTime());

    String status = txtStatus.getText().trim();
    if (status.isEmpty()) {
        status = "Emprestado"; // Definindo valor default
    }

    // Tentando estabelecer a conexão com o banco de dados
    Connection conn = null;
    PreparedStatement pst = null;

    try {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bibliotecaProjeto", "root", "gaby2008");

        // SQL para inserir o empréstimo
        String sql = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, data_devolucao, status) VALUES (?, ?, ?, ?, ?)";
        pst = conn.prepareStatement(sql);

        pst.setInt(1, idUsuario);
        pst.setInt(2, idLivro);
        pst.setDate(3, sqlDataEmprestimo);
        pst.setDate(4, sqlDataDevolucao);
        pst.setString(5, status);

        
        pst.executeUpdate();

        
        String dataEmprestimoBr = sdf.format(sqlDataEmprestimo);
        String dataDevolucaoBr = sdf.format(sqlDataDevolucao);

        JOptionPane.showMessageDialog(this,
                "Empréstimo registrado com sucesso!\n\n"
                + "ID Livro: " + idLivro + "\n"
                + "Cliente: " + idUsuario + "\n"
                + "Data Empréstimo: " + dataEmprestimoBr + "\n"
                + "Data Devolução: " + dataDevolucaoBr + "\n"
                + "Status: " + status
        );

        // Limpar campos após sucesso
        txtIdLivro.setText("");
        txtCliente.setText("");
        txtEmprestimo.setText("");
        txtDevolucao.setText("");
        txtStatus.setText("");

        // Fechar conexão e statement
        pst.close();
        conn.close();

        // Abrir a tela principal
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        this.dispose();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao registrar empréstimo: " + e.getMessage());
    } finally {
        // Fechar a conexão e statement no final para evitar vazamentos
        if (pst != null) try { pst.close(); } catch (SQLException ex) { ex.printStackTrace(); }
        if (conn != null) try { conn.close(); } catch (SQLException ex) { ex.printStackTrace(); }
    }

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Erro ao registrar empréstimo: " + e.getMessage());
}

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        try {
    String idStr = txtIdLivro.getText().trim();

    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Digite o ID do Empréstimo para pesquisar!");
        return;
    }

    int idEmprestimo;
    try {
        idEmprestimo = Integer.parseInt(idStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido! Digite apenas números.");
        txtIdLivro.requestFocus();
        return;
    }

    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bibliotecaProjeto", "root", "gaby2008");

   String sql = "SELECT e.id_emprestimo, c.nome AS nome_cliente, e.id_livro, l.titulo AS nome_livro, "
           + "e.data_emprestimo, e.data_devolucao, e.status "
           + "FROM emprestimos e "
           + "JOIN livros l ON e.id_livro = l.id_livro "
           + "JOIN clientes c ON e.id_usuario = c.id_cliente "
           + "WHERE e.id_emprestimo = ?";

    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1, idEmprestimo);
    ResultSet rs = pst.executeQuery();

   DefaultTableModel model = new DefaultTableModel(new Object[]{
    "ID Empréstimo", "Nome Cliente", "ID Livro", "Nome Livro", "Data Empréstimo", "Data Devolução", "Status"
}, 0);
tbEmprestimos.setModel(model);

    if (rs.next()) {
        model.addRow(new Object[]{
    rs.getInt("id_emprestimo"),
    rs.getString("nome_cliente"),
    rs.getInt("id_livro"),
    rs.getString("nome_livro"),
    rs.getDate("data_emprestimo"),
    rs.getDate("data_devolucao"),
    rs.getString("status")
});
       

        JOptionPane.showMessageDialog(this, "Empréstimo encontrado!");
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum empréstimo encontrado com esse ID.");
    }

    rs.close();
    pst.close();
    conn.close();

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Erro ao pesquisar empréstimo: " + e.getMessage());
}
      
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    
        
    
    
    
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tbEmprestimos;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtDevolucao;
    public static javax.swing.JTextField txtEmprestimo;
    public static javax.swing.JTextField txtIdLivro;
    public static javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
