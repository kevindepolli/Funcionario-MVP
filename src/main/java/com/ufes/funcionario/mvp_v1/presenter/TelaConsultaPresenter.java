/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.presenter;

import com.ufes.funcionario.mvp_v1.collection.FuncionarioCollection;
import com.ufes.funcionario.mvp_v1.model.Funcionario;
import com.ufes.funcionario.mvp_v1.observer.Observer;
import com.ufes.funcionario.mvp_v1.view.TelaConsultaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class TelaConsultaPresenter implements Observer{
    private TelaConsultaView view;
    private FuncionarioCollection funcionarios;
    private DefaultTableModel tmFuncionarios;
    
    public TelaConsultaPresenter(FuncionarioCollection funcionarios){
        this.funcionarios = funcionarios;
        view = new TelaConsultaView();
        view.setVisible(false);
        
        funcionarios.adicionaObserver(this);
        
        tmFuncionarios = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Idade", "Salário"}
        );
        
        view.getFuncionariosTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tmFuncionarios.setNumRows(0);
        for(Funcionario f: funcionarios.getFuncionarios())
            tmFuncionarios.addRow(new Object[]{f.getNome(), f.getIdade(), f.getSalario()});
        
        view.getFuncionariosTable().setModel(tmFuncionarios);
        
        view.getExcluirButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                excluir();
            }
        });
        
        view.getVisualizacaoButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                visualizar();
            }
        });
        
        view.getFecharButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fechar();
            }
        });
        
        view.setVisible(true);
    }
    
    private void fechar(){
        view.dispose();
    }
    
    private void excluir(){
        String nome = view.getFuncionariosTable().getValueAt(view.getFuncionariosTable().getSelectedRow(), 0).toString();
        for(Funcionario f: funcionarios.getFuncionarios())
            if(f.getNome().equals(nome)){
                funcionarios.removeFuncionario(f);
            }
    }
    
    private void visualizar(){
        String nome = view.getFuncionariosTable().getValueAt(view.getFuncionariosTable().getSelectedRow(), 0).toString();
        for(Funcionario f: funcionarios.getFuncionarios())
            if(f.getNome().equals(nome)){
                new TelaVisualizacaoPresenter(f,funcionarios);
            }
        
    }
    
    @Override
    public void atualiza(){
        tmFuncionarios.setNumRows(0);
        for(Funcionario f: funcionarios.getFuncionarios())
            tmFuncionarios.addRow(new Object[]{f.getNome(), f.getIdade(), f.getSalario()});
    }
}
