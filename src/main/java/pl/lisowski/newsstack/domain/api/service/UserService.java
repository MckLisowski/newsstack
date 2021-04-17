package pl.lisowski.newsstack.domain.api.service;

import org.apache.commons.codec.digest.DigestUtils;
import pl.lisowski.newsstack.domain.api.DTO.UserDto;
import pl.lisowski.newsstack.domain.user.User;
import pl.lisowski.newsstack.domain.user.UserDao;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(UserDto UserDto) {
        User userToSave = UserMapper.map(UserDto);
        try {
            hashPasswordWithSha256(userToSave);
            userDao.save(userToSave);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void hashPasswordWithSha256(User user) throws NoSuchAlgorithmException {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());   //tworzenie shashowanego hasła
        user.setPassword(sha256Password);
    }

    private static class UserMapper {   //DTO->DAO
        static User map(UserDto userDto) {
            return new User(
                    userDto.getUsername(),
                    userDto.getEmail(),
                    userDto.getPassword(),
                    LocalDateTime.now()
            );
        }
    }
}
