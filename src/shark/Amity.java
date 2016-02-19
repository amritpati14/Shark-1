/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shark;

import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author keiran
 */
class Amity extends Environment implements CellDataProviderIntf, MoveValidatorIntf{

    private Grid grid;
    private Jaws jaws;
    private ArrayList<Barrier> barriers;
    private ArrayList<Item> items;

    public Amity() {
        
        this.setBackground(ResourceTools.loadImageFromResource("shark/backgroundshark.jpg").getScaledInstance(900, 600, Image.SCALE_SMOOTH));
        
        grid = new Grid(25, 20, 27, 27, new Point (80, 10), Color.black);
        
        jaws = new Jaws(Direction.RIGHT, grid, this);
       
        items = new ArrayList<>();
//        items.add(new Item(4, 5, true, Item.Item_Type_Drowning_Person , this, this)); GIVE THIS IMAGE
         
//<editor-fold defaultstate="collapsed" desc="so many barriers">
//        barriers = new ArrayList<>();
//        barriers.add(new Barrier(0, 0, Color.magenta, this));
//        barriers.add(new Barrier(0, 1, Color.magenta, this));
//        barriers.add(new Barrier(0, 2, Color.magenta, this));
//        barriers.add(new Barrier(0, 3, Color.magenta, this));
//        barriers.add(new Barrier(0, 4, Color.magenta, this));
//        barriers.add(new Barrier(0, 5, Color.magenta, this));
//        barriers.add(new Barrier(0, 6, Color.magenta, this));
//        barriers.add(new Barrier(0, 7, Color.magenta, this));
//        barriers.add(new Barrier(0, 8, Color.magenta, this));
//        barriers.add(new Barrier(0, 9, Color.magenta, this));
//        barriers.add(new Barrier(0, 10, Color.magenta, this));
//        barriers.add(new Barrier(0, 11, Color.magenta, this));
//        barriers.add(new Barrier(0, 12, Color.magenta, this));
//        barriers.add(new Barrier(0, 13, Color.magenta, this));
//        barriers.add(new Barrier(0, 14, Color.magenta, this));
//        barriers.add(new Barrier(0, 15, Color.magenta, this));
//        barriers.add(new Barrier(0, 16, Color.magenta, this));
//        barriers.add(new Barrier(0, 17, Color.magenta, this));
//        barriers.add(new Barrier(0, 18, Color.magenta, this));
//        barriers.add(new Barrier(0, 19, Color.magenta, this));
//        barriers.add(new Barrier(1, 0, Color.magenta, this));
//        barriers.add(new Barrier(2, 0, Color.magenta, this));
//        barriers.add(new Barrier(3, 0, Color.magenta, this));
//        barriers.add(new Barrier(4, 0, Color.magenta, this));
//        barriers.add(new Barrier(5, 0, Color.magenta, this));
//        barriers.add(new Barrier(6, 0, Color.magenta, this));
//        barriers.add(new Barrier(7, 0, Color.magenta, this));
//        barriers.add(new Barrier(8, 0, Color.magenta, this));
//        barriers.add(new Barrier(9, 0, Color.magenta, this));
//        barriers.add(new Barrier(10, 0, Color.magenta, this));
//        barriers.add(new Barrier(11, 0, Color.magenta, this));
//        barriers.add(new Barrier(12, 0, Color.magenta, this));
//        barriers.add(new Barrier(13, 0, Color.magenta, this));
//        barriers.add(new Barrier(14, 0, Color.magenta, this));
//        barriers.add(new Barrier(15, 0, Color.magenta, this));
//        barriers.add(new Barrier(16, 0, Color.magenta, this));
//        barriers.add(new Barrier(17, 0, Color.magenta, this));
//        barriers.add(new Barrier(18, 0, Color.magenta, this));
//        barriers.add(new Barrier(19, 0, Color.magenta, this));
//        barriers.add(new Barrier(20, 0, Color.magenta, this));
//        barriers.add(new Barrier(21, 0, Color.magenta, this));
//        barriers.add(new Barrier(22, 0, Color.magenta, this));
//        barriers.add(new Barrier(23, 0, Color.magenta, this));
//        barriers.add(new Barrier(24, 0, Color.magenta, this));
//        barriers.add(new Barrier(24, 1, Color.magenta, this));
//        barriers.add(new Barrier(24, 2, Color.magenta, this));
//        barriers.add(new Barrier(24, 3, Color.magenta, this));
//        barriers.add(new Barrier(24, 4, Color.magenta, this));
//        barriers.add(new Barrier(24, 5, Color.magenta, this));
//        barriers.add(new Barrier(24, 6, Color.magenta, this));
//        barriers.add(new Barrier(24, 7, Color.magenta, this));
//        barriers.add(new Barrier(24, 8, Color.magenta, this));
//        barriers.add(new Barrier(24, 9, Color.magenta, this));
//        barriers.add(new Barrier(24, 10, Color.magenta, this));
//        barriers.add(new Barrier(24, 11, Color.magenta, this));
//        barriers.add(new Barrier(24, 12, Color.magenta, this));
//        barriers.add(new Barrier(24, 13, Color.magenta, this));
//        barriers.add(new Barrier(24, 14, Color.magenta, this));
//        barriers.add(new Barrier(24, 15, Color.magenta, this));
//        barriers.add(new Barrier(24, 16, Color.magenta, this));
//        barriers.add(new Barrier(24, 17, Color.magenta, this));
//        barriers.add(new Barrier(24, 18, Color.magenta, this));
//        barriers.add(new Barrier(24, 19, Color.magenta, this));
//        barriers.add(new Barrier(23, 19, Color.magenta, this));
//        barriers.add(new Barrier(22, 19, Color.magenta, this));
//        barriers.add(new Barrier(21, 19, Color.magenta, this));
//        barriers.add(new Barrier(20, 19, Color.magenta, this));
//        barriers.add(new Barrier(19, 19, Color.magenta, this));
//        barriers.add(new Barrier(18, 19, Color.magenta, this));
//        barriers.add(new Barrier(17, 19, Color.magenta, this));
//        barriers.add(new Barrier(16, 19, Color.magenta, this));
//        barriers.add(new Barrier(15, 19, Color.magenta, this));
//        barriers.add(new Barrier(14, 19, Color.magenta, this));
//        barriers.add(new Barrier(13, 19, Color.magenta, this));
//        barriers.add(new Barrier(12, 19, Color.magenta, this));
//        barriers.add(new Barrier(11, 19, Color.magenta, this));
//        barriers.add(new Barrier(10, 19, Color.magenta, this));
//        barriers.add(new Barrier(9, 19, Color.magenta, this));
//        barriers.add(new Barrier(8, 19, Color.magenta, this));
//        barriers.add(new Barrier(7, 19, Color.magenta, this));
//        barriers.add(new Barrier(6, 19, Color.magenta, this));
//        barriers.add(new Barrier(5, 19, Color.magenta, this));
//        barriers.add(new Barrier(4, 19, Color.magenta, this));
//        barriers.add(new Barrier(3, 19, Color.magenta, this));
//        barriers.add(new Barrier(2, 19, Color.magenta, this));
//        barriers.add(new Barrier(1, 19, Color.magenta, this));
//</editor-fold>
        
//        background =  ResourceTools.loadImageFromResource(backgroundshark.jpg);
    }

