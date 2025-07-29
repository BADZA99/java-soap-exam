package com.exam.metier.dao;

import java.util.Optional;

import com.exam.metier.entity.UserEntity;

public interface IUserDao extends Repository<UserEntity> {

	public Optional<UserEntity> login (String email, String password);
}
