/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.builder;

import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.BinarizationDecorator;
import com.pss.imagem.processamento.decorator.BlurDecorator;
import com.pss.imagem.processamento.decorator.BrilhoDecorator;
import com.pss.imagem.processamento.decorator.EspelhadaDecorator;
import com.pss.imagem.processamento.decorator.GlowDecorator;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.NegativaDecorator;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import com.pss.imagem.processamento.decorator.RotacionaDecorator;
import com.pss.imagem.processamento.decorator.SalvarImagemDecorator;
import com.pss.imagem.processamento.decorator.SepiaDecorator;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;
import com.pss.imagem.processamento.decorator.VerdeDecorator;
import com.pss.imagem.processamento.decorator.VermelhoDecorator;
import com.pss.imagem.processamento.model.Imagem;
import java.io.IOException;

/**
 *
 * @author Thiago
 */
public class ImagemBuilder {
    
    private ImagemComponente resultado;
    
    public ImagemBuilder(String caminho) throws IOException, InterruptedException, IllegalArgumentException {
        reset(caminho);
    }
    
    public ImagemComponente getResultado() {
        return this.resultado;
    }
    private void reset(String caminho) throws IOException, InterruptedException, IllegalArgumentException {
        this.resultado = new Imagem(caminho);
    }
    
    public void setImagemEspelhada() throws InterruptedException {
        resultado = new EspelhadaDecorator(resultado);
    }
    
    public void setImagemComBrilho(int escala) throws InterruptedException {
        resultado = new BrilhoDecorator(resultado, escala);
    }
    
    public void setImagemAzul() throws InterruptedException {
        resultado = new AzulDecorator(resultado);
    }
    
    public void setImagemVermelha() throws InterruptedException {
        resultado = new VermelhoDecorator(resultado);
    }
    
    public void setImagemVerde() throws InterruptedException {
        resultado = new VerdeDecorator(resultado);
    }
    
    public void setImagemGlowBlur() throws InterruptedException {
        resultado = new GlowDecorator(resultado);
    }
    
    public void setImagemNegativa() throws InterruptedException {
        resultado = new NegativaDecorator(resultado);
    }
    
    public void setImagemPixelada(int tamanhoPixel) throws InterruptedException {
        resultado = new PixeladaDecorator(resultado, tamanhoPixel);
    }
    
    public void rotacionaImagem(int angulo) throws InterruptedException {
        resultado = new RotacionaDecorator(resultado, angulo);
    }
    
    public void setFiltroSepia() throws InterruptedException {
        resultado = new SepiaDecorator(resultado);
    }
    
    public void setImagemCinza() throws InterruptedException {
        resultado = new TomDeCinzaDecorator(resultado);
    }
    
    public void setImagemBlur(int raio) throws InterruptedException{
        resultado = new BlurDecorator(resultado, raio);
    }
    
    public void setImagemBinaria() throws InterruptedException {
        resultado = new BinarizationDecorator(resultado);
    }
    
    public void salvarImagem(String nome) throws InterruptedException {
        resultado = new SalvarImagemDecorator(resultado, nome);
    }
}
 