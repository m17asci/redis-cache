package com.spring.test.service;

import com.spring.test.dto.UserRequestDTO;
import com.spring.test.dto.UserResponseDTO;
import com.spring.test.exception.UserNotFound;
import com.spring.test.model.User;
import com.spring.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponseDTO addUser(UserRequestDTO requestDTO) {
        return modelMapper.map(userRepository.save(modelMapper.map(requestDTO, User.class)), UserResponseDTO.class);
    }
   @Cacheable(value = "user")
    public List<UserResponseDTO> findAllUser() {
       System.out.println("DB'e gidildi");
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        userRepository.findAllByIdBetween(1L, 100L).forEach(user -> userResponseDTOList.add(modelMapper.map(user, UserResponseDTO.class)));
        return userResponseDTOList;
    }

    public UserResponseDTO getUser(String  tcIdentity) {
        return modelMapper
                .map(userRepository
                        .findByTcIdentity(tcIdentity)
                        .orElseThrow(() -> new UserNotFound("Kullanıcı bulunamadı")), UserResponseDTO.class);

    }
  @CachePut(value = "user")
    public UserResponseDTO updateUser(UserRequestDTO newUserRequest) {
        User oldUser = userRepository.findByTcIdentity(newUserRequest.getTcIdentity()).orElseThrow(() -> new UserNotFound("Kullanıcı bulunamadı"));

        userRepository.findByTcIdentity(newUserRequest.getTcIdentity())
                .ifPresent(user -> {
                    user.setName(newUserRequest.getName());
                    user.setSurname(newUserRequest.getSurname());
                    user.setAccountBalance(newUserRequest.getAccountBalance());
                    userRepository.save(user);});

        return modelMapper.map(userRepository.findById(oldUser.getId()).get(), UserResponseDTO.class);
    }
    @CacheEvict(value = "user")
    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("Kullanıcı bulunamadı."));
        userRepository.deleteById(user.getId());
    }


}

