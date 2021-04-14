package com.springrest.springrest.clients;

import com.springrest.springrest.dao.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name = "user-name-fetching", url="http://10.177.68.88:8090")
public interface UserClient {
        @RequestMapping(method = RequestMethod.GET,path="/Template/getAllEmployee")
        List<Employee> getAllEmployee();


}
