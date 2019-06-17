/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.decorator;

import com.pss.imagem.processamento.decorator.imported.GaussianFilter;
import com.pss.imagem.processamento.decorator.imported.GlowFilter;
import java.awt.image.BufferedImage;

/**
 *
 * @author Thiago
 */
public class GlowDecorator extends ImagemDecorator{

    private BufferedImage img;
    
    public GlowDecorator(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        if (img == null) {
            return glowBlurImage();
        }
        return img;
    }
    
    private BufferedImage glowBlurImage() throws Exception{
        this.imagem = elementoDecorado.getImagem();
        BufferedImage novaImagem = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        
        GlowFilter filtro = new GlowFilter();
        novaImagem = filtro.filter(imagem, novaImagem);
        
        img = novaImagem;
        return novaImagem;
    }
}
