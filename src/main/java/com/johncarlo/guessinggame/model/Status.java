package com.johncarlo.guessinggame.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    WON("won"),
    LOST("lost"),
    PLAYING("playing"),
    SURRENDERED("surrendered");

    private final String value;

}