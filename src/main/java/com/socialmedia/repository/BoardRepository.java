package com.socialmedia.repository;

import com.socialmedia.model.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Boards,Integer> {


}