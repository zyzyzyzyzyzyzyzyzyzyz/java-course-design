package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageDaoImpl implements ManageDao {
    @Override
    public List<Person> getAllPerson() {
        String sql = "select * from person where userIdentify!=2";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Person> getSearch(String matchText) {
        String sql = "select * from person where userIdentify!=2 and (userAccount='' or userName like '%"+matchText+"%' or userIdCard='"+matchText+"')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public void addPerson(Person newPerson) {
        String sql = "insert into person values('"+newPerson.getUserAccount()+"','"+newPerson.getUserName()+"','"+newPerson.getUserSex()+"','"+newPerson.getUserBirthday()+"','"+newPerson.getUserIdCard()+"','"+newPerson.getUserPassword()+"',"+newPerson.getUserIdentify()+",'"+newPerson.getUserOtherName()+"','"+newPerson.getUserjavascore()+"','"+newPerson.getUsermathscore()+"','"+newPerson.getUserenglishscore()+"')";
        Deal.deal(sql);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        String sql = "update person set userPassword = '"+userPassword+"' where userAccount='"+userAccount+"'";
        Deal.deal(sql);
    }

    @Override
    public void delThisPerson(String delAccount, String userIdentify) {
        if(Integer.parseInt(userIdentify)==0){
            //删除学生
            String sql = "DELETE FROM userteacher WHERE `userAccount` = '"+delAccount+"'";
            Deal.deal(sql);
            sql = "DELETE FROM studenttask WHERE studentAccount = '"+delAccount+"'";
            Deal.deal(sql);
        }else{
            //删除老师
            String sql = "DELETE FROM `studenttask` WHERE taskAccount IN (SELECT taskAccount FROM task WHERE teacherAccount='"+delAccount+"')";
            Deal.deal(sql);
            sql = "DELETE FROM task WHERE teacherAccount = '"+delAccount+"'";
            Deal.deal(sql);
            sql = "DELETE FROM userteacher WHERE teacherAccount = '"+delAccount+"'";
            Deal.deal(sql);
        }
        String sql = "DELETE FROM person WHERE userAccount = '"+delAccount+"'";
        Deal.deal(sql);
    }
}
