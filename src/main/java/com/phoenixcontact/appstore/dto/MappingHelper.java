package com.phoenixcontact.appstore.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappingHelper {

	public static boolean checkIfNameExist(ResultSet rs, String name) {
		boolean result = true;
		try {
			rs.getObject(name);
		} catch (SQLException ex) {
			result = false;
		}
		return result;
	}


}
