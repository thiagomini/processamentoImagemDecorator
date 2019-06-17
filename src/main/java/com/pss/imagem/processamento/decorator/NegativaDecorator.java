package com.pss.imagem.processamento.decorator;

import java.awt.image.BufferedImage;

//Adaptado de https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-negative
public class NegativaDecorator extends ImagemDecorator {

    private BufferedImage img;
    private int altura, largura;

    public NegativaDecorator(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        if (img == null) {
            return converterNegativo();
        }
        return img;
    }

    private BufferedImage converterNegativo() throws Exception {
        imagem = elementoDecorado.getImagem();

        altura = imagem.getHeight();
        largura = imagem.getWidth();

        BufferedImage novaImagem = new BufferedImage(largura, altura,
                imagem.getType());

        // Convert to negative 
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int p = imagem.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //subtract RGB from 255 
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                //set new RGB value 
                p = (a << 24) | (r << 16) | (g << 8) | b;
                novaImagem.setRGB(x, y, p);
            }
        }
        img = novaImagem;

        return novaImagem;
    }
}
