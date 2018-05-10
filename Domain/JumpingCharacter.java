package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }

    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        //Contador en la mayor posición 
        int contador = 372;
        while (true) {
            try {
                //Cuando llegue a la posicion inicial, La imagen esté en pie 
                if (contador == 372) {
                    super.setImage(sprite.get(2));
                    Thread.sleep(300);

                    //El contador se disminuye 
                    contador = 360;
                }

                //Si el contador está en la posición 360 que la imagen esté subiendo 
                if (contador == 360) {
                    super.setImage(sprite.get(0));
                    for (int i = 360; i >= 272; i = i - 4) {
                        Thread.sleep(27);
                        //La coordenada Y se coloca en la posición que recorre el for
                        this.setY(i);
                        //El contador sea 272 
                        contador = i;
                    }
                }
                //Si el contador está en la posición 272, la imagen sea la que esté cayendo
                if (contador == 272) {
                    super.setImage(sprite.get(1));
                    for (int i = 272; i <= 372; i = i + 4) {
                        Thread.sleep(27);
                        //La coordenada Y se coloca en la posición que recorre el for
                        this.setY(i);
                        //El contador vuelva a 372
                        contador = i;

                    }
                }

            } catch (InterruptedException ex) {
            }
        }
    }
}
