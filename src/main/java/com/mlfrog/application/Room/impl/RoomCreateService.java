package com.mlfrog.application.Room.impl;

import org.springframework.stereotype.Service;

import com.mlfrog.application.Room.RoomTestService;
import com.mlfrog.domain.Room.Room;
import com.mlfrog.domain.Room.RoomFactory;
import com.mlfrog.domain.Room.RoomId;

@Service
public class RoomCreateService implements RoomTestService{
	private RoomFactory roomFactory = new RoomFactory();
	
	@Override
	public Room createRoom(String roomType) {
		/*
		 * 1. 디비에서 Sequence를 통해서 가장 최근 값을 가져온다.
		 * 2. 가져온 값에서 +1 한 값을 ID로 만든다.(동시성 문제가 발생 할 수 있다. 지금은 예제이니까 생각안함)
		 * 3. 해당 ID로 방 생성
		 */
		
		// 실제 DB랑 연동 되어 있다면 DB에서 최신 값을 가져오도록 해야됨
		RoomId roomId = RoomId.of(11);
		return roomFactory.getInstance(roomId, roomType);
	}

}