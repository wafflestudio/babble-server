package com.wafflestudio.babble.chat.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wafflestudio.babble.member.domain.Member;

@Repository
public interface ChatterRepository extends JpaRepository<Chatter, Long> {

    boolean existsByRoomAndMember(ChatRoom room, Member member);

    boolean existsByRoomAndNickname(ChatRoom room, String nickname);

    int countByRoom(ChatRoom room);

    @Query("SELECT c "
        + "FROM Chatter c "
        + "JOIN c.room "
        + "JOIN c.member "
        + "WHERE c.room.id = :roomId AND c.member.userId = :userId")
    Optional<Chatter> findByRoomIdAndUserId(@Param("roomId") Long roomId, @Param("userId") String userId);

    Optional<Chatter> findByRoomAndMember(ChatRoom room, Member member);
}
