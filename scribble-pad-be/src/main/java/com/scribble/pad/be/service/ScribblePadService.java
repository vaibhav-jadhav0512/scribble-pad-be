package com.scribble.pad.be.service;

import java.util.List;

import com.scribble.pad.be.model.Notes;

public interface ScribblePadService {

	public List<Notes> getAllNotesByUserId(String userId);

	public int addNote(String userId, Notes note);

	public int updateNote(String userId, Notes note);

	public int deleteNote(String userId, Long noteId);

}
