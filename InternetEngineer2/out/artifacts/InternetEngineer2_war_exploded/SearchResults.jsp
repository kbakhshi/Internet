<%@ page import="java.util.*" %>
<%@ page import="domain.House" %>
<%@ page import="domain.KhaneBeDoosh" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body dir="rtl">
<%
    List<House> houses = new ArrayList<>();
    if (request.getAttribute("houseList") != null)
        houses = (List<House>) request.getAttribute("houseList");
%>
<div>
    <h3 style="display: inline-block;">نام کاربری:<%=request.getParameter("sessionUserName")%>
    </h3>
    <h3 style="display: inline-block;margin-right: 30%">اعتبار شما:<%=request.getParameter("balance")%>
    </h3>
</div>

<% if (houses.isEmpty()) {%>
<span style="color:darkred">هیچ خانه ای بااین مشخصات یافت نشد</span>
<%}%>
<input type="hidden" name="sessionUserName" value="<%=request.getParameter("sessionUserName")%>"/>
<input type="hidden" name="balance" value="<%=request.getParameter("balance")%>"/>
<%for (House h : houses) {%>

<div>

    <%if (h.getDealType() == 1) {%>
    <div>
        قیمت پایه:<span><%=h.getPrice().getBasePrice()%></span>
    </div>
    <div>
        مبلغ اجاره:<span><%=h.getPrice().getRentPrice()%></span>
    </div>
    <%}%>
    <%if (h.getDealType() == 0) {%>
    <div>
        قیمت:<span><%=h.getPrice().getSellPrice()%></span>
    </div>
    <%}%>
    <div>
        متراژ:<span><%=h.getArea()%></span>
    </div>
    <div>
        نوع:<span>
                <%
                    String dealType = "رهن واجاره";
                    if (h.getDealType() == 0) {
                        dealType = "فروش";
                    }
                %><%=dealType%></span>
    </div>
    <div>
        لینک عکس:<span><%=h.getImageURL()%></span>
    </div>
    <div>
        <a href="cmoreInfo?id=<%=h.getId()%>">اطلاعات بیشتر</a>
    </div>
</div>
<%}%>

</body>
</html>