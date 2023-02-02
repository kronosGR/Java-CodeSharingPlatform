package platform.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;


public class Code {

    @JsonIgnore
    int id;
    String code;
    String date;


    public Code() {
    }

    public Code(int id, String code, String date) {
        this.code = code;
        this.date = date;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
