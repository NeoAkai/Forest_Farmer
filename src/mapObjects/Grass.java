package mapObjects;

import model.framework.GraphicalObject;
import view.framework.DrawTool;

public class Grass extends GraphicalObject  {

    //Atribute
    private int width;
    private int heigth;

    //Referenzen


    public Grass(double x, double y){
        this.x = x;
        this.y = y;
        createAndSetNewImage("assets/images/grass.png");

    }
    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(getMyImage(),x,y);
    }
}

