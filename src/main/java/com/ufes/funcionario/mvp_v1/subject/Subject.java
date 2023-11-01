/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.funcionario.mvp_v1.subject;

import com.ufes.funcionario.mvp_v1.observer.Observer;

/**
 *
 * @author Kevin
 */
public interface Subject {
    public void adicionaObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifica();
}
