package loginekrani;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("LOGİN EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Kullanıcı Adı:");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(39, 49, 109, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Şifre");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(39, 100, 59, 21);
		contentPane.add(label_1);
		
		TextField user = new TextField();
		user.setBounds(194, 49, 132, 21);
		contentPane.add(user);
		
		Button button_giris = new Button("Giriş");
		button_giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//ResultSet myRs=null;
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelotomasyonu","root","1234");
					Statement stmt=con.createStatement();
					String sql="Select * from kullanici where kullanıcı_adı='"+user.getText()+"' and Şifresi='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Giriş Başarılı");
						
						setVisible(false);
						
						Giris_Ekranı frame= new Giris_Ekranı();
						frame.setVisible(true);
					
					
					}else
						JOptionPane.showMessageDialog(null, "Yanlış kullanıcı adı veya Şifre");
					con.close();
					
				} catch (Exception er) {
					// TODO: handle exception
					er.printStackTrace();
					System.out.println("bağlantı yapılamadı");
				}
				
				return;
				
				
				
				
				
				
				
				
				
				/**String k_ad = "sema";
				String password = "1234";
				
				if(jtex_kad.getText().equals(k_ad) && jpass.getText().equals(password)) {
					JOptionPane.showMessageDialog(null, "Giriş Başarılı");
					
					setVisible(false);
					
					Giris_Ekranı frame= new Giris_Ekranı();
					frame.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "yanlış girdin!");
					
				}*/
			}
		});
		
		
		button_giris.setForeground(new Color(64, 0, 128));
		button_giris.setBounds(209, 193, 142, 21);
		contentPane.add(button_giris);
		
		pass = new JPasswordField();
		pass.setBounds(194, 112, 132, 19);
		contentPane.add(pass);
	}
}
