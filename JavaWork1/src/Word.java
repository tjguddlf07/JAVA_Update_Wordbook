//�ܾ��� ������
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	  //AWT �̺�Ʈ ���

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;		 	  //���� ������Ʈ Ŭ���� ���

public class Word extends JFrame{
	//�ܾ��� GUI ������
	Word() {
		setTitle("�ܾ��� ������");			 //������ Ÿ��Ʋ ����
		createMenu();
		setSize(300,200);				 //������ ũ�� ����
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//üũ�ڽ��� ����
		JCheckBox infect = new JCheckBox("Infect");
		
		//����Ʈ�ҿ� 1���� üũ�ڽ� ����
		c.add(infect);
		
		//���ڿ� ���̺� ����
		JLabel pronunce = new JLabel("[In'fekt]");
		JLabel mean1 = new JLabel("1. V. ������Ű��");
		JLabel mean2 = new JLabel("2. V. (���� ��������) ������Ű��");
		JLabel mean3 = new JLabel("3. V. (��ǻ�Ϳ� ���̷�����) ħ����Ű��");
		JLabel example1= new JLabel("To stop these wildfires, people came up with a new idea.");
		JLabel example2= new JLabel("�� ����� ���� ���� ������� �Ѱ��� ���̵� ���÷ȴ�.");
		
		//��ƮƮ�ҿ�  5���� �� ����
		c.add(pronunce);
		c.add(mean1);
		c.add(mean2);
		c.add(mean3);
		c.add(example1);
		c.add(example2);
		
		setVisible(true);						//ȭ�鿡 ������ ���
	}
	//�޴��� ���� �� ����
	void createMenu() { 
		JMenuBar mb = new JMenuBar(); 			// �޴��� ����
		JMenuItem [] menuItem = new JMenuItem [2];
		String[] itemTitle = {"�ܾ��� ������", "���ã�� ���"};		 //�޴��� �������
		JMenu screenMenu = new JMenu("�߰����");				 //�޴��� ��ü ����
		
		//MenuActionListener ��ü ����
		MenuActionListener listener = new MenuActionListener();	
		
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(listener); 
			screenMenu.add(menuItem[i]);
		}		
		mb.add(screenMenu); 								// screenMenu ���۷����� �޴��� ����
		setJMenuBar(mb); 									// �޴��ٸ� �����ӿ� ����
	}
	class MenuActionListener implements ActionListener { 	//MenuActionListener �޼ҵ�
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); 
			switch(cmd) { 			  //�޴� �������� ���� ����
				case "�ܾ��� ������" :     //�ܾ��� �������� ���
					new Word();		 //�ܾ��� �������� �̵�
				     dispose();
					break;
				case "���ã�� ���" :    //���ã�� ����� ���
					new BookMark(); //���ã�� �������� �̵�
					 dispose();
					break;
			}
		}
	}
}