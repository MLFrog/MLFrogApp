package com.mlfrog.domain.Board;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class BoardId implements Serializable {

    private final long value;

    static BoardId of(long value) {
        return BoardId.of(value);
    }

    @Override
    public String toString() {
        return Long.toString(this.value);
    }
}
