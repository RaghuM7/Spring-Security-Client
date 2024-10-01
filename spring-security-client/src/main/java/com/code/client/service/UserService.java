package com.code.client.service;

import com.code.client.entity.User;
import com.code.client.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationToken(String token, User user);

}
