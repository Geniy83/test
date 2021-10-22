package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.sql.Date;
import static org.mockito.Mockito.when;

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
    public void getEmployeeIdTest() {
        Employee testEmployee = new Employee();
        testEmployee.setEmployeeId(1L);
        testEmployee.setFirstName("Tom");
        testEmployee.setLastName("Cruise");
        testEmployee.setDepartmentID(1);
        testEmployee.setJobTitle("actor");
        testEmployee.setGender(Gender.valueOf("MALE"));
        testEmployee.setDataOfBirth(Date.valueOf("1962-07-03"));

        when(employeeDao.getEmployeeId(1L)).thenReturn(testEmployee);

        employeeService.getEmployeeId(1L);
        Mockito.verify(employeeDao).getEmployeeId(1L);
    }

}
