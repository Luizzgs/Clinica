/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import modelo.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import util.ExcecaoIdNaoEncontrado;
import util.JpaUtil;

/**
 *
 * @author temporario
 */
public class DaoTest {
    
    public DaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /*@Test
    public void testInserirUsuario() {
        Dao<Usuario> dao = new Dao(Usuario.class);
        Usuario u = new Usuario("Astolfo", "Rua das Antas, 1 - Bandeirantes-PR", "(43) 9988-7755", 
                new GregorianCalendar(2004, Calendar.FEBRUARY, 11).getTime(), 
                "astolfo", "123"); 
        dao.inserir(u);     
    }*/
   
//    @Test
//    public void testInserirAnimal() throws ExcecaoIdNaoEncontrado{
//        Dao<Animal> dao = new Dao(Animal.class);
//        Dao<Tutor> daoTutor = new Dao(Tutor.class);
//        Tutor tutor = daoTutor.buscarPorId(2);  // existe tutor com codigo 2
//        // String classe, String nome, Tutor tutor
//        Animal a = new Animal("Cachorro", "Rex", tutor); 
//        dao.inserir(a);        
//    }
    
    public void testExcluir(){
        
    }
   
  
    
    
}
