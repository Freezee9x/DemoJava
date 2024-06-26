package demo.com.example.demo.model.mapper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDto {
    private int id;
    private String name;
    private  String email;
    private String phone;
    private String avatar;

}
