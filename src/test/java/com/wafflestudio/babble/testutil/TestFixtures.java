package com.wafflestudio.babble.testutil;

import com.wafflestudio.babble.location.domain.Location;

public class TestFixtures {

    public static final String USER_ID = "ABC123";
    public static final Long KAKAO_AUTH_ID = 123L;
    public static final String NICKNAME = "멋진하마";
    public static final String ROOM_NAME = "101동 수업 강의실";
    public static final String HASHTAG = "LECTURE_ROOM";
    public static final String HASHTAG_DISPLAYNAME = "강의실";
    public static final String CHAT_CONTENT = "안녕하세요";
    public static final Location LOCATION = new Location(10.0d, 10.0d);
    public static final Double LATITUDE = 10.0d;
    public static final Double LONGITUDE = 10.0d;
    // 2024년 2월 12일 0시 0분 0초
    public static final Long PAST_UNIX_TIME = 1707696000L;
    public static final Long PAST_UNIX_TIME_MS = PAST_UNIX_TIME * 1000;
    // 2024년 2월 12일 0시 0분 0초
    public static final Long FUTURE_UNIX_TIME = 32472144000L;
    public static final Long FUTURE_UNIX_TIME_MS = FUTURE_UNIX_TIME * 1000;
}
