/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author temporario
 */
public class ExcecaoIdNaoEncontrado extends Exception{

    public ExcecaoIdNaoEncontrado(Integer id){    
        super("Não Existe esse id" + id);
}
    
    
}
