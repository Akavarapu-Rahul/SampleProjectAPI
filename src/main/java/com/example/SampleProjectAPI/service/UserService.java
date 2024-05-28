package com.example.SampleProjectAPI.service;

import com.example.SampleProjectAPI.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final String URL="https://fakestoreapi.com/users";
    private final RestTemplate restTemplate;

    public UserService(){
        this.restTemplate=new RestTemplate();
    }

    public User[] getUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity(URL, User[].class);
        return response.getBody();
    }

    public User getUserById(int id) {
        String url = URL + "/" + id;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        return response.getBody();
    }
}
