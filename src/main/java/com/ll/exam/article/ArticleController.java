package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {

    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq){
        List<ArticleDto> articleDtos = articleService.findAll();


        rq.setAttr("articles",articleDtos);
        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq) { // 정보를 받아 service에 토스만 한다. 전달만 한다.
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title,body);

        rq.appendBody("%d번 게시물이 생성되었습니다.".formatted(id));

    }

    public void showDetail(Rq rq) {
        long id = 1;

        ArticleDto articleDto = articleService.findById(id);

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }
}
