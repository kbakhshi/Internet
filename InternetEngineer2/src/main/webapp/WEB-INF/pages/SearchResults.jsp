
<%@ page import="java.util.*" %>


<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

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


</body>
</html>