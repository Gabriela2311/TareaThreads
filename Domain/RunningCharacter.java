package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {
            try {
                //Controla las posiciones 
                int controlador = 0;
                //Controla las imagenes para que vayan cambiando
                int imagen = 0;

                for (int i = 0; i <= 800; i = i + 5) {
                    super.setImage(sprite.get(imagen));
                    super.setX(i);
                    Thread.sleep(25);
                    
                    //Si el controlador llega a 800, se aumenta en 25 para cambiar la imagen
                    if(i == controlador + 25){
                        imagen++;
                        controlador = i;
                }
                    //Si la imagen llega a siete vuelve a cero 
                    if(imagen == 7){
                        imagen =0;
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
