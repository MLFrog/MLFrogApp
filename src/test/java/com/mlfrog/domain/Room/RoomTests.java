package com.mlfrog.domain.Room;

import org.junit.jupiter.api.Test;

@sl
public class RoomTests {
	
	@Test
	public void 방_생성_테스트() {
		String youtube = "Youtube";
		String file = "File";
		RoomFactory roomFactory = new RoomFactory();
		RoomId id1 = RoomId.of(11);
		RoomId id2 = RoomId.of(22);
		
		Room room1 = roomFactory.getInstance(id1, file);
		Room room2 = roomFactory.getInstance(id2, youtube);
		
		log.info("?? : " + room1.getId());
		log.info("?? : " + room2.getId());
		
		room1.musicUpload();
		room2.musicUpload();
	}
}
