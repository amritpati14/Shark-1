/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shark;

import images.ResourceTools;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author keiran
 */
public class Item {

     public Item(Point location, String type, Image image, CellDataProviderIntf cellData){
    this.x = location.x;
    this.y = location.y;
    this.type = type;
    this.image = image;
    this.cellData = cellData;
     }

    
//    public void draw(Graphics graphics){
//       graphics.drawImage(),
//        getCellData().getSystemCoordX(getX, getY()),
//    }
    private void setImage(String type) {
        switch (type) {
            case Item.Item_Type_Drowning_Person:
                image = ResourceTools.loadImageFromResource("shark/Drownee1.png");
                break;
        }
    }
    
    
    
    
    
   
    
    
    
    
    
//<editor-fold defaultstate="collapsed" desc="Properties">
   public static final String Item_Type_Drowning_Person = "DROWNEE";
    public static final String Item_Type_Boat = "BOAT";
    
    
    private int x, y;
    private String type;
    private Image image;
    private final CellDataProviderIntf cellData;

//    Item(int i, int i0, boolean b, String Item_Type_Drowning_Person, Amity aThis, Amity aThis0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
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
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    
    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    /**
     * @return the cellData
     */
    public CellDataProviderIntf getCellData() {
        return cellData;
    }
    
    public Point getLocation(){
        return new Point(x,y);
    }
    
    public void setLocation(Point location){
        this.x = location.x;
        this.y = location.y;
    }
    
//</editor-fold>

}
