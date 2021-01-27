
<%--
  Created by IntelliJ IDEA.
  User: qingkong
  Date: 2021/1/25
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>分页查询用户列表</title>
</head>
<body>
<div id="div">
    <table id="table1" cellpadding="10px" border="1px" cellspacing="0px" width="600px" height="300px">
        <tr>
            <th>ID11</th>
            <th>所属小区</th>
            <th>栋数编号</th>
            <th>栋数名称</th>
            <th>总户数</th>
            <th>描述</th>
            <th>创建时间</th>
<%--            <th id="th1"></th>--%>
        </tr>
<%--        <tr>--%>
<%--            <td >--%>

<%--            </td>--%>
<%--        </tr>--%>
    <%--    列表渲染--%>
<%--         <tr>--%>
<%--            <td>${housenumber.hosusenum_id}</td>--%>
<%--            <td>${housenumber.housenum_village}</td>--%>
<%--            <td>${housenumber.housenum_code}</td>--%>
<%--            <td>${housenumber.housenum_name}</td>--%>
<%--            <td>${housenumber.housenum_hushu}</td>--%>
<%--            <td>${housenumber.housenum_remark}</td>--%>
<%--            <td>${housenumber.housenum_createtime}</td>--%>

<%--         </tr>--%>

<%--        <tr>--%>
<%--            <td colspan="3">--%>
<%--                第<input id="currentPage" type="text">/<input id="totalPage" type="text">页--%>
<%--                总记录数:<span id="totalSize"></span> 每页显示<span id="pageSize"></span>条--%>
<%--                    <a id="first">首页</a>--%>
<%--                    <a  id="previous">上一页</a>--%>
<%--                    <a id="next">下一页</a>--%>
<%--                    <a ></a>--%>
<%--        第${pageInfo.currentPage}/${pageInfo.totalPage}页 总记录数:${pageInfo.totalSize} 每页显示${pageInfo.pageSize}条--%>
<%--            </td>--%>

<%--        </tr>--%>
    </table>
</div>
</body>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
    // $("#btn").on("click", function () {
    //     console.log("11111333");
    // })
    // var $ = jQuery;
    $(document).ready(function () {
        var pageSize = $("#pageSize").val();
        var currentPage = $("#currentPage").val();
        //使用jquery的get
        $.get("pageQuery",
            {
                "currentPage":currentPage
            }, function (res) {
            // res.totalPage

            showTable(res)
        }, "json");
    })
    function showTable(res) {
        var str = "";
        var list = res.list;
        for (var i = 0; i < list.length; i++) {
            // console.log(list[i]);
            str = "<tr><td>" + list[i].housenum_id + "</td>" +
                  "<td>" + list[i].housenum_village + "</td>" +
                    "<td>" + list[i].housenum_code + "</td>" +
                    "<td>" + list[i].housenum_name + "</td>" +
                "<td>" + list[i].housenum_hushu + "</td>" +
                "<td>" + list[i].housenum_remark + "</td>" +
                "<td>" + list[i].housenum_createtime + "</td></tr>";
            $("#table1").append(str);
        }
        console.log(res.totalPage);
        console.log(res.totalSize);
        console.log(res.pageSize);
    }
</script>
</html>
