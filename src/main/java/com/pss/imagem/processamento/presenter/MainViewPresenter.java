/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.presenter;

import com.pss.imagem.processamento.builder.ImagemBuilder;
import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.BinarizationDecorator;
import com.pss.imagem.processamento.decorator.EspelhadaDecorator;
import com.pss.imagem.processamento.decorator.GlowDecorator;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.NegativaDecorator;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import com.pss.imagem.processamento.decorator.SepiaDecorator;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;
import com.pss.imagem.processamento.decorator.VerdeDecorator;
import com.pss.imagem.processamento.decorator.VermelhoDecorator;
import com.pss.imagem.processamento.view.MainView;
import com.pss.imagem.processamento.view.MainViewMemento;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class MainViewPresenter {

    private MainView view;
    private ImagemComponente imgComponente;

    public MainViewPresenter() {
        view = new MainView();
        view.setVisible(true);
        inicializar();

        view.getBtnDesfazer().addActionListener((ActionEvent e) -> {
            btnDesfazer();
        });

        view.getBtnRestaurar().addActionListener((ActionEvent e) -> {
            btnRestaurarPadrao();
        });

        view.getImagemAzul().addActionListener((ActionEvent e) -> {
            btnAzul();
        });

        view.getImagemVerde().addActionListener((ActionEvent e) -> {
            btnVerde();
        });

        view.getImagemVermelha().addActionListener((ActionEvent e) -> {
            btnVermelho();
        });

        view.getImagemEspelhada().addActionListener((ActionEvent e) -> {
            btnEspelharImagem();
        });

        view.getNegativoImagem().addActionListener((ActionEvent e) -> {
            btnNegativo();
        });

        view.getSepia().addActionListener((ActionEvent e) -> {
            btnSepia();
        });
        
        view.getPixelar().addActionListener((ActionEvent e) -> {
            btnPixelar();
        });

        view.getTonsDeCinza().addActionListener((ActionEvent e) -> {
            btnTonsDeCinza();
        });

        view.getGlowingBlur().addActionListener((ActionEvent e) -> {
            btnGlowingBlur();
        });

        view.getBinarizar().addActionListener((ActionEvent e) -> {
            btnBinarizar();
        });

    }

    private void inicializar() {
        try {
            ImagemBuilder builder = new ImagemBuilder("lenna.jpg");
            imgComponente = builder.getResultado();
            atualizaImagem(imgComponente.getImagem());
            MainViewMemento m = new MainViewMemento(view);
            Zelador.adicionarMemento(m);
        } catch (IOException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void atualizaImagem(BufferedImage imagemAtualizada) {

        view.getLabelImagem().setIcon(new ImageIcon(imagemAtualizada));
        view.pack();
        view.repaint();
    }

    private void btnEspelharImagem() {
        boolean selecionado = view.getImagemEspelhada().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setImagemEspelhada(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new EspelhadaDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnAzul() {
        boolean selecionado = view.getImagemAzul().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setImagemAzul(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new AzulDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void btnVerde() {
        boolean selecionado = view.getImagemVerde().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setImagemVerde(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new VerdeDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnVermelho() {
        boolean selecionado = view.getImagemVermelha().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setImagemVermelha(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new VermelhoDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnNegativo() {
        boolean selecionado = view.getNegativoImagem().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setNegativoImagem(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new NegativaDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnSepia() {
        boolean selecionado = view.getSepia().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setSepia(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new SepiaDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnTonsDeCinza() {
        boolean selecionado = view.getTonsDeCinza().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setTonsDeCinza(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new TomDeCinzaDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnPixelar() {
        boolean selecionado = view.getPixelar().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setPixelar(!selecionado);
        Zelador.adicionarMemento(m);

        if (selecionado) {
            String resultado = JOptionPane.showInputDialog(view, "Informe o tamanho do Pixel:", "Pixelar Imagem", JOptionPane.PLAIN_MESSAGE);
            int tamanho = Integer.parseInt(resultado);
            try {
                imgComponente = new PixeladaDecorator(imgComponente, tamanho);
                atualizaImagem(imgComponente.getImagem());
            } catch (InterruptedException ex) {
                Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String mensagem = "Atenção, o filtro 'Pixelar' é do tipo não-reversível. Se "
                    + "remover o mesmo, todos os filtros aplicados posteriormente a esse serão também "
                    + "removidos. Deseja continuar?";
            int resposta = JOptionPane.showConfirmDialog(view, mensagem, "Remoção do Filtro: Pixelar", JOptionPane.YES_NO_OPTION);
            if(resposta == 0) {
                btnDesfazer();
                while(view.getPixelar().isSelected()) {
                    btnDesfazer();
                }
            } else {
                System.out.println("Não Confirmou!");
            }
        }

    }

    private void btnGlowingBlur() {
        boolean selecionado = view.getGlowingBlur().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setGlowingBlur(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new GlowDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnBinarizar() {
        boolean selecionado = view.getBinarizar().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        m.setBinarizar(!selecionado);
        Zelador.adicionarMemento(m);
        try {
            imgComponente = new BinarizationDecorator(imgComponente);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnDesfazer() {

        try {
            restauraMemento(Zelador.getUltimoEstado());
            imgComponente = imgComponente.reverter();
            atualizaImagem(imgComponente.getImagem());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }

    }

    private void restauraMemento(MainViewMemento m) {
        this.view.getImagemAzul().setSelected(m.isImagemAzul());
        this.view.getImagemVerde().setSelected(m.isImagemVerde());
        this.view.getImagemVermelha().setSelected(m.isImagemVermelha());
        this.view.getImagemEspelhada().setSelected(m.isImagemEspelhada());
        this.view.getRotacaoEmGraus().setSelected(m.isRotacaoEmGraus());
        this.view.getNegativoImagem().setSelected(m.isNegativoImagem());
        this.view.getSepia().setSelected(m.isSepia());
        this.view.getPixelar().setSelected(m.isPixelar());
        this.view.getTonsDeCinza().setSelected(m.isTonsDeCinza());
        this.view.getBrilho().setSelected(m.isBrilho());
        this.view.getBlur().setSelected(m.isBlur());
        this.view.getGlowingBlur().setSelected(m.isGlowingBlur());
        this.view.getBinarizar().setSelected(m.isBinarizar());
    }

    private void btnRestaurarPadrao() {
        while (Zelador.estados.size() >= 1) {
            restauraMemento(Zelador.getUltimoEstado());
            imgComponente = imgComponente.reverter();
        }
        try {
            atualizaImagem(imgComponente.getImagem());
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
