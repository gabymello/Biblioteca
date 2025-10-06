
package DTO;

public class EmprestimoDTO {
    private int id_emprestimo;
    private int id_livro;
    private String nome_cliente;
    private String data_emprestimo;
    private String data_devolucao;
    private String status_emprestimo;

    // Getters e Setters
    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getStatus_emprestimo() {
        return status_emprestimo;
    }

    public void setStatus_emprestimo(String status_emprestimo) {
        this.status_emprestimo = status_emprestimo;
    }
    
}
