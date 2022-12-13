package com.scribble.pad.be.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scribble.pad.be.model.Notes;

public class NotesRowMapper implements RowMapper<Notes> {

	@Override
	public Notes mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notes obj = new Notes();
		obj.setUserId(rs.getString("user_id"));
		obj.setNoteId(rs.getLong("note_id"));
		obj.setDescription(rs.getString("description"));
		obj.setTitle(rs.getString("title"));
		obj.setTag(rs.getString("tag"));
		obj.setDate(rs.getTimestamp("date"));
		return obj;
	}
	}


