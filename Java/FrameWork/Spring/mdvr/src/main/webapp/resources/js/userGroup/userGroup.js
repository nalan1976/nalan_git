//nalan_*:jQuery:checkbox:*;
//        var userGroupIsSelected = false;
var STATE_SUBMITING = false;//状态正在提交数据
var OLD_UG_NAME = "";
function del_row(obj) {
           if($(obj).prop('checked'));
               alert(userGroupIsSelected);
}
//css("background-color","#00A2CA");
function refillUser2GroupTable(data) {
    if(data == "") return;
    //处理用户组表，
        // 获得表头并删除所有节点
        $("#table_user_group tr:first").siblings().not("#tr_title").remove();
        //填充数据到表中
        var str;
        for(var i = 0; i < data.userGroupList.length; i++){
            str +="<tr><p>";
            str += '<td><input class="checkbox_normal" type="checkbox" onclick="del_row(this)">'+'</input>';
            str += data.userGroupList[i].userGroupId+'</td>';
            str += '<td id="td_2">' + data.userGroupList[i].userGroupName+'</td>';
            str += '<td id="td_3">' + 'test3'+'</td>';
            str += '<td id="td_4">' + 'test3'+'</td>';
            str += '<td id="td_5" class="td_hidden" hidden="hidden">' +'</td>';
            str += "</p></tr>";
        }
        $("#table_user_group tr:first").after(str);

    //处理用户表
    $("#table_user tr:first").siblings().not("#tr_user_title").remove();
    //填充数据到表中
    var str1;
    var datetime;
    for(var i = 0; i < data.userList.length; i++){//这个结构应该有更好的设计
        datetime = new Date(data.userList[i].createDatetime);
        str1 +="<tr><p>";
        str1 += '<td><input class="checkbox_normal" type="checkbox">'+'</input>';/* <!--onclick="del_user_row(this)"-->*/
        str1 += data.userList[i].userId+'</td>';
        str1 += '<td id="td_user_2">' + data.userList[i].userName+'</td>';
        str1 += '<td id="td_user_3">' + data.userList[i].userType+'</td>';
        str1 += '<td id="td_user_4">' + '****'+'</td>';
        str1 += '<td id="td_user_5">' + datetime+'</td>';
        str1 += '<td id="td_user_6">' + 'test6'+'</td>';
        str1 += '<td id="td_user_7">' + 'test6'+'</td>';
        str1 += '<td id="td_user_8" class="td_hidden" hidden="hidden">' +'</td>';
        str1 += "</p></tr>";
    }
    $("#table_user tr:first").after(str1);    

}
function refillTable(data){
    if(data == "") return;
    // 获得表头并删除所有节点
    // alert("hello");
    // var tblHead = $("#table_user_group tr:first").css("background-color","#00A2CA");
    // $("#table_user_group tr).not("#tr_title").remove();
    $("#table_user_group tr:first").siblings().not("#tr_title").remove();
    // $("#table_user_group tr:first").css("background-color","#00A2CA");


    //填充数据到表中
    // alert(data.innerUserGroups.length);
    // var result = eval('(' + data + ')');
    var str;
    for(var i = 0; i < data.innerUserGroups.length; i++){
            str +="<tr><p>";
            str += '<td><input class="checkbox_normal" type="checkbox" onclick="del_row(this)">'+'</input>';
            str += data.innerUserGroups[i].userGroupId+'</td>';
            str += '<td id="td_2">' + data.innerUserGroups[i].userGroupName+'</td>';
            str += '<td id="td_3">' + 'test3'+'</td>';
            str += '<td id="td_4">' + 'test3'+'</td>';
            str += '<td id="td_5" class="td_hidden" hidden="hidden">' +'</td>';
            str += "</p></tr>";
    }
    $("#table_user_group tr:first").after(str);
}
function refillUserTable(data){
    if(data == "") return;
    // 获得表头并删除所有节点
    // alert("hello");
    // var tblHead = $("#table_user_group tr:first").css("background-color","#00A2CA");
    // $("#table_user_group tr).not("#tr_title").remove();
    $("#table_user tr:first").siblings().not("#tr_user_title").remove();
    // $("#table_user_group tr:first").css("background-color","#00A2CA");


    //填充数据到表中
    // alert(data.innerUserGroups.length);
    // var result = eval('(' + data + ')');
    var str;
    var datetime;
    for(var i = 0; i < data.innerUserList.length; i++){//这个结构应该有更好的设计
        datetime = new Date(data.innerUserList[i].createDatetime);
        str +="<tr><p>";
        str += '<td><input class="checkbox_normal" type="checkbox">'+'</input>';/* <!--onclick="del_user_row(this)"-->*/
        str += data.innerUserList[i].userId+'</td>';
        str += '<td id="td_user_2">' + data.innerUserList[i].userName+'</td>';
        str += '<td id="td_user_3">' + data.innerUserList[i].userType+'</td>';
        str += '<td id="td_user_4">' + '****'+'</td>';
        str += '<td id="td_user_5">' + datetime+'</td>';
        str += '<td id="td_user_6">' + 'test6'+'</td>';
        str += '<td id="td_user_7">' + 'test6'+'</td>';
        str += '<td id="td_user_8" class="td_hidden" hidden="hidden">' +'</td>';
        str += "</p></tr>";
    }
    $("#table_user tr:first").after(str);
}
function change_row(obj) {
    var objTemp = $(obj).parent();
    var userGroupName = objTemp.siblings().filter("#td_2").children().val();
    var str = [{"userGroupId" : $(".checkbox_normal:checked").parent().text()},
        {"newName" : userGroupName}];
    // var str = {"userGroupId" : $(".checkbox_normal:checked").parent().text()};
    //     str.push({"userGroupId" : userGroupName});
    if(str != "" && !STATE_SUBMITING){

/*        var str = new Array();//nalan_*:js:array:*;
            str.push({"oldName":OLD_UG_NAME, "newName":userGroupName});*/
        // alert(str);
        $.ajax({type:'post',
                url : '/jsp/setup/changeUserGroup',
                contentType : 'application/json;charset=utf-8',
                data : JSON.stringify(str),
                success:function (data) {
                    // alert(data.userGroupName);
                    STATE_SUBMITING = false;
                    if(data == "")//后台返回对象为null时，转为json后传到前台为空
                        alert("数据保存失败！success");
                    else{
                        refillTable(data);
                    }
                },
                error:function (data) {
                    STATE_SUBMITING=false;
                    alert("数据保存失败！error");
                }
            }
        );

        STATE_SUBMITING = true;
    }
}
function add_row(obj) {
    var objTemp = $(obj).parent();
    var userGroupName = objTemp.siblings().filter("#td_2").children().val();

    if(userGroupName != "" && !STATE_SUBMITING){
        //nalan_*:jason:js:*;  组装json数据
        var str = {"userGroupName":userGroupName};//nalan_*:json:js:map:*;
        // alert(str);
        $.ajax({type:'post',
                url : '/jsp/setup/addUserGroup',/*${pageContext.request.contextPath}/!*/
                // contentType : 'application/json;charset=utf-8',
                data : str,
                success:function (data) {
                    // alert(data.userGroupName);
                    STATE_SUBMITING = false;
                    if(data == "")//后台返回对象为null时，转为json后传到前台为空
                        alert("数据保存失败！success");
                    else{
                        refillTable(data);
                    }
                },
                error:function (data) {
                    STATE_SUBMITING=false;
                    alert("数据保存失败！error");
                }
            }
        );
        // $.ajax({url:"/jsp/setup/userGroup",async:false});
        // $("#form_user_group").submit();
        STATE_SUBMITING = true;
    }
}
function add_user_row(obj) {
    var objTemp = $(obj).parent();
    var userName = objTemp.siblings().filter("#td_user_2").children().val();
    var type = objTemp.siblings().filter("#td_user_3").children().val();
    var password = objTemp.siblings().filter("#td_user_4").children().val();

    if(userName != "" && !STATE_SUBMITING){
        var str0 = {"userName":userName, "userType" : type, "userId" : 0, "password" : password};
        //下面代码段不要删除
/*        var str1 = {"userType" : type};
        var str2 = {"userId" : 0};
        var str = [str0 , str1, str2];//nalan*_:js:array:*;   //二维数组的一种写法*/

        $.ajax({type:'post',
                url : '/jsp/setup/addUser',/*${pageContext.request.contextPath}/!*/
                contentType : 'application/json;charset=utf-8',
                data : JSON.stringify(str0),
                success:function (data) {
                    // alert(data.userGroupName);
                    STATE_SUBMITING = false;
                    if(data == "")//后台返回对象为null时，转为json后传到前台为空
                        alert("数据保存失败！success");
                    else{
                        refillUserTable(data);
                    }
                },
                error:function (data) {
                    STATE_SUBMITING=false;
                    alert("数据保存失败！error");
                }
            }
        );
        // $.ajax({url:"/jsp/setup/userGroup",async:false});
        // $("#form_user_group").submit();
        STATE_SUBMITING = true;
    }
}
$(document).ready(function () {
    // $("#").click(function (){});
    $("#btn_add_user2group").click(function () {
        // var userId = $("#table_user_group > input");
        var str = {};
        var userGroupId;
        if($("#table_user_group input:checked").length > 1){
            alert("只允许选中一个用户组");
            return;
        }
        userGroupId = $("#table_user_group input:checked").parent().text();//只允许一个选中
        str[0] = $("#table_user_group input:checked").parent().text();

        var userId = {};//有可能是多个用户被选择
        $.each($("#table_user input:checked").parent(), function (i, dom) {
            userId[i] = dom.innerText;
            str[i + 1] = dom.innerText;
        });

        if(userGroupId < 1 || userId.length < 1) return;
        //将2种数据拼成一个数组str , userId和userGroupId没有用到

        $.ajax({type:'post',  url : '/jsp/setup/addUser2Group',//@RequestBody绝对不能用get
            contentType : 'application/json;charset=utf-8',
            data : JSON.stringify(str),   //将对象变成字符串
            success:function (data) {
                // alert(data.userGroupName);
                STATE_SUBMITING = false;
                if(data == "")//后台返回对象为null时，转为json后传到前台为空
                    alert("数据保存失败！success");
                else{
                    refillUser2GroupTable(data);
                }
            },
            error:function (data) {
                STATE_SUBMITING=false;
                alert("数据保存失败！error");
            }
        });
        // alert(userId);
    });
    $("#btn_add_user").click(function () {
        $("#table_user tr:last").after('<tr><p>' + '<td id="td_user_1"><input class="checkbox_normal" type="checkbox" onclick="del_row(this)"/>测试test</td>'+
            '<td id="td_user_2">test1</td>'+
            '<td id="td_user_3">test1</td>'+
            '<td id="td_user_4">test1</td>'+
            '<td id="td_user_5">test1</td>'+
            '<td id="td_user_6">test1</td>'+
            '<td id="td_user_7">test1</td>'+
            '<td id="td_user_8" class="td_hidden" hidden="hidden"></td>'+
            '</p></tr>');
        //添加确定按钮
        var obj= $("#table_user tr:last").children("td").filter("#td_user_8");
//                obj.css("background-color","#00A2CA");
        obj.css("width", "60");
        obj.html('<button class="btn_row_submit" type="button" onclick="add_user_row(this)">确定</button>');//传td级别的对象给函数onclick='add_row(this)'
        obj.show();
        //增加输入框
        var obj2 = $("#table_user tr:last").children("td").filter("#td_user_2");
        obj2.html('<input class="ipt_normal" type="text"/>');
        //添加类型框
        $("#table_user tr:last").children("td").filter("#td_user_3").html('<input class="ipt_normal" type="text"/>');
        //添加密码框
        $("#table_user tr:last").children("td").filter("#td_user_4").html('<input class="ipt_normal" type="text"/>');
        //所有输入框限制一下宽度
        $(".ipt_normal").css("width", "80");
    });
    $("#btn_add").click(function () {//nalan_*:jQuery:table:*;
        $("#table_user_group tr:last").after('<tr><p>' + '<td id="td_1"><input class="checkbox_normal" type="checkbox" onclick="del_row(this)"/>测试test</td>'+
            '<td id="td_2">test1</td>'+
            '<td id="td_3">test1</td>'+
            '<td id="td_4">test1</td>'+
            '<td id="td_5" class="td_hidden" hidden="hidden"></td>'+
            '</p></tr>');
        //添加确定按钮
        var obj= $("#table_user_group tr:last").children("td").filter("#td_5");
//                obj.css("background-color","#00A2CA");
        obj.css("width", "60");
        obj.html('<button class="btn_row_submit" type="button" onclick="add_row(this)">确定</button>');//传td级别的对象给函数onclick='add_row(this)'
        obj.show();
        //增加输入框
        var obj2 = $("#table_user_group tr:last").children("td").filter("#td_2");
        obj2.html('<input class="checkbox_normal" type="text"/>');


    });
    $("#btn_delete").click(function () {
        //var obj = $(".checkbox_normal:checked").parent();
        // alert(obj.first().text());

        // var aReal = [{}];//正确的写法1
        var aReal = [[]];//正确的写法2
        $.each($(".checkbox_normal:checked").parent(), function (i, dom) {//nalan_*:jQuery:each:*;
            //参数若只传一个值，则表示循环次数，第二个才是Dom对象（注意不是jQuery对象，它要用$(this)来表示）
            var aInner;
            // if(i == 0) {
            //     aInner = {"type" : "UG_DEL_UG"};
            //     aReal[i] = aInner;
            // }
            aInner = {"userGroupId" : dom.innerText};//nalan_*:array:*;
            // aReal[i+1] = aInner;
            aReal[i] = aInner;
            // alert(Number(dom.innerText) + 1);
        })

        $.ajax({type:'post',  url : '/jsp/setup/addUserGroup2',//@RequestBody绝对不能用get
            contentType : 'application/json;charset=utf-8',
            data : JSON.stringify(aReal),   //将对象变成字符串
 /*       var params = JSON.stringify([{
            username : "zhangSan",
            passwd : "123456"
        },{
            username : "LiSi",
            passwd : "8888"
        }]);
        $.ajax({
            type : 'POST',
            url : '/jsp/setup/addUserGroup2',
            data : params,
            dataType : "json",
            cache : false,
            contentType : "application/json",*/
            success:function (data) {
                // alert(data.userGroupName);
                STATE_SUBMITING = false;
                if(data == "")//后台返回对象为null时，转为json后传到前台为空
                    alert("数据保存失败！success");
                else{
                    refillTable(data);
                }
            },
            error:function (data) {
                STATE_SUBMITING=false;
                alert("数据保存失败！error");
            }
        });
        STATE_SUBMITING = true;
        // $(".checkbox_normal:checked").parent().parent().remove();
    });
    /*          以下是页面使用jQuery的实例代码，不要删除
                $("#btn_delete").click(function () {
                    $(".checkbox_normal:checked").parent().parent().remove();
                });
                */
    $("#btn_change").click(function () {
        var o = $(".checkbox_normal:checked").parent();//td_1
        //nalan_*:jQuery:选择器:*;
        // alert(o.siblings().filter("#td_2").text());
        OLD_UG_NAME = o.siblings().filter("#td_2").text();
        $(o).siblings().filter("#td_2").html('<input id="ipt_change" class="checkbox_normal" type="text"/>');

        //添加确定按钮
        var obj= o.siblings().filter("#td_5");
//                obj.css("background-color","#00A2CA");
                obj.css("width", "60");
                obj.html('<button class="btn_row_submit" type="button" onclick="change_row(this)">确定</button>');//传td级别的对象给函数onclick='add_row(this)'
                obj.show();

        //按下确定后
        // alert($(o).siblings().filter("#td_2").children().text());
    });

});
