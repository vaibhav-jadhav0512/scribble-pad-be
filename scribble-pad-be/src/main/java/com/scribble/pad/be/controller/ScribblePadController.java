package com.scribble.pad.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scribble.pad.be.model.Notes;
import com.scribble.pad.be.service.ScribblePadService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/scribble-pad")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ScribblePadController {

	@Autowired
	private ScribblePadService service;

	@GetMapping("/get/all")
	public ResponseEntity<List<Notes>> getAllNotes(Authentication authentication) {
		log.info("Getting all notes for user:{}", authentication.getName());
		return new ResponseEntity<>(service.getAllNotesByUserId(authentication.getName()), HttpStatus.OK);
	}

	@PostMapping("/note/add")
	public ResponseEntity<Integer> addNote(Authentication authentication, @RequestBody Notes note) {
		log.info("Adding note for user:{} with notes:{}", authentication.getName(), note.toString());
		return new ResponseEntity<>(service.addNote(authentication.getName(), note), HttpStatus.CREATED);
	}

	@PutMapping("/note/edit")
	public ResponseEntity<Integer> updateNote(Authentication authentication, @RequestBody Notes note) {
		log.info("Updating note for user:{} with notes:{}", authentication.getName(), note.toString());
		return new ResponseEntity<>(service.updateNote(authentication.getName(), note), HttpStatus.CREATED);
	}

	@DeleteMapping("/note/delete/{noteId}")
	public ResponseEntity<Integer> deleteNote(Authentication authentication, @PathVariable("noteId") Long noteId) {
		log.info("Deleting note for user:{} with note ID:{}", authentication.getName(), noteId);
		return new ResponseEntity<>(service.deleteNote(authentication.getName(), noteId), HttpStatus.NO_CONTENT);
	}
}
