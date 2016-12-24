/**
 * Created by kris on 16/12/17.
 */

function get() {
    var result = new Object();
    $.ajax({
        url: "/house/add/generate",
        type: "GET",
        contentType: 'application/json;charset=utf-8',
        dataType: "json",
        success: function (data) {
            var resultObj = eval(data);
            result = resultObj;
        }
    });
    return result;
}

function save(array) {
    $.ajax({
        url: "/house/add",
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
    if (resultObj.code == 200){
        location.href = "/house/"+ resultObj.data.id;
    }
    // returnList(resultObj.data, "#lists")
}

function returnList(json, name) {
    var data;
    for (var i = 0; i < json.items.length; i++) {
        data = parseObject(json.items[i]);
    }
    $(name).empty();
    $(name).append(data);
}

function parseObject(house) {
    return ("");
}
