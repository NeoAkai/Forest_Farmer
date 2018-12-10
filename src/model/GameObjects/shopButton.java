package model.GameObjects;

import control.ProgramController;
import model.framework.GraphicalObject;
import view.framework.DrawTool;

import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class shopButton extends GraphicalObject {

    //Atribute
    private int width = 150;
    private int heigth = 150;
    private BufferedImage xImage;

    private boolean klicked = false;
    private boolean visible = true, active;

    //Referenzen

    private ProgramController pc;


    public shopButton(double x, double y, ProgramController pc) {
        this.x = x;
        this.y = y;
        this.pc = pc;

        createAndSetNewImage("assets/images/shopButton.png");
        try{
            xImage = ImageIO.read(new File("assets/images/ix.png"));
        }catch(Exception e){

        }
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        if(visible)drawTool.drawImage(getMyImage(), x, y);
        else{
            drawTool.drawImage(xImage,1070, 590);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (!klicked) {
            if (visible) {
                if (e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + heigth) {
                    pc.removeButtons(false,0,0);
                }
            }else{

            }
        }
        klicked = !klicked;
    }
    public void setVisibility(boolean b){
        visible = b;

    }
}


