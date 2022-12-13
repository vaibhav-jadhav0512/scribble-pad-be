package com.scribble.pad.be.repository.query;

public class ScribblePadQueries {

	public static final String GET_ALL_NOTES_BY_USER_ID = "SELECT note_id, `date`, description, tag, title, user_id "
			+ "FROM scribble_pad.notes WHERE user_id=:userId";
	public static final String ADD_NOTE = "INSERT INTO scribble_pad.notes "
			+ "(`date`, description, tag, title, user_id) "
			+ "VALUES(CURRENT_TIMESTAMP, :description, :tag, :title, :userId)";
	public static final String UPDATE_NOTE = "UPDATE scribble_pad.notes "
			+ "SET `date`=CURRENT_TIMESTAMP, description=:description, tag=:tag, title=:title "
			+ "WHERE note_id=:noteId AND user_id=:userId";
	public static final String DELETE_NOTE = "DELETE FROM scribble_pad.notes "
			+ "WHERE note_id=:noteId AND user_id=:userId";
}
