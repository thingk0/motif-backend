package com.ssafy.motif.app.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    /* 회원(Member) */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입 성공"),
    LOGIN_SUCCESS(HttpStatus.OK, "로그인 성공"),

    /* 시간표(TimeTable) */
    TIMETABLE_CREATE_SUCCESS(HttpStatus.CREATED, "타임테이블 생성 성공"),
    TIMETABLE_RESPONSE_SUCCESS(HttpStatus.OK, "타임테이블 조회 성공"),

    /* 스케쥴(Schedule) */
    SCHEDULE_CREATE_SUCCESS(HttpStatus.CREATED, "스케쥴 생성 성공");


    private final HttpStatus status;
    private final String message;
}

