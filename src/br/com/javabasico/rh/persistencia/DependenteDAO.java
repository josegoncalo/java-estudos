package br.com.javabasico.rh.persistencia;

import java.util.List;

import br.com.javabasico.rh.model.Dependente;

public interface DependenteDAO {
	public String inserir(Dependente dep);	
	public String alterar(Dependente dep);	
	public String excluir(Dependente dep);	
	public List<Dependente> listarTodos();	
	public List<Dependente> pesquisarPorEmpregado(String cpf);
}