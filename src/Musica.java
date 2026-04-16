import javax.sound.sampled.*;
import java.io.File;

public class Musica {

    public static void tocar(String caminho) {
        try {
            File musica = new File(caminho);
            AudioInputStream audio = AudioSystem.getAudioInputStream(musica);
            
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            
            clip.loop(Clip.LOOP_CONTINUOUSLY); // 🔁 fica em loop
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}