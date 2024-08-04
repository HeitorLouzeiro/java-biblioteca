package br.com.heitorlouzeiro.classes;

public class Emprestimos {
    private int idEmprestimo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean statusEmprestimo;
    private int idLivro;
    private int idAluno;
    
    public int getIdEmprestimo() {
        return idEmprestimo;
    }
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public String getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public boolean isStatusEmprestimo() {
        return statusEmprestimo;
    }
    public void setStatusEmprestimo(boolean statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }
    public int getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
}
