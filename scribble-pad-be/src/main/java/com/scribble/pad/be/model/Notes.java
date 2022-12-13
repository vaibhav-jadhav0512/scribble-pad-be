package com.scribble.pad.be.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Notes {
	private String userId;
	private Long noteId;
	private String title;
	private String description;
	private String tag;
	private Timestamp date;

}
