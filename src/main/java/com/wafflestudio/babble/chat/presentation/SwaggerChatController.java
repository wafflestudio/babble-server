package com.wafflestudio.babble.chat.presentation;

import org.springframework.http.ResponseEntity;

import com.wafflestudio.babble.chat.presentation.dto.ChatResponse;
import com.wafflestudio.babble.chat.presentation.dto.ChatsResponse;
import com.wafflestudio.babble.chat.presentation.dto.ChatterResponse;
import com.wafflestudio.babble.chat.presentation.dto.CreateChatRequest;
import com.wafflestudio.babble.chat.presentation.dto.CreateChatRoomRequest;
import com.wafflestudio.babble.chat.presentation.dto.CreateChatterRequest;
import com.wafflestudio.babble.chat.presentation.dto.GetChatRoomResponse;
import com.wafflestudio.babble.chat.presentation.dto.NearByChatRoomsResponse;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

public interface SwaggerChatController {

    @ApiOperation(value = "현재 위치를 기준으로 채팅방 목록을 조회한다.")
    ResponseEntity<NearByChatRoomsResponse> getNearbyRooms(Double latitude, Double longitude);

    @ApiOperation(value = "로그인한 유저의 현재 위치를 기반으로 채팅방을 생성하고, 본인이 방장이 된다.")
    @ApiImplicitParams({
        @ApiImplicitParam(
            // NOTE: 파라미터가 아니라 ResponseBody의 경우
            // name에 어떤 값을 입력하는지에 따라 애플리케이션 실행이 안되거나 Example Value에 표시되지 않을 수 있다.
            // 우선순위가 낮으므로 디버깅을 보류하고 임의의 문자열을 사용한다.
            name = "ABC",
            required = true,
            paramType = "body", dataTypeClass = CreateChatRoomRequest.class)
    })
    ResponseEntity<Void> createRoom(String authId, CreateChatRoomRequest requestBody);

    @ApiOperation(value = "특정 채팅방에 입장하며 본인의 참여 여부와 최근 채팅들을 조회한다.")
    ResponseEntity<GetChatRoomResponse> getChatRoom(@ApiIgnore String authId, Long roomId, Double latitude, Double longitude);

    @ApiOperation(value = "채팅방에 참여한다.")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "ABC",
            required = true,
            paramType = "body", dataTypeClass = CreateChatterRequest.class)
    })
    ResponseEntity<ChatterResponse> createChatter(@ApiIgnore String authId, Long roomId, CreateChatterRequest requestBody);

    @ApiOperation(value = "가장 최근에 조회한 채팅을 기준으로 그 이후에 생성된 모든 채팅을 조회한다.")
    ResponseEntity<ChatsResponse> getChats(@ApiIgnore String authId, Long roomId, Long latestChatId, Double latitude, Double longitude);

    @ApiOperation(value = "본인이 참여 중인 채팅방에서 채팅을 생성한다.")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "ABC",
            required = true,
            paramType = "body", dataTypeClass = CreateChatRequest.class)
    })
    ResponseEntity<ChatResponse> createChat(@ApiIgnore String authId, Long roomId, CreateChatRequest requestBody);
}
