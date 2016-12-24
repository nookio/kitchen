package helper;

import com.avaje.ebean.PagedList;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午4:38
 * @Descrition:
 */
public class Page<T> {

    Integer totalPage;
    Integer totalRow;
    Integer page;
    Integer size;
    List<T> items;


    public Page(List<T> items, Integer page, Integer size, Integer total) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.totalPage = total;
    }

    public Page(PagedList pagedList) {
        this.items = pagedList.getList();
        this.page = pagedList.getPageIndex() + 1;
        this.size = pagedList.getPageSize();
        this.totalPage = pagedList.getTotalPageCount();
        this.totalRow = pagedList.getTotalRowCount();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
