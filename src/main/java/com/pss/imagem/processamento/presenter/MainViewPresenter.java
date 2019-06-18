/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.imagem.processamento.presenter;

import com.pss.imagem.processamento.builder.Diretor;
import com.pss.imagem.processamento.builder.ImagemBuilder;
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
import com.pss.imagem.processamento.decorator.SepiaDecorator;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;
import com.pss.imagem.processamento.decorator.VerdeDecorator;
import com.pss.imagem.processamento.decorator.VermelhoDecorator;
import com.pss.imagem.processamento.view.MainView;
import com.pss.imagem.processamento.view.MainViewMemento;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Thiago
 */
public class MainViewPresenter {

    private MainView view;
    private ImagemComponente imgComponente;
    private int rotacao;

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

        view.getRotacaoEmGraus().addActionListener((ActionEvent e) -> {
            btnRotacao();
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

        view.getBrilho().addActionListener((ActionEvent e) -> {
            btnBrilho();
        });

        view.getBlur().addActionListener((ActionEvent e) -> {
            btnBlur();
        });

        view.getGlowingBlur().addActionListener((ActionEvent e) -> {
            btnGlowingBlur();
        });

        view.getBinarizar().addActionListener((ActionEvent e) -> {
            btnBinarizar();
        });

        view.getBtnAbrir().addActionListener((ActionEvent e) -> {
            btnAbrir();
        });

        view.getBtnSalvar().addActionListener((ActionEvent e) -> {
            btnSalvar();
        });

        view.getBtnFechar().addActionListener((ActionEvent e) -> {
            btnFechar();
        });

        view.getBuilderComboBox().addActionListener((ActionEvent e) -> {
            filtroComboBox();
        });

    }

    private void inicializar() {
        try {
            ImagemBuilder builder = new ImagemBuilder("lenna.jpg");
            imgComponente = builder.getResultado();
            atualizaImagem(imgComponente.getImagem());
//            MainViewMemento m = new MainViewMemento(view);
//            Zelador.adicionarMemento(m);
        } catch (IOException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        view.getBuilderComboBox().addItem("Verde + Brilho");
        view.getBuilderComboBox().addItem("Sepia + Brilho + Espelhada");
        view.getBuilderComboBox().addItem("Blur + Pixelar + Negativa");

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

    private void btnRotacao() {
        boolean selecionado = view.getRotacaoEmGraus().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        view.getRotacaoEmGraus().setEnabled(false);
        m.setRotacaoEmGraus(!selecionado);
        Zelador.adicionarMemento(m);

        String resultado = JOptionPane.showInputDialog(view, "Informe a rotacao (em graus °): ", "Aplicar Rotação", JOptionPane.PLAIN_MESSAGE);
        int graus = Integer.parseInt(resultado);
        try {
            imgComponente = new RotacionaDecorator(imgComponente, graus);
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
        view.getImagemAzul().setEnabled(false);
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
        view.getImagemVerde().setEnabled(false);
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
        view.getImagemVermelha().setEnabled(false);
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
        view.getSepia().setEnabled(false);
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
        view.getTonsDeCinza().setEnabled(false);
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
        view.getPixelar().setEnabled(false);
        m.setPixelar(!selecionado);
        Zelador.adicionarMemento(m);

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

    }

    private void btnGlowingBlur() {
        boolean selecionado = view.getGlowingBlur().isSelected();

        MainViewMemento m = new MainViewMemento(view);
        view.getGlowingBlur().setEnabled(false);
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
        view.getBinarizar().setEnabled(false);
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

    private void btnBrilho() {
        boolean selecionado = view.getBrilho().isSelected();
        MainViewMemento m = new MainViewMemento(view);
        view.getBrilho().setEnabled(false);
        m.setBrilho(!selecionado);
        Zelador.adicionarMemento(m);

        String resultado = JOptionPane.showInputDialog(view, "Informe a intensidade do Brilho:", "Aplicar Brilho", JOptionPane.PLAIN_MESSAGE);
        int tamanho = Integer.parseInt(resultado);
        try {
            imgComponente = new BrilhoDecorator(imgComponente, tamanho);
            atualizaImagem(imgComponente.getImagem());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnBlur() {
        boolean selecionado = view.getBlur().isSelected();

        MainViewMemento m = new MainViewMemento(view);
        view.getBlur().setEnabled(false);
        m.setBlur(!selecionado);
        Zelador.adicionarMemento(m);

        String resultado = JOptionPane.showInputDialog(view, "Informe a intensidade do Blur:", "Borrar Imagem", JOptionPane.PLAIN_MESSAGE);
        int tamanho = Integer.parseInt(resultado);
        try {
            imgComponente = new BlurDecorator(imgComponente, tamanho);
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

        this.view.getImagemAzul().setEnabled(m.isBtnImgAzul());
        this.view.getImagemVerde().setEnabled(m.isBtnImgVerde());
        this.view.getImagemVermelha().setEnabled(m.isBtnImgVermelha());
        this.view.getImagemEspelhada().setEnabled(m.isBtnImgEspelhada());
        this.view.getRotacaoEmGraus().setEnabled(m.isBtnRotacao());
        this.view.getNegativoImagem().setEnabled(m.isBtnNegativo());
        this.view.getSepia().setEnabled(m.isBtnSepia());
        this.view.getPixelar().setEnabled(m.isBtnPixelar());
        this.view.getTonsDeCinza().setEnabled(m.isBtnTonsDeCinza());
        this.view.getBrilho().setEnabled(m.isBtnBrilho());
        this.view.getBlur().setEnabled(m.isBtnBlur());
        this.view.getGlowingBlur().setEnabled(m.isBtnGlowingBlur());
        this.view.getBinarizar().setEnabled(m.isBtnBinarizar());

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

    private void btnAbrir() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Files", "jpg", "jpeg");
        j.setFileFilter(filter);
        int resultado = j.showOpenDialog(view);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String caminho = j.getSelectedFile().getPath();

            try {
                ImagemBuilder b = new ImagemBuilder(caminho);
                imgComponente = b.getResultado();
                atualizaImagem(imgComponente.getImagem());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }

        }
    }

    private void btnSalvar() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Files", "png", "png");
        j.setFileFilter(filter);
        int resultado = j.showSaveDialog(view);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = (j.getSelectedFile());
            if (FilenameUtils.getExtension(arquivo.getName()).equalsIgnoreCase("png")) {
                try {
                    ImageIO.write(imgComponente.getImagem(), "png", arquivo);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            } else {
                arquivo = new File(arquivo.toString() + ".png");  // append .xml if "foo.jpg.xml" is OK
                arquivo = new File(arquivo.getParentFile(), FilenameUtils.getBaseName(arquivo.getName()) + ".png"); // ALTERNATIVELY: remove the extension (if any) and replace it with ".xml"
                try {
                    ImageIO.write(imgComponente.getImagem(), "png", arquivo);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }

        }
    }

    private void btnFechar() {
        view.dispose();
    }

    private void filtroComboBox() {
        int escolha = view.getBuilderComboBox().getSelectedIndex();
        btnRestaurarPadrao();
        ImagemBuilder b = new ImagemBuilder(imgComponente);
        Diretor d = new Diretor(b);
        switch (escolha) {
            case 0: {
                try {
                    d.buildVerdeComBrilho();
                    this.imgComponente = b.getResultado();
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getImagemVerde().setSelected(true);
                    view.getImagemVerde().setEnabled(false);
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getBrilho().setSelected(true);
                    view.getBrilho().setEnabled(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 1: {
                try {
                    d.buildSepiaBrilhoEspelhada();
                    this.imgComponente = b.getResultado();
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getSepia().setSelected(true);
                    view.getSepia().setEnabled(false);
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getBrilho().setSelected(true);
                    view.getBrilho().setEnabled(false);
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getImagemEspelhada().setSelected(true);

                } catch (InterruptedException ex) {
                    Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 2: {
                try {
                    d.buildBlurPixelarNegativa();
                    this.imgComponente = b.getResultado();
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getBlur().setSelected(true);
                    view.getBlur().setEnabled(false);
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getPixelar().setSelected(true);
                    view.getPixelar().setEnabled(false);
                    Zelador.adicionarMemento(new MainViewMemento(view));
                    view.getNegativoImagem().setSelected(true);
                    view.getNegativoImagem().setEnabled(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
        try {
            atualizaImagem(imgComponente.getImagem());
        } catch (Exception ex) {
            Logger.getLogger(MainViewPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
