package com.jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class McaDao {

	Connection con;
//	Statement st;
	PreparedStatement st;
	ResultSet rs;
	public  McaDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mca","root","1234");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Mca getRecord(int rollno) {
		Mca mca = null;
		try {
			st = con.prepareStatement("select * from mca where rollno = "+rollno);
			rs= st.executeQuery();
			if(rs.next()) {
				mca=new Mca();
				mca.setRollno(rs.getInt("rollno"));
				mca.setName(rs.getString("name"));
				mca.setCity(rs.getString("city"));
				mca.setSubject(rs.getString("subject"));
				mca.setPhone(rs.getLong("phone"));
			} else {
				System.out.println("Nothing !!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mca;
	}
	
	public List<Mca> getAllRecords(){
		List<Mca> mlist = new ArrayList<Mca>();
		Mca mca = null;
		try {
			st = con.prepareStatement("select * from mca");
			rs = st.executeQuery();
			while(rs.next()) {
				mca=new Mca();
				mca.setRollno(rs.getInt("rollno"));
				mca.setName(rs.getString("name"));
				mca.setCity(rs.getString("city"));
				mca.setSubject(rs.getString("subject"));
				mca.setPhone(rs.getLong("phone"));
				mlist.add(mca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
	public List<Mca> getRecordsByPage(int page,int i){
		List<Mca> mlist = new ArrayList<Mca>();
		Mca mca = null;
		try {
			st =  con.prepareStatement("select * from mca limit ?,?");
			st.setInt(1, page);
			st.setInt(2, i);
			rs = st.executeQuery();
			while(rs.next()) {
				mca=new Mca();
				mca.setRollno(rs.getInt("rollno"));
				mca.setName(rs.getString("name"));
				mca.setCity(rs.getString("city"));
				mca.setSubject(rs.getString("subject"));
				mca.setPhone(rs.getLong("phone"));
				mlist.add(mca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
	public int insertRecord(Mca m) {
		int rs = 0 ;
		try {
			st = con.prepareStatement("insert into mca values(?,?,?,?,?)");
			st.setInt(1, m.getRollno());
			st.setString(2, m.getName());
			st.setString(3, m.getCity());
			st.setString(4, m.getSubject());
			st.setLong(5, m.getPhone());
			rs = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int deleteRecord(int roll) {
		int status = 0 ;
		try {
			st = con.prepareStatement("delete from mca where rollno = ?");
			st.setInt(1, roll);
			status = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public int updateRecord(Mca m) {
		int status = 0;
		try {
			st = con.prepareStatement("update mca set name =?,city=?,subject=?,phone=? where rollno =?");
			st.setString(1,m.getName());
			st.setString(2, m.getCity());
			st.setString(3, m.getSubject());
			st.setLong(4, m.getPhone());
			st.setInt(5, m.getRollno());
			status = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public void closeObject() {
		try {
			con.close();
//			rs.close();
//			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/* normal statement 
	public Mca getRecord(int rollno) {
		Mca mca = null;
		try {
			st = con.createStatement();
			rs= st.executeQuery("select * from mca where rollno = "+rollno);
			if(rs.next()) {
				mca=new Mca();
				mca.setRollno(rs.getInt("rollno"));
				mca.setName(rs.getString("name"));
				mca.setCity(rs.getString("city"));
				mca.setSubject(rs.getString("subject"));
				mca.setPhone(rs.getLong("phone"));
			} else {
				System.out.println("Nothing !!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mca;
	}
	
	public List<Mca> getAllRecords(){
		List<Mca> mlist = new ArrayList<Mca>();
		Mca mca = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from mca");
			while(rs.next()) {
				mca=new Mca();
				mca.setRollno(rs.getInt("rollno"));
				mca.setName(rs.getString("name"));
				mca.setCity(rs.getString("city"));
				mca.setSubject(rs.getString("subject"));
				mca.setPhone(rs.getLong("phone"));
				mlist.add(mca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
	public List<Mca> getRecordsByPage(int page,int i){
		List<Mca> mlist = new ArrayList<Mca>();
		Mca mca = null;
		try {
			st =  con.createStatement();
			rs = st.executeQuery("select * from mca limit "+page+","+i);
			while(rs.next()) {
				mca=new Mca();
				mca.setRollno(rs.getInt("rollno"));
				mca.setName(rs.getString("name"));
				mca.setCity(rs.getString("city"));
				mca.setSubject(rs.getString("subject"));
				mca.setPhone(rs.getLong("phone"));
				mlist.add(mca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
	public int insertRecord(Mca m) {
		int rs = 0 ;
		try {
			st = con.createStatement();
			rs = st.executeUpdate("insert into mca values("+m.getRollno()+",'"+m.getName()+"','"+m.getCity()+"','"+m.getSubject()+"',"+m.getPhone()+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int deleteRecord(int roll) {
		int status = 0 ;
		try {
			st = con.createStatement();
			status = st.executeUpdate("delete from mca where rollno ="+roll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public int updateRecord(Mca m) {
		int status = 0;
		try {
			st = con.createStatement();
			status = st.executeUpdate("update mca set name ='"+m.getName()+"',city='"+m.getCity()+"',subject='"+m.getSubject()+"',phone="+m.getPhone()+" where rollno ="+m.getRollno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public void closeObject() {
		try {
			con.close();
//			rs.close();
//			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */
	
}
