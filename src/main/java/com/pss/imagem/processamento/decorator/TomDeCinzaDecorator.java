package com.pss.imagem.processamento.decorator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import javax.swing.GrayFilter;

//Adaptado de https://github.com/brizius/Grayscale/blob/master/GrayscaleWithGrayFilter.java
public class TomDeCinzaDecorator extends ImagemDecorator {

    private BufferedImage img;

    public TomDeCinzaDecorator(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        if (img == null) {
            return converterEscalaDeCinza();
        }
        return img;
    }

    private BufferedImage converterEscalaDeCinza() throws Exception {
        int i, j;
        imagem = elementoDecorado.getImagem();

        ImageFilter filter = new GrayFilter(true, 50);
        ImageProducer producer = new FilteredImageSource(imagem.getSource(), filter);
        Image newImg = Toolkit.getDefaultToolkit().createImage(producer);

        BufferedImage novaImagem = new BufferedImage(newImg.getWidth(null), newImg.getHeight(null), imagem.getType());

        // Draw the image on to the buffered image
        Graphics2D bGr = novaImagem.createGraphics();
        bGr.drawImage(newImg, 0, 0, null);
        bGr.dispose();

        img = novaImagem;

        return novaImagem;
    }
}
