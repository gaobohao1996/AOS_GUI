package GUIPACKAGE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pop_up_help extends JFrame implements ActionListener{
	
	private JButton hide_help;
	private JTextArea ta;
	private JScrollPane jsp;
	private JPanel jp;
	
	public pop_up_help(gui_learn father)
	{
		ImageIcon icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		init(father);
	}
	
	public void init(gui_learn father)
	{
		this.setTitle("Help info");
		this.setLocationRelativeTo(father);
		this.setVisible(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int)(toolkit.getScreenSize().getWidth()/2);
		int height = (int)(toolkit.getScreenSize().getHeight()/2);
		this.setSize(width, height);
		
		ta = new JTextArea();
		jp = new JPanel();
		hide_help = new JButton("Hide Help");
		this.add(ta);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}

}
