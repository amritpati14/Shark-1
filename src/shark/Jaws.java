/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shark;

import grid.Grid;
//import images.ImageManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author keiran
 */
public class Jaws {
    
    
    public Jaws(Direction direction, Grid grid, MoveValidatorIntf validator){
        this.direction = direction;
        this.grid = grid;
        this.validator = validator;
      
        
        //create body
        body = new ArrayList<>();
        body.add(new Point(10, 9));
        body.add(new Point(9, 9));
        body.add(new Point(8, 9));
        body.add(new Point(8, 8));
        body.add(new Point(8, 7));
        body.add(new Point(8, 6));
        
        
        
        
//        ImageManager im = new ImageManager();
        
        
        
        
        
        
        
        
        
    }
    
    private Direction direction = Direction.RIGHT;
    private ArrayList<Point> body;
    private Grid grid;
    private Color bodyColor = Color.WHITE;
    private final MoveValidatorIntf validator;
    private static final int HEAD_POSITION = 0;
    public boolean selfHit;
    private boolean alive = true;
    private Point location;
    
    public void draw(Graphics graphics) {
        graphics.setColor(getBodyColor());
        for (int i = 0; i < getBody().size(); i++) {
//            System.out.println("Body Location Equals" + body.get(i).toString());
            graphics.fillOval(getGrid().getCellSystemCoordinate(getBody().get(i)).x, 
                    getGrid().getCellSystemCoordinate(getBody().get(i)).y, 
                    getGrid().getCellWidth(), 
                    getGrid().getCellHeight());
        }
        
    }
    
    public void move(){
//        make a copy of current head location
       Point newHead = new Point(getHead());
       
       if (getDirection() == Direction.RIGHT)
           newHead.x++;
       
       if (getDirection() == Direction.LEFT)
           newHead.x--;
       
       if (getDirection() == Direction.UP)
           newHead.y--;
       
       if (getDirection() == Direction.DOWN)
           newHead.y++;
       
       
//       add new head
        getBody().add(HEAD_POSITION, validator.validateMove(newHead));
        getBody().remove(getBody().size() - 1);
        
       
      
    }
    
    
    public boolean selfHit(){
        for (int i = 1; i < body.size(); i++) {
            if (getHead().equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    public Point getHead(){
        return getBody().get(0);
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * @return the bodyColor
     */
    public Color getBodyColor() {
        return bodyColor;
    }

    /**
     * @param bodyColor the bodyColor to set
     */
    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
            
    public Point getLocation() {
        return location;
    }
    
    public void setLocation() {
        this.location = location;
    }
    
}
