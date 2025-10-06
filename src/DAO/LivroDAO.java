
package DAO;

import DTO.LivroDTO;
import VIEW.TelaLivro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LivroDAO {
      Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // 🔹 INSERIR LIVRO
    public void inserirLivro(LivroDTO objLivroDTO) {
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao, genero, quantidade) VALUES (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objLivroDTO.getTitulo());
            pst.setString(2, objLivroDTO.getAutor());
            pst.setInt(3, objLivroDTO.getAno_publicacao());
            pst.setString(4, objLivroDTO.getGenero());
            pst.setInt(5, objLivroDTO.getQuantidade());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                limparCampos();
                pst.close();
                conexao.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método inserirLivro: " + e);
        }
    }

    // 🔹 PESQUISAR LIVRO POR ID
    public void pesquisar(LivroDTO objLivroDTO) {
        String sql = "SELECT * FROM livros WHERE id_livro = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objLivroDTO.getId_livro());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaLivro.txtTitulo.setText(rs.getString("titulo"));
                TelaLivro.txtAutor.setText(rs.getString("autor"));
                TelaLivro.txtAno.setText(String.valueOf(rs.getInt("ano_publicacao")));
                TelaLivro.txtGenero.setText(rs.getString("genero"));
                TelaLivro.txtQuantidade.setText(String.valueOf(rs.getInt("quantidade")));
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Livro não encontrado!");
                limparCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método pesquisar: " + e);
        }
    }

    // 🔹 EDITAR LIVRO
    public void editar(LivroDTO objLivroDTO) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ?, genero = ?, quantidade = ? WHERE id_livro = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objLivroDTO.getTitulo());
            pst.setString(2, objLivroDTO.getAutor());
            pst.setInt(3, objLivroDTO.getAno_publicacao());
            pst.setString(4, objLivroDTO.getGenero());
            pst.setInt(5, objLivroDTO.getQuantidade());
            pst.setInt(6, objLivroDTO.getId_livro());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
                limparCampos();
                conexao.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método editar: " + e);
        }
    }

    // 🔹 LIMPAR CAMPOS
    public void limparCampos() {
        TelaLivro.txtId.setText(null);
        TelaLivro.txtTitulo.setText(null);
        TelaLivro.txtAutor.setText(null);
        TelaLivro.txtAno.setText(null);
        TelaLivro.txtGenero.setText(null);
        TelaLivro.txtQuantidade.setText(null);
    }
    
}
