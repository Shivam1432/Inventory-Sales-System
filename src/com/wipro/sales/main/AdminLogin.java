package com.wipro.sales.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.sales.util.DBUtil;

public class AdminLogin 
{
	JFrame frame;
	JTextField t1;
	JPasswordField passwordField;
	Connection conn = null;
	PreparedStatement pstmt = null;
	AdminLogin()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Username:");
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		l1.setBounds(321, 64, 169, 22);
		frame.getContentPane().add(l1);
		
		t1 = new JTextField();
		t1.setBounds(321, 96, 191, 19);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel l2 = new JLabel("Password:");
		l2.setFont(new Font("Tahoma", Font.BOLD, 16));
		l2.setBounds(321, 190, 169, 22);
		frame.getContentPane().add(l2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(321, 240, 191, 19);
		frame.getContentPane().add(passwordField);
		
		JButton b1 = new JButton("Login");
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from HR.TBL_ADMIN where name=? and pass=?";
				String uname=t1.getText();
				String pwd=passwordField.getText();
				try {
					conn = DBUtil.getDBConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uname);
					pstmt.setString(2, pwd);
					ResultSet rs=pstmt.executeQuery();
					int count=0;
					while(rs.next())
					{
						count++;
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null,"Login successful");
						frame.dispose();
						new SalesApplication();
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null,"Duplicate username and password");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Username or password incorrect");
					}
					rs.close();
					pstmt.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					
				}
			}
		});
		b1.setBounds(217, 345, 160, 36);
		frame.getContentPane().add(b1);
		
		JLabel l3 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		l3.setIcon(new ImageIcon(img));
		l3.setBounds(88, 34, 160, 273);
		frame.getContentPane().add(l3);
		frame.setVisible(true);
	}
	public static void main(String[] args) throws ParseException {
		new AdminLogin();
	}
}
