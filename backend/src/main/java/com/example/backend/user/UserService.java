package com.example.backend.user;

import com.example.backend.user.dto.UserRegistrationDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void save(UserRegistrationDTO userDTO) {
        userRepository.findByEmail(userDTO.email()).ifPresent(user -> {
                    throw new RuntimeException("User with email" + user.getEmail() + " not found");
                }
        );

        final User user = userMapper.userDtoToUser(userDTO);
        userRepository.save(user);
    }
}
