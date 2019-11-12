//���ã�� ��� ������
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	  //AWT �̺�Ʈ ���

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;		 //���� ������Ʈ Ŭ���� ���

public class BookMark extends JFrame  {
	//���ã�� ��� GUI ������
	BookMark(){
		createMenu();
		setTitle("���ã�� ���");			
		setSize(300,200);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//4���� üũ�ڽ��� ����  + 1���� üũ�ڽ� �߰�
		JCheckBox preview  = new JCheckBox("1. Preview",true);
		JCheckBox progress = new JCheckBox("2. Progress",true);
		JCheckBox prompt = new JCheckBox("3. Prompt",true);
		JCheckBox protect = new JCheckBox("4.Protect",true);
		//JCheckBox infect = new JCheckBox("5. Infect ",true);
		
		//����Ʈ�ҿ� 4���� üũ�ڽ� ���� + 1���� üũ�ڽ� ����
		c.add(preview);
		c.add(progress);
		c.add(prompt);
		c.add(protect);
		//c.add(infect);
		
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
		mb.add(screenMenu);									// screenMenu ���۷����� �޴��� ����
		setJMenuBar(mb); 									// �޴��ٸ� �����ӿ� ����
	}
	class MenuActionListener implements ActionListener {	//MenuActionListener �޼ҵ�
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); 
			switch(cmd) { 									// �޴� �������� ���� ����
				case "�ܾ��� ������" :							//�ܾ��� �������� ���
					new Word();								//�ܾ��� �������� �̵�
				     dispose();
					break;
				case "���ã�� ���" :							//���ã�� ����� ���
					new BookMark();							//���ã�� �������� �̵�
					 dispose();
					break;
			}
		}
	}
}