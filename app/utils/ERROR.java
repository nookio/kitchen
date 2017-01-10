package utils;

/**
 * Created by yeeson on 15/10/9.
 */
public enum ERROR {
    SUCCESS("200", "success"),
    INVALID_TOKEN("1001", "Token无效或者已过期"),
    STAFF_NOT_EXIST("1002", "用户不存在"),
    STAFF_WRONG_PASSWORD("1003", "密码不正确"),
    STAFF_STATUS_BAD_STATUS("1004", "员工状态不正确"),
    INVALID_INPUT("1005", "输入参数格式验证失败"),
    RUNTIME_ERROR("1006", "未知运行时异常"),
    UNKNOWN_ERROR("1007", "未知异常"),
    NULL_OBJECT("1008", "查询到的数据为空"),
    INVALID_PARAMS("1009", "输入参数不正确"),
    INVALID_PHONE_NUMBER("1010", "手机号格式不正确"),
    DATE_TYPE_MISSING("1011", "日期类型和日期必须同时填写"),
    ERROR("1012", "系统业务错误，请求数据有误"),
    STATUS_ERROR("1013", "数据状态不正常")
    ;


    public String code;
    public String msg;

    ERROR(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