    @Override
    public void initializeEnvironment() {
    }
    
//    int counter;
    
    
    int moveDelay = 0;
    int moveDelayLimit = 5;

    @Override
    public void timerTaskHandler() {
//        System.out.println("Aidan is cool! " + ++counter );
        if (jaws != null) {
            if (moveDelay >= moveDelayLimit){
                jaws.move();
                moveDelay = 0;}
            else {
                moveDelay++;
            }
            
                    }
        
//        if (jaws.getHead = ()) {
//            
//        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        System.out.println("Key Event " + e.getKeyChar()); 
//        System.out.println("Key Event " + e.getKeyCode()); 
        if (e.getKeyCode() == KeyEvent.VK_A) {
            jaws.setDirection(Direction.LEFT);
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            jaws.setDirection(Direction.RIGHT);
        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            jaws.setDirection(Direction.UP);
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            jaws.setDirection(Direction.DOWN);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jaws.setDirection(Direction.LEFT);
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            jaws.setDirection(Direction.UP);
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jaws.setDirection(Direction.RIGHT);
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jaws.setDirection(Direction.DOWN);
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_D) {
         //Pause
        }
    }
        
        
        
        
        
        
    @Override
    public void keyReleasedHandler(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_W) {
//            System.out.println("Go Up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
//            System.out.println("Go Left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
//            System.out.println("Go Down");
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_D) {
//            System.out.println("Go Right");
        }
        
        
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
//        System.out.println("Mouse clicked at " + e.getPoint());
//        System.out.println("You are in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
        
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }
        if (jaws != null) {
            jaws.draw(graphics);
        }
        
        if (barriers != null){
            for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).draw(graphics);
            }
//            barriers.draw(graphics);
        }
        
//        graphics.drawImage(background, 0, 0, 100, 800, this);
        
    }

    //<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf">
    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }
    
    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }
    
    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }
    
    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MoveValidatorIntf">
    @Override
    public Point validateMove(Point proposedLocation) {
        
        if (proposedLocation.x < 0) {
//            System.out.println("YOU CROSSED THE LINE"); 
            proposedLocation.x = grid.getColumns() -1;
        }
        
            else if (proposedLocation.x > 24) {
//                System.out.println("YOU CROSSED THE LINE");
                proposedLocation.x = 0;
       }
            
         else if (proposedLocation.y < 0) {
//                System.out.println("YOU CROSSED THE LINE");
             proposedLocation.y = grid.getRows() - 1;
       }
         
          else if (proposedLocation.y > 19) {
//                System.out.println("YOU CROSSED THE LINE");
              proposedLocation.y = 0;
       }
            
//        if(proposedLocation.y < grid.getRows() / 2) {
//            proposedLocation.x++;
//            proposedLocation.y++;
//        }
//        if(proposedLocation.y > grid.getRows() / 2) {
//            proposedLocation.x++;
//            proposedLocation.y++;
//        }
        
        
        
        
        return proposedLocation;
    }
//</editor-fold>
    
}
