package cm.stu.bean;

public class Person {
    //`userAccount``userName``usersex``userBirthday``userIdCard``userPassword``userIdentify``userOtherName`
    private String userAccount;
    private String userName;
    private String userSex;
    private String userBirthday;
    private String userIdCard;
    private String userPassword;
    private int userIdentify;
    private String userOtherName;
    private  String userjavascore;
    private  String usermathscore;
    private String userenglishscore;

    public Person() {
    }

    public Person(String userAccount, String userName, String userSex, String userBirthday, String userIdCard, String userPassword, int userIdentify, String userOtherName,String userjavascore,String usermathscore,String userenglishscore) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userIdCard = userIdCard;
        this.userPassword = userPassword;
        this.userIdentify = userIdentify;
        this.userOtherName = userOtherName;
        this.userjavascore = userjavascore;
        this.usermathscore = usermathscore;
        this.userenglishscore = userenglishscore;
    }

    public Person(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(int userIdentify) {
        this.userIdentify = userIdentify;
    }

    public String getUserOtherName() {
        return userOtherName;
    }

    public void setUserOtherName(String userOtherName) {
        this.userOtherName = userOtherName;
    }
    public String getUserjavascore() {
        return userjavascore;
    }

    public void setUserjavascore(String userjavascore) {
        this.userjavascore = userjavascore;
    }
    public String getUsermathscore() {
        return usermathscore;
    }

    public void setUsermathscore(String usermathscore) {
        this.usermathscore = usermathscore;
    }

    public String getUserenglishscore() {
        return userenglishscore;
    }

    public void setUserenglishscore(String userenglishscore) {
        this.userenglishscore = userenglishscore;
    }


    @Override
    public String toString() {
        return "Person{" +
                "userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIdentify=" + userIdentify +
                ", userOtherName='" + userOtherName + '\'' +
                ", userjavascore=" + userjavascore +
                ", usermathscore='" + usermathscore + '\'' +
                ", userenglishscore=" + userenglishscore +
                '}';
    }


}
