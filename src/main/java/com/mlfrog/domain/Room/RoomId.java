package com.mlfrog.domain.Room;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


/**
 * Id값을 primitive 값으로 관리하면,
 * 추후 여러 id를 가져다가 사용할 때 구분이 어려워질 수 있다.
 * 이에 따로 객체로 관리를 하는 방법을 이용한다.
 * @author 최현호
 *
 */

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class RoomId implements Serializable{
	private final long value;
	
	static RoomId of(int value) { return RoomId.of((long) value); }
	
	@Override
	public String toString() { return Long.toString(this.value); }
}
