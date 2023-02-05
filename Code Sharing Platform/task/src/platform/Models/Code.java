package platform.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Code {

    @JsonIgnore
    @Id

    String id;
    String code;

    String date;

    @JsonIgnore
    LocalDateTime localDateTime;
    long time;
    long views;
    @Transient
    @JsonIgnore
    boolean limited;



}
