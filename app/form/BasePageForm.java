package form;

import javax.validation.constraints.NotNull;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 下午3:36
 * @Descrition:
 */
public abstract class BasePageForm extends BaseForm{

    @NotNull
    private Integer page = 0;

    @NotNull
    private Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page - 1;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
