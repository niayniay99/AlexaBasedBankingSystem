package com.amazon.ask.helloworld_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.ask.helloworldservlet.model.LoantypeinfoVO;

public class Database {
	static Connection cn = null;
	// jdbc:mysql://localhost:3307/project_db
	// un : root pw: root
	static final String HOSTNAME = "jdbc:mysql://database-1-alexa-banking.cqoiev0du86m.us-east-1.rds.amazonaws.com/project_db_alexa_banking";
	static final String USERNAME = "admin";
	static final String PASSWORD = "Admin1234";

	public static Statement connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
			Statement s = cn.createStatement();

			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List search(String fn) {
		List ls = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from Register where first_name='" + fn + "'");
			while (rs.next()) {
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				ls.add(firstname);
				ls.add(lastname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public void insert(String fn, String ln) {
		try {
			Statement s = connection();
			s.executeUpdate("insert into Register(first_name,last_name) values('" + fn + "','" + ln + "')");
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void insert(String s1) { System.out.println("before insert...");
	 * try { String s2 = "world"; Statement s = connection();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * @param pin
	 * @return
	 */
	public List searchPin(String pin) {
		List ls1 = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select * from login_table where pin='" + pin + "'");
			while (rs.next()) {
				String name = rs.getString("username");

				ls1.add(name);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls1;
	}

	public List<String> searchAccounttype() {
		List<String> ls2 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("select account_type from accounttype_table where status = true");
			while (rs.next()) {
				String Accounttype = rs.getString("account_type");
				ls2.add(Accounttype);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls2;
	}

	public List<String> searchAccountdescription(String accounttype) {
		List<String> ls3 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT account_description FROM accounttype_table WHERE account_type ='"
					+ accounttype + "' AND status = true");
			while (rs.next()) {
				String Accountdescription = rs.getString("account_description");

				ls3.add(Accountdescription);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls3;
	}

	public List searchLoantype() {
		List<String> ls4 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT loan_type from loantype_table where status = true");
			while (rs.next()) {
				String Loantype = rs.getString("loan_type");
				ls4.add(Loantype);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls4;

	}

	public List searchLoanid(String loantype) {
		List loanls = new ArrayList();

		int Loantypeid;
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT loantype_id FROM loantype_table WHERE loan_type ='" + loantype + "' AND status = true");
			while (rs.next()) {
				Loantypeid = rs.getInt("loantype_id");
				loanls.add(Loantypeid);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loanls;
	}

	public List searchLoantypedescription(int loantypeid) {
		List ls6 = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT * FROM loantypeinfo_table WHERE loantype_id ='" + loantypeid + "' AND status = true");
			while (rs.next()) {

				String Loan_Rate = rs.getString("loan_rate");
				String maximumloan_Amount = rs.getString("maximumloan_Amount");
				String numberof_Emi = rs.getString("numberof_Emi");
				String time_Duration = rs.getString("time_Duration");
				
				String desc = Loan_Rate + maximumloan_Amount + numberof_Emi + time_Duration;
				
//				LoantypeinfoVO loantypeinfoVO = new LoantypeinfoVO();
//				loantypeinfoVO.setLoanRate(Loan_Rate);
//				loantypeinfoVO.setMaximumloanAmount(maximumloan_Amount);
//				loantypeinfoVO.setNumberofEmi(numberof_Emi);
//				loantypeinfoVO.setTimeDuration(time_Duration);

				ls6.add(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls6;
	}

	public List searchAreaname() {
		List<String> ls7 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT area_name from area_table where status = true");
			while (rs.next()) {
				String Areaname = rs.getString("area_name");
				ls7.add(Areaname);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls7;

	}

	public List searchAreadescription(String areaname) {
		List<String> ls8 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT area_description from area_table where area_name='" + areaname + "' AND status = true");
			while (rs.next()) {
				String Areadescription = rs.getString("area_description");
				ls8.add(Areadescription);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls8;

	}

	public List searchAreaid(String areaname) {
		int Areaid;
		List ls9 = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT area_id FROM area_table WHERE area_name ='" + areaname + "' AND status = true");
			while (rs.next()) {
				Areaid = rs.getInt("area_id");
				System.out.println(Areaid);
				String areaID = Integer.toString(Areaid);
				ls9.add(areaID);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls9;

	}

	public List searchBranch(int areaid) {
		List<String> ls10 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT branch_name FROM branch_table WHERE area_id ='" + areaid + "' AND status = true");
			while (rs.next()) {
				String Branchname = rs.getString("branch_name");

				ls10.add(Branchname);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls10;

	}

	public List searchBranchAddress(String branchname) {
		List<String> ls11 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT branch_address FROM branch_table WHERE branch_name ='" + branchname
					+ "' AND status = true");
			while (rs.next()) {
				String Branchaddress = rs.getString("branch_address");
				System.out.println(Branchaddress);
				ls11.add(Branchaddress);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls11;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Database d = new Database(); //d.insert("a", "b"); List ls =
		 * d.search("a");
		 * 
		 * String speech=""; for (int i = 0; i < ls.size(); i++) { if(i==0){
		 * speech = (String)ls.get(0); }else{ speech =
		 * speech+", "+(String)ls.get(i); } }
		 * System.out.println("Data: "+speech);
		 */
		Database d1 = new Database();
		/*
		 * List ls1 = d1.searchPin("1234");
		 * 
		 * String speech1 = ""; for (int i = 0; i < ls1.size(); i++) { if (i ==
		 * 0) { speech1 = (String) ls1.get(0); } else { speech1 = speech1 + " "
		 * + (String) ls1.get(i); } } System.out.println("Name: " + speech1);
		 * 
		 * String speech2 = ""; Database d2 = new Database(); List ls2 =
		 * d2.searchAccounttype(); for (int i = 0; i < ls2.size(); i++) { if (i
		 * == 0) { speech2 = (String) ls2.get(0); } else { speech2 = speech2 +
		 * " Account, " + (String) ls2.get(i); } }
		 * 
		 * System.out.println("Account: " + speech2 + " Account. ");
		 * 
		 * String speech3 = ""; Database d3 = new Database(); List ls3 =
		 * d3.searchAccountdescription("Savings"); for (int i = 0; i <
		 * ls3.size(); i++) { if (i == 0) { speech3 = (String) ls3.get(0); }
		 * else { speech3 = "Somewhere error"; } }
		 * System.out.println("Description : " + speech3 + ". "); //Loan String
		 * speech4 = ""; Database d4 = new Database(); List ls4 =
		 * d4.searchLoantype(); for (int i = 0; i < ls4.size(); i++) { if (i ==
		 * 0) { speech4 = (String) ls4.get(0); } else { speech4 = speech4 +
		 * " Loan, " + (String) ls4.get(i); } }
		 * 
		 * System.out.println("Loan: " + speech4 + " Loan. ");
		 * 
		 * //Getting Loan id String speech5 = ""; Database d5 = new Database();
		 * int loantypeid = d5.searchLoanid("Personal");
		 * 
		 * speech5 = ""+loantypeid; System.out.println(speech5);
		 */

		// Loan Type
		String speech6 = "";
		Database d6 = new Database();
		List ls6 = d6.searchLoantypedescription(13);
		LoantypeinfoVO loantypeinfoVO = (LoantypeinfoVO) ls6.get(0);
		System.out.println("DESCRIPTION OF SPEECH 6 :\n rate of interest= " + loantypeinfoVO.getLoanRate()
				+ "\n max ammount = " + loantypeinfoVO.getMaximumloanAmount() + "\n emi = "
				+ loantypeinfoVO.getNumberofEmi() + "\n duration" + loantypeinfoVO.getTimeDuration());

		// Get Area name
		String speech7 = "";
		Database d7 = new Database();
		List ls7 = d7.searchAreaname();

		for (int i = 0; i < ls7.size(); i++) {
			if (i == 0) {
				speech7 = (String) ls7.get(0);
			} else {
				speech7 = speech7 + " Area, " + (String) ls7.get(i);
			}
		}

		System.out.println("Area : " + speech7 + " Area. ");

		// Area Description
		String speech8 = "";
		Database d8 = new Database();
		List ls8 = d8.searchAreadescription("Surat");

		for (int i = 0; i < ls8.size(); i++) {
			if (i == 0) {
				speech8 = (String) ls8.get(0);
			} else {
				speech8 = "Somewhere error";
			}
		}

		System.out.println("Area Description : " + speech8);

		// Getting Loan id
		String speech9 = "";
		Database d9 = new Database();
		List ls9 = d9.searchAreaid("Rajkot");
		for (int i = 0; i < ls9.size(); i++) {
			if (i == 0) {
				speech9 = (String) ls9.get(0);
			} else {
				speech9 = "Something error";
			}
		}
		System.out.println("ID : " + speech9);

		String speech10 = "";
		Database d10 = new Database();
		List ls10 = d10.searchBranch(3);

		for (int i = 0; i < ls10.size(); i++) {
			if (i == 0) {
				speech10 = "SBI - " + (String) ls10.get(0);
			} else {
				speech10 = speech10 + " Branch, " + "SBI - " + (String) ls10.get(i);
			}
		}
		System.out.println("Branch : " + speech10 + " Branch. ");

		String speech11 = "";
		Database d11 = new Database();
		List ls11 = d11.searchBranchAddress("SMECCC Majura Gate");
		for (int i = 0; i < ls11.size(); i++) {
			if (i == 0) {
				speech11 = "Address: " + (String) ls11.get(0);
			} else {
				speech11 = "Something error";
			}
		}
		System.out.println("Address : " + speech11);

	}
}
