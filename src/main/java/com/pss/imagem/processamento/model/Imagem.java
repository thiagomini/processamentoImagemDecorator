package com.pss.imagem.processamento.model;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagem extends ImagemComponente {

    public Imagem(String caminhoArquivo) throws IOException, InterruptedException, IllegalArgumentException {
        try {
            if (!caminhoArquivo.toLowerCase().endsWith(".jpg")) {
                throw new IllegalArgumentException("Informe um arquivo JPG");
            }
            imagem = ImageIO.read(new File(caminhoArquivo));
            Thread.sleep(1000);

        } catch (IOException | InterruptedException e) {
            throw new IOException("Falha: Não foi possivel abrir a imagem \n" + e.getMessage());
        }
    }

    @Override
    public BufferedImage getImagem() {
        return imagem;
    }

    @Override
    public ImagemComponente reverter() {
        return this;
    }

}
