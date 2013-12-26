package com.cap.qualstracker.interfaces;

public interface GroupServiceInterface {

	public String retrieveGroupsForUser(String userId);
	public String retrieveGroups();
	public String retrieveGroupProfile(String groupId);
}
