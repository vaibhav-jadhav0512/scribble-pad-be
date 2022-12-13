package com.scribble.pad.be.repository;

import java.util.List;

import com.scribble.pad.be.model.Notes;

public interface NotesRepository {

	List<Notes> getAllNotesByUserId(String userId);

	int addNote(String userId, Notes note);

	int updateNote(String userId, Notes note);

	int deleteNote(String userId, Long noteId);

}
