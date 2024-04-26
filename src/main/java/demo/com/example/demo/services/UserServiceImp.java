package demo.com.example.demo.services;

import demo.com.example.demo.entity.User;
import demo.com.example.demo.exception.NotFoundException;
import demo.com.example.demo.model.mapper.UserMapper;
import demo.com.example.demo.model.mapper.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class UserServiceImp implements UserService {
    private static final List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "DQT", "dqt@gmail.com", "0123","abc.img", "abc"));
        users.add(new User(2, "DHN", "dhn@gmail.com", "01234","acc.img", "abcd"));
        users.add(new User(3, "DHT", "dht@gmail.com", "012345","abcc.img", "abca"));
    }


    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user)   );
        }
        return result;
    }
    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user)   ;
            }
        }
        throw new NotFoundException("User khong ton tai ");
    }
    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
if(user.getName().contains(keyword)){
            result.add(UserMapper.toUserDto(user)   );}
        }
        return result;
    }

    @Override
    public UserDto createUser(UserDto userDto) {


        var maxId = users.stream()
                .map(User::getId)
                .max(Comparator.naturalOrder())
                .orElse(0);

        User newUser = new User(
                maxId + 1,
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getAvatar(),
                ""
        );
        users.add(newUser);
        return UserMapper.toUserDto(newUser);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(userDto.getName());
                user.setEmail(userDto.getEmail());
                userDto.setPhone(userDto.getPhone());
                user.setAvatar(userDto.getAvatar());
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại");
    }

    @Override
    public void deleteUser(int id) {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (!removed) {
            throw new NotFoundException("User không tồn tại");
        }
    }
}

