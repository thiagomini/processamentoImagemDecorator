package com.pss.imagem.processamento.decorator;

import java.awt.image.BufferedImage;

public abstract class ImagemComponente {

    protected BufferedImage imagem;
    private VisualizarDecorator visualizador;

    public abstract BufferedImage getImagem() throws Exception;

    public abstract ImagemComponente reverter();

    public final void visualizar() throws Exception {
        visualizador = new VisualizarDecorator(this);
    }

}
