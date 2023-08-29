package com.daylog.tomatolog.repository;

import com.daylog.tomatolog.config.JpaConfig;
import com.daylog.tomatolog.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@ActiveProfiles("testdb")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("JPA connection Test")
@Import({JpaConfig.class})
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,
                             @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName(value = "JPA 연결이 정상적으로 되었는지 확인한다.")
    @Test
    public void JPA_연결_확인() throws Exception {
        // given

        // when
        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName(value = "Insert 동작 여부를 테스트한다.")
    @Test
    public void 등록확인() throws Exception {
        // given
        long preCnt = articleRepository.count();

        Article article = Article.of("new article", "new content", "spring");
        // when
        Article savedArticle = articleRepository.save(article);

        long articles = articleRepository.count();

        // then
        assertThat(articles).isEqualTo(preCnt + 1);

    }

    @DisplayName(value = "Update 동작 여부를 테스트한다.")
    @Test
    public void 수정확인() throws Exception {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);

        // when
        Article save = articleRepository.saveAndFlush(article);

        // then
        assertThat(save).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);

    }

    @DisplayName(value = "Delete 동작 여부를 테스트한다.")
    @Test
    public void 삭제확인() throws Exception {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleComment = articleCommentRepository.count();
        int deletedCommentSize = article.getArticles().size();

        // when
        articleRepository.delete(article);

        long afterArticleCount = articleRepository.count();
        long afterArticleComment = articleCommentRepository.count();
        int afterDeletedCommentSize = article.getArticles().size();

        // then
        assertThat(afterArticleCount).isEqualTo(previousArticleCount -1 );
        assertThat(afterArticleComment).isEqualTo(previousArticleComment - deletedCommentSize );

    }
}