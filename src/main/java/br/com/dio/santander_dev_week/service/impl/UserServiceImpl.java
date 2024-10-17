package br.com.dio.santander_dev_week.service.impl;

import br.com.dio.santander_dev_week.domain.model.User;
import br.com.dio.santander_dev_week.domain.repository.UserRepository;
import br.com.dio.santander_dev_week.service.UserService;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) throws IllegalAccessException {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalAccessException("This Account Number already exists.");
        }
        return this.userRepository.save(userToCreate);
    }
}
