package org.cjh.ayinfo.model.ui;

import java.util.List;

public class UIPaginationResult<T> {

    private Integer total;
    private List<T> rows;
    
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UIPaginationResult [total=");
        builder.append(total);
        builder.append(", rows=");
        builder.append(rows);
        builder.append("]");
        return builder.toString();
    }
}
