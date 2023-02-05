package platform.Services;

import platform.Models.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    public static String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";


    private ServiceRepository serviceRepository;

    public Service(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Code getCodeById(Long id) {

        return serviceRepository.findById(id).orElseThrow();
    }

    public Long putCode(Code code) {
        Code tmp =  new Code();
        tmp.setCode(code.getCode());
        tmp.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        tmp.setLocalDateTime(LocalDateTime.now());
        return serviceRepository.save(tmp).getId();
    }

    public List<Code> getLatestCode() {
        return serviceRepository.findFirst10ByOrderByLocalDateTimeDesc();
    }
}
