package resources;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlWindow {
	
	private JFrame f;
	private JPanel p;
	
	public ControlWindow() {
		
		f = new JFrame("Control Window");
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		p = new JPanel();
		f.add(p);
		
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public void add(Component comp) {
		
		p.add(comp);
		f.pack();
	}
}