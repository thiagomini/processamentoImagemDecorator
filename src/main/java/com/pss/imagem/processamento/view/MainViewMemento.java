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
    private boolean btnImgAzul, btnImgVerde, btnImgVermelha, btnImgEspelhada,
            btnRotacao, btnNegativo, btnSepia, btnPixelar, btnTonsDeCinza, btnBrilho,
            btnBlur, btnGlowingBlur, btnBinarizar;

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
        
        this.btnImgAzul = view.getImagemAzul().isEnabled();
        this.btnImgVerde = view.getImagemVerde().isEnabled();
        this.btnImgVermelha = view.getImagemVermelha().isEnabled();
        this.btnImgEspelhada = view.getImagemEspelhada().isEnabled();
        this.btnRotacao = view.getRotacaoEmGraus().isEnabled();
        this.btnNegativo = view.getNegativoImagem().isEnabled();
        this.btnSepia = view.getSepia().isEnabled();
        this.btnPixelar = view.getPixelar().isEnabled();
        this.btnTonsDeCinza = view.getTonsDeCinza().isEnabled();
        this.btnBrilho = view.getBrilho().isEnabled();
        this.btnBlur = view.getBlur().isEnabled();
        this.btnGlowingBlur = view.getGlowingBlur().isEnabled();
        this.btnBinarizar = view.getBinarizar().isEnabled();
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

    public boolean isBtnImgAzul() {
        return btnImgAzul;
    }

    public void setBtnImgAzul(boolean btnImgAzul) {
        this.btnImgAzul = btnImgAzul;
    }

    public boolean isBtnImgVerde() {
        return btnImgVerde;
    }

    public void setBtnImgVerde(boolean btnImgVerde) {
        this.btnImgVerde = btnImgVerde;
    }

    public boolean isBtnImgVermelha() {
        return btnImgVermelha;
    }

    public void setBtnImgVermelha(boolean btnImgVermelha) {
        this.btnImgVermelha = btnImgVermelha;
    }

    public boolean isBtnImgEspelhada() {
        return btnImgEspelhada;
    }

    public void setBtnImgEspelhada(boolean btnImgEspelhada) {
        this.btnImgEspelhada = btnImgEspelhada;
    }

    public boolean isBtnRotacao() {
        return btnRotacao;
    }

    public void setBtnRotacao(boolean btnRotacao) {
        this.btnRotacao = btnRotacao;
    }

    public boolean isBtnNegativo() {
        return btnNegativo;
    }

    public void setBtnNegativo(boolean btnNegativo) {
        this.btnNegativo = btnNegativo;
    }

    public boolean isBtnSepia() {
        return btnSepia;
    }

    public void setBtnSepia(boolean btnSepia) {
        this.btnSepia = btnSepia;
    }

    public boolean isBtnPixelar() {
        return btnPixelar;
    }

    public void setBtnPixelar(boolean btnPixelar) {
        this.btnPixelar = btnPixelar;
    }

    public boolean isBtnTonsDeCinza() {
        return btnTonsDeCinza;
    }

    public void setBtnTonsDeCinza(boolean btnTonsDeCinza) {
        this.btnTonsDeCinza = btnTonsDeCinza;
    }

    public boolean isBtnBrilho() {
        return btnBrilho;
    }

    public void setBtnBrilho(boolean btnBrilho) {
        this.btnBrilho = btnBrilho;
    }

    public boolean isBtnBlur() {
        return btnBlur;
    }

    public void setBtnBlur(boolean btnBlur) {
        this.btnBlur = btnBlur;
    }

    public boolean isBtnGlowingBlur() {
        return btnGlowingBlur;
    }

    public void setBtnGlowingBlur(boolean btnGlowingBlur) {
        this.btnGlowingBlur = btnGlowingBlur;
    }

    public boolean isBtnBinarizar() {
        return btnBinarizar;
    }

    public void setBtnBinarizar(boolean btnBinarizar) {
        this.btnBinarizar = btnBinarizar;
    }
    
    

        
}
