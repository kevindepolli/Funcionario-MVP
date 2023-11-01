/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.presenter;

import com.ufes.funcionario.mvp_v1.view.TelaConsultaView;

/**
 *
 * @author Kevin
 */
public class TelaConsultaPresenter {
    private TelaConsultaView view;
    
    public TelaConsultaPresenter(){
        view = new TelaConsultaView();
        view.setVisible(true);
    }
    
}
