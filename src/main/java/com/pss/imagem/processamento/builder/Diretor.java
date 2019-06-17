/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.builder;

/**
 *
 * @author Thiago
 */
public class Diretor {
    
    private ImagemBuilder builder;
    
    public Diretor(ImagemBuilder builder) {
        this.builder = builder;
    }
    
    public void setBuilder(ImagemBuilder builder) {
        this.builder = builder;
    }
    
    public void buildVerdeComBrilho() throws InterruptedException {
        builder.setImagemVerde();
        builder.setImagemComBrilho(5);
    }
}
