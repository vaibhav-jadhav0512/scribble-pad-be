package com.scribble.pad.be.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scribble-pad")
public class ScribblePadController {

	@GetMapping("/test")
	@RolesAllowed("admin")
	public String test() {
		return "success";
	}

}
