package com.scribble.pad.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribble.pad.be.model.Notes;
import com.scribble.pad.be.repository.NotesRepository;

@Service
public class ScribblePadServiceImpl implements ScribblePadService {

	@Autowired
	private NotesRepository repo;

	@Override
	public List<Notes> getAllNotesByUserId(String userId) {
		return repo.getAllNotesByUserId(userId);
	}

	@Override
	public int addNote(String userId, Notes note) {
		return repo.addNote(userId, note);
	}

	@Override
	public int updateNote(String userId, Notes note) {
		return repo.updateNote(userId, note);
	}

	@Override
	public int deleteNote(String userId, Long noteId) {
		return repo.deleteNote(userId, noteId);
	}

}
