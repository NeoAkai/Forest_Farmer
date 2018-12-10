package model.GameObjects;

import control.ProgramController;
import model.framework.GraphicalObject;
import view.framework.DrawTool;

import java.awt.*;
import java.awt.event.MouseEvent;

public class XButton extends GraphicalObject {

    private ProgramController pc;
    private boolean klicked, visible;

    public XButton(double x, double y, ProgramController pc){
        this.x = x;
        this.y = y;
        this.pc = pc;
        createAndSetNewImage("assets/images/ix.png");
        visible = false;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(visible) drawTool.drawImage(getMyImage(),x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(klicked){
            if(visible){
                if(new Rectangle(((int)x),((int)y),((int)width),((int)height)).contains(e.getPoint())){
                    pc.removeButtons(true,0,0);
                }
            }
        }
        klicked =! klicked;
    }

    public void setVisible(boolean b){
        visible = b;
    }
}
