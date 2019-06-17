/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.decorator;

import com.pss.imagem.processamento.decorator.imported.GaussianFilter;
import java.awt.image.BufferedImage;

/**
 *
 * @author Thiago
 */
public class BlurDecorator extends ImagemDecorator{

    private float raio;
    private BufferedImage img;
    public BlurDecorator(ImagemComponente elementoDecorado, int raio) throws InterruptedException {
        super(elementoDecorado);
        this.raio = raio;
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        if (img == null) {
            return blurImage();
        }
        return img;
    }
    
    private BufferedImage blurImage() throws Exception {
        this.imagem = elementoDecorado.getImagem();
        
        BufferedImage novaImagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        
        GaussianFilter filtro = new GaussianFilter(raio);
        novaImagem = filtro.filter(imagem, novaImagem);
        
        img = novaImagem;
        return novaImagem;
    }
}
