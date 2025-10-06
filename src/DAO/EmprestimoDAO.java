
package DAO;

import DTO.EmprestimoDTO;
import VIEW.TelaEmprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmprestimoDAO {
       Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // INSERIR
    public void inserirEmprestimo(EmprestimoDTO objEmprestimoDTO) {
        String sql = "INSERT INTO emprestimo (id_livro, nome_cliente, data_emprestimo, data_devolucao, status_emprestimo) "
                   + "VALUES (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objEmprestimoDTO.getId_livro());
            pst.setString(2, objEmprestimoDTO.getNome_cliente());
            pst.setString(3, objEmprestimoDTO.getData_emprestimo());
            pst.setString(4, objEmprestimoDTO.getData_devolucao());
            pst.setString(5, objEmprestimoDTO.getStatus_emprestimo());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Empréstimo registrado com sucesso!");
                limparCampos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método inserirEmprestimo: " + e);
        }
    }

    // PESQUISAR
    public void pesquisarEmprestimo(EmprestimoDTO objEmprestimoDTO) {
        String sql = "SELECT * FROM emprestimo WHERE id_emprestimo = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objEmprestimoDTO.getId_emprestimo());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaEmprestimo.txtIdLivro.setText(rs.getString("id_livro"));
                TelaEmprestimo.txtNomeCliente.setText(rs.getString("nome_cliente"));
                TelaEmprestimo.txtDataEmprestimo.setText(rs.getString("data_emprestimo"));
                TelaEmprestimo.txtDataDevolucao.setText(rs.getString("data_devolucao"));
                TelaEmprestimo.txtStatus.setText(rs.getString("status_emprestimo"));
            } else {
                JOptionPane.showMessageDialog(null, "Empréstimo não encontrado!");
                limparCampos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método pesquisarEmprestimo: " + e);
        }
    }

    // EDITAR
    public void editarEmprestimo(EmprestimoDTO objEmprestimoDTO) {
        String sql = "UPDATE emprestimo SET id_livro = ?, nome_cliente = ?, data_emprestimo = ?, data_devolucao = ?, status_emprestimo = ? "
                   + "WHERE id_emprestimo = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objEmprestimoDTO.getId_livro());
            pst.setString(2, objEmprestimoDTO.getNome_cliente());
            pst.setString(3, objEmprestimoDTO.getData_emprestimo());
            pst.setString(4, objEmprestimoDTO.getData_devolucao());
            pst.setString(5, objEmprestimoDTO.getStatus_emprestimo());
            pst.setInt(6, objEmprestimoDTO.getId_emprestimo());

            int edit = pst.executeUpdate();
            if (edit > 0) {
                JOptionPane.showMessageDialog(null, "Empréstimo atualizado com sucesso!");
                limparCampos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método editarEmprestimo: " + e);
        }
    }

    // EXCLUIR
    public void excluirEmprestimo(EmprestimoDTO objEmprestimoDTO) {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objEmprestimoDTO.getId_emprestimo());

            int delete = pst.executeUpdate();
            if (delete > 0) {
                JOptionPane.showMessageDialog(null, "Empréstimo excluído com sucesso!");
                limparCampos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método excluirEmprestimo: " + e);
        }
    }

    // LIMPAR CAMPOS (referenciando sua tela)
    public void limparCampos() {
        TelaEmprestimo.txtIdEmprestimo.setText(null);
        TelaEmprestimo.txtIdLivro.setText(null);
        TelaEmprestimo.txtNomeCliente.setText(null);
        TelaEmprestimo.txtDataEmprestimo.setText(null);
        TelaEmprestimo.txtDataDevolucao.setText(null);
        TelaEmprestimo.txtStatus.setText(null);
    }
    
}
