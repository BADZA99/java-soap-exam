package com.exam.metier.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.exam.metier.dto.UserDto;
import com.exam.metier.entity.UserEntity;

public class UserMapper {

	
	public static List<UserDto> listUserEntityToListUserDto(List<UserEntity> users) {
		
		return users.stream()
				.map(UserMapper::toUserDto)
				.collect(Collectors.toList());
	}
	
	
	public static UserDto toUserDto(UserEntity user) {
		
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}
	
	public static UserEntity toUserEtity(UserDto user) {
		
		return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}
}
