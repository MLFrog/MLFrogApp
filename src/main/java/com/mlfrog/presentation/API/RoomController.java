package com.mlfrog.presentation.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlfrog.application.Room.RoomTestService;
import com.mlfrog.domain.Room.Room;

@RestController
public class RoomController {
	
	@Autowired
	private RoomTestService roomTestService;
	
	@GetMapping("/createFileRoom")
	public String createFileRoom() {
		Room room = roomTestService.createRoom("File");
		room.musicUpload();
		return room.toString();
	}
	
	@GetMapping("/createYoutubeRoom")
	public String createYoutubeRoom() {
		Room room = roomTestService.createRoom("Youtube");
		room.musicUpload();
		return room.toString();
	}
	
	@GetMapping("/createChatRoom")
	public String createChatRoom() {
		Room room = roomTestService.createRoom("Chat");
		return room.toString();
	}
}
