//�α��� ������
import java.awt.FlowLayout;		  //���ʿ��� ���������� ��ġ
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	  //AWT �̺�Ʈ ���

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;		 //���� ������Ʈ Ŭ���� ���

public class Login extends JFrame implements ActionListener {
 private String id = "test1";			//ID ���� �� ����(�ʱ�ȭ)
 private String password = "123";		//Password ���� �� ����(�ʱ�ȭ)
 private JTextField tf;					//GUI ID ����
 private JTextField pf;					//GUI �н����� ����
 private JButton login;					//GUI �α��� ��ư ����
 JLabel loginText = new JLabel();		//GUI �� ��ü ����
 private boolean isLogin = false;		//���� ���� �Է¹��� �� �� ����

 public Login() {						//������
  JPanel idPanel = new JPanel();		//ID �г� ��ü ����
  JPanel passPanel = new JPanel();		//Password �г� ��ü ����
  tf = new JTextField(12);				//JText �ʵ� ���۷��� ����(ID/tf)
  pf = new JTextField(10);				//JText �ʵ� ���۷��� ����(Password/pf)
 
  JLabel idLabel = new JLabel("ID : ");			//ID �� �� ����
  JLabel passLabel = new JLabel("PASSWORD : ");	//Password �� �� ����
  login = new JButton("�α���");					//��ư ������Ʈ ����
  login.addActionListener(this);				//login�� ��ư ����
  
  idPanel.add(idLabel);							//idPanel�� idLabel ����
  idPanel.add(tf);								//ID �󺧰� ID�� ���۷��� �� ����

  passPanel.add(passLabel);						//passPanel�� passLabel ����
  passPanel.add(pf);							//Password ��ΰ� Password�� ���۷��� �� ����

  this.add(idPanel);							//idPanel ����
  this.add(passPanel);							//passPanel ����
  this.add(login);								//��ư ����
  this.add(loginText);							//�� ����	
  
  setLayout(new FlowLayout());

  setTitle("�α��� ������");						       //������ Ÿ��Ʋ ����
  setSize(300, 200);							   //������ ũ�� ����
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //������ ������ ������ ���α׷� ����

  setVisible(true);								   //ȭ�鿡 ������ ���
 }

 //ID�� Password�� ���尪�� �Է¹��� �� ��
 @Override
 public void actionPerformed(ActionEvent e) {
 //���� ó��
  if (e.getSource() == login) {
   try {
    if (id.equals(tf.getText()) && password.equals(pf.getText()))
     isLogin = true;
    else
     isLogin = false;
    if (isLogin) {											//���� ���� �Է¹��� ���� ���� ���
     new Word();											//�ܾ��� �������� �̵�
     dispose();
    } else {												//���� ���� �Է¹��� ���� �ٸ� ���
     loginText.setText("ID �Ǵ� password�� �߸��Ǿ����ϴ�.");			//�ϴܿ� ����� ����
    }
   } catch (Exception e1) {
    System.out.println("false");
   }
  }
 }
} 