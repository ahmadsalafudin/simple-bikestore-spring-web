package com.batm.tokoBatch3.service;

import java.util.List;
import com.batm.tokoBatch3.model.User;

public interface UserService {
	
	List <User> listUser();
	
	User saveOrUpdate (User user);
	User getIdUser(Integer id);
	void hapus (Integer id);

}
