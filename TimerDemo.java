package GUI;

import java.util.Timer;
import java.util.TimerTask;

	public class TimerDemo  {  
		Timer timer = new Timer();  
		TimerDemo(int seconds)   {  
			//schedule the task  
			timer.schedule(new RemindTask(), seconds*1000);   
		}  
		class RemindTask extends TimerTask   {  
			public void run()   {  
				System.out.println("You have a notification!");  
				//terminate the timer thread  
				timer.cancel();   
			}  
		}  
		//driver code  
		public static void main(String args[])   {  
			//function calling      
			new TimerDemo(10);  
		}  
	}  
