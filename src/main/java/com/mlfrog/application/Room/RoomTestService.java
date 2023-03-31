package com.mlfrog.application.Room;

import org.springframework.stereotype.Service;

import com.mlfrog.domain.Room.Room;

/**
 * 교육 예시용 서비스
 * 추후 사용하게 될지 여부는 모른다
 * @author 최현호
 */

@Service
public interface RoomTestService {
	public Room createRoom(String roomType);
}
