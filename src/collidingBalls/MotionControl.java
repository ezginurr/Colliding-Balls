package collidingBalls;
import java.util.ArrayList;

public class MotionControl {

	ArrayList<Ball> list = new ArrayList<Ball>();
	
	public MotionControl(ArrayList<Ball> list) {
		this.list=list;
	}
	
	public void collision() {
        
		for(int i=0; i<list.size(); i++) {
			for(int k=0; k<list.size(); k++) {
				if(i!=k) {
					if(list.get(i).control(list.get(k))) {
						double distance=Math.sqrt(Math.pow(list.get(i).getX()-list.get(k).getX(), 2)+Math.pow(list.get(i).getY()-list.get(k).getY(),2));
						double overlap=(distance-list.get(i).getRadius()-list.get(k).getRadius())/2;
						
						list.get(i).setValueX((int)(list.get(i).getX()-(overlap*(list.get(i).getX()-list.get(k).getX())/distance)));
						list.get(i).setValueY((int)(list.get(i).getY()-(overlap*(list.get(i).getY()-list.get(k).getY())/distance)));
						
						list.get(k).setValueX((int)(list.get(k).getX()+(overlap*(list.get(k).getX()-list.get(i).getX())/distance)));
						list.get(k).setValueY((int)(list.get(k).getY()+(overlap*(list.get(k).getY()-list.get(i).getY())/distance)));
					
						double nx=(list.get(k).getX()-list.get(i).getX())/distance;
						double ny=(list.get(k).getY()-list.get(i).getY())/distance;
						
						double kx=(list.get(i).getX()-list.get(k).getX());
						double ky=(list.get(i).getY()-list.get(k).getY());
						double p=2*(nx*kx*+ny*ky)/(list.get(i).getRadius()+list.get(k).getRadius());
						
						
						list.get(i).setXx((int)(list.get(i).getXx()-p*list.get(i).getRadius()*nx));
						list.get(i).setYy((int)(list.get(i).getYy()-p*list.get(i).getRadius()*ny));

						list.get(k).setXx((int)(list.get(k).getXx()+p*list.get(k).getRadius()*nx));
						list.get(k).setYy((int)(list.get(k).getYy()+p*list.get(k).getRadius()*ny));
					
						if(list.get(i).getXx()>10)
							list.get(i).setXx(10);
						else if(list.get(i).getXx()<-10)
							list.get(i).setXx(-10);
						if(list.get(k).getXx()>10)
							list.get(k).setXx(10);
						else if(list.get(k).getXx()<-10)
							list.get(k).setXx(-10);
						
						if(list.get(i).getYy()>10)
							list.get(i).setYy(10);
						else if(list.get(i).getYy()<-10)
							list.get(i).setYy(-10);
						if(list.get(k).getYy()>10)
							list.get(k).setYy(10);
						else if(list.get(k).getYy()<-10)
							list.get(k).setYy(-10);
					}
				}
			}
		}
    }

    public void wallCollision() {
    	
         for(Ball ball : list){
        	if(ball.getX()-ball.getRadius()<=0 || ball.getX()+ball.getRadius()>=660)
        		ball.reverseX();
        	if(ball.getY()-ball.getRadius()<=0 || ball.getY()+ball.getRadius()>=640)
        		ball.reverseY();
        	
        }
    }

}
