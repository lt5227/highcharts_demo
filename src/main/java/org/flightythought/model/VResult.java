package org.flightythought.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wangcj
 * @version 1.0.0
 * @CreateTime 2016/10/28 14:19
 * @Description
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VResult<T> {

    private Integer code;

    private String message;

    private String type;

    private T content;

    private List<T> contents;

    public VResult() {
        super();
    }

    public VResult(Integer code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public VResult(Integer code, String message, List<T> contents) {
        this.code = code;
        this.message = message;
        this.contents = contents;
    }

    public VResult(Integer code, String message, String type) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public VResult(Integer code, String message, String type, T content) {
        this.content = content;
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public VResult(Integer code, String message, String type, List<T> contents) {
        this.contents = contents;
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
