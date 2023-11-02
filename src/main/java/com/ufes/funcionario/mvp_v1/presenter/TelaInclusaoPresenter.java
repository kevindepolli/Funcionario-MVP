/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.presenter;

import com.ufes.funcionario.mvp_v1.collection.FuncionarioCollection;
import com.ufes.funcionario.mvp_v1.model.Funcionario;
import com.ufes.funcionario.mvp_v1.view.TelaFuncionarioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class TelaInclusaoPresenter {
    private TelaFuncionarioView view;
    private FuncionarioCollection funcionarios;

    public TelaInclusaoPresenter(FuncionarioCollection funcionarios){
        this.funcionarios = funcionarios;
        view = new TelaFuncionarioView();
        view.setVisible(false);
        
        view.getAcaoButton().setText("Salvar");
        
        view.getAcaoButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                salvar();
            }
        });
        
        view.getCancelarButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fechar();
            }
        });
        
        
        
        view.setVisible(true);
    }
    
    private void salvar(){
        String nome = view.getNomeTextField().getText();
        int idade = Integer.parseInt(view.getIdadeTextField().getText());
        double salario = Double.parseDouble(view.getSalarioTextField().getText());
        
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        
        funcionarios.adicionaFuncionario(funcionario);
        
        JOptionPane.showMessageDialog(view, "Funcionario salvo com sucesso");
        
        view.getNomeTextField().setText("");
        view.getIdadeTextField().setText("");
        view.getSalarioTextField().setText("");
    }
      
    private void fechar(){
        view.dispose();
    }
    
}