package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        switch (rq.getMethod()) {
            case "GET":
                switch (rq.getPath()) {
                    case "/usr/article/list/free":
                        articleController.showList(rq); //showList는 post를 달라
                        break;
                    case "/usr/article/write/free":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/member/login":
                        memberController.showLogin(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getPath()) {
                    case "/usr/article/write/free":
                        articleController.doWrite(rq); // do write는 처리하다 받아들이다
                        break;
                }
                break;
        }
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
            doGet(req, resp);
        }


    }

