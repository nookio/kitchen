package exception;

import utils.ERROR;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午2:19
 * @Descrition:
 */
public class KitchenException extends RuntimeException {

    private String code;

    public KitchenException() {
        super(ERROR.UNKNOWN_ERROR.msg);
        code = ERROR.UNKNOWN_ERROR.code;
    }

    public KitchenException(String message) {
        super(message);
        code = ERROR.UNKNOWN_ERROR.code;
    }

    public KitchenException(ERROR error, String message) {
        super(message);
        code = error.code;
    }

    public KitchenException(ERROR error) {
        super(error.msg);
        this.code = error.code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
