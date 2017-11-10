package GUIPACKAGE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
//import pop_up_help;
// Test Comment
public class gui_learn extends JFrame implements ActionListener{
	//public static MyWindowDemo mw1;
	//public static MyWindowDemo mw2;
	
	//The buttons and panels,layouts for actionevent
	JButton j_first;
	JButton j_previous;
	JButton j_next;
	JButton j_last;
	JPanel j_middle;
	CardLayout card;
	JMenuItem item100;
	pop_up_help help_frame;
	pop_up_dialogs n;
	set_windows_sensor set_sensor;
	set_windows_motor set_motor;
	set_windows_hidden set_hidden;
	set_data_address_window set_data_address;
	JMenuItem item1;
	JMenuItem item2;
	Map<String,List<List<Integer>>> all_info = new HashMap<String,List<List<Integer>>>();
	//Done for here
	//This line for test
	
	
	public static void main(String args[]){
		
		gui_learn demo = new gui_learn();
		
	}
	
	public gui_learn() {
		//init();
		int i = test_1();
		//this.setSize(1000,120);
		this.setVisible(true);
		Object[] options = {"Yes please", "No thanks"};
		JOptionPane jp = new JOptionPane();
		jp.setSize(1000, 150);
		jp.setVisible(true);
		ImageIcon icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("GENISAMA.png");
		
		//Toolkit toolkit = Toolkit.getDefaultToolkit();
		//int target_width = toolkit.
		this.setSize(img.getIconWidth(), img.getIconHeight()+80);
		this.setResizable(false);
		JLabel j1 = new JLabel();
		
		j1.setSize(img.getIconWidth(),img.getIconHeight());
		j1.setIcon(img);
		//j2.add(j1);
		this.getContentPane().add(j1);
		
		//int n = jp.showOptionDialog(null, "Do you need any help when setting?","Need any help?",jp.YES_NO_OPTION,jp.QUESTION_MESSAGE,null,options,options[0]);
		n = new pop_up_dialogs(this);
	}
	
	public int test_1() {
		//JButton j1 = new JButton("");
		JMenuBar menuBar = new JMenuBar();
		//Create the menuBar at the top of the screen.
		this.setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Menu(M)");
		JMenu menu2 = new JMenu("Type(T)");
		JMenu menu3 = new JMenu("File(F)");
		JMenu menu4 = new JMenu("Modality(D)");
		JMenu menu5 = new JMenu("Help");
		
		menu1.setMnemonic('M');
		menu2.setMnemonic('T');
		menu3.setMnemonic('F');
		menu4.setMnemonic('D');
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);
		
		item1 = new JMenuItem("DN 1");
		item2 = new JMenuItem("DN 2");
		menu2.add(item1);
		menu2.add(item2);
		
		JMenuItem item3 = new JMenuItem("Save Settings");
		JMenuItem item4 = new JMenuItem("Load Network");
		JMenuItem item5 = new JMenuItem("Create a new DN");
		JMenuItem item6 = new JMenuItem("Save DN");
		menu3.add(item3);
		menu3.add(item4);
		menu3.add(item5);
		menu3.add(item6);
		
		JMenuItem item7 = new JMenuItem("Vision");
		JMenuItem item8= new JMenuItem("Language");
		JMenuItem item9 = new JMenuItem("Audition");
		menu4.add(item7);
		menu4.add(item8);
		menu4.add(item9);
		
		item100 = new JMenuItem("Help Info");
		menu5.add(item100);
		//menu5.setFont(new Font("Dialog",0,100));
		item100.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		
		init_all_info();
		//menuBar.setFont(new Font("Dialog",0,100));
		
		
		
