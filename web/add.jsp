<%--
  Created by IntelliJ IDEA.
  User: laoyu
  Date: 2020/2/20
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增雨量监测信息</title>
    <style>
        * {
            margin: 0 auto
        }

        #list {
            width: 450px;
            height: auto
        }

        table, tr, .add {
            width: 450px
        }

        td:first-child {
            text-align: left;
        }

        tr:last-child > td:first-child {
            text-align: center;
        }
    </style>
</head>
<body>

<div id="list">
    <form action="add" method="post">
        <h3 align="center">新增雨量监测信息</h3>
        <table align="center">
            <tbody align="center">
            <tr>
                <td>区域名称：</td>
                <td><input type="text" id="rName" name="districtName"></td>
                <td></td>
            </tr>
            <tr>
                <td>监测时间：</td>
                <td><input type="text" id="rTime" name="monitorTime"></td>
                <td>yyyy.MM.dd格式</td>
            </tr>
            <tr>
                <td>雨量值(mm)：</td>
                <td><input type="text" id="rNum" name="rain"></td>
                <td></td>
            </tr>
            <tr>
                <td>监测站：</td>
                <td><input type="text" id="rStation" name="monitoringStation"></td>
                <td></td>
            </tr>
            <tr>
                <td>站点地址：</td>
                <td><input type="text" id="rAddress" name="monitoringAddress"></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" onclick="" value="保存">
                    <input type="reset" onclick="" value="重置">
                    <input type="button" onclick="" value="返回">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<script src="statics/js/jquery-1.8.3.min.js"></script>
<script>
    //表单的提交事件
    $("form").submit(function () {
        var flag = true;

        if (!checkDistrictName()) {//检查区域名
            flag = false;
        } else if (!checkTime()) {//检查检测时间
            flag = false;
        } else if (!checkNum()) {//检查雨量值
            flag = false;
        } else if (!checkStation()) {//检查监测站
            flag = false;
        } else if (!checkAddress()) {//检查站点地址
            flag = false;
        }
        return flag;
    });


    //检查区域名
    function checkDistrictName() {
        var $districtName = $("#rName").val();
        if ($districtName == null || $districtName === "") {
            alert("区域名称不能为空！");
            $("#rName").focus();
            return false;
        }
        return true;
    }

    function checkTime() {
        var $time = $("#rTime").val();
        if ($time == null || $time === "") {
            alert("检测时间不能为空！");
            $("#rTime").focus();
            return false;
        }
        reg = /^\d{4}\.\d{2}\.\d{2}$/;
        if(!reg.test($time)){
            alert("时间格式错误！")
            return false;
        }
        return true;
    }

    function checkNum() {
        var $num = $("#rNum").val();
        if($num == null || $num == ""){
            alert("雨量值不能为空");
            $("rNum").focus();
            return false;
        }
        // 正则表达式
        var reg = /\d/;
        if (!reg.test($num)) {
            alert("雨量值有误！");
            return false;
        }

        return true;
    }
    function checkStation() {
        var $station = $("#rStation").val();
        if($station == null || $station === ""){
            alert("检测站不能为空");
            $("rStation").focus();
            return false;
        }
        return true;
    }
    function checkAddress() {
        var $address = $("#rAddress").val();
        if($address == null || $address === ""){
            alert("站点地址不能为空");
            $("rAddress").focus();
            return false;
        }
        return true;
    }

</script>
</body>
</html>