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

/**
 *
 * @author Kevin
 */
public class TelaVisualizacaoPresenter implements ITelaFuncionarioPresenter {

    private TelaFuncionarioView view;
    private Funcionario funcionario;
    private FuncionarioCollection funcionarios;
    
    public TelaVisualizacaoPresenter(Funcionario funcionario, FuncionarioCollection funcionarios) {
        this.funcionario = funcionario;
        this.funcionarios = funcionarios;
        view = new TelaFuncionarioView();
        
        view.setVisible(false);

        view.getAcaoButton().setText("Excluir");
        
        view.getNomeTextField().setEditable(false);
        view.getIdadeTextField().setEditable(false);
        view.getSalarioTextField().setEditable(false);
        
        view.getNomeTextField().setText(funcionario.getNome());
        view.getIdadeTextField().setText(String.valueOf(funcionario.getIdade()));
        view.getSalarioTextField().setText(String.valueOf(funcionario.getSalario()));
        
        view.getAcaoButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                acao();
            }
        });
        
        view.getCancelarButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                voltar();
            }
        });
        
        view.setVisible(true);
        
    }
    
    
    @Override
    public void acao(){
        funcionarios.removeFuncionario(funcionario);
        view.dispose();
    };
    
    @Override
    public void voltar(){
        view.dispose();
    };
}
