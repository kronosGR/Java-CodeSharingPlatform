package platform.Services;

import platform.Models.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    List<Code> db = new ArrayList<>();
    public static String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";
    int lastID = 1;
//    Code code = new Code("public static void main(String[] args) {\n" +
//            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
//            "}"
//            , LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));

//    public Code getCode() {
//        Code tmp = new Code(code.getCode(), code.getDate());
//        return tmp;
//    }

//    public void updateCode(Code c) {
//        code = new Code(c.getCode(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
//    }

    public Code getCodeById(int id) {
        return db.get(id - 1);
    }

    public int putCode(Code code) {
        int id = lastID++;
        db.add(new Code(id,
                code.getCode(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN))
        ));
        return id;
    }

    public List<Code> getLatestCode() {
        List<Code> tmp = new ArrayList<>();
        int startFrom = db.size() < 10 ? 0 : db.size() - 10;

        if (db.size() == 0) return null;

        for (int idx = startFrom; idx < db.size(); idx++) {
            tmp.add(0, db.get(1));
        }
        return tmp;
    }
}
