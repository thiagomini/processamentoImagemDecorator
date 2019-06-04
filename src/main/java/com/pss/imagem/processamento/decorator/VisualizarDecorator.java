package com.pss.imagem.processamento.decorator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class VisualizarDecorator extends ImagemDecorator {

    private VisualizarImagemView view;

    public VisualizarDecorator(ImagemComponente imagemComponente) throws InterruptedException, Exception {
        super(imagemComponente);
        imagem = imagemComponente.getImagem();
        if (imagem == null) {
            throw new IllegalArgumentException("Imagem nula, informe uma imagem válida");
        }
        view = new VisualizarImagemView();
        //    int altura = imagem.getHeight() + 300;
        //  int largura = imagem.getWidth() + 300;
        //view.setPreferredSize(new Dimension(largura, altura));

        view.getLblImagem().setIcon(new ImageIcon(imagem));
        //view.pack();
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        view.pack();
        view.repaint();
        view.setVisible(true);
    }

    @Override
    public BufferedImage getImagem() throws Exception {
        return imagem;
    }

    @Override
    public ImagemComponente reverter() {
        throw new IllegalArgumentException("A imagem foi exibida, nao e possivel reverter");
    }

}
