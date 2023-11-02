/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.presenter;

import com.ufes.funcionario.mvp_v1.collection.FuncionarioCollection;
import com.ufes.funcionario.mvp_v1.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kevin
 */
public class TelaPrincipalPresenter {
    private TelaPrincipalView view;
    private FuncionarioCollection funcionarios;

    public TelaPrincipalPresenter(){
        funcionarios = new FuncionarioCollection();
        
        view = new TelaPrincipalView();
        view.setVisible(false);
       
        view.getIncluirButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                incluir();
            }
        });
        
        view.getConsultarButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                consultar();
            }
        });
        
        view.setVisible(true);
    }
    
    private void incluir(){
       new TelaInclusaoPresenter(funcionarios);
    }
    
    private void consultar(){
        new TelaConsultaPresenter(funcionarios);
    }
    
}
