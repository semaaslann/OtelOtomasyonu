package loginekrani;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.Button;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class Müşteri_Kayıt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Müşteri_Kayıt frame = new Müşteri_Kayıt();
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
	public Müşteri_Kayıt() {
		setTitle("MÜŞTERİ_KAYIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("TC:");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(49, 50, 59, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Ad:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(49, 111, 59, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Soyad:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(49, 171, 59, 21);
		contentPane.add(label_2);
		
		Label label_4 = new Label("Tel No:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(49, 239, 86, 21);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Adres:");
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(49, 306, 59, 21);
		contentPane.add(label_5);
		
		TextField txttc = new TextField();
		txttc.setBounds(200, 50, 132, 21);
		contentPane.add(txttc);
		
		TextField txtad = new TextField();
		txtad.setBounds(200, 111, 132, 21);
		contentPane.add(txtad);
		
		TextField txtsoyad = new TextField();
		txtsoyad.setBounds(200, 171, 132, 21);
		contentPane.add(txtsoyad);
		
		TextField txttelno = new TextField();
		txttelno.setBounds(200, 239, 132, 21);
		contentPane.add(txttelno);
		
		TextField txtadres = new TextField();
		txtadres.setBounds(200, 306, 132, 67);
		contentPane.add(txtadres);
		
		Label label_8 = new Label("Kalma Süresi:");
		label_8.setFont(new Font("Dialog", Font.BOLD, 12));
		label_8.setBounds(376, 50, 115, 21);
		contentPane.add(label_8);
		
		Label label_9 = new Label("Ücret");
		label_9.setFont(new Font("Dialog", Font.BOLD, 12));
		label_9.setBounds(376, 111, 129, 21);
		contentPane.add(label_9);
		
		Label label_10 = new Label("Oda No:");
		label_10.setFont(new Font("Dialog", Font.BOLD, 12));
		label_10.setBounds(376, 171, 101, 21);
		contentPane.add(label_10);
		
		
		
		TextField txtucret = new TextField();
		txtucret.setBounds(518, 111, 132, 21);
		contentPane.add(txtucret);
		
		TextField txtkalmasuresi = new TextField();
		txtkalmasuresi.setBounds(518, 50, 132, 21);
		contentPane.add(txtkalmasuresi);
		
		TextField txtodano = new TextField();
		txtodano.setBounds(518, 171, 132, 21);
		contentPane.add(txtodano);
		
		
		Button btnkaydet = new Button("Kayıt Oluştur");
		btnkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Kayıt Oluşturuldu");
				
				
				
				String tc,ad,soyad,tel,adres,kalmasuresi,ucret,odano,sql_sorgu;
				
				tc=txttc.getText();
				ad=txtad.getText();
				soyad=txtsoyad.getText();
				tel=txttelno.getText();
				adres=txtadres.getText();
				kalmasuresi=txtkalmasuresi.getText();
				ucret=txtucret.getText();
				odano=txtodano.getText();
				
				sql_sorgu="INSERT INTO musteri_listesi(Tc,Ad,Soyad,Tel_no,Adres,Kalma_suresi,Ucret,Oda_no) VALUES ("+
						tc +  ",'" + ad + "'," + "'" + soyad + "'," + "'" + tel + "'," + "'" + adres + "'," + "'" + kalmasuresi + "'," + "'" + ucret + "'," + "'" + odano +"')";
				
				
				PersonelListe_baglanti.ekleMusteri(sql_sorgu);
				
				
				
				
				
			}
		});
		btnkaydet.setBackground(new Color(128, 255, 128));
		btnkaydet.setFont(new Font("Dialog", Font.ITALIC, 14));
		btnkaydet.setBounds(452, 435, 157, 38);
		contentPane.add(btnkaydet);
		
		
		
		
		Button btncikis = new Button("Çıkış");
		btncikis.setBackground(new Color(255, 0, 0));
		btncikis.setFont(new Font("Dialog", Font.ITALIC, 14));
		btncikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				Giris_Ekranı framee = new Giris_Ekranı();
				framee.setVisible(true);
			}
		});
		btncikis.setBounds(646, 485, 157, 38);
		contentPane.add(btncikis);
		
		Button btnkaydet_1 = new Button("Listeye Git");
		btnkaydet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                setVisible(false);
				
				Müşteri_Liste framee = new Müşteri_Liste();
				framee.setVisible(true);
			}
		});
		btnkaydet_1.setFont(new Font("Dialog", Font.ITALIC, 14));
		btnkaydet_1.setBackground(new Color(255, 128, 0));
		btnkaydet_1.setBounds(646, 435, 157, 38);
		contentPane.add(btnkaydet_1);
		
		Button btnkaydet_2 = new Button("Sil");
		btnkaydet_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String tc,sql_sorgu;
				
				tc=txttc.getText();
				
				sql_sorgu="DELETE FROM musteri_listesi WHERE Tc="+tc;
				
				
				PersonelListe_baglanti.silMusteri(sql_sorgu);
				
			}
		});
		btnkaydet_2.setFont(new Font("Dialog", Font.ITALIC, 14));
		btnkaydet_2.setBackground(new Color(128, 128, 255));
		btnkaydet_2.setBounds(262, 435, 157, 38);
		contentPane.add(btnkaydet_2);
	}
}
