package demo.com.example.demo.services;

import demo.com.example.demo.model.mapper.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();
    public UserDto getUserById(int id);
    public List<UserDto> searchUser(String keyword);


    UserDto createUser(UserDto userDto);

    UserDto updateUser(int id, UserDto userDto);

    void deleteUser(int id);
}
