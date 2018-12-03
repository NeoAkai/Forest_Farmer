package model.GameObjects;

import model.framework.GraphicalObject;
import view.framework.DrawTool;

public class Cat extends GraphicalObject  {

    //Atribute
    private int width;
    private int heigth;
    private boolean moving = false;
    private double moveCounter = (int)(Math.random()*12 + 3);
    private int direction = 0;

    //Referenzen


    public Cat(double x, double y){
        this.x = x;
        this.y = y;
        createAndSetNewImage("assets/images/cat_black_down.png");


    }
    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(getMyImage(),x,y);
    }

    public void update(double dt){
        moveCounter = moveCounter - dt;
        if(moveCounter<=0){
            moveCounter = (int)(Math.random()*12 + 3);
            direction = (int)(Math.random()*4+1);
            if(direction==1)createAndSetNewImage("assets/images/cat_black_right.png");
            if(direction==2)createAndSetNewImage("assets/images/cat_black_down.png");
            if(direction==3)createAndSetNewImage("assets/images/cat_black_left.png");
            if(direction==4)createAndSetNewImage("assets/images/cat_black_up.png");

            moving = !moving;
        }
        if(moving){
            if(direction == 1){
                x = x + dt * 20;
            }
            if(direction == 2){
                y = y + dt * 20;
            }
            if(direction == 3){
                x = x - dt * 20;
            }
            if(direction == 4){
                y = y - dt * 20;
            }
            if(x<=150){
                direction=1;
                createAndSetNewImage("assets/images/cat_black_right.png");
            }
            if(x>=1225){
                direction=3;
                createAndSetNewImage("assets/images/cat_black_left.png");
            }
            if(y<=225){
                direction=2;
                if(direction==2)createAndSetNewImage("assets/images/cat_black_down.png");
            }
            if(y>=600){
                direction=4;
                createAndSetNewImage("assets/images/cat_black_up.png");
            }



        }
    }
}

