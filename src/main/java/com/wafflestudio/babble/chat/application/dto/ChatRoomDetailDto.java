package com.wafflestudio.babble.chat.application.dto;

import java.util.List;

import com.wafflestudio.babble.chat.domain.chatroom.ChatRoom;
import com.wafflestudio.babble.location.domain.Location;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChatRoomDetailDto {

    private final ChatRoomResponseDto room;
    private final Boolean isChatter;
    private final Integer chatterCount;
    private final ChatsDto chatsDto;

    public static ChatRoomDetailDto of(ChatRoom room, Location userLocation, int chatterCount, ChatsDto chats) {
        return new ChatRoomDetailDto(ChatRoomResponseDto.of(room, userLocation), chats.isChatter(), chatterCount, chats);
    }

    public Long getMyChatterId() {
        return chatsDto.getMyChatterId();
    }

    public List<ChatDto> getChats() {
        return chatsDto.getValues();
    }
}
