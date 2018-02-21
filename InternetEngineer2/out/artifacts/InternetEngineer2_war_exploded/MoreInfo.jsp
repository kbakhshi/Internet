<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="domain.House" %>


<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body dir="rtl">

<%
    if (request.getAttribute("house") != null) {
        House h = (House) request.getAttribute("house");
%>
<div>
    <h3 style="display: inline-block;">نام کاربری:<%=request.getParameter("sessionUserName")%>
    </h3>
    <h3 style="display: inline-block;margin-right: 30%">اعتبار شما:<%=request.getParameter("balance")%>
    </h3>
</div>
<div>
    <div>
        نوع ساختمان:<span><%=h.getBuildingType()%></span>
    </div>
    <div>
        متراژ:<span><%=h.getArea()%></span>
    </div>
</div>
<div>
    <div>
        نوع قرارداد:<span>
                <%
                    String dealType = "رهن واجاره";
                    if (h.getDealType() == 0) {
                        dealType = "فروش";
                    }
                %><%=dealType%></span>
    </div>
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
</div>
<div>
    <div>
        آدرس:<span><%=h.getAddress()%></span>
    </div>
    <div>
        لینک عکس:<a href=<%=h.getImageURL()%>><%=h.getImageURL()%>
    </a>
    </div>

</div>
<div>
    <div>
        توضیحات:<span><%=h.getDescription()%></span>
    </div>
</div>
<div>
    <a href="cgetOwnerPhone?id=<%=h.getId()%>">دریافت شماره مالک /مشاور</a>
</div>
<%
    if (request.getAttribute("msg") != null) {
%>
<h1><%= request.getAttribute("msg") %>
</h1>
<%
    }
%>
<%
    if (request.getAttribute("phoneNum") != null) {
%>
<h1>شماره مالک/مشاور:<%= request.getAttribute("phoneNum") %>
</h1>
<%
    }
%>
<%
    }
%>

</body>
</html>