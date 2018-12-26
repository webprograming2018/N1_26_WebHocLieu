<jsp:include page="../header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="./css/news.css">
    <div id="wrap" class="wrap">
            <main>
                <article>
                <%@page import="model.SubContent" %>
                <% 
                    SubContent subContent = (SubContent)request.getAttribute("subContent");
                    String h1 = subContent.getH1();
                    String h2 = subContent.getH2();
                    String time = subContent.getTime().toString();
                    String content = subContent.getContent();%>                
                <h1><%=h1%></h1>
                <p><%=time%></p>
                <h2><%=h2%></h2>
                <div><%=content%></div>
                </article>
                <aside>
                    <iframe src="https://calendar.google.com/calendar/embed?src=be2kevkq2cj5tgc9tibfiju6ds%40group.calendar.google.com&ctz=Asia%2FSaigon" style="border: 0" width="200" height="200" frameborder="0" scrolling="no"></iframe>
                </aside>				
            </main>
        </div>
<jsp:include page="../footer.jsp"></jsp:include>
