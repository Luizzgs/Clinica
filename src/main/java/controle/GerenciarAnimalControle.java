package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Tutor;
import util.JsfUtil;

@Named
@ViewScoped
public class GerenciarAnimalControle implements Serializable {
    private Dao<Animal> dao; 
    private Dao<Tutor> daoTutor;
    private List<Tutor> listaTutores; //criar listaAnimais unica para cada classe 
    private List<Animal> listaAnimais;
    private Animal animal;
    private Boolean mostraPopupAlteracao;
    
    @PostConstruct
    public void iniciar() {
        dao = new Dao(Animal.class);
        daoTutor = new Dao(Tutor.class);
        animal = new Animal();
        listaTutores = daoTutor.listarTodos();        
        listaAnimais = dao.listarTodos();       
        mostraPopupAlteracao = false;
    }
    
    public void alterar(Animal selecionado) {
        this.animal = selecionado; 
        mostraPopupAlteracao = true;
    }

    
    public void excluir(Animal excluido) {
        dao.excluir(excluido.getCodigo());
        listaAnimais = dao.listarTodos();
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }

    public List<Animal> getListaAnimais() {
        return listaAnimais;
    }

    public void setListaAnimais(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

   
        
    public String salvar() {
        dao.inserir(animal);
        animal = new Animal(); // limpa os campos 
        JsfUtil.mostrarSucesso("Animal cadastrado");
        listaAnimais = dao.listarTodos(); // atualiza tabela 
        return null; 
    }

    public String salvarAlteracao(){
        dao.alterar(animal);
        animal = new Animal(); // limpa os campos 
        JsfUtil.mostrarSucesso("Animal alterado");
        listaAnimais = dao.listarTodos(); // atualiza tabela 
        return null; 
    }
          
    
    public List<Tutor> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<Tutor> listaTutores) {
        this.listaTutores = listaTutores;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public Boolean getMostraPopupAlteracao() {
        return mostraPopupAlteracao;
    }

    public void setMostraPopupAlteracao(Boolean mostraPopupAlteracao) {
        this.mostraPopupAlteracao = mostraPopupAlteracao;
    }

    
}