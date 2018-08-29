package com.artqiyi.dahuashai.game.vo;

import java.util.Map;
import java.util.TreeMap;

public class WechatModelMsgVo {

    private String touser;
    private String template_id;
    private String page;
    private String form_id;
    private Map data = new TreeMap();


    public WechatModelMsgVo put(String keyWord, String val) {
        KeyWord value = new KeyWord(val);
        data.put(keyWord, value);
        return this;
    }

    private class KeyWord {
        private String value;

        public KeyWord(String value) {
            this.value = value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Map getData() {
        return data;
    }
}

