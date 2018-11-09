<jsp:include page="../header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
                    this is aside
                </aside>				
            </main>
        </div>
<jsp:include page="../footer.jsp"></jsp:include>
