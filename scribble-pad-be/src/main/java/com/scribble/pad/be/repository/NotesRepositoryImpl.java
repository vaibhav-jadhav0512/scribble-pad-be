package com.scribble.pad.be.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scribble.pad.be.model.Notes;
import com.scribble.pad.be.repository.query.ScribblePadQueries;
import com.scribble.pad.be.repository.rowmapper.NotesRowMapper;

@Repository
public class NotesRepositoryImpl implements NotesRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Notes> getAllNotesByUserId(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return template.query(ScribblePadQueries.GET_ALL_NOTES_BY_USER_ID, params, new NotesRowMapper());
	}

	@Override
	public int addNote(String userId, Notes note) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("title", note.getTitle());
		params.put("description", note.getDescription());
		params.put("tag", note.getTag());
		return template.update(ScribblePadQueries.ADD_NOTE, params);
	}

	@Override
	public int updateNote(String userId, Notes note) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("title", note.getTitle());
		params.put("description", note.getDescription());
		params.put("tag", note.getTag());
		params.put("noteId", note.getNoteId());
		return template.update(ScribblePadQueries.UPDATE_NOTE, params);
	}

	@Override
	public int deleteNote(String userId, Long noteId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("noteId", noteId);
		return template.update(ScribblePadQueries.DELETE_NOTE, params);
	}

}
