package com.hlj.common.z.toutiao.dto;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-28.
 */
public class TouTiaoTokenResponse {
    private Integer ret;
    private String msg;
    private String req_id;
    private TouTiaoTokenData data;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReq_id() {
        return req_id;
    }

    public void setReq_id(String req_id) {
        this.req_id = req_id;
    }

    public TouTiaoTokenData getData() {
        return data;
    }

    public void setData(TouTiaoTokenData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TouTiaoTokenResponse{" + "ret=" + ret + ", msg='" + msg + ", req_id='" + req_id + ", data=" + data + '}';
    }

    public boolean getTokenSuccess() {
        return true;
    }
}
