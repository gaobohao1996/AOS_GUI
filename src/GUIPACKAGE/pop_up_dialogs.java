package GUIPACKAGE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pop_up_dialogs extends JFrame implements ActionListener
{
	JButton temp;
	JButton yes_button;
	JButton no_button;
	gui_learn father;
	JLabel ask_need_help;
	
	
	public pop_up_dialogs(gui_learn f)
	{
		ImageIcon icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		father = f;
		init();
	}
	
	public void init()
	{
		int width = father.getWidth();
		int height = (int)(father.getHeight()*1.2);
		int gap = width/6;
		int button_height = height/4;
		int button_width = width/4;
		int word = width/30;
		this.setSize(width,height);
		this.setTitle("Need any help ?");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		yes_button = new JButton("Yes Please");
		no_button = new JButton("No Thanks");
		
		yes_button.setBounds(gap,height/2, button_width, button_height);
		yes_button.setFont(new Font("Dialog",1,word));
		no_button.setBounds(width-gap-button_width,height/2,button_width,button_height );
		no_button.setFont(new Font("Dialog",1,word));
		
		yes_button.addActionListener(this);
		yes_button.addActionListener(father);
		no_button.addActionListener(this);
		no_button.addActionListener(father);
		
		ask_need_help = new JLabel("Do you need any help while setting the DN ?");
		ask_need_help.setFont(new Font("Dialog",0,word));
		ask_need_help.setBounds(gap, height/8, width-2*gap, word);
		
		this.add(ask_need_help);
		this.add(yes_button);
		this.add(no_button);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == no_button)
		{
			//pop_up_help h = new pop_up_help(father);
			this.dispose();
			//no_button.setBackground(Color.red);
		}
		else if (e.getSource() == yes_button)
		{
			this.dispose();
		}
	}

}
