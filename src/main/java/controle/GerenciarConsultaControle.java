/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Consulta;
import util.JsfUtil;

/**
 *
 * @author temporario
 */
@Named
@ViewScoped
public class GerenciarConsultaControle implements Serializable {
    private Dao<Consulta> daoConsulta;
    private Dao<Animal> daoAnimal;
    private Consulta consulta;
    private List<Consulta> listaConsulta;
    private List<Animal> listaAnimal;
    private Boolean mostraPopupAlteracao;

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    @PostConstruct
    public void iniciar() {
        daoConsulta = new Dao(Consulta.class);        
        consulta = new Consulta();
        listaConsulta = daoConsulta.listarTodos();           
        mostraPopupAlteracao = false;
        daoAnimal = new Dao(Animal.class);
        listaAnimal = daoAnimal.listarTodos();
    }
    
    public void alterar(Consulta selecionado) {
        this.consulta = selecionado; 
        mostraPopupAlteracao = true;
    }

    
    public void excluir(Consulta excluido) {
        daoConsulta.excluir(excluido.getCodigo());
        listaConsulta = daoConsulta.listarTodos();
    }
    
    public String salvar() {
        daoConsulta.inserir(consulta);
        consulta = new Consulta(); // limpa os campos 
        JsfUtil.mostrarSucesso("Consulta cadastrado");
        listaConsulta = daoConsulta.listarTodos(); // atualiza tabela 
        return null; 
    }
    
    public String salvarAlteracao(){
        daoConsulta.alterar(consulta);
        consulta = new Consulta(); // limpa os campos 
        JsfUtil.mostrarSucesso("Consulta alterada");
        listaConsulta = daoConsulta.listarTodos(); // atualiza tabela 
        return null; 
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Consulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<Consulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }
    

    public Boolean getMostraPopupAlteracao() {
        return mostraPopupAlteracao;
    }

    public void setMostraPopupAlteracao(Boolean mostraPopupAlteracao) {
        this.mostraPopupAlteracao = mostraPopupAlteracao;
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }
     
  
    
    
}
