package com.mlfrog.domain.Room;

import com.mlfrog.domain.Room.Chat.impl.ChattingOnlyRoom;
import com.mlfrog.domain.Room.Uploader.impl.FileUploader;
import com.mlfrog.domain.Room.Uploader.impl.YoutubeLinkUploader;

/**
 * 팩토리 패턴은 객체의 생성을 위임하는 방법
 * 방 종류가 1개인 경우엔 무의미하지만, 
 * 추후 여러개로 늘어나는 경우 해당 코드에서 반환하는 방의 종류를 정해서 반환할 수 있게된다.
 * @author 최현호
 *
 */

public class RoomFactory {
	
	// 팩토리 생성할 때, 필수요소가 있다면 생성자로 받아준다.
	public RoomFactory() {
		
	}
	
	// 단지 하위 객체 구현을 위해서 나누는 형태라면 getInstance에서 구현한다.
	public Room getInstance(RoomId id, String roomType) {
		if (roomType.equals("File")) {
			return new Room(id, new FileUploader());
		} else if (roomType.equals("Youtube")) {
			return new Room(id, new YoutubeLinkUploader());
		} else if (roomType.equals("Chat")) {
			return new Room(id, new ChattingOnlyRoom());
		}else {
			throw new IllegalArgumentException();
		}
	}
}
