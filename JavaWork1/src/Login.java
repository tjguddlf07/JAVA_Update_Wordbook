//로그인 페이지
import java.awt.FlowLayout;		  //왼쪽에서 오른쪽으로 배치
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	  //AWT 이벤트 사용

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;		 //스윙 컴포넌트 클래스 사용

public class Login extends JFrame implements ActionListener {
 private String id = "test1";			//ID 저장 값 지정(초기화)
 private String password = "123";		//Password 지정 값 지정(초기화)
 private JTextField tf;					//GUI ID 변수
 private JTextField pf;					//GUI 패스워드 변수
 private JButton login;					//GUI 로그인 버튼 변수
 JLabel loginText = new JLabel();		//GUI 라벨 객체 생성
 private boolean isLogin = false;		//저장 값과 입력받은 값 비교 변수

 public Login() {						//생성자
  JPanel idPanel = new JPanel();		//ID 패널 객체 생성
  JPanel passPanel = new JPanel();		//Password 패널 객체 생성
  tf = new JTextField(12);				//JText 필드 레퍼런스 생성(ID/tf)
  pf = new JTextField(10);				//JText 필드 레퍼런스 생성(Password/pf)
 
  JLabel idLabel = new JLabel("ID : ");			//ID 라벨 값 지정
  JLabel passLabel = new JLabel("PASSWORD : ");	//Password 라벨 값 지정
  login = new JButton("로그인");					//버튼 컴포넌트 생성
  login.addActionListener(this);				//login에 버튼 부착
  
  idPanel.add(idLabel);							//idPanel에 idLabel 부착
  idPanel.add(tf);								//ID 라벨과 ID의 레퍼런스 값 연결

  passPanel.add(passLabel);						//passPanel에 passLabel 부착
  passPanel.add(pf);							//Password 페널과 Password의 레퍼런스 값 연결

  this.add(idPanel);							//idPanel 부착
  this.add(passPanel);							//passPanel 부착
  this.add(login);								//버튼 부착
  this.add(loginText);							//라벨 부착	
  
  setLayout(new FlowLayout());

  setTitle("로그인 페이지");						       //프레임 타이틀 지정
  setSize(300, 200);							   //프레임 크기 지정
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //프레임 윈도우 닫으면 프로그램 종료

  setVisible(true);								   //화면에 프레임 출력
 }

 //ID와 Password의 저장값과 입력받은 값 비교
 @Override
 public void actionPerformed(ActionEvent e) {
 //예외 처리
  if (e.getSource() == login) {
   try {
    if (id.equals(tf.getText()) && password.equals(pf.getText()))
     isLogin = true;
    else
     isLogin = false;
    if (isLogin) {											//저장 값과 입력받은 값이 같은 경우
     new Word();											//단어장 페이지로 이동
     dispose();
    } else {												//저장 값과 입력받은 값이 다를 경우
     loginText.setText("ID 또는 password가 잘못되었습니다.");			//하단에 출력할 문장
    }
   } catch (Exception e1) {
    System.out.println("false");
   }
  }
 }
} 