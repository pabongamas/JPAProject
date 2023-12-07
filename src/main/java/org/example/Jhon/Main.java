package org.example.Jhon;


import org.example.Jhon.Util.UtilEntity;
import org.example.Jhon.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManager em= UtilEntity.getEntityManager();
        List<Employee> employees=em.createQuery("select e from Employee e",Employee.class).getResultList();
        employees.forEach(System.out::println);


        System.out.println("-------------buscar uno--------------");
        int employeeId=3;
        Employee employee=em.find(Employee.class,employeeId);
        System.out.println(employee);

        //insercion
//        System.out.println("---------------crear uno ----------------------");
//
//        Employee newEmployee=new Employee();
//        newEmployee.setFirstName("creado nuevo");
//        newEmployee.setPaSurname("apellido nuevo");
//        newEmployee.setMaSurname("otro apellido");
//        newEmployee.setEmail("nuevo@example.com");
//        newEmployee.setSalary((float) 12312);
//
//        em.getTransaction().begin();
//        em.persist(newEmployee);
//        em.getTransaction().commit();
//
//        System.out.println("nuevo empleado creado:"+newEmployee);

//        System.out.println("-------------actualizar--------------------");
//        int employeeToUpdateId=2;
//        Employee employeeToUpdate=em.find(Employee.class,employeeToUpdateId);
//        System.out.println("Empleado a modificar "+employeeToUpdate);
//        employeeToUpdate.setMaSurname("jairo editado");
//        employeeToUpdate.setPaSurname("pabon");
//        employeeToUpdate.setSalary((float) 4500000);
//        em.getTransaction().begin();
//        em.merge(employeeToUpdate);
//        em.getTransaction().commit();
//
//        System.out.println("empleado actualizado "+employeeToUpdate);

        System.out.println("---------------eliminar----------------");
        int employeeToDeleteId=21;
        Employee employeetoDelete=em.find(Employee.class,employeeToDeleteId);
        System.out.println("empleado a eliminar "+employeetoDelete);
        em.getTransaction().begin();
        em.remove(employeetoDelete);
        em.getTransaction().commit();
        em.close();

    }
}