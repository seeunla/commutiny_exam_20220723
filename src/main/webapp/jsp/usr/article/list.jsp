<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>


<script src="https://cdn.tailwindcss.com"></script>


<%--보통 구획은 섹션으로 나눈다.--%>
<section>
    <div class="container mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트</h1>
        <ul class="mt-5">
            <% for ( ArticleDto article : articles) { %>
            <li class="flex">
                <a class="w-[100px] hover:underline hover:text-[blue] hover:font-bold" href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getId()%></a>
                <%--flex-grow: 성장성 1--%>
                <a class="flex-grow hover:underline hover:text-[blue] hover:font-bold" href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getTitle()%></a>
                <a class="w-[100px] hover:underline hover:text-[blue] hover:font-bold" href="/usr/article/detail/free/<%=article.getId()%>">삭제</a>
            </li>
            <% } %>
        </ul>
    </div>
</section>

