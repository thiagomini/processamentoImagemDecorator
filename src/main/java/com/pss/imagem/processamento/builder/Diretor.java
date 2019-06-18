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
    
    public void buildSepiaBrilhoEspelhada() throws InterruptedException {
        builder.setFiltroSepia();
        builder.setImagemComBrilho(5);
        builder.setImagemEspelhada();
    }
    
    public void buildBlurPixelarNegativa() throws InterruptedException {
        builder.setImagemBlur(5);
        builder.setImagemPixelada(5);
        builder.setImagemNegativa();
    }
}
