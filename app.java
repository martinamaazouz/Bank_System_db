package org.example.banksystem;


import org.example.banksystem.dao.*;

import java.io.IOException;

public class app {
    public static void main(String[] args) throws IOException {
        //userdao userdao = new userDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
       // employeeDao.findAll();
        employeeDao.findAll.forEach(System.out::println);

        //userdao.signup();
      // AdminDao adminDao = new AdminDaoImpl();
      // adminDao.AddBankBranch();

    }
}
