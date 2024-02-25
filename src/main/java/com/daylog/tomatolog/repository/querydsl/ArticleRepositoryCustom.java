package com.daylog.tomatolog.repository.querydsl;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepositoryCustom {

    List<String> findAllDistinctHashtags();
}
