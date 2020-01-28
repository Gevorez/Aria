package wyklady;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class splash {
	  JFrame frame;//Creating object of JFrame
	  JLabel image=new JLabel(new ImageIcon("tlo.png"));
	  JLabel text=new JLabel("TUTORIALS FIELD");
	    JProgressBar progressBar=new JProgressBar();
	    JLabel message=new JLabel();//Crating a JLabel for displaying the message
	    splash()
	    {
	    	createGUI();
	        addImage();
	        
	       runningPBar();
	    }
	    public void createGUI(){
	        frame=new JFrame();
	        frame.getContentPane().setLayout(null);
	        frame.setUndecorated(true);
	        frame.setSize(600,300);
	        frame.setLocationRelativeTo(null);
	        frame.getContentPane().setBackground(Color.black);
	        frame.setVisible(true);

	    }
	    public void addImage(){
	        image.setSize(900,400);
	        frame.add(image);
	    }
	  
	    public void runningPBar(){
	        int i=0;//Creating an integer variable and intializing it to 0

	        while( i<=100)
	        {
	            try{
	                Thread.sleep(30);//Pausing execution for 50 milliseconds
	                progressBar.setValue(i);//Setting value of Progress Bar
	                message.setText("LOADING "+Integer.toString(i)+"%");//Setting text of the message JLabel
	                i+=2;
	                if(i==100)
	                    frame.dispose();
	            }catch(Exception e){
	                e.printStackTrace();
	            }



	        }
	    }
	}
