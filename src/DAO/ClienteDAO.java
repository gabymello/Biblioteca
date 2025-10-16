
package DAO;

import DTO.ClienteDTO;
import VIEW.TelaCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ClienteDAO {
   
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
/*
    // Método para cadastrar cliente
    public void cadastrarCliente(ClienteDTO objClienteDTO) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, objClienteDTO.getNome());
        pst.setString(2, objClienteDTO.getCpf());
        pst.setString(3, objClienteDTO.getTelefone());
        pst.setString(4, objClienteDTO.getEmail());
        pst.setString(5, objClienteDTO.getEndereco());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        conexao.close();
    }
*/
    // Método para editar cliente
    public void editarCliente(ClienteDTO objClienteDTO) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id_cliente = ?";
        conexao = ConexaoDAO.conector();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, objClienteDTO.getNome());
        pst.setString(2, objClienteDTO.getCpf());
        pst.setString(3, objClienteDTO.getTelefone());
        pst.setString(4, objClienteDTO.getEmail());
        pst.setString(5, objClienteDTO.getEndereco());
        pst.setInt(6, objClienteDTO.getId_cliente());
        int edit = pst.executeUpdate();
        if (edit > 0) {
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        }
        conexao.close();
    }

    // Método para excluir cliente
    public void excluirCliente(int id_cliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        conexao = ConexaoDAO.conector();

        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id_cliente);
        int del = pst.executeUpdate();
        if (del > 0) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        }
        conexao.close();
    }

    // Método para listar clientes na tabela
    /*
    public void pesquisaAuto() {
        String sql = "SELECT * FROM clientes";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

           DefaultTableModel model = (DefaultTableModel) TelaCliente.tbCliente.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");

                model.addRow(new Object[]{id, nome, cpf, telefone, email, endereco});
            }

            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método pesquisaAuto: " + e);
        }
    }
*/
}
 
