//nalan_*:jQuery:checkbox:*;
//        var userGroupIsSelected = false;
var STATE_SUBMITING = false;//状态正在提交数据
function del_row(obj) {
//            if($(obj).prop('checked'));
//                alert(userGroupIsSelected);
}
//css("background-color","#00A2CA");
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
$(document).ready(function () {
    $("#btn_add").click(function () {//nalan_*:jQuery:table:*;
        $("#table_user_group tr:last").after('<tr><p>' + '<td><input class="checkbox_normal" type="checkbox" onclick="del_row(this)"/>测试test</td>'+
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

//            $("#btn_add").on(function () {
//
//            });

    $("#btn_delete").click(function () {
        $(".checkbox_normal:checked").parent().parent().remove();
    });
    /*          以下是页面使用jQuery的实例代码，不要删除
                $("#btn_delete").click(function () {
                    $(".checkbox_normal:checked").parent().parent().remove();
                });
                */
    $("#btn_change").click(function () {
        var o = $(".checkbox_normal:checked").parent();
        //nalan_*:jQuery:选择器:*;
        $(o).siblings().filter("#td_2").html('<input class="checkbox_normal" type="text"/>');
//                $(o).siblings().last().html('<input class="checkbox_normal" type="text"/>');
    });

});
