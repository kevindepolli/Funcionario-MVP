/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.collection;

import com.ufes.funcionario.mvp_v1.model.Funcionario;
import com.ufes.funcionario.mvp_v1.observer.Observer;
import com.ufes.funcionario.mvp_v1.subject.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class FuncionarioCollection implements Subject {
    private ArrayList<Funcionario> funcionarios;
   
    
    public FuncionarioCollection(){
        funcionarios = new ArrayList<>();
        observers = new ArrayList<>();
    }
    
    public void adicionaFuncionario(Funcionario funcionario){
        if(funcionarios.contains(funcionario)){
            throw new RuntimeException("Contato já existe");
        }
        if(funcionario != null){
            funcionarios.add(funcionario);
            notifica();
        }
        else
            throw new RuntimeException("Forneça uma instância de funcionário");
    }
    
    public void removeFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
        notifica();
    }
    
    public List<Funcionario> getFuncionarios(){
        return Collections.unmodifiableList(funcionarios);
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
        //if(!observers.isEmpty())
        for(Observer o: observers){
            o.atualiza();
        }
    }
}
