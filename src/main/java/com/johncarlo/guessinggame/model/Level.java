package com.johncarlo.guessinggame.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Level {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private final String rating;

}
