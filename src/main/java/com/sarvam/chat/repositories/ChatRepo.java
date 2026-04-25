package com.sarvam.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarvam.chat.entites.ChatInfo;

public interface ChatRepo extends JpaRepository<ChatInfo, Long> {

}
