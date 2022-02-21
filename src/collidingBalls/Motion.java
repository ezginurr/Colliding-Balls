package collidingBalls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Motion extends MotionControl implements ActionListener {    
    
    Timer timerMotion=new Timer(50,this);
    ArrayList<Ball> list= new ArrayList<Ball>();
    int time=0;
    
    public Motion(ArrayList<Ball> list){
    	super(list);
        this.list=list;
        timerMotion.start();
    }
    public void restartTimerM(){
        timerMotion.restart();
    }
    public void stopTimerM(){
        timerMotion.stop();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(time>=2000)
            collision();
        
        wallCollision();
        
        for(Ball ball: list){
            ball.setXY();  
        }
      
        for(Ball ball: list){
            ball.repaint();    
        }
        time+=50;
    }
}
