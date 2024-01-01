package loginekrani;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Müşteri_Liste extends JFrame {

	private JPanel contentPane;
	
	DefaultTableModel modelim =new DefaultTableModel();
	//sutun ve satır oluşturalım 
	Object[] kolonlar= {"Tc","Ad","Soyad","Tel_no","Adres","Kalma_suresi","Ucret","Oda_no"};
	Object[] satirlar= new Object[8];
	//new Object[7];
	
	private JButton btnCikis;
	private JTable table;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Müşteri_Liste frame = new Müşteri_Liste();
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
	public Müşteri_Liste() {
		setTitle("MÜŞTERİ LİSTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 735, 402);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(305, 321, 334, 131);
		//contentPane.add(table);
		scrollPane.setViewportView(table);
		
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//alattaki kod listeyi siler tekrar yazdırır
				modelim.setRowCount(0);
				ResultSet myRs= PersonelListe_baglanti.yapMusteri();
				
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("Tc");
						satirlar[1]=myRs.getString("Ad");
						satirlar[2]=myRs.getString("Soyad");
						satirlar[3]=myRs.getString("Tel_no");
						satirlar[4]=myRs.getString("Adres");
						satirlar[5]=myRs.getString("Kalma_suresi");
						satirlar[6]=myRs.getString("Ucret");
						satirlar[7]=myRs.getString("Oda_no");
						
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
		btnListele.setBounds(452, 471, 130, 32);
		contentPane.add(btnListele);
		
		btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				Giris_Ekranı fram = new Giris_Ekranı();
				fram.setVisible(true);
			}
		});
		btnCikis.setBackground(new Color(255, 0, 0));
		btnCikis.setBounds(622, 471, 130, 32);
		contentPane.add(btnCikis);
	}
}