		return menuBar.getHeight();
		
		
	}
	public void init_all_info()
	{
		
		List<List<Integer>> sensor_list = new ArrayList<List<Integer>>();
		List<List<Integer>> motor_list = new ArrayList<List<Integer>>();
		List<List<Integer>> hidden_list = new ArrayList<List<Integer>>();
		
		List<Integer> s_1 = new ArrayList<Integer>();
		s_1.add(1);
		s_1.add(12);
		sensor_list.add(s_1);
		
		List<Integer> m_1 = new ArrayList<Integer>();
		List<Integer> m_2 = new ArrayList<Integer>();
		m_1.add(1);
		m_1.add(17);
		m_1.add(5);
		
		m_2.add(1);
		m_2.add(3);
		m_2.add(1);
		motor_list.add(m_1);
		motor_list.add(m_2);
		
		List<Integer> h_1 = new ArrayList<Integer>();
		h_1.add(5145);
		h_1.add(1);
		hidden_list.add(h_1);
		
		all_info.put("sensor", sensor_list);
		all_info.put("motor", motor_list);
		all_info.put("hidden", hidden_list);
		//System.out.println(123);
		
	}
	public void init_90(JPanel p) {
		JButton j1 = new JButton("open");
		JButton j2 = new JButton("save");
		JButton j3 = new JButton("save as");
		JPanel j4 = new JPanel();
		
		String[] str = {"java note", "C# note", "HTML5 note"};
		JComboBox j5 = new JComboBox(str);
		JTextField j6 = new JTextField();
		JButton j7 = new JButton("clear");
		JList j8= new JList(str);
		JTextArea j9 = new JTextArea();
		j9.setBackground(Color.PINK);
		GridBagLayout layout = new GridBagLayout();
		p.setLayout(layout);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		p.add(j4);
		p.add(j5);
		p.add(j6);
		p.add(j7);
		p.add(j8);
		p.add(j9);
		
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j1,s);
		
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j2,s);
		
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j3,s);
		
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j4,s);
		
		s.gridwidth = 2;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j5,s);
		
		s.gridwidth = 4;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(j6,s);
		
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j7,s);
		
		s.gridwidth = 2;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j8,s);
		
		s.gridwidth = 5;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j9,s);
		
	}
	
	public void init_92 (JPanel p){
		j_first = new JButton("FIRST");
		j_previous = new JButton("PREVIOUS");
		j_next = new JButton("NEXT");
		j_last = new JButton("LAST");
		
		JPanel j_left = new JPanel();
		j_middle = new JPanel();
		JPanel j_right = new JPanel();
		//JPanel j_bottom = new JPanel();
		
		j_left.setBackground(Color.orange);
		j_right.setBackground(Color.red);
		j_middle.setBackground(Color.lightGray);
		//j_bottom.setBackground(Color.red);
		
		GridBagLayout layout = new GridBagLayout();
		p.setLayout(layout);
		
		p.add(j_left);
		p.add(j_middle);
		p.add(j_right);
		//p.add(j_left);
		//p.add(j_bottom);
		
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j_left,s);
		
		s.gridwidth = 5;
		s.weightx = 1;
		s.weighty = 1;
		layout.setConstraints(j_middle,s);
		

		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j_right,s);
		
		j_left.add(j_first);
		j_left.add(j_last);
		j_right.add(j_previous);
		j_right.add(j_next);
		
		GridBagLayout sides_layout = new GridBagLayout();
		j_left.setLayout(sides_layout);
		j_right.setLayout(sides_layout);
		
		GridBagConstraints s_sides = new GridBagConstraints();
		s_sides.fill = GridBagConstraints.BOTH;
		
		s_sides.gridwidth = 0;
		s_sides.weightx = 0;
		s_sides.weighty = 1;
		//s_sides.insets = new Insets(50,0,50,0);
		sides_layout.setConstraints(j_first,s_sides);
		sides_layout.setConstraints(j_last,s_sides);
		sides_layout.setConstraints(j_previous,s_sides);
		sides_layout.setConstraints(j_next,s_sides);
		
		card = new CardLayout();
		j_middle.setLayout(card);
		
		JButton j_card1 = new JButton("Button 1");
		JButton j_card2 = new JButton("Button 2");
		JButton j_card3 = new JButton("Button 3");
		JButton j_card4 = new JButton("Button 4");
		JButton j_card5 = new JButton("Button 5");
		JButton j_card6 = new JButton("Button 6");
		
		j_card1.setBackground(Color.red);
		j_card2.setBackground(Color.pink);
		j_card3.setBackground(Color.green);
		j_card4.setBackground(Color.yellow);
		j_card5.setBackground(Color.cyan);
		j_card6.setBackground(Color.orange);
		
		j_middle.add(j_card1);
		j_middle.add(j_card2);
		j_middle.add(j_card3);
		j_middle.add(j_card4);
		j_middle.add(j_card5);
		j_middle.add(j_card6);
		
		JTabbedPane tabPane = new JTabbedPane();
		
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();
		JPanel tab3 = new JPanel();
		
		init_tab1(tab1);
		tab2.setBackground(Color.magenta);
		tab3.setBackground(Color.white);
		
		tabPane.addTab("tab1",null,tab1,"First panel");  
        tabPane.addTab("tab2",null,tab2,"Second panel");  
        tabPane.addTab("tab3",null,tab3,"Third panel");
        
        j_middle.add(tabPane);
        
		j_first.addActionListener(this);
		j_last.addActionListener(this);
		j_previous.addActionListener(this);
		j_next.addActionListener(this);
		
		
		
		
	}
	
	public void init_tab1(JPanel p){
		p.setBackground(Color.white);
		
		JLabel sensor_layer = new JLabel("Sensor Layer");
		JLabel num_of_layers = new JLabel("# Of Layers");
		JTextField field1 = new JTextField();
		
		sensor_layer.setFont( new Font("Dialog",0,20));
		num_of_layers.setFont( new Font("Dialog",0,20));
		
		p.add(sensor_layer);
		p.add(num_of_layers);
		p.add(field1);
		
		/*
		GridBagLayout layout = new GridBagLayout();
		p.setLayout(layout);
		
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(sensor_layer,s);
		
		s.gridwidth = 5;
		s.weightx = 1;
		s.weighty = 1;
		layout.setConstraints(,s);
		

		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j_right,s);
		*/
	}
	
	/*
	public void help_frame()
	{
		
	}
	*/
	public void write_setting_file(String file_name, String file_address)
	{
		List<String> key_list = new ArrayList<String>();
		key_list.add("sensor");
		key_list.add("motor");
		key_list.add("hidden");
		try
		{
			String full_name = file_address + file_name + ".txt";
			String DN_name = set_hidden.setting_name;
			
			FileWriter fw = new FileWriter(full_name);
			String changeline = System.getProperty("line.separator");
			fw.write("%AOS RELEASE Version 1.0");
			fw.write(changeline);
			fw.write(DN_name + "\t// DN Version");
			fw.write(changeline);
			
			for(String i : key_list)
			{
				if (i == "sensor")
				{
					List<List<Integer>> sensor_list = all_info.get(i);
					fw.write(sensor_list.size() + "\t// # of SensorLayers.");
					fw.write(changeline);
					
					String sensor_label = "\t// Size of SensorLayers";
					for ( List<Integer> j : sensor_list)
					{
						fw.write(j.get(0) + " " + j.get(1) + sensor_label);
						fw.write(changeline);
						sensor_label = "";
					}
					
				}
				else if (i == "motor")
				{
					List<List<Integer>> motor_list = all_info.get(i);
					List<Integer> topk_list = new ArrayList<Integer>();
					
					fw.write(motor_list.size() + "\t// # of MotorLayers.");
					fw.write(changeline);
					String motor_label = "\t// Size of MotorLayers";
					
					for ( List<Integer> j : motor_list)
					{
						fw.write(j.get(0) + " " + j.get(1) + motor_label);
						fw.write(changeline);
						motor_label = "";
						topk_list.add(j.get(2));
					}
					
					for (Integer k : topk_list)
					{
						fw.write(k + " ");
					}
					
					fw.write("\t// TopK winning of MotorLayer.");
					fw.write(changeline);
				}
				else if (i == "hidden")
				{
					List<List<Integer>> hidden_list = all_info.get(i);
					List<Integer> topk_list = new ArrayList<Integer>();
					
					fw.write(hidden_list.size() + "\t// # of HiddenLayers.");
					fw.write(changeline);
					String hidden_label = "\t// Size of HiddenLayers";
					
					for ( List<Integer> j : hidden_list)
					{
						fw.write(j.get(0) + hidden_label);
						fw.write(changeline);
						hidden_label = "";
						topk_list.add(j.get(1));
					}
					
					for (Integer k : topk_list)
					{
						fw.write(k + " ");
					}
					
					fw.write("\t// TopK winning of HiddenLayer.");
					fw.write(changeline);
				}
			}
			
			fw.write("V: Le;\t// Modality.");
			fw.write(changeline);
			fw.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == j_previous)
		{
			card.previous(j_middle);
		}
		if (e.getSource() == j_next)
		{
			card.next(j_middle);
		}
		if (e.getSource() == j_first)
		{
			card.first(j_middle);
		}
		if (e.getSource() == j_last)
		{
			card.last(j_middle);
		}
		if (e.getSource() == item100)
		{
			if (help_frame == null)
			{
				help_frame = new pop_up_help(this);
			}
			else if (help_frame.isShowing() == false)
			{
				help_frame = new pop_up_help(this);
			}
		}
		if (e.getSource() == n.yes_button)
		{
			help_frame = new pop_up_help(this);
			set_sensor = new set_windows_sensor("DN 1",this);
		}
		if (e.getSource() == n.no_button)
		{
			set_sensor = new set_windows_sensor("DN 1",this);
		}
		if (e.getSource() == item1)
		{
			if (set_sensor.isShowing() == false)
			{
				set_sensor = new set_windows_sensor("DN 1",this);
			}
		}
		if (e.getSource() == item2)
		{
			
			if (set_sensor.isShowing() == false)
			{
				set_sensor = new set_windows_sensor("DN 2",this);
			}
		}
		if (set_sensor.isShowing() == true)
		{
			if (e.getSource() == set_sensor.finish)
			{
				set_motor = new set_windows_motor(set_sensor.setting_name,this);
			}
		}
		
		else if (set_motor.isShowing() == true)
		{
			if (e.getSource() == set_motor.finish)
			{
				set_hidden = new set_windows_hidden(set_motor.setting_name,this);
			}
		}
		else if (set_hidden.isShowing() == true)
		{
			if (e.getSource() == set_hidden.finish)
			{
				//System.out.println("Here");
				//write_setting_file(set_hidden.name_field.getText(),set_hidden.address_field.getText());
				//System.out.println(set_hidden.setting_file_name);
				set_data_address = new set_data_address_window(set_hidden.setting_name,this);
				
			}
		}
		//System.out.println("come to here");
		
	}
	
	
	
    //JButton j2;
    //JButton j3;
    //JPanel j4;
    //JComboBox j5;
    //JTextField j6;
    //JButton j7;
    //JList j8;
    //JTextArea j9;
	

}

