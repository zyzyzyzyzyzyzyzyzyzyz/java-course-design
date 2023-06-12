package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.bean.StudentAnswer;
import cm.stu.dao.Generate;
import cm.stu.service.StudentService;
import cm.stu.service.StudentServiceImpl;
import cm.stu.service.TeacherService;
import cm.stu.service.TeacherServiceImpl;
import cm.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student.action")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        StudentService ss = new StudentServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();
        //"student.action?action=searchTeacher"
        if(action.equals("list")||action.equals("searchTeacher")){

            List<Person> arr ;
            if(action.equals("list")){
                arr = ss.getAllTeacher();
            }else {
                String matchText = req.getParameter("matchText");
                arr = ss.getSearchTeacher(matchText);
            }

            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goMyTeacher")||action.equals("deleteMyTeacher")){
            //student.action?action=goMyTeacher
            //student.action?action=deleteMyTeacher&teacherAccount="+teacherAccount;
            if(action.equals("deleteMyTeacher")){
                String teacherAccount = req.getParameter("teacherAccount");
                ss.deleteMyTeacher(userAccount,teacherAccount);
            }
            List<Person> arr = ss.getMyTeacher(userAccount);
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","myTeacher.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("addTeacher")){
            //addTeacher&teacherAccount="
            String teacherAccount = req.getParameter("teacherAccount");
            int flag = Generate.IsExistStuTea(userAccount,teacherAccount);
            if(flag==0){
                ss.addTeacher(userAccount,teacherAccount);
                req.setAttribute("tip","添加成功");
            }else {
                req.setAttribute("tip","你已经选择这个老师，本次选择失败！");
            }
            req.setAttribute("mainRight","blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goMyTeaTask")){
//          "student.action?action=goMyTeaTask&teacherAccount="+teacherAccount
            String teacherAccount = req.getParameter("teacherAccount");
            List<StudentAnswer> arr = ss.goMyTeaTask(userAccount,teacherAccount);
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","studentTask.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("doAnswer")){
//            stu.action?action=doAnswer&taskAccount="+taskAccount+"",
            String taskAccount = req.getParameter("taskAccount");
            req.setAttribute("taskAccount",taskAccount);
            req.getRequestDispatcher("doAnswer.jsp").forward(req,resp);
        }else if(action.equals("dealAnswer")){
            //"student.action?action=doAnswer&taskAccount="+taskAccount

            String taskAccount = req.getParameter("taskAccount");
            String answer = (req.getParameter("answer")).trim();
            System.out.println(taskAccount+"     "+answer);
            ss.doAnswer(userAccount,taskAccount,answer);
            req.setAttribute("tip","恭喜答题完成，请关闭页面等待老师的更改！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else if(action.equals("doFenshu")){
            //student.action?action=doFenshu&taskAccount="+taskAccount+"&studentAccount="+studentAccount,
            String taskAccount = req.getParameter("taskAccount");
            String studentAccount = req.getParameter("studentAccount");
            req.setAttribute("taskAccount",taskAccount);
            req.setAttribute("studentAccount",studentAccount);
            req.getRequestDispatcher("getFenshu.jsp").forward(req,resp);
        }else if(action.equals("getFenshu")){
            //action="student.action?action=getFenshu&taskAccount=${taskAccount}&studentAccount=${studentAccount}"
            String taskAccount = req.getParameter("taskAccount");
            String studentAccount = req.getParameter("studentAccount");
            String fenshu = req.getParameter("fenshu");
            ss.dealFenshu(taskAccount,studentAccount,fenshu);
            req.setAttribute("tip","已修改分数！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }
    }
}
