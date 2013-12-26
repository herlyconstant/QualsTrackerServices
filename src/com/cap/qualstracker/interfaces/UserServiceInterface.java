package com.cap.qualstracker.interfaces;

import com.cap.qualstracker.enums.Status;
import com.cap.qualstracker.transferobjects.User;
import com.cap.qualstracker.transferobjects.UserGroup;

public interface UserServiceInterface {

	public String findByEmailId(String emailId);
	public String findByName(String userName);
	public void associateToGroup(String userId, String groupId);
	public UserGroup retrievePendingUserGroupAssociations(String userId);
	public void associateUserToGroup(String groupName, String userId);
}
