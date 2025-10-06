
package DAO;

import DTO.UsuarioDTO;
import VIEW.TelaPrincipal;
import VIEW.TelaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // 🔹 INSERIR USUÁRIO
    public void inserirUsuario(UsuarioDTO objUsuarioDTO) {
        String sql = "INSERT INTO usuarios (nome, email, telefone, tipo) VALUES (?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getNome());
            pst.setString(2, objUsuarioDTO.getEmail());
            pst.setString(3, objUsuarioDTO.getTelefone());
            pst.setString(4, objUsuarioDTO.getTipo());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
                limparCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + e);
        }
    }

    // 🔹 PESQUISAR USUÁRIO
    public void pesquisarUsuario(UsuarioDTO objUsuarioDTO) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaUsuario.txtNome.setText(rs.getString("nome"));
                TelaUsuario.txtEmail.setText(rs.getString("email"));
                TelaUsuario.txtTelefone.setText(rs.getString("telefone"));
                TelaUsuario.txtTipo.setText(rs.getString("tipo"));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                limparCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário: " + e);
        }
    }

    // 🔹 EDITAR USUÁRIO
    public void editarUsuario(UsuarioDTO objUsuarioDTO) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ?, tipo = ? WHERE id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getNome());
            pst.setString(2, objUsuarioDTO.getEmail());
            pst.setString(3, objUsuarioDTO.getTelefone());
            pst.setString(4, objUsuarioDTO.getTipo());
            pst.setInt(5, objUsuarioDTO.getId_usuario());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                limparCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar usuário: " + e);
        }
    }

    // 🔹 EXCLUIR USUÁRIO
    public void excluirUsuario(UsuarioDTO objUsuarioDTO) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            int deletado = pst.executeUpdate();

            if (deletado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                limparCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + e);
        }
    }

    // 🔹 LIMPAR CAMPOS
    public void limparCampos() {
        TelaUsuario.txtId.setText(null);
        TelaUsuario.txtNome.setText(null);
        TelaUsuario.txtEmail.setText(null);
        TelaUsuario.txtTelefone.setText(null);
        TelaUsuario.txtTipo.setText(null);
    }
}
    

