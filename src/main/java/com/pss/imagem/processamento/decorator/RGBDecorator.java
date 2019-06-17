package com.pss.imagem.processamento.decorator;

import java.awt.image.BufferedImage;

//Adaptado de https://www.geeksforgeeks.org/image-processing-java-set-5-colored-red-green-blue-image-conversion/
public abstract class RGBDecorator extends ImagemDecorator {

    private BufferedImage img;
    private int altura, largura;
    protected int rgb, a, red, green, blue;

    public RGBDecorator(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        if (img == null) {
            return colorir();
        }
        return img;
    }

    protected final BufferedImage colorir() throws Exception {

        //https://www.geeksforgeeks.org/image-processing-java-set-8-creating-mirror-image/
        imagem = elementoDecorado.getImagem();

        altura = imagem.getHeight();
        largura = imagem.getWidth();

        BufferedImage novaImagem = new BufferedImage(largura, altura,
                imagem.getType());

        // convert to blue image 
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {

                this.rgb = imagem.getRGB(x, y);

                alteraCor();

                novaImagem.setRGB(x, y, this.rgb);
            }
        }

        img = novaImagem;

        return novaImagem;
    }

    public abstract void alteraCor();
}
