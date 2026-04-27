import java.awt.*;
import javax.swing.*;

public class Background {
    public void gerarBack() {
        //Cria o JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Faz a janela maximizar para ocupar a tela toda
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        // Pega o tamanho da tela do computador
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraMonitor = tamanhoTela.width;
        int alturaMonitor = tamanhoTela.height;

        //Carrega a imagem original
        ImageIcon iconeOriginal = new ImageIcon("src/img/oraculo.jpeg");
        Image imagem = iconeOriginal.getImage();

        //Redimensiona a imagem para o tamanho exato da tela      
        Image imagemRedimensionada = imagem.getScaledInstance(larguraMonitor, alturaMonitor, Image.SCALE_SMOOTH);

        //Cria um novo ImageIcon com a imagem já no tamanho certo
        ImageIcon iconeTelaCheia = new ImageIcon(imagemRedimensionada);

        //Coloca no JLabel e adiciona à janela
        JLabel labelImagem = new JLabel(iconeTelaCheia);
        frame.add(labelImagem);

        //Deixa a janela visível
        frame.setVisible(true);
    }
}