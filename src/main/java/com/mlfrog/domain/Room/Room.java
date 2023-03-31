package com.mlfrog.domain.Room;

import com.mlfrog.domain.Room.Chat.ChattingRoom;
import com.mlfrog.domain.Room.Exception.RoomException;
import com.mlfrog.domain.Room.Uploader.Uploader;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 도메인 객체
 * 
 * 도메인이 실행하는 모든 행위는 여기에 정의하여야 한다.
 * 추가로 분류되어질 수 있는 도메인인데, 하위에 종속되는 객체라면
 * 서브 도메인으로 정의한다.
 * @author 최현호
 *
 */

@Data
@RequiredArgsConstructor
public class Room {
	
	/*
	 * 방 고유 ID
	 */
	private final RoomId id;
	
	/*
	 * 방 생성 시간
	 */
	private String createDate;
	
	/*
	 * 입장 가능한 유저 제한 수
	 */
	private int userLimit;
	
	/*
	 * 현재 입장한 유저 수
	 */
	private int joinUserCnt;
	
	/*
	 * 업로드
	 * 업로드 기능 자체는 방이 가진 고유 기능
	 * Music의 기능이 아니다.
	 */
	private Uploader uploader;
	
	/*
	 * 테스트용 채팅방
	 */
	private ChattingRoom chattingRoom; 
	
	public Room(RoomId id, Uploader uploader) {
		this.id = id;
		this.uploader = uploader;
	}
	
	public Room(RoomId id, ChattingRoom chattingRoom) {
		this.id = id;
		this.chattingRoom = chattingRoom;
	}
	
	/*
	 * 음악 업로드
	 * 업로드 방식을 정해주도록 Factory에서 정해줘야 함
	 */
	public void musicUpload() {
		uploader.upload();
	}
	
	/*
	 * 방 인원 입장
	 */
	public int addUser() {
		if (joinUserCnt <= userLimit) {
			joinUserCnt += 1;
			return this.joinUserCnt;
		} else {
			throw new RoomException("Full");
		}
	}
	
	/*
	 * 방 인원 퇴장
	 */
	public int subUser() {
		if (joinUserCnt > 0) {
			joinUserCnt -= 1;
			return this.joinUserCnt;
		} else {
			throw new RoomException("No User");
		}
	}
}
