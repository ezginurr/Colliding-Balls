package collidingBalls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class MouseMotion extends MotionControl implements ActionListener{         

    Timer timerMouseMotion=new Timer(50,this);
    
    ArrayList<Ball> list= new ArrayList<Ball>();
    
    ArrayList<Ball> mainList=new ArrayList<Ball>();
    
    public MouseMotion(ArrayList<Ball> list, ArrayList<Ball> mainList){
    	super(list);
        this.list=list;
        this.mainList=mainList;
        timerMouseMotion.start();
    }
    
    public void restartTimerMM(){
        timerMouseMotion.restart();
    }
    
    public void stopTimerMM(){
        timerMouseMotion.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	listControl();
    	
        collision();
        
        wallCollision();
        
        for(Ball ball: list) {
        	ball.setXY();
        }
        
        for(Ball ball : list){
            ball.repaint();           
        }
       
    }

    
    public void listControl() {
    	int size=list.size();
        for(int b=0; b<mainList.size(); b++) {
        	for(int a=0; a<size; a++) {
        		if(!list.contains(mainList.get(b))) {
        			if(mainList.get(b).control(list.get(a))) {
        				list.add(mainList.get(b));
        			}
        		}
        	}
        }
    }
    
    
}

