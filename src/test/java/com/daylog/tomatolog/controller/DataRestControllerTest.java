package com.daylog.tomatolog.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외")
@DisplayName(value = "Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestControllerTest {

    private final MockMvc mockMvc;

    public DataRestControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @DisplayName(value = "게시글 리스트 조회 API 정상 호출 테스트")
    @Test
    public void givenNothing_whenRequestingArticles_thenReturnArticlesJsonResponse() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }

    @DisplayName(value = "게시글 단건 조회 API 정상 호출 테스트")
    @Test
    public void givenNothing_whenRequestingArticle_thenReturnArticleJsonResponse() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }

    @DisplayName(value = "게시글 댓글 리스트 조회 API 정상 호출 테스트")
    @Test
    public void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnArticleCommentsFromArticleJsonResponse() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
        ;

    }

    @DisplayName(value = "댓글 리스트 조회 API 정상 호출 테스트")
    @Test
    public void givenNothing_whenRequestingArticleComments_thenReturnArticleCommentsJsonResponse() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }

    @DisplayName(value = "댓글 단건 조회 API 정상 호출 테스트")
    @Test
    public void givenNothing_whenRequestingArticleComment_thenReturnArticleCommentJsonResponse() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
        ;

    }
}
