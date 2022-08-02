package com.ll.exam.article.controller;

import com.ll.exam.annotation.Autowired;
import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;
import com.ll.exam.article.service.ArticleService;

@Controller // ArticleController가 Controller임을 명시
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/usr/article/list")
    // GET /usr/article/list로 요청이 왔을 때 작동하는 함수
    public void showList() {

    }

}
