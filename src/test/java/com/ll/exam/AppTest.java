package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    @Test
    public void junit_assertThat() {

        int rs = 10 + 20;

        assertThat(rs).isEqualTo(30);
    }

    @Test
    public void ioc_articleController() {

        ArticleController articleController = Container.getArticleController();

        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__articleController__싱글톤() {

        ArticleController articleController1 = Container.getArticleController();
        ArticleController articleController2 = Container.getArticleController();

        assertThat(articleController1).isEqualTo(articleController2);
    }

}
