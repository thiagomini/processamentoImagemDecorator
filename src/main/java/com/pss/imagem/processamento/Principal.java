package com.pss.imagem.processamento;

import com.pss.imagem.processamento.decorator.GlowDecorator;
import com.pss.imagem.processamento.model.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.presenter.MainViewPresenter;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        new MainViewPresenter();
        
        //ImagemComponente imagem = new Imagem("lenna.jpg");
        //imagem.visualizar();
        
        //imagem = new BinarizationDecorator(imagem);
        //imagem = imagem.reverter();
        //imagem.visualizar();
        
        //imagem = new BlurDecorator(imagem, 15);
        //imagem.visualizar();
        
        //imagem = new GlowDecorator(imagem);
        //imagem.visualizar();
        
        //imagem = new BrilhoDecorator(imagem, 8);
        //imagem = imagem.reverter();
        //imagem.visualizar();
        
        //imagem = new EspelhadaDecorator(imagem);
        //imagem.visualizar();
        
        //imagem = new NegativaDecorator(imagem);
        //imagem.visualizar();

        //imagem = new PixeladaDecorator(imagem, 5);
        //imagem.visualizar();
        //imagem = new SalvarImagemDecorator(imagem, "lenna-verde.jpg");

        
        //imagem = new VermelhoDecorator(imagem);
        //imagem.visualizar();
        
        //imagem = new AzulDecorator(imagem);
        //imagem.visualizar();
        
        //imagem = new VerdeDecorator(imagem);
        //imagem.visualizar();
        
        //imagem = new RotacionaDecorator(imagem, 365);
        //imagem.visualizar();

        //imagem = imagem.reverter();
        //imagem.visualizar();

       // imagem = new SepiaDecorator(imagem);
       //imagem.visualizar();
       
       //imagem = new TomDeCinzaDecorator(imagem);
       //imagem.visualizar();
        
        
    }

}
