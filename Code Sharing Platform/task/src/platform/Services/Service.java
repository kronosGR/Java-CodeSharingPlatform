package platform.Services;

import platform.Models.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@org.springframework.stereotype.Service
public class Service {

    public static String DATE_PATTERN="yyyy/MM/dd HH:mm:ss";
    Code code = new Code("public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}"
            , LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));

    public Code getCode(){
        Code tmp = new Code(code.getCode(), code.getDate());
        return tmp;
    }

    public void updateCode(Code c){
        code = new Code(c.getCode(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
    }
}
