package controle;

import dao.Dao;
import dao.DaoUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuario;
import util.JsfUtil;

@Named
@ViewScoped
public class GerenciarUsuarioControle implements Serializable {

    private Usuario usuario;
    private Dao<Usuario> dao;
    private DaoUsuario daoUser;
    private List<Usuario> lista;
    private Boolean mostraPopupAlteracao;
    private Boolean verificarUser;

    @PostConstruct
    public void iniciar() {
        usuario = new Usuario();
        dao = new Dao(Usuario.class);
        daoUser = new DaoUsuario();
        setLista(dao.listarTodos());
        mostraPopupAlteracao = false; 
    }

    public void alterar(Usuario selecionado) {
        this.usuario = selecionado; 
        mostraPopupAlteracao = true;
    }

    public void converter() {
        usuario.setLogin(usuario.getLogin().toLowerCase());
    }
    
    public void excluir(Usuario excluido) {
        dao.excluir(excluido.getCodigo());
        lista = dao.listarTodos();
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }
    
    public String salvar() {
        verificarUser = daoUser.jaExiste(usuario.getLogin());
        if(verificarUser == false){
            dao.inserir(usuario);
            usuario = new Usuario(); // limpa os campos 
            JsfUtil.mostrarSucesso("Usuário cadastrado");
            lista = dao.listarTodos(); // atualiza tabela 
            return null;
        } else{
            JsfUtil.mostrarErro("Já Existe um usuário com este login");
            return null;
        }
        
        }

    public String salvarAlteracao(){
        dao.alterar(usuario);
        usuario = new Usuario(); // limpa os campos 
        JsfUtil.mostrarSucesso("Usuário alterado");
        lista = dao.listarTodos(); // atualiza tabela 
        return null; 
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Boolean getMostraPopupAlteracao() {
        return mostraPopupAlteracao;
    }

    public void setMostraPopupAlteracao(Boolean mostraPopupAlteracao) {
        this.mostraPopupAlteracao = mostraPopupAlteracao;
    }

}