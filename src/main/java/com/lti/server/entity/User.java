package com.lti.server.entity;


import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
    //User Entity

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "User_Seq")//genrating seq of user seperately
    @SequenceGenerator(name="User_Seq",sequenceName = "user_seq",allocationSize = 1)
    private int userId;

    @Column(length = 10)
    private String userName;

    private long userPhone;

    @Column(length = 20)
    private String userEmail;

    @Column(length = 10)
    private String userPass;

    @Column(length = 10)
    private String userConfirmPass;

    @Column(length = 30)
    private String userAdd;

    private double userSalary;
    @Column(length = 10)
    private String userCard;

    private boolean verified=false;
    
    //Getters and Setters


    public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserConfirmPass() {
        return userConfirmPass;
    }

    public void setUserConfirmPass(String userConfirmPass) {
        this.userConfirmPass = userConfirmPass;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
    }

    public double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(double userSalary) {
        this.userSalary = userSalary;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    //Constructors


    public User() {
        super();
    }

    public User(int userId, String userName, long userPhone, String userEmail, String userPass, String userConfirmPass, String userAdd, double userSalary, String userCard, boolean verified) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userConfirmPass = userConfirmPass;
        this.userAdd = userAdd;
        this.userSalary = userSalary;
        this.userCard = userCard;
        this.verified=verified;
    }
}
