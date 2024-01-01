package loginekrani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonelListe_baglanti {
	
	static Connection myConn;
	static Statement myStat;
	
	static ResultSet yap() {
		ResultSet myRs=null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelotomasyonu","root","1234");
			myStat=myConn.createStatement();
			myRs= myStat.executeQuery("select * from personel_listesi");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return myRs;
	}
	
	static void ekle(String sql_sorgu) {
		
		try {
			
			if (myConn == null || myConn.isClosed()) {
	            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelotomasyonu", "root", "1234");
	        }
			
			if(myStat == null) {
				myStat=myConn.createStatement();
			}
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	static ResultSet yapMusteri() {
		ResultSet myRs=null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelotomasyonu","root","1234");
			myStat=myConn.createStatement();
			myRs= myStat.executeQuery("select * from musteri_listesi");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("bağlantı yapılamadı");
		}
		
		return myRs;
	}
	
    static void ekleMusteri(String sql_sorgu) {
		
		try {
			
			if (myConn == null || myConn.isClosed()) {
	            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelotomasyonu", "root", "1234");
	        }
			
			if(myStat == null) {
				myStat=myConn.createStatement();
			}
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
    
    static void sil(String sql_sorgu) {
    	
    	try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    static void silMusteri(String sql_sorgu) {
    	
        try {
			
			if (myConn == null || myConn.isClosed()) {
	            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelotomasyonu", "root", "1234");
	        }
			
			if(myStat == null) {
				myStat=myConn.createStatement();
			}
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }

}
