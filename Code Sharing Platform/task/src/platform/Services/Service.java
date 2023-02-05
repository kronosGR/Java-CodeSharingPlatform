package platform.Services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import platform.Models.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {
    public static String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";


    private ServiceRepository serviceRepository;

    public Service(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Code getCodeById(String id) {
        Code cs = serviceRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No code with this id");
        });

        if (cs.getTime() >= 1 || cs.getViews() >= 1) {
            if (cs.getViews() > 0) {
                cs.setLimited(true);
                cs.setViews(cs.getViews() - 1);
                if (cs.getViews() < 1) {
                    serviceRepository.deleteById(cs.getId());
                    return cs;
                }
                cs = serviceRepository.save(cs);
            }
            if (cs.getTime() > 0) {
                cs.setTime(cs.getTime() -
                        ChronoUnit.SECONDS.between(cs.getLocalDateTime(), LocalDateTime.now()));
                if (cs.getTime() < 1) {
                    serviceRepository.deleteById(cs.getId());
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "No code with this id");
                }
            }
        }

        return cs;
    }

    public String putCode(Code code) {
        Code tmp =  new Code();
        tmp.setCode(code.getCode());
        tmp.setId(UUID.randomUUID().toString());
        tmp.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        tmp.setLocalDateTime(LocalDateTime.now());
        tmp.setViews(code.getViews());
        tmp.setTime(code.getTime());
        return serviceRepository.save(tmp).getId();
    }

    public List<Code> getLatestCode() {
        return serviceRepository.getLatestCode();
    }
}
