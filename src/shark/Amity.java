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
import java.awt.Font;
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
final class Amity extends Environment implements CellDataProviderIntf, MoveValidatorIntf {

    private Grid grid;
    private Jaws jaws;
    private ArrayList<Barrier> barriers;
    private ArrayList<Item> items;
    private GameState gamestate = GameState.PLAY;
    private Image drownee;

    public Amity() {

        this.setBackground(ResourceTools.loadImageFromResource("shark/backgroundshark.jpg").getScaledInstance(900, 600, Image.SCALE_SMOOTH));

        grid = new Grid(25, 20, 27, 27, new Point(80, 10), Color.black);

        jaws = new Jaws(Direction.RIGHT, grid, this);

        items = new ArrayList<>();
            for (int i = 0; i < 3; i++) {

                items.add(new Item(getRandomGridLocation(), Item.Item_Type_Drowning_Person, drownee, this));
        
            }
            
        
        
    }

    public int getRandom(int min, int max) {
        return (int) (min + (Math.random() * (max - min + 1)));
    }

    public Point getRandomGridLocation() {
        return new Point(getRandom(0, grid.getColumns() - 1), getRandom(0, grid.getRows() - 1));
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
            if (moveDelay >= moveDelayLimit) {
                jaws.move();
                moveDelay = 0;
            } else {
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

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            jaws.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            jaws.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            jaws.setDirection(Direction.DOWN);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jaws.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            jaws.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jaws.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jaws.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            gamestate = GameState.ENDED;
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
//            System.out.println("Go Up");
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            System.out.println("Go Left");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//            System.out.println("Go Down");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
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
//        if (grid != null) {
//            grid.paintComponent(graphics);
//        }
//        if (jaws != null) {
//            jaws.draw(graphics);
//        }
//        
//        if (barriers != null){
//            for (int i = 0; i < barriers.size(); i++) {
//                barriers.get(i).draw(graphics);
//            }
////            barriers.draw(graphics);
//        }
//        
        switch (gamestate) {
            case PLAY:
                if (grid != null) {
                    grid.paintComponent(graphics);
                }
                if (jaws != null) {
                    jaws.draw(graphics);
                }

                if (barriers != null) {
                    for (int i = 0; i < barriers.size(); i++) {
                        barriers.get(i).draw(graphics);
                    }

                    if (items != null) {
                        for (Item items : items) {

                        }
                    }

//            barriers.draw(graphics);
                }

                break;

            case ENDED:
                
                graphics.setFont(new Font("helvetica", Font.PLAIN, 40));
                graphics.drawString("GAME OVER", 330, 300);
                

        }

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

        if (jaws.selfHit()) {
            jaws.setAlive(false);
            gamestate = GameState.ENDED;
        }

        if (proposedLocation.x < 0) {
//            System.out.println("YOU CROSSED THE LINE"); 
            proposedLocation.x = grid.getColumns() - 1;
        } else if (proposedLocation.x > 24) {
//                System.out.println("YOU CROSSED THE LINE");
            proposedLocation.x = 0;
        } else if (proposedLocation.y < 0) {
//                System.out.println("YOU CROSSED THE LINE");
            proposedLocation.y = grid.getRows() - 1;
        } else if (proposedLocation.y > 19) {
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

    public Point checkIntersection(Point location) {
        if (items != null) {
            for (Item item : items) {
                if (item.getLocation().equals(location)) {
                    if (item.getType().equals(Item.Item_Type_Drowning_Person)) {
                        return location;
                    }
                    item.setLocation(getRandomGridLocation());
                }
            }
        }
        return location;
    }
}
