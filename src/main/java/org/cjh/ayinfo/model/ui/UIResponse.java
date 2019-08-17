package org.cjh.ayinfo.model.ui;

public class UIResponse<T> {

    private int errCode = 0;
    private String msg;
    private T data;
    
    public int getErrCode() {
        return errCode;
    }
    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    
}
