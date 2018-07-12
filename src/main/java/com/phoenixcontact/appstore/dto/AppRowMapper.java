package com.phoenixcontact.appstore.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.phoenixcontact.appstore.domain.App;

public class AppRowMapper implements RowMapper<App> {

	@Override
	public App mapRow(ResultSet rs, int rowNum) throws SQLException {
		App app = new App();
		//primary key(s); should always be part of the query
		app.setId(rs.getLong("id"));
		app.setName(rs.getString("_name"));
		app.setUserUuid(rs.getString("user_uuid"));
		//all other fields; may not be part of the query, so check first
		if (MappingHelper.checkIfNameExist(rs, "downloads"))
			app.setDownloads(rs.getInt("downloads"));
		if (MappingHelper.checkIfNameExist(rs, "price"))
			app.setPrice(rs.getDouble("price"));
		if (MappingHelper.checkIfNameExist(rs, "version"))
			app.setVersion(rs.getString("version"));
		if (MappingHelper.checkIfNameExist(rs, "description"))
			app.setDescription(rs.getString("description"));
		if (MappingHelper.checkIfNameExist(rs, "whatsnew"))
			app.setWhatsNew(rs.getString("whatsnew"));
		if (MappingHelper.checkIfNameExist(rs, "icon_url"))
			app.setIconUrl(rs.getString("icon_url"));
		if (MappingHelper.checkIfNameExist(rs, "last_update"))
			app.setLastUpdate(rs.getDate("last_update"));
		if (MappingHelper.checkIfNameExist(rs, "active"))
			app.setActive(rs.getBoolean("active"));
		if (MappingHelper.checkIfNameExist(rs, "certified"))
			app.setCertified(rs.getBoolean("certified"));
		if (MappingHelper.checkIfNameExist(rs, "rating"))
			app.setRating(rs.getDouble("rating"));
		
		return app;
	}
	
}
