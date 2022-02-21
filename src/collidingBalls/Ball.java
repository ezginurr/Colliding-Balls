package collidingBalls;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Ball extends JPanel{
    private int x;
    private int y;
    private int xx;
    private int yy;
    private int radius;
    private int speed;
    private int angle;
    public Color c;
    BufferedImage b;
    
    public Ball(){
        radius=15;
        x=250;
        y=250;
        angle=(int)(Math.random()*360);
        speed=(int)(Math.random()*5);
        yy=(int)(Math.sin(angle)*speed);
        xx=(int)(Math.cos(angle)*speed);
        c=new Color((int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random()));
        this.setPreferredSize(new Dimension(radius*2, radius*2));
        b=new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics=b.createGraphics();
        graphics.setPaint(Color.black);
    }
    public Ball(int radius, int speed, Color c){
        this.radius=radius;
        x=250;
        y=250;
        angle=(int)(Math.random()*360);
        this.speed=speed;
        yy=(int)(Math.sin(angle)*speed);
        xx=(int)(Math.cos(angle)*speed);
        this.c=c;
        this.setPreferredSize(new Dimension(radius*2, radius*2));
        b=new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics=b.createGraphics();
        graphics.setPaint(Color.black);
    }
	public Ball(int radius, int speed){
        this.radius=radius;
        x=250;
        y=250;
        angle=(int)(Math.random()*360);
        this.speed=speed;
        yy=(int)(Math.sin(angle)*speed);
        xx=(int)(Math.cos(angle)*speed);
        this.c=Color.black;
        this.setPreferredSize(new Dimension(radius*2, radius*2));
        b=new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics=b.createGraphics();
        graphics.setPaint(Color.black);
    }
	public void painting(Graphics g) {
		    g.setColor(c);
		    g.fillOval(0,0, radius*2, radius*2);
	}
    @Override
    public void paint(Graphics g) {
        super.paint(g); 

        this.setLocation(x-radius, y-radius);
        painting(b.getGraphics());
        g.drawImage(b, 0, 0, null);
        
        //g.setColor(Color.BLACK);
        //g.fillOval(0, 0, radius*2, radius*2);
    }
    @Override
    public void repaint() {
        super.repaint();
    }
    
    public int getRadius(){
        return radius;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSpeed() {
        return speed;
    }
    public int getAngle() {
        return angle;
    }
    public int getXx() {
        return xx;
    }
    public int getYy() {
        return yy;
    }
    public void reverseY(){  
        yy=-yy;
    }
    public void reverseX(){   
        xx=-xx;
    }
    public void setValueXY(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void setValueX(int x){
        this.x=x;
    }
    public void setValueY(int y){
        this.y=y;
    }
    public void setXx(int xx) {
        this.xx = xx;
    }
    public void setYy(int yy) {
        this.yy = yy;
    }
    public void reverseYX(){  
        xx=-xx;
        yy=-yy;
    }
    public void setXY(){
        x+=xx;
        y+=yy;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public boolean control(Ball a){
        if(Math.sqrt(Math.pow(x-a.x, 2)+Math.pow(y-a.y, 2))<=radius+a.radius){   
            if(Math.sqrt(Math.pow(x-a.x, 2)+Math.pow(y-a.y, 2))==0) {
                x+=3;
            }
            return true;
        }
        return false;
    }
    public boolean mouseControl(int xM, int yM){
        if(Math.sqrt(Math.pow(x-xM, 2)+Math.pow(y-yM, 2))<=radius){
            return true;
        }
        return false;
    }
}

