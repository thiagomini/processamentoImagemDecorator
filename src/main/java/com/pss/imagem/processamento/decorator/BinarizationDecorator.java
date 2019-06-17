/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.decorator;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Thiago
 */
public class BinarizationDecorator extends ImagemDecorator {

    private BufferedImage img;
    private int altura, largura;

    public BinarizationDecorator(ImagemComponente elementoDecorado) throws InterruptedException {
        super(elementoDecorado);
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        if (img == null) {
            return binarizaImagem();
        }
        return img;
    }

    private BufferedImage binarizaImagem() throws Exception {
        this.imagem = elementoDecorado.getImagem();

        int red;
        int newPixel;

        int threshold = otsuTreshold(imagem);

        BufferedImage binarized = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());

        for (int i = 0; i < imagem.getWidth(); i++) {
            for (int j = 0; j < imagem.getHeight(); j++) {

                // Get pixels
                red = new Color(imagem.getRGB(i, j)).getRed();
                int alpha = new Color(imagem.getRGB(i, j)).getAlpha();
                if (red > threshold) {
                    newPixel = 255;
                } else {
                    newPixel = 0;
                }
                newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
                binarized.setRGB(i, j, newPixel);

            }
        }
        img = binarized;
        return binarized;
    }

    // The luminance method
    private BufferedImage toGray(BufferedImage imagem) {

        int alpha, red, green, blue;
        int newPixel;

        BufferedImage lum = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());

        for (int i = 0; i < imagem.getWidth(); i++) {
            for (int j = 0; j < imagem.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(imagem.getRGB(i, j)).getAlpha();
                red = new Color(imagem.getRGB(i, j)).getRed();
                green = new Color(imagem.getRGB(i, j)).getGreen();
                blue = new Color(imagem.getRGB(i, j)).getBlue();

                red = (int) (0.21 * red + 0.71 * green + 0.07 * blue);
                // Return back to imagem format
                newPixel = colorToRGB(alpha, red, red, red);

                // Write pixels into image
                lum.setRGB(i, j, newPixel);

            }
        }
        
        return lum;

    }

    private int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }

    // Get binary treshold using Otsu's method
    private int otsuTreshold(BufferedImage imagem) {

        int[] histogram = imageHistogram(imagem);
        int total = imagem.getHeight() * imagem.getWidth();

        float sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * histogram[i];
        }

        float sumB = 0;
        int wB = 0;
        int wF = 0;

        float varMax = 0;
        int threshold = 0;

        for (int i = 0; i < 256; i++) {
            wB += histogram[i];
            if (wB == 0) {
                continue;
            }
            wF = total - wB;

            if (wF == 0) {
                break;
            }

            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;

            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }

        return threshold;

    }

    // Return histogram of grayscale image
    public int[] imageHistogram(BufferedImage input) {

        int[] histogram = new int[256];

        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = 0;
        }

        for (int i = 0; i < input.getWidth(); i++) {
            for (int j = 0; j < input.getHeight(); j++) {
                int red = new Color(input.getRGB(i, j)).getRed();
                histogram[red]++;
            }
        }

        return histogram;

    }
}
