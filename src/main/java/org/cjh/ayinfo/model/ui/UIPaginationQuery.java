package org.cjh.ayinfo.model.ui;

public class UIPaginationQuery {

    private Integer page;
    private Integer rows;
    
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UIPaginationQuery [page=");
        builder.append(page);
        builder.append(", rows=");
        builder.append(rows);
        builder.append("]");
        return builder.toString();
    }
}
