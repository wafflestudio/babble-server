package com.wafflestudio.babble.chat.domain.chatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.wafflestudio.babble.common.exception.BadRequestException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Nickname {

    private static final Pattern NICKNAME_PATTERN = Pattern.compile("^[ ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]{1,15}$");

    @Column(name = "nickname", nullable = false)
    private String value;

    public Nickname(String value) {
        value = value.trim();
        Matcher matcher = NICKNAME_PATTERN.matcher(value);
        if (!matcher.matches()) {
            throw new BadRequestException("닉네임은 최대 1~15글자 한글, 숫자, 영문자로만 구성되어야 합니다.");
        }
        this.value = value;
    }
}
