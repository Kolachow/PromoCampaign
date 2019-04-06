package pl.mkolasinski.promocampaign;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.mkolasinski.promocampaign.employee.controller.EmployeeController;
import pl.mkolasinski.promocampaign.employee.model.Employee;
import pl.mkolasinski.promocampaign.employee.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTestMVC {
                                                                //TE TESTY SA LEPSZE ! ! ! ! ! !
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    private List<Employee> employeeList = new ArrayList<>();

    @Before
    public void create_employee_list() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Snow");
        employee.setCompany("Bosman");
        employee.setId(5);
        employeeList.add(employee);
    }

    @Test
    public void test_get_all_employees() throws Exception {
        //given

        //when
        when(service.getEmployeeList()).thenReturn(employeeList);

        //then
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"firstName\":\"John\"," +
                        "\"lastName\":\"Snow\"," +
                        "\"company\":\"Bosman\"," +
                        "\"id\":5}]"));
    }
}
