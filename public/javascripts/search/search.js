/**
 * Created by kris on 16/12/17.
 */

function search(array) {
    $.ajax({
        url: "/house/query",
        data: arrayToJson(array),
        type: "POST",
        contentType: 'application/json;charset=utf-8',
        dataType: "json",
        success: function (data) {
            checkResult(data);
        }
    });
}

function arrayToJson(array) {
    return JSON.stringify(array);
}
function checkResult(result) {
    var resultObj = eval(result);
    if (resultObj == null) {
        alert("传输出现错误");
    }
    if (resultObj.code != 200) {
        alert(resultObj.message);
    }
    if (resultObj.data.items.length == 0){
        alert("没有数据");
    }
    returnList(resultObj.data, "#lists")
}

function returnList(json, name) {
    page = addPage(json);
    $(name).empty();
    $("#pages").empty();
    $("#pages").append(page);
    for (var i = 0; i < json.items.length; i++) {
        $(name).append(parseObject(json.items[i]));
    }
}

function addPage(json) {
    var start = 1;
    var end = 5;
    if (json.page > 2) {
        start = json.page - 2;
        end = json.page + 2;
    }
    if (json.totalPage <= 5) {
        start = 1;
        end = json.totalPage;
    }
    var result = "";
    for (var i = start; i < end + 1; i++) {
        result += "<li>" + "<a name='page' id='page' value=" + i + ">" + i + "</a>" + "</li>";
    }
    return result;
}

function parseObject(house) {
    return (   "<li>" +
        "<p>" + house.code + "<span class=\"small-info\">" + "        分钟前更新" + "</span></p>" +
        "<p>" + house.cityName + "-" + house.areaName + "-" + house.address + house.floor + " 层" +
        "<a href=\"#\">地图</a></p>" +
        "<p><a href=\"#\">全景地图</a></p>" +
        "<p>" + house.houseTypeName + " 铺原等级：" + house.houseLevelName + " 带看" + house.showTimes + "次" + "</p>" +
        "</li>" +
        "<li>" +
        "<p>" + house.areas + "平米" + "</p>" +
        "</li>" +
        "<li>" +
        "<p></p>" +
        "<p>" + house.chummageDaily + "元/每天每平米</p>" +
        "<p>" + house.chummageMonth + "万元/月</p>" +
        "<p>" + house.transferCost + "万元转让费</p>" +
        "</li>" +
        "<li class=\"money-li\">" +
        "<p></p>" +
        "<p>当前品牌：" + house.businessName + "</p>" +
        "<p>租售状态：" + house.rentStatusName + "</p>" +
        "<p>当前业态：" + house.businessStatus + "</p>" +
        "</li>" +
        "<li class=\"message-li\">" +
        "<p><a href=/house/edit/" + house.id +">" + "编辑" + "</a> " +
    "       <a href=/house/" + house.id +">" + "查看详情" + "</a></p>" +
        "<p>" + house.owner + "  " + house.ownerTypeName + "</p>" +
        "<p>" + house.ownerMobile + "</p>" +
        "<p>来源类型：" + house.sourceTypeName + "</p>" +
        "</li>"
    );
}
