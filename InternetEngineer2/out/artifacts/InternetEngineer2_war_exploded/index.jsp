<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="domain.KhaneBeDoosh" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%
    if (request.getAttribute("msg") != null) {
%>
<h1><%= request.getAttribute("msg") %></h1>
<%
    }
%>

<form action="csearch" method=GET>
    <input type="hidden" name="sessionUserName" value="<%=KhaneBeDoosh.getSessionUser().getName()%>"/>
    <input type="hidden" name="balance" value="<%=KhaneBeDoosh.getSessionUser().getBalance()%>"/>
    <div class="row-fluid"  dir="rtl">
        <div style="display: inline-block;width:30%"  >
            <label style="display: inline-block;" class="col-mod-4">حداقل متراژ</label>
            <input type="text" name="minArea" style="display: inline-block;" class="col-mod-8"/>
        </div>
        <div style="display: inline-block;width:30%" >
            <label style="display: inline-block;">نوع ملک</label>
            <input type="text" name="buildingType" style="display: inline-block;"/>
        </div>
    </div>
    <div class="row-fluid" dir="rtl">
        <div style="display: inline-block;width:30%;"  >
            <label style="display: inline-block;margin-right: 7%">نوع قرارداد</label>
            <input type="text" name="dealType" style="display: inline-block;"class="col-mod-8"/>
        </div>
        <div style="display: inline-block;width:30%">
            <label style="display: inline-block;"class="col-mod-4">حداکثر قیمت</label>
            <input type="text" name="maxPrice" style="display: inline-block;"class="col-mod-8"/>
        </div>
    </div>
    <div dir="rtl">
        <input type="submit" value="جست و جو" />
    </div>
</form>
<hr>

<form action="cadd" method=GET>
    <div class="row-fluid" dir="rtl">
        <div style="display: inline-block;">
            <label style="display: inline-block;">نوع ساختمان(ویلایی/آپارتمانی)</label>
            <input type="text" name="buildingType" style="display: inline-block;"/>
        </div>
        <div style="display: inline-block;">
            <label style="display: inline-block;">متراژ</label>
            <input type="text" name="area" style="display: inline-block;"/>
        </div>
    </div>
    <div class="row-fluid" dir="rtl">
        <div style="display: inline-block;">
            <label style="display: inline-block;">نوع قرارداد(خرید/اجاره)</label>
            <input type="text" name="dealType" style="display: inline-block;"/>
        </div>
        <div style="display: inline-block;">
            <label style="display: inline-block;">قیمت فروش/اجاره</label>
            <input type="text" name="price" style="display: inline-block;"/>
        </div>
    </div>

    <div class="row-fluid" dir="rtl">
        <div style="display: inline-block;">
            <label style="display: inline-block;">آدرس</label>
            <input type="text" name="address" style="display: inline-block;"/>
        </div>
        <div style="display: inline-block;">
            <label style="display: inline-block;">شماره تلفن</label>
            <input type="text" name="phone" style="display: inline-block;"/>
        </div>
    </div>
    <div class="row-fluid" dir="rtl">
        <div style="display: inline-block;">
            <label style="display: inline-block;">توضیحات</label>
            <input type="text" name="description" style="display: inline-block;"/>
        </div>
    </div>
    <div dir="rtl">
        <input type="submit" value="اضافه کردن خانه جدید"/>
    </div>


</form>
<hr>

<form action="cincrease" method=GET>
    <div class="row-fluid" dir="rtl">
        <div style="display: inline-block;">
            <label style="display: inline-block;">اعتبار</label>
            <input type="text" name="pay" style="display: inline-block;"/>
        </div>
    </div>
    <div dir="rtl">
        <input type="submit" value="افزایش اعتبار"/>
    </div>


</form>
</body>
</html>