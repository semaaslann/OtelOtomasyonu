package loginekrani;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Giris_Ekranı extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris_Ekranı frame = new Giris_Ekranı();
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
	public Giris_Ekranı() {
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setTitle("GİRİŞ EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button mus_kayit = new Button("Müşteri Kayıt");
		mus_kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				Müşteri_Kayıt frame = new Müşteri_Kayıt();
				frame.setVisible(true);
			}
		});
		mus_kayit.setBackground(new Color(128, 128, 128));
		mus_kayit.setFont(new Font("Dialog", Font.BOLD, 12));
		mus_kayit.setBounds(305, 130, 384, 52);
		contentPane.add(mus_kayit);
		
		Button button_1 = new Button("Personel Kayıt");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				Personel_Kayıt frm = new Personel_Kayıt();
				frm.setVisible(true);
						
			}
		});
		button_1.setBackground(new Color(128, 128, 128));
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setBounds(305, 300, 384, 52);
		contentPane.add(button_1);
		
		Button button_3 = new Button("Çıkış");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				login fram = new login();
				fram.setVisible(true);
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 12));
		button_3.setBackground(new Color(255, 0, 0));
		button_3.setBounds(744, 482, 152, 45);
		contentPane.add(button_3);
		
		Button button = new Button("Müşteri Liste");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				Müşteri_Liste frame= new Müşteri_Liste();
				frame.setVisible(true);
				
			}
		});
		button.setBackground(new Color(128, 128, 255));
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(305, 215, 384, 52);
		contentPane.add(button);
		
		Button button_4 = new Button("Personel Liste");
		button_4.setBackground(new Color(128, 128, 255));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				Personel_Liste frame= new Personel_Liste();
				frame.setVisible(true);
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 12));
		button_4.setBounds(305, 391, 384, 52);
		contentPane.add(button_4);
		
		JLabel lblNewLabel = new JLabel("OTEL OTOMASYONU");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 66));
		lblNewLabel.setBounds(176, 26, 675, 70);
		contentPane.add(lblNewLabel);
	}
}
