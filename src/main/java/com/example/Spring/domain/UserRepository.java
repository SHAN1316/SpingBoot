package com.example.Spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * dao只要继承JpaRepository类就可以，几乎可以不用写方法，
 * 还有一个特别有尿性的功能非常赞，就是可以根据方法名来自动的生产SQL，
 * 比如findByUserName 会自动生产一个以 userName 为参数的查询方法，
 * 比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
	User findById(long id);
	Long deleteById(long id);
	User findByUserNameOrEmail(String username, String email);
}
