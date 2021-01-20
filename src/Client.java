import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.Timer;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Client extends JFrame {

	JPanel p1,p2; 
	JTextField t1;
	//JButton b1;
	static JPanel a1;
	
	static Box vertical = Box.createVerticalBox();
	static JFrame f1 = new JFrame();
	
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Boolean typing;
	
	Client(){
		f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 40, 450, 70);
		f1.add(p1);
		
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(7, 75, 80));
		p2.setBounds(0, 0, 450, 40);
		f1.add(p2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5, 17, 30, 30);
		p1.add(l1);
		l1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
		Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40, 5, 60, 60);
		p1.add(l2);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel l5 = new JLabel(i9);
		l5.setBounds(310, 20, 30, 30);
		p1.add(l5);
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icons/phone.png"));
		Image i12 = i11.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon(i12);
		JLabel l6 = new JLabel(i13);
		l6.setBounds(360, 20, 30, 30);
		p1.add(l6);
		
		ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("Icons/3icon.png"));
		Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
		ImageIcon i16 = new ImageIcon(i15);
		JLabel l7 = new JLabel(i16);
		l7.setBounds(410, 22, 13, 25);
		p1.add(l7);
		
		JLabel l3 = new JLabel("TEAM MEMB");
		l3.setFont(new Font("SAN_SERIT", Font.BOLD, 16));
		l3.setForeground(Color.white);
		l3.setBounds(110, 15, 140, 20);
		p1.add(l3);
		
		JLabel l4 = new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIT", Font.PLAIN, 12));
		l4.setForeground(Color.white);
		l4.setBounds(110, 35, 100, 20);
		p1.add(l4);
		
		Timer t = new Timer(1, new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		    	if(!typing) {
		    		l4.setText("Active Now");
		    		
		    	}
		    }
		});
		
		t.setInitialDelay(2000);
		
		JLabel l15 = new JLabel("JAVA PRO CHAT");
		l15.setFont(new Font("SAN_SERIT", Font.BOLD, 18));
		l15.setForeground(Color.white);
		l15.setBounds(150, 1, 150, 30);
		p2.add(l15);
		
		a1 = new JPanel();
		a1.setBounds(3, 113, 442, 543);
		//a1.setBackground(Color.BLUE);
		a1.setFont(new Font("SAN_SERIT", Font.PLAIN,16));
		f1.add(a1);
		
		
		t1= new JTextField();
		t1.setBounds(3,660,400,40);
		t1.setFont(new Font("SAN_SERIT", Font.PLAIN, 16));
		f1.add(t1);
		
		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				l4.setText("Typing...");
				
				t.stop();
				
				typing = true;
			}
			
			public void keyReleased(KeyEvent ke) {
				typing = false;
				
				if(!t.isRunning()) {
					t.start();
				}
			}
		});
		
	       /*b1 = new JButton("Send");
	       b1.setBounds(320, 655, 123, 40);
	       b1.setBackground(new Color(7, 94, 84));
	       b1.setForeground(Color.WHITE);
	       b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
	       b1.addActionListener(this);
	       f1.add(b1);*/
	       
	       ImageIcon i17 = new ImageIcon(ClassLoader.getSystemResource("Icons/send.png"));
		   Image i18 = i17.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		   ImageIcon i19 = new ImageIcon(i18);
		   JLabel l8 = new JLabel(i19);
		   l8.setBounds(365, 660, 123, 40);
		   f1.add(l8);
			l8.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent ae) {
					try {
					  String out = t1.getText();
		
					  JPanel p3 = formatLabel(out);
					
					  a1.setLayout(new BorderLayout());
					
					  JPanel right = new JPanel(new BorderLayout());
					  right.add(p3, BorderLayout.LINE_END);
					  vertical.add(right);
					  vertical.add(Box.createVerticalStrut(10));//DISTANCE BETWEEN TwO MSGS
					
					  a1.add(vertical, BorderLayout.PAGE_START);
					  dout.writeUTF(out);
					  t1.setText("");
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
			});
	        
	       f1.getContentPane().setBackground(Color.WHITE);
	       f1.setLayout(null);
	       f1.setSize(450, 700);
	       f1.setLocation(1100, 200); 
	       f1.setUndecorated(true);
	       f1.setVisible(true);
	        
	    }
	    
	   /* public void actionPerformed(ActionEvent ae){
	        try{
	            String out = t1.getText();
	            
	            JPanel p2 = formatLabel(out);
	            
	            a1.setLayout(new BorderLayout());
	            
	            JPanel right = new JPanel(new BorderLayout());
	            right.add(p2, BorderLayout.LINE_END);
	            vertical.add(right);
	            vertical.add(Box.createVerticalStrut(15));
	            
	            a1.add(vertical, BorderLayout.PAGE_START);
	            
	            //a1.add(p2);
	            dout.writeUTF(out);
	            t1.setText("");
	        }catch(Exception e){
	            System.out.println(e);
	        }
	    }*/
	    
	    public static JPanel formatLabel(String out){
	        JPanel p4 = new JPanel();
	        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
	        
	        JLabel l9 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
	        l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        l9.setBackground(new Color(37, 211, 102));
	        l9.setOpaque(true);
	        l9.setBorder(new EmptyBorder(15,15,15,50));
	        
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	        
	        JLabel l10 = new JLabel();
	        l10.setText(sdf.format(cal.getTime()));
	        
	        p4.add(l9);
	        p4.add(l10);
	        return p4;
	    }
	    
	
 public static void main(String [] args) {
	 new Client().setVisible(true);
	 String msginput = " ";
	 
	 try {
		 s = new Socket("127.0.0.1", 6001);
		 din = new DataInputStream(s.getInputStream());
		 dout = new DataOutputStream(s.getOutputStream());
		 
		 while(true) {
			    a1.setLayout(new BorderLayout());
			    msginput = din.readUTF() ;
			    JPanel p3 = formatLabel(msginput);
			    JPanel left = new JPanel(new BorderLayout());
                left.add(p3, BorderLayout.LINE_START);
			    
			    vertical.add(left);
			    vertical.add(Box.createVerticalStrut(15));
	            a1.add(vertical, BorderLayout.PAGE_START);;
	            f1.validate();//after appending the panel we have to show also
			 }
		 
	    
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	
  }
}
