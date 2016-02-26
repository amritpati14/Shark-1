/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shark;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author keiran
 */
public class Barrier {
    
    public void draw(Graphics graphics){
        
        graphics.setColor(color);
//        Point topLeft = cellData.getSystemCoord(x, y);
//        graphics.fill3DRect(topLeft.x, topLeft.y, 
//                cellData.getCellWidth(), 
//                cellData.getCellHeight(), true);
        
    }
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Barrier(int x, int y, Color color, CellDataProviderIntf cellData){
        this.x = x;
        this.y = y;
        this.color = color;
        this.cellData = cellData;
    }
//</editor-fold>
    
    
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x, y;
    private Color color;
    private CellDataProviderIntf cellData;
    
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
//</editor-fold>
//</editor-fold>

           
    
    
    
    
    
    
    
}
