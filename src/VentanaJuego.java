import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class VentanaJuego extends JFrame{

		private JPanel az;
		private JPanel za;
		private JButton ac;
		private JButton pa;
		private JButton izk;
		private JButton der;
		protected Coche lul;
		private boolean ar;
		
		public VentanaJuego() {
			
			ar = true;
			
			Container cp = this.getContentPane();
			
			az = new JPanel();
			az.setPreferredSize(new Dimension(750,750));
			az.setBackground(Color.black);
			za = new JPanel(new GridLayout(1,4));
			za.setPreferredSize(new Dimension(100,50));
			ac = new JButton("ac");
			pa = new JButton("pa");
			izk = new JButton("izk");
			der = new JButton("der");
		
			za.add(ac);
			za.add(pa);
			za.add(izk);
			za.add(der);
			
			cp.add(az, BorderLayout.NORTH);
			cp.add(za,BorderLayout.SOUTH);
			
			this.setResizable(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setTitle("Coche");
			this.pack();;
			this.setVisible(true);
			
			
			Thread acc = new Thread () {
				
				public void run() {
					
					
					int temp =0;
					double velu= 1;
					while(ar==true) {
						
						temp++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
						velu= velu*temp;
						if(velu<=24) {
						lul.setVel(velu);
						}
						
						System.out.println(lul);
						System.out.println(ar);
					}
					
					
					
					
				}
			
			};
			
			
			ac.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					acc.start();
					
					
				}
			});
			
			pa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (ar==true) {
						
						ar=false;
						
						
						
						
					}
					
					
				}
			});
			
			
		}
		
		
		
		
		
		
		
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			
			
			
			
	SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					VentanaJuego o = new VentanaJuego();
					o.lul = new Coche();
					o.lul.setPosx(150);
					o.lul.setPosy(100);
					System.out.println(o.lul);
				}
			});
			
			
		}
}
