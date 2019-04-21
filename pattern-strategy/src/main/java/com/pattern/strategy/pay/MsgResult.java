package com.pattern.strategy.pay;

public class MsgResult {
    private int code;
    private Object data;
    private String msg;

    public MsgResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MsgResult{" +
                "支付状态code=" + code +
                ", 交易详情data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
