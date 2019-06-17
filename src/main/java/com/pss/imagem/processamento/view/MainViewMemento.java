/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.view;

import javax.swing.JCheckBox;

/**
 *
 * @author Thiago
 */
public class MainViewMemento {
    private boolean imagemAzul, imagemVerde, imagemVermelha,
            imagemEspelhada, rotacaoEmGraus, negativoImagem, 
            sepia, pixelar, tonsDeCinza, brilho, blur, glowingBlur,
            binarizar;

    public MainViewMemento(MainView view) {
        this.imagemAzul = view.getImagemAzul().isSelected();
        this.imagemVerde = view.getImagemVerde().isSelected();
        this.imagemVermelha = view.getImagemVermelha().isSelected();
        this.imagemEspelhada = view.getImagemEspelhada().isSelected();
        this.rotacaoEmGraus = view.getRotacaoEmGraus().isSelected();
        this.negativoImagem = view.getNegativoImagem().isSelected();
        this.sepia = view.getSepia().isSelected();
        this.pixelar = view.getPixelar().isSelected();
        this.tonsDeCinza = view.getTonsDeCinza().isSelected();
        this.brilho = view.getBrilho().isSelected();
        this.blur = view.getBlur().isSelected();
        this.glowingBlur = view.getGlowingBlur().isSelected();
        this.binarizar = view.getBinarizar().isSelected();
        
    }

    public boolean isImagemAzul() {
        return imagemAzul;
    }

    public boolean isImagemVerde() {
        return imagemVerde;
    }

    public boolean isImagemVermelha() {
        return imagemVermelha;
    }

    public boolean isImagemEspelhada() {
        return imagemEspelhada;
    }

    public boolean isRotacaoEmGraus() {
        return rotacaoEmGraus;
    }

    public boolean isNegativoImagem() {
        return negativoImagem;
    }

    public boolean isSepia() {
        return sepia;
    }

    public boolean isPixelar() {
        return pixelar;
    }

    public boolean isTonsDeCinza() {
        return tonsDeCinza;
    }

    public boolean isBrilho() {
        return brilho;
    }

    public boolean isBlur() {
        return blur;
    }

    public boolean isGlowingBlur() {
        return glowingBlur;
    }

    public boolean isBinarizar() {
        return binarizar;
    }

    public void setImagemAzul(boolean imagemAzul) {
        this.imagemAzul = imagemAzul;
    }

    public void setImagemVerde(boolean imagemVerde) {
        this.imagemVerde = imagemVerde;
    }

    public void setImagemVermelha(boolean imagemVermelha) {
        this.imagemVermelha = imagemVermelha;
    }

    public void setImagemEspelhada(boolean imagemEspelhada) {
        this.imagemEspelhada = imagemEspelhada;
    }

    public void setRotacaoEmGraus(boolean rotacaoEmGraus) {
        this.rotacaoEmGraus = rotacaoEmGraus;
    }

    public void setNegativoImagem(boolean negativoImagem) {
        this.negativoImagem = negativoImagem;
    }

    public void setSepia(boolean sepia) {
        this.sepia = sepia;
    }

    public void setPixelar(boolean pixelar) {
        this.pixelar = pixelar;
    }

    public void setTonsDeCinza(boolean tonsDeCinza) {
        this.tonsDeCinza = tonsDeCinza;
    }

    public void setBrilho(boolean brilho) {
        this.brilho = brilho;
    }

    public void setBlur(boolean blur) {
        this.blur = blur;
    }

    public void setGlowingBlur(boolean glowingBlur) {
        this.glowingBlur = glowingBlur;
    }

    public void setBinarizar(boolean binarizar) {
        this.binarizar = binarizar;
    }
    

        
}
