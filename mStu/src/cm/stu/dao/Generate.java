package cm.stu.dao;

public class Generate {
    public static int isExistTaskAccount(String taskAccount) {
        String sql = "select count(*) num from task where taskAccount='"+taskAccount+"'";
        return Deal.isExist(sql);
    }

    public static int IsExistStuTea(String userAccount, String teacherAccount) {
        //`userteacher` `userAccount``teacherAccount`
        String sql = "select count(*) num from userteacher where userAccount='"+userAccount+"' and teacherAccount='"+teacherAccount+"'";
        return Deal.isExist(sql);
    }

    public static int isExistPersonAccount(String userAccount) {
        String sql = "select count(*) num from person where userAccount='"+userAccount+"'";
        return Deal.isExist(sql);
    }
}
