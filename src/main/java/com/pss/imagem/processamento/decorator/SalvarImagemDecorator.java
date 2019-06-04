package com.pss.imagem.processamento.decorator;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SalvarImagemDecorator extends ImagemDecorator {

    private BufferedImage img;
    private String nome;

    public SalvarImagemDecorator(ImagemComponente elementoDecorado, String nome) throws InterruptedException {
        super(elementoDecorado);
        this.nome = nome;
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        return salvarImagem();
    }

    private BufferedImage salvarImagem() throws Exception {

        imagem = elementoDecorado.getImagem();

        String caminho = new File("src/main/resources/").getAbsolutePath();
        System.out.println(caminho);

        File arquivo = new File(caminho + "\\" + this.nome);
        ImageIO.write(imagem, "jpg", arquivo);

        img = imagem;

        return imagem;
    }

    @Override
    public ImagemComponente reverter() {
        throw new IllegalArgumentException("A imagem foi salva, nao e possivel reverter");
    }

}
