package demo.com.example.demo.model.mapper;

import demo.com.example.demo.entity.User;
import demo.com.example.demo.model.mapper.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp     = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
return tmp;
    }
}
