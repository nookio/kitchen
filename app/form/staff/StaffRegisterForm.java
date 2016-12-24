package form.staff;


import form.BaseForm;

import javax.validation.constraints.NotNull;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/9 下午4:54
 * @Descrition:
 */
public class StaffRegisterForm extends BaseForm {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
