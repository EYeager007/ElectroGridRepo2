package com;

import java.sql.*;

public class Roles
{
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
 
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/paf", "root", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public String readRoles()
	{
		String output = "";
		
		try
		{
			Connection con = connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
 
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Role_id</th><th>Role_name</th><th>Role_description</th></tr>";
 
			String query = "select * from Roles";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
 
			// iterate through the rows in the result set
			while (rs.next())
			{
				String roleID = Integer.toString(rs.getInt("Role_ID"));
				String roleName = rs.getString("Role_Name");
				String roleDescription = rs.getString("Role_description");
 
				// Add into the html table
				output += "<tr><td><input id='hidRoleIDUpdate'name='hidRoleIDUpdate'type='hidden' value='" + roleID+ "'>" + roleName + roleDescription + "</td>";
				output += "<td>" + roleID + "</td>";
				output += "<td>" + roleName + "</td>";
				output += "<td>" + roleDescription + "</td>";
 
				// buttons
				output += "<td><input name='btnUpdate'type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"+ "<td><input name='btnRemove'type='button' value='Remove'class='btnRemove btn btn-danger'data-roleid='"+ roleID + "'>" + "</td></tr>";
			}
 
			con.close();
 
			// Complete the html table
			output += "</table>";
		}
 
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
 
		return output;
	}
	
	public String insertRole(String ID, String Name, String Description)
    {
		String output = "";

		try
		{
			Connection con = connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
 
			// create a prepared statement
			String query = " insert into items(`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)"+ " values (?, ?, ?, ?, ?)";
		 
			PreparedStatement preparedStmt = con.prepareStatement(query);
		 
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, ID);
			preparedStmt.setString(3, Name);
			preparedStmt.setString(5, Description);
		 
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readRoles();
			output = "{\"status\":\"success\", \"data\": \"" +readRoles() + "\"}";
		 }
		
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\":\"Error while inserting the Roles.\"}";
			 System.err.println(e.getMessage());
		 }
		
		 return output;
		 
		 }
	
		 public String updateRoles(String ID, String Name, String Description)
		 {
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for updating.";
				 }
				 
				 // create a prepared statement
				 String query = "UPDATE Roles SET RolesID=?,RolesName=?,RolesDescription=? WHERE RolesID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
				 // binding values
				 preparedStmt.setString(1, ID);
				 preparedStmt.setString(2, Name);
				 preparedStmt.setString(4, Description);

		
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
		
				 String newRoles = readRoles();
				 output = "{\"status\":\"success\", \"data\": \"" +
				 newRoles + "\"}";
		 }
			 
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while updating the Roles.\"}";
			 System.err.println(e.getMessage());
		 }
		 
		return output;
	}
		
	public String deleteRoles(String RoleID)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for deleting.";
			 }
		 
			 // create a prepared statement
			 String query = "delete from items where RoleID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(RoleID));
		 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 String newRoles = readRoles();
			 output = "{\"status\":\"success\", \"data\": \"" +
			 newRoles + "\"}";
		 }
		 
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the role.\"}";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
		 }
	}
		 