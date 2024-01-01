package loginekrani;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class Personel_Kayıt extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtyas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personel_Kayıt frame = new Personel_Kayıt();
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
	public Personel_Kayıt() {
		setTitle("PERSONEL KAYIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("TC:");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(49, 48, 94, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Ad:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(49, 113, 94, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Soyad:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(49, 178, 94, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Yaş:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(49, 241, 94, 21);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Telefon:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(49, 303, 94, 21);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Adres:");
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(49, 368, 94, 21);
		contentPane.add(label_5);
		
		TextField txttc = new TextField();
		txttc.setBounds(168, 48, 101, 21);
		contentPane.add(txttc);
		
		TextField txtad = new TextField();
		txtad.setBounds(168, 113, 101, 21);
		contentPane.add(txtad);
		
		TextField txtsoyad = new TextField();
		txtsoyad.setBounds(168, 178, 101, 21);
		contentPane.add(txtsoyad);
		
		TextField txttelno = new TextField();
		txttelno.setBounds(168, 303, 101, 21);
		contentPane.add(txttelno);
		
		TextField txtadres = new TextField();
		txtadres.setBounds(168, 368, 101, 21);
		contentPane.add(txtadres);
		
		Label label_6 = new Label("Maaş:");
		label_6.setFont(new Font("Dialog", Font.BOLD, 12));
		label_6.setBounds(372, 48, 94, 21);
		contentPane.add(label_6);
		
		TextField txtmaas = new TextField();
		txtmaas.setBounds(521, 48, 125, 21);
		contentPane.add(txtmaas);
		
		JButton btnKaydet = new JButton("Kayıt Oluştur");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aşagidaki kod bloğu personel listesine gider 
				//Personel_Liste framee = new Personel_Liste();
				//framee.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Kayıt Oluşturuldu");
				
				String tc,ad,soyad,yas,tel_no,adres,maas,sql_sorgu;
				
				tc=txttc.getText();
				ad=txtad.getText();
				soyad=txtsoyad.getText();
				yas=txtyas.getText();
				tel_no=txttelno.getText();
				adres=txtadres.getText();
				maas=txtmaas.getText();
				
				sql_sorgu = "INSERT INTO personel_listesi(Tc,Ad,Soyad,Yas,Tel_no,Adres,Maas) VALUES ("+
				tc +  ",'" + ad + "'," + "'" + soyad + "'," + "'" + yas + "'," + "'" + tel_no + "'," + "'" + adres + "'," + "'" + maas + "')" ;
				
				//System.out.println(sql_sorgu);
				
				PersonelListe_baglanti.ekle(sql_sorgu);
				
				
				
				
			}
		});
		btnKaydet.setBackground(new Color(0, 255, 0));
		btnKaydet.setFont(new Font("Dialog", Font.BOLD, 12));
		btnKaydet.setBounds(314, 441, 152, 36);
		contentPane.add(btnKaydet);
		
		
		
		Button btnCikis = new Button("Çıkış");
		btnCikis.setBackground(new Color(255, 0, 0));
		btnCikis.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//alttaki kod boloğu ile giriş ekranına listesine gider 
				
				setVisible(false);
				
				Giris_Ekranı framee = new Giris_Ekranı();
				framee.setVisible(true);
				
				
			}
		});
		btnCikis.setBounds(514, 501, 152, 36);
		contentPane.add(btnCikis);
		
		txtyas = new JTextField();
		txtyas.setBounds(168, 241, 101, 21);
		contentPane.add(txtyas);
		txtyas.setColumns(10);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tc,sql_sorgu;
				
				tc=txttc.getText();
				
				sql_sorgu="DELETE FROM personel_listesi WHERE Tc="+tc;
				
				
				PersonelListe_baglanti.sil(sql_sorgu);
				
				
			}
		});
		btnSil.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSil.setBackground(new Color(128, 128, 255));
		btnSil.setBounds(126, 441, 152, 36);
		contentPane.add(btnSil);
		
		JButton btnListeyeGit = new JButton("Listeye Git");
		btnListeyeGit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                setVisible(false);
				
				Personel_Liste frameee = new Personel_Liste();
				frameee.setVisible(true);
			}
		});
		btnListeyeGit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListeyeGit.setBackground(new Color(255, 128, 0));
		btnListeyeGit.setBounds(514, 441, 152, 36);
		contentPane.add(btnListeyeGit);
	}
}
