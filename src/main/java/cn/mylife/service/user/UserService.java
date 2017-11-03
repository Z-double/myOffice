package cn.mylife.service.user;
import cn.mylife.entity.Employee;
import java.util.List;

public interface UserService extends BaseService<Employee>{
    void saveUser(Employee user);
    List<Employee> getAll();
}