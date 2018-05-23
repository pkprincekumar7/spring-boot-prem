package com.tricon.dbservice.repository;

import com.tricon.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by premsingh on 2/19/18.
 */
public interface QuotesRepository extends JpaRepository<Quote,Integer> {
    List<Quote> findByUserName(String username);
}
