package com.daylog.tomatolog.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName(value = "View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mockMvc;

    public ArticleControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 리스트 (게시판) 페이지 - 정상호출")
    @Test
    public void 게시글_리스트_정상호출() throws Exception {

        // given

        // when &  then
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));
    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 상세 페이지 - 정상호출")
    @Test
    public void 게시글_상세페이지_정상호출() throws Exception {

        // given

        // when &  then
        mockMvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 검색 전용 페이지 - 정상호출")
    @Test
    public void 게시글_검색전용_페이지_정상호출() throws Exception {

        // given

        // when &  then
        mockMvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));
    }

    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 hashtag 검색 페이지 - 정상호출")
    @Test
    public void 게시글_hashtag_검색_페이지_정상호출() throws Exception {

        // given

        // when &  then
        mockMvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }
}
