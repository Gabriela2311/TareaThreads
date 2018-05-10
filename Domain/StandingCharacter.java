package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 4; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Standing" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {
            try {
                
                //Controla las imagenes para que vayan cambiando 
                int imagen = 0;
                
                for (int i = 0; i < 20; i = i + 5) {
                    super.setImage(sprite.get(imagen));
                    imagen++;
                    Thread.sleep(300);

                    //Si la imagen llega a tres vuelve a cero
                    if (imagen == 3) {
                        imagen = 0;

                    }
                    //Que tarde más con los ojos abiertos 
                    if (imagen == 1) {
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
