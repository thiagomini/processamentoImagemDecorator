package com.pss.imagem.processamento;

import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import com.pss.imagem.processamento.decorator.RotacionaDecorator;
import com.pss.imagem.processamento.decorator.SalvarImagemDecorator;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem.visualizar();

        imagem = new PixeladaDecorator(imagem, 5);
        imagem.visualizar();
        imagem = new SalvarImagemDecorator(imagem, "lenna-verde.jpg");

        imagem = new RotacionaDecorator(imagem, 180);
        imagem.visualizar();

        imagem = imagem.reverter();
        imagem.visualizar();

        /*       
        imagem = new EspelhadaDecorator(imagem);
        view = new VisualizagemImagem(imagem);
         */
    }

}
