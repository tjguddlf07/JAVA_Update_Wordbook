//단어장 페이지
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	  //AWT 이벤트 사용

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;		 	  //스윙 컴포넌트 클래스 사용

public class Word extends JFrame{
	//단어장 GUI 디자인
	Word() {
		setTitle("단어장 페이지");			 //프레임 타이틀 지정
		createMenu();
		setSize(300,200);				 //프레임 크기 지정
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//체크박스를 생성
		JCheckBox infect = new JCheckBox("Infect");
		
		//컨텐트팬에 1개의 체크박스 삽입
		c.add(infect);
		
		//문자열 레이블 생성
		JLabel pronunce = new JLabel("[In'fekt]");
		JLabel mean1 = new JLabel("1. V. 감염시키다");
		JLabel mean2 = new JLabel("2. V. (유해 세균으로) 오염시키다");
		JLabel mean3 = new JLabel("3. V. (컴퓨터에 바이러스를) 침투시키다");
		JLabel example1= new JLabel("To stop these wildfires, people came up with a new idea.");
		JLabel example2= new JLabel("이 산불을 막기 위해 사람들은 한가지 아이디어를 떠올렸다.");
		
		//컨트트팬에  5개의 라벨 삽입
		c.add(pronunce);
		c.add(mean1);
		c.add(mean2);
		c.add(mean3);
		c.add(example1);
		c.add(example2);
		
		setVisible(true);						//화면에 프레임 출력
	}
	//메뉴바 구성 및 생성
	void createMenu() { 
		JMenuBar mb = new JMenuBar(); 			// 메뉴바 생성
		JMenuItem [] menuItem = new JMenuItem [2];
		String[] itemTitle = {"단어장 페이지", "즐겨찾기 목록"};		 //메뉴바 구성요소
		JMenu screenMenu = new JMenu("추가기능");				 //메뉴바 객체 생성
		
		//MenuActionListener 객체 생성
		MenuActionListener listener = new MenuActionListener();	
		
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(listener); 
			screenMenu.add(menuItem[i]);
		}		
		mb.add(screenMenu); 								// screenMenu 레퍼런스에 메뉴바 삽입
		setJMenuBar(mb); 									// 메뉴바를 프레임에 부착
	}
	class MenuActionListener implements ActionListener { 	//MenuActionListener 메소드
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); 
			switch(cmd) { 			  //메뉴 아이템의 종류 구분
				case "단어장 페이지" :     //단어장 페이지인 경우
					new Word();		 //단어장 페이지로 이동
				     dispose();
					break;
				case "즐겨찾기 목록" :    //즐겨찾기 목록인 경우
					new BookMark(); //즐겨찾기 페이지로 이동
					 dispose();
					break;
			}
		}
	}
}