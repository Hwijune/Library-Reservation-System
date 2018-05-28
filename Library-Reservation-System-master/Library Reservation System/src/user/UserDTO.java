package user;

public class UserDTO {

	private String userID;
	private String userPassword;
	private String userGender;
	private int userAge;
	private String userEmail;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public UserDTO(String userID, String userPassword, String userGender, int userAge, String userEmail) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userEmail = userEmail;
	}
	
}
