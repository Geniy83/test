package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.EmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.runners.MockitoJUnitRunner;;
import java.sql.Date;

//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    EmployeeServiceImpl employeeService;


    @Test
    public void deleteTest() {
    employeeService.delete(1L);
    Mockito.verify(employeeDao).delete(1L);
    }

    @Test
    public void saveTest() {
        Employee testEmployee = new Employee();
        testEmployee.setEmployeeId(1L);
        testEmployee.setFirstName("Tom");
        testEmployee.setLastName("Cruz");
        testEmployee.setDepartmentID(1);
        testEmployee.setJobTitle("engineer");
        testEmployee.setGender(Gender.valueOf("MALE"));
        testEmployee.setDataOfBirth(Date.valueOf("1983-02-03"));

        Mockito.when(employeeService.save(Mockito.any(employeeDao.save(testEmployee)));
       
    }

//    @InjectMocks
//    EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeDao);
//
//    private static  Employee testEmployee;
//
//    @BeforeClass
//    public static void prepareTestData() {
//        Employee testEmployee = new Employee();
//        testEmployee.setEmployeeId(1L);
//        testEmployee.setFirstName("Tom");
//        testEmployee.setLastName("Cruz");
//        testEmployee.setDepartmentID(1);
//        testEmployee.setJobTitle("engineer");
//        testEmployee.setGender(Gender.valueOf("MALE"));
//        testEmployee.setDataOfBirth(Date.valueOf("1983-02-03"));
//        }

//    @Before
//    public void init() {
//        employeeService = new EmployeeServiceImpl(employeeDao);
//        }

//    @Test
//    public void updateTest() {
//        Mockito.verify(employeeDao).update(testEmployee);
//        when(employeeDao.getEmployeeId(any(Long.class))).thenReturn(testEmployee);
//        when(employeeDao.update(any(Employee.class))).;
//    }

}
