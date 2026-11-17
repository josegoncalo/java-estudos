package br.com.javabasico.rh.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.javabasico.rh.controller.DependenteController;
import br.com.javabasico.rh.controller.EmpregadoController;
import br.com.javabasico.rh.model.Dependente;
import br.com.javabasico.rh.model.Empregado;

public class Teste {
    public static void main(String[] args) {
        /*
         * Empregado emp = new Empregado();
         * EmpregadoController controller = new EmpregadoController();
         * emp.setCpf("33333");
         * emp.setNome("Marta Souza");
         * emp.setIdade(45);
         * emp.setSalario(3700.0);
         * System.out.println(controller.inserir(emp));
         */
        /*
         * Empregado emp = new Empregado();
         * EmpregadoController controller = new EmpregadoController();
         * emp.setCpf("11111");
         * emp.setNome("Maria da Silva Almeida");
         * emp.setIdade(25);
         * emp.setSalario(2500.0);
         * System.out.println(controller.alterar(emp));
         */
        /*
         * Empregado emp = new Empregado();
         * EmpregadoController controller = new EmpregadoController();
         * emp.setCpf("11111");
         * System.out.println(controller.excluir(emp));
         */

        /*
         * EmpregadoController controller = new EmpregadoController();
         * List<Empregado> lista = controller.listarTodos();
         * if (lista != null) {
         * for (Empregado e : lista) {
         * System.out.println("CPF: " + e.getCpf());
         * System.out.println("Nome: " + e.getNome());
         * System.out.println("Idade: " + e.getIdade());
         * System.out.println("Salário: " + e.getSalario());
         * }
         * }
         */

        /*
         * EmpregadoController controller = new EmpregadoController();
         * Empregado emp = new Empregado();
         * emp = controller.pesquisarPorCpf("22222");
         * if (emp != null) {
         * System.out.println("CPF: " + emp.getCpf());
         * System.out.println("Nome: " + emp.getNome());
         * System.out.println("Idade: " + emp.getIdade());
         * System.out.println("Salário: " + emp.getSalario());
         * }
         */

        /*
         * Dependente dep = new Dependente();
         * DependenteController dc = new DependenteController();
         * dep.setCpfempregado("22222");
         * dep.setNome("Maria Almeida");
         * dep.setDataNascimento(LocalDate.of(2002, 11, 6));
         * dep.setGrauparentesco("Filha");
         * System.out.println(dc.inserir(dep));
         */
        /*
         * Dependente dep = new Dependente();
         * DependenteController dc = new DependenteController();
         * dep.setCpfempregado("22222");
         * dep.setNome("João Paulo");
         * dep.setDataNascimento(LocalDate.of(2006, 12, 4));
         * dep.setGrauparentesco("Enteado");
         * System.out.println(dc.alterar(dep));
         */
        /*
         * Dependente dep = new Dependente();
         * DependenteController dc = new DependenteController();
         * dep.setCpfempregado("22222");
         * dep.setNome("João Paulo");
         * System.out.println(dc.excluir(dep));
         */

      /*   List<Dependente> lista = new ArrayList<>();
        DependenteController dc = new DependenteController();
       lista = dc.listarTodos();
        if (lista != null) {
            for (Dependente d : lista) {
                System.out.println("Empregado: " + d.getCpfempregado());
                System.out.println("Nome: " + d.getNome());
            }

        }*/
       List<Dependente> lista = new ArrayList<>();
		DependenteController dc = new DependenteController();
		lista = dc.pesquisarPorEmpregado("22222");
		if (lista != null){
			for(Dependente d : lista){
				System.out.println("Empregado: "+d.getCpfempregado());
				System.out.println("Nome: "+d.getNome());
			}			
		}


    }
}
