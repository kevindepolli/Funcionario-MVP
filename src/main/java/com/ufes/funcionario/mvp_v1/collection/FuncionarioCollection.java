/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.collection;

import com.ufes.funcionario.mvp_v1.model.Funcionario;
import com.ufes.funcionario.mvp_v1.observer.Observer;
import com.ufes.funcionario.mvp_v1.subject.Subject;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class FuncionarioCollection implements Subject {
    private ArrayList<Funcionario> funcionarios;
   
    
    public FuncionarioCollection(){
        funcionarios = new ArrayList<>();
    }
    
    public void adicionaFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    
    public void removeFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
    
    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarios;
    }
    
    //Observer
    private ArrayList<Observer> observers;
    
    @Override
    public void adicionaObserver(Observer o){
        observers.add(o);
    }
    
    @Override
     public void removeObserver(Observer o){
        observers.remove(o);
    }
     
    @Override
    public void notifica(){
        for(Observer o: observers){
            o.atualiza();
        }
    }
}
