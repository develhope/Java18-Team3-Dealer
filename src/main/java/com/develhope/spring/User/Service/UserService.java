package com.develhope.spring.User.Service;
import com.develhope.spring.User.DTO.UsersDTO;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.User.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;
    public UsersDTO createUsers(UsersDTO usersDTO) {
        Users saveDTO = convertToEntity(usersDTO);
        usersRepository.save(saveDTO);
        return usersDTO;
    }

    public void deleteUsersByID(Long userId) {
        Users users = usersRepository.findById(userId).orElse(null);
        if (users == null) {
            throw new IllegalArgumentException("Buyer not found by ID : " + userId);
        } else {
            usersRepository.deleteById(userId);
        }
    }

    public UsersDTO findById(Long userId) {
        Users users = usersRepository.findById(userId).orElse(null);
        if (users == null) {
            throw new IllegalArgumentException("Buyer not found by ID : " + userId);
        }
        return convertToDTO(users);
    }

    public UsersDTO updateUser(Long userId, UsersDTO usersDTO) {
        Users usersUpdate = usersRepository.findById(userId).orElse(null);
        if (usersUpdate == null) {
            throw new IllegalArgumentException("Unable to update buyer with this ID : " + userId);
        }
        Users saveUsersDTO = convertToEntity(usersDTO);
        usersUpdate.setFirstName(saveUsersDTO.getFirstName());
        usersUpdate.setLastName(saveUsersDTO.getLastName());
        usersUpdate.setEmail(saveUsersDTO.getEmail());
        usersUpdate.setPassword(saveUsersDTO.getPassword());
        usersUpdate.setTelephoneNumber(saveUsersDTO.getTelephoneNumber());
        usersRepository.save(usersUpdate);
        return usersDTO;
    }

    private Users convertToEntity(UsersDTO usersDTO) {
        Users users = new Users();
        users.setFirstName(usersDTO.getFirstName());
        users.setLastName(usersDTO.getLastName());
        users.setEmail(usersDTO.getEmail());
        users.setPassword(usersDTO.getPassword());
        users.setTelephoneNumber(usersDTO.getTelephoneNumber());
        return users;
    }

    private UsersDTO convertToDTO(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setFirstName(users.getFirstName());
        usersDTO.setLastName(users.getLastName());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setPassword(users.getEmail());
        usersDTO.setTelephoneNumber(users.getTelephoneNumber());
        return usersDTO;
    }
}
