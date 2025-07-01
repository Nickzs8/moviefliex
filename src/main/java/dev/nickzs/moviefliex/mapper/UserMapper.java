package dev.nickzs.moviefliex.mapper;

import dev.nickzs.moviefliex.controller.request.UserRequest;
import dev.nickzs.moviefliex.controller.response.UserResponse;
import dev.nickzs.moviefliex.entity.User;
import lombok.experimental.UtilityClass;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
