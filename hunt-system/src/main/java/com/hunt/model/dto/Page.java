package com.hunt.model.dto;

/**
 * @Author: ouyangan
 * @Date : 2016/10/11
 */
public class Page {
    private int total = 1;
    private Object data;

    public Page(int total, Object data) {
        this.total = total;
        this.data = data;
    }

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
