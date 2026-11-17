package br.com.javabasico.rh.model;

import java.time.LocalDate;

public class Dependente {
	private String cpfempregado;
	private String nome;
	private String grauparentesco;
	private LocalDate dataNascimento;
	public Dependente(){}
	public String getCpfempregado() {
        return cpfempregado;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public String getGrauparentesco() {
        return grauparentesco;
    }
    public String getNome() {
        return nome;
    }
    public void setCpfempregado(String cpfempregado) {
        this.cpfempregado = cpfempregado;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setGrauparentesco(String grauparentesco) {
        this.grauparentesco = grauparentesco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}

