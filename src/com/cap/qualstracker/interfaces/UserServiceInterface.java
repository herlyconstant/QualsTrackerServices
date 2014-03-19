package com.cap.qualstracker.interfaces;

public interface UserServiceInterface {

	public abstract String findByEmailId(String emailId);
	public abstract String findByName(String userName);
	public abstract void associateToGroup(String groupName, String userId);
	public abstract String retrievePendingUserGroupAssociations(String userId);
	//public void associateUserToGroup(String groupName, String userId);
}
