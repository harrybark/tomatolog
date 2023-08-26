package com.daylog.tomatolog.domain;

import java.time.LocalDateTime;

public class ArticleComment {

    private Long id;
    private Article article;           // 게시글(ARTICLE_ID)
    private String content;            // 댓글 내용

    private LocalDateTime createdAt;   // 생성자
    private String createdBy;          // 생성일시
    private LocalDateTime modifiedAt;  // 수정자
    private String modifiedBy;         // 수정일시
}
