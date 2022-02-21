package collidingBalls;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Balls extends JPanel implements MouseMotionListener, MouseListener {  

    ArrayList<Ball> balls=new ArrayList<Ball>();
    ArrayList<Ball> mouseBalls=new ArrayList<Ball>();
    Ball mouseBall=new Ball();
    Motion motion;
    MouseMotion mouseMotion;
    int index;
    
    public Balls(int num){
        addMouseMotionListener(this);
        addMouseListener(this);
        this.setSize(700, 700);
        this.setLayout(new GridBagLayout());
        for(int i=1; i<num; i++){
        	Ball e=new Ball();
            balls.add(e);
            this.add(e);
        }
        index=-1;
        motion=new Motion(balls);
        mouseMotion=new MouseMotion(mouseBalls, balls);
        mouseMotion.stopTimerMM();
    }
    public Balls(){
        addMouseMotionListener(this);
        addMouseListener(this);
        this.setSize(700, 700);
        this.setLayout(new GridBagLayout());
        index=-1;
        motion=new Motion(balls);
        mouseMotion=new MouseMotion(mouseBalls, balls);
        mouseMotion.stopTimerMM();
    }
    public void addBall(Ball ball) {
    	balls.add(ball);
    	this.add(ball);
    }
	@Override
    public void mouseDragged(MouseEvent e) {
        int i=0;
        while(i<balls.size() && index==-1){
            if(balls.get(i).mouseControl(e.getX(), e.getY())){
                balls.get(i).setValueXY(e.getX()-balls.get(i).getRadius(),e.getY()-balls.get(i).getRadius());
                index=i;
                mouseBall=balls.get(i);
                balls.remove(i);
            }
            i++;
        }
        if(index!=-1){
            int k=0;
            while(k<balls.size()){
            	if(mouseBall.control(balls.get(k)) && !mouseBalls.contains(balls.get(k))){
            		mouseBalls.add(balls.get(k));
            	}
                k++;
            }
            mouseBall.setValueXY(e.getX()-mouseBall.getRadius(),e.getY()-mouseBall.getRadius());
            mouseBall.repaint();
        }
    }
    @Override
	public void mousePressed(MouseEvent e) {
    	motion.stopTimerM();       
        mouseMotion.restartTimerMM();
	}
    @Override
	public void mouseReleased(MouseEvent e) {
		mouseMotion.stopTimerMM();
        motion.restartTimerM();
        index=-1;
        balls.add(mouseBall);
        mouseBalls.clear();
	}


    @Override
    public void mouseMoved(MouseEvent e) {
    }

    
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

}