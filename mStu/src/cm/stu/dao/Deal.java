package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.bean.StudentAnswer;
import cm.stu.bean.Task;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Deal {


    public static List<Person> getAllPerson(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Person> list = new ArrayList<>();
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Person newPerson = new Person();
                //`userAccount``userName``usersex``userBirthday``userIdCard``userPassword``userIdentify``userOtherName`
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
                newPerson.setUserjavascore(res.getString("userjavascore"));
                newPerson.setUsermathscore(res.getString("usermathscore"));
                newPerson.setUserenglishscore(res.getString("userenglishscore"));
                list.add(newPerson);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return list;
    }

    public static List<Task> getAllMyTask(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Task> list = new ArrayList<>();
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Task task = new Task();
                //`taskAccount``teacherAccount``taskDate``taskName`
                task.setTaskAccount(res.getString("taskAccount"));
                task.setTaskDate(res.getString("taskDate"));
                task.setTaskName(res.getString("taskName"));
                task.setTeacherAccount(res.getString("teacherAccount"));
                list.add(task);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<StudentAnswer> getTaskDetail(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentAnswer> list = new ArrayList<>();
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentAnswer sa = new StudentAnswer();
                ////`taskAccount``studentAccount``studentAnswer``isFinish``isScore``userName``taskName`
                sa.setTaskAccount(res.getString("taskAccount"));
                sa.setStudentAccount(res.getString("studentAccount"));
                sa.setStudentAnswer(res.getString("studentAnswer"));
                sa.setIsFinish(res.getInt("isFinish"));
                sa.setIsScore(res.getInt("isScore"));
                sa.setUserName(res.getString("userName"));
                sa.setTaskName(res.getString("taskName"));
                list.add(sa);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static int isExist(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        int num=0;
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                num = res.getInt("num");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return num;
    }

    public static void deal(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            pre =connection.prepareStatement(sql);
            pre.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
    }
}
