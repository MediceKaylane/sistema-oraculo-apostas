import javax.sound.sampled.*;
import java.io.File;

/**
 * Classe responsável por reproduzir música no sistema.
 */

public class Musica {
    
    /**
     * Método que toca uma música a partir de um caminho de arquivo.
     * A música é reproduzida em loop contínuo.
     * 
     * @param caminho caminho do arquivo de áudio (.wav recomendado)
     */

    public static void tocar(String caminho) {
        try {
            File musica = new File(caminho); //cria o objeto File 
            AudioInputStream audio = AudioSystem.getAudioInputStream(musica);
            
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            
            clip.loop(Clip.LOOP_CONTINUOUSLY); // fica em loop
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
