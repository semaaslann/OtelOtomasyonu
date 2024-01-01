package loginekrani;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Personel_Liste extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim =new DefaultTableModel();
	//sutun ve satır oluşturalım 
	Object[] kolonlar= {"Tc","Ad","Soyad","Yas","Tel_no","Adres","Maas"};
	Object[] satirlar= new Object[7];
	private JButton btnk;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personel_Liste frame = new Personel_Liste();
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
	public Personel_Liste() {
		setTitle("PERSONEL LİSTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 612, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(203, 236, 311, 200);
		//contentPane.add(table);
		//scrolview içine table attık
		scrollPane.setViewportView(table);
		
		
		JButton btnListele = new JButton("Listele");
		//buton click özelliği
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//alattaki kod listeyi siler tekrar yazdırır
				
				//listeyi siler
				modelim.setRowCount(0);
				ResultSet myRs= PersonelListe_baglanti.yap();
				
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("Tc");
						satirlar[1]=myRs.getString("Ad");
						satirlar[2]=myRs.getString("Soyad");
						satirlar[3]=myRs.getString("Yas");
						satirlar[4]=myRs.getString("Tel_no");
						satirlar[5]=myRs.getString("Adres");
						satirlar[6]=myRs.getString("Maas");
						//satır ve sütunları ekleyelim 
						modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				table.setModel(modelim);
				
				
				
			}	
			
		});
		
		btnListele.setBackground(new Color(0, 255, 0));
		btnListele.setBounds(372, 418, 102, 37);
		contentPane.add(btnListele);
		
		btnk = new JButton("Çıkış");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                setVisible(false);
				
				Giris_Ekranı fram = new Giris_Ekranı();
				fram.setVisible(true);
			}
		});
		btnk.setBackground(new Color(255, 0, 0));
		btnk.setBounds(520, 418, 102, 37);
		contentPane.add(btnk);
		
		
	}
}
