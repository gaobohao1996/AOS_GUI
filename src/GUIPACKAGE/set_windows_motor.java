package GUIPACKAGE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class set_windows_motor extends JFrame implements ActionListener
{
	String setting_name;
	//Map all_info = new HashMap();
	gui_learn father;
	//JPanel bottom_buttons;
	//JButton previous;
	JButton next;
	JButton finish;
	JTabbedPane tb;
	JButton add_one;
	JLabel intro_sensor;
	JLabel num_of_layers;
	List<List<Integer>> info;
	JPanel upper;
	JPanel lower;
	JPanel content;
	JButton confirm;
	JTextField num_field;
	
	List<JTextField> height_info;
	List<JTextField> width_info;
	List<JTextField> topk_info;
	
	int default_layer_num  =0;
	int width;
	int height;
	int big_gap;
	int small_gap;
	int mini_gap;
	int word;
	int content_now_width;
	int content_now_height;
	int now_height = 0;
	int now_width = 0;
	int total_lines = 0;
	public set_windows_motor(String name,gui_learn f)
	{
		setting_name = name;
		father = f;
		ImageIcon icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		init();
	}
	
	public void init()
	{
		this.setTitle(setting_name + " Setting Motor Layer");
		this.setLocationRelativeTo(father);
		
		BorderLayout border = new BorderLayout();
		this.setLayout(border);
		
		this.setVisible(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		width = (int)(toolkit.getScreenSize().getWidth()/2);
		height = (int)(toolkit.getScreenSize().getHeight()/2);
		big_gap = height/5;
		small_gap = big_gap/3;
		mini_gap = small_gap/2;
		word = width/50;
		
		
		upper = new JPanel();
		lower = new JPanel();
		content = new JPanel();
		upper.setLayout(new BorderLayout());
		upper.setBounds(mini_gap,small_gap*2+mini_gap,width-mini_gap,height-2*big_gap);
		upper.setBackground(Color.red);
		lower.setBounds(0,height*4/5,width,big_gap);
		lower.setBackground(Color.LIGHT_GRAY);
		content.setBackground(new Color(176,224,230));
		content.setLayout(null);
		this.add(upper,BorderLayout.CENTER);
		
		upper.setPreferredSize(new Dimension(0,height-2*big_gap-small_gap));
		content.setPreferredSize(new Dimension(width,height));
		//upper.setMaximumSize(new Dimension(0,height-2*big_gap-small_gap));
		//upper.add(content);
		this.add(lower,BorderLayout.SOUTH);
		lower.setPreferredSize(new Dimension(0,big_gap));
		
		this.setSize(width,height);
		//this.setResizable(false);
		
		
		JScrollPane jsp = new JScrollPane();
		upper.add(jsp,BorderLayout.CENTER);
		jsp.setViewportView(content);
		
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //jsp.setPreferredSize(new Dimension(width/10,0));
		
		intro_sensor = new JLabel("This is the step to setting the Motor Layers of " + setting_name);
		intro_sensor.setFont(new Font("Dialog",0,word));
		intro_sensor.setBounds(small_gap, big_gap/2, width-2*small_gap, word+4);
		this.add(intro_sensor,BorderLayout.NORTH);
		intro_sensor.setPreferredSize(new Dimension(0,small_gap));
		
		
		height_info = new ArrayList<JTextField>();
		width_info = new ArrayList<JTextField>();
		topk_info = new ArrayList<JTextField>();
		
		info = father.all_info.get("motor");
		
		int count = 1;
		for(List<Integer> s : info)
		{
			add_a_line(count,s.get(0),s.get(1),s.get(2));
			//System.out.println(count);
			count += 1;
		}
		
		default_layer_num = count-1;
		init_lower(count-1);
		
		
		
	}
	
	public void init_lower(int default_num)
	{
		FlowLayout f = new FlowLayout(FlowLayout.CENTER,mini_gap,2*mini_gap);
		lower.setLayout(f);
		
		num_of_layers = new JLabel("Number of layers: ");
		num_of_layers.setFont(new Font("Dialog",0,word));
		num_field = new JTextField(String.valueOf(default_num));
		num_field.setFont(new Font("Dialog",0,word));
		confirm = new JButton("Confirm");
		//next = new JButton("Next");
		finish = new JButton("Finish/Next");
		
		num_of_layers.setPreferredSize(new Dimension(big_gap*2,word+4));
		num_field.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		confirm.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		//next.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		finish.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		
		confirm.addActionListener(this);
		//next.addActionListener(this);
		finish.addActionListener(this);
		finish.addActionListener(father);
		
		confirm.setFont(new Font("Dialog",0,word));
		finish.setFont(new Font("Dialog",0,word));
		//next.setFont(new Font("Dialog",0,word));
		
		lower.add(num_of_layers);
		lower.add(num_field);
		lower.add(confirm);
		lower.add(finish);
		//lower.add(next);
		
	}
	
	
	public void add_a_line(int num, int h, int w, int k)
	{
		JPanel a_line = new JPanel();
		GridLayout grid = new GridLayout(1,6);
		a_line.setLayout(grid);
		
		String num_str = String.valueOf(num);
		
		JTextField heightfield = new JTextField(String.valueOf(h));
		heightfield.setFont(new Font("Dialog",0,word));
		JTextField widthfield = new JTextField(String.valueOf(w));
		widthfield.setFont(new Font("Dialog",0,word));
		JTextField topkfield = new JTextField(String.valueOf(k));
		topkfield.setFont(new Font("Dialog",0,word));
		
		JLabel heightlabel = new JLabel("Height " + num_str);
		heightlabel.setFont(new Font("Dialog",0,word));
		JLabel widthlabel = new JLabel("Width " + num_str);
		widthlabel.setFont(new Font("Dialog",0,word));
		JLabel topklabel = new JLabel("Top K " + num_str);
		topklabel.setFont(new Font("Dialog",0,word));
		
		
		a_line.add(heightlabel);
		a_line.add(heightfield);
		a_line.add(widthlabel);
		a_line.add(widthfield);
		a_line.add(topklabel);
		a_line.add(topkfield);
		a_line.setBounds(small_gap, num*small_gap, width-2*small_gap, word+4);
		
		content.add(a_line);
		now_height += (small_gap);
		total_lines += 1;
		
		
		height_info.add(heightfield);
		width_info.add(widthfield);
		topk_info.add(topkfield);
		
		if (now_height > height)
		{
			content.setPreferredSize(new Dimension(width,now_height));
		}
		
		this.validate();
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == add_one)
		{
			//pop_up_help h = new pop_up_help(father);
			//add_a_line(total_lines+1,2,3);
			//no_button.setBackground(Color.red);
		}
		else if (e.getSource() == confirm)
		{
			String s = num_field.getText();
			int num = Integer.parseInt(s);
			if (num > default_layer_num)
			{
				int start = default_layer_num + 1;
				while(start <= num)
				{
					add_a_line(start,0,0,0);
					start += 1;
				}
			}
			else
			{
				//num = default_layer_num;
			}
			confirm.setBackground(Color.red);
			confirm.setText("Confirmed");
			confirm.setEnabled(false);
			num_field.setText(String.valueOf(num) + " .Cannot Edit");
			num_field.setEditable(false);
		}
		
		else if (e.getSource() == finish)
		{
			
			int count = 0;
			int total = height_info.size();
			List<List<Integer>> sensor_list = new ArrayList<List<Integer>>();
			while(count < total)
			{
				int h = Integer.valueOf( height_info.get(count).getText() );
				int w = Integer.valueOf( width_info.get(count).getText() );
				int k = Integer.valueOf( topk_info.get(count).getText() );
				
				height_info.get(count).setEditable(false);
				width_info.get(count).setEditable(false);
				topk_info.get(count).setEditable(false);
				
				if (h == 0 && w == 0)
				{
					count += 1;
					continue;
				}
				List<Integer> one_layer = new ArrayList<Integer>();
				one_layer.add(h);
				one_layer.add(w);
				one_layer.add(k);
				
				sensor_list.add(one_layer);
				//System.out.println(h + " " + w);
				
				
				count += 1;
			}
			
			father.all_info.put("motor", sensor_list);
			
			finish.setBackground(Color.red);
			finish.setText("Finished");
			finish.setEnabled(false);
			this.dispose();
				
		}
		/**
		else if(e.getSource() == next)
		{
			this.dispose();
		}
		*/
	}

}
