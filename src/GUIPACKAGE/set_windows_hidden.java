package GUIPACKAGE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class set_windows_hidden extends JFrame implements ActionListener
{
	String setting_name;
	//String setting_file_name;
	//String setting_file_address;
	
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
	
	JTextField name_field;
	JTextField address_field;
	
	List<JTextField> neuron_info;
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
	public set_windows_hidden(String name,gui_learn f)
	{
		setting_name = name;
		father = f;
		ImageIcon icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		init();
	}
	
	public void init()
	{
		this.setTitle(setting_name + " Setting Hidden Layer");
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
		content.setBackground(new Color(255,128,128));
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
		
		intro_sensor = new JLabel("This is the step to setting the Hidden Layers of " + setting_name);
		intro_sensor.setFont(new Font("Dialog",0,word));
		intro_sensor.setBounds(small_gap, big_gap/2, width-2*small_gap, word+4);
		this.add(intro_sensor,BorderLayout.NORTH);
		intro_sensor.setPreferredSize(new Dimension(0,small_gap));
		
		
		neuron_info = new ArrayList<JTextField>();
		topk_info = new ArrayList<JTextField>();
		
		info = father.all_info.get("hidden");
		
		int count = 1;
		for(List<Integer> s : info)
		{
			add_a_line(count,s.get(0),s.get(1));
			count += 1;
		}
		
		default_layer_num = count-1;
		init_lower(count-1);
		/**
		add_a_line(2,2,3);
		add_a_line(3,4,5);
		add_a_line(4,5,6);
		add_a_line(5,2,3);
		add_a_line(6,4,5);
		add_a_line(7,5,6);
		add_a_line(8,2,3);
		add_a_line(9,4,5);
		add_a_line(10,5,6);
		add_a_line(11,2,3);
		add_a_line(12,4,5);
		add_a_line(13,5,6);
		*/
		
		
		
	}
	
	public void init_lower(int default_num)
	{
		FlowLayout f = new FlowLayout(FlowLayout.CENTER,mini_gap,mini_gap);
		lower.setLayout(f);
		
		num_of_layers = new JLabel("Number of layers: ");
		JLabel file_name = new JLabel("Setting File Name: ");
		JLabel file_address = new JLabel("Setting File Address: ");
		
		num_of_layers.setFont(new Font("Dialog",0,word));
		file_name.setFont(new Font("Dialog",0,word));
		file_address.setFont(new Font("Dialog",0,word));
		
		num_field = new JTextField(String.valueOf(default_num));
		name_field = new JTextField();
		address_field = new JTextField();
		
		num_field.setFont(new Font("Dialog",0,word));
		name_field.setFont(new Font("Dialog",0,word));
		address_field.setFont(new Font("Dialog",0,word));
		
		confirm = new JButton("Confirm");
		next = new JButton("Next/Done");
		finish = new JButton("Finish");
		
		num_of_layers.setPreferredSize(new Dimension(big_gap*2,word+4));
		num_field.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		confirm.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		next.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		finish.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		file_name.setPreferredSize(new Dimension(big_gap+2*small_gap,word+4));
		name_field.setPreferredSize(new Dimension(big_gap+small_gap,word+4));
		file_address.setPreferredSize(new Dimension(big_gap+2*small_gap+mini_gap,word+4));
		address_field.setPreferredSize(new Dimension(big_gap*3,word+4));
		
		confirm.addActionListener(this);
		next.addActionListener(this);
		finish.addActionListener(this);
		next.addActionListener(father);
		
		confirm.setFont(new Font("Dialog",0,word));
		next.setFont(new Font("Dialog",0,word));
		finish.setFont(new Font("Dialog",0,word));
		
		lower.add(num_of_layers);
		lower.add(num_field);
		lower.add(confirm);
		lower.add(finish);
		lower.add(next);
		lower.add(file_name);
		lower.add(name_field);
		lower.add(file_address);
		lower.add(address_field);
		
	}
	
	
	public void add_a_line(int num, int h, int w)
	{
		JPanel a_line = new JPanel();
		GridLayout grid = new GridLayout(1,4);
		a_line.setLayout(grid);
		
		JTextField heightfield = new JTextField(String.valueOf(h));
		heightfield.setFont(new Font("Dialog",0,word));
		JTextField widthfield = new JTextField(String.valueOf(w));
		widthfield.setFont(new Font("Dialog",0,word));
		JLabel heightlabel = new JLabel("Neurons " + String.valueOf(num));
		heightlabel.setFont(new Font("Dialog",0,word));
		JLabel widthlabel = new JLabel("Top K " + String.valueOf(num));
		widthlabel.setFont(new Font("Dialog",0,word));
		a_line.add(heightlabel);
		a_line.add(heightfield);
		a_line.add(widthlabel);
		a_line.add(widthfield);
		a_line.setBounds(small_gap, num*small_gap, width-2*small_gap, word+4);
		content.add(a_line);
		now_height += (small_gap);
		total_lines += 1;
		
		neuron_info.add(heightfield);
		topk_info.add(widthfield);
		
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
			add_a_line(total_lines+1,2,3);
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
					add_a_line(start,0,0);
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
			int total = neuron_info.size();
			List<List<Integer>> sensor_list = new ArrayList<List<Integer>>();
			while(count < total)
			{
				int h = Integer.valueOf( neuron_info.get(count).getText() );
				int w = Integer.valueOf( topk_info.get(count).getText() );
				
				neuron_info.get(count).setEditable(false);
				topk_info.get(count).setEditable(false);
				
				if (h == 0 && w == 0)
				{
					count += 1;
					continue;
				}
				List<Integer> one_layer = new ArrayList<Integer>();
				one_layer.add(h);
				one_layer.add(w);
				sensor_list.add(one_layer);
				//System.out.println(h + " " + w);
				
				count += 1;
			}
			
			father.all_info.put("hidden", sensor_list);
			
			finish.setBackground(Color.red);
			finish.setText("Finished");
			finish.setEnabled(false);
			
			
		}
		else if (e.getSource() == next)
		{
			this.dispose();
		}
	}

}

