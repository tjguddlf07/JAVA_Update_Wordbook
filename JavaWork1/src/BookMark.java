//즐겨찾기 목록 페이지
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	  //AWT 이벤트 사용

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;		 //스윙 컴포넌트 클래스 사용

public class BookMark extends JFrame  {
	//즐겨찾기 목록 GUI 디자인
	BookMark(){
		createMenu();
		setTitle("즐겨찾기 목록");			
		setSize(300,200);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//4개의 체크박스를 생성  + 1개의 체크박스 추가
		JCheckBox preview  = new JCheckBox("1. Preview",true);
		JCheckBox progress = new JCheckBox("2. Progress",true);
		JCheckBox prompt = new JCheckBox("3. Prompt",true);
		JCheckBox protect = new JCheckBox("4.Protect",true);
		//JCheckBox infect = new JCheckBox("5. Infect ",true);
		
		//컨텐트팬에 4개의 체크박스 삽입 + 1개의 체크박스 삽입
		c.add(preview);
		c.add(progress);
		c.add(prompt);
		c.add(protect);
		//c.add(infect);
		
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
		mb.add(screenMenu);									// screenMenu 레퍼런스에 메뉴바 삽입
		setJMenuBar(mb); 									// 메뉴바를 프레임에 부착
	}
	class MenuActionListener implements ActionListener {	//MenuActionListener 메소드
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); 
			switch(cmd) { 									// 메뉴 아이템의 종류 구분
				case "단어장 페이지" :							//단어장 페이지인 경우
					new Word();								//단어장 페이지로 이동
				     dispose();
					break;
				case "즐겨찾기 목록" :							//즐겨찾기 목록인 경우
					new BookMark();							//즐겨찾기 페이지로 이동
					 dispose();
					break;
			}
		}
	}
}