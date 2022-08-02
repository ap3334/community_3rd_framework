package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

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

    @Test
    public void ioc__Controller들을_스캔하여_수집() {
        List<String> controllerNames = Container.getControllerNames();

        controllerNames.contains("home");
        controllerNames.contains("article");
    }

}
