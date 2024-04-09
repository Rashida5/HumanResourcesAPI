# HR-System-Using-RestAPI
this rest apis enable CRUD operation for each Entity

## Documentation 
https://documenter.getpostman.com/view/24971171/2sA35MzzVr
### Technologies
- [x] JAX-RS (Jersey)
- [x] Jakarta persistance (Hibernate)
- [x] Postman
- [x] Junit 5 for testing
## Features

### Employees
#### Add Employee Request
##### url: http://localhost:8181/HR_API_REST/api/employees
![AddEmployee](https://github.com/Rashida5/HumanResourcesAPI/blob/main/images/addEmployee.png)

#### get Data about Employee
##### url: http://localhost:8181/HR_API_REST/api/employees/1
![getEmployee](https://github.com/Rashida5/HumanResourcesAPI/blob/main/images/getEmployee.png)

### Department

#### Add Department Request
##### url: http://localhost:8181/HR_API_REST/api/departments/addDepartment
![AddDepartment](https://github.com/Rashida5/HumanResourcesAPI/blob/main/images/addDept.png)

#### Get Department Response 
##### url: http://localhost:8181/HR_API_REST/api/departments/getDepartment?departmentId=1
![GetDepartment](https://github.com/Rashida5/HumanResourcesAPI/blob/main/images/getDept.png)

### Attendance

#### Mark Arrive of User
##### url: http://localhost:8181/HR_API_REST/api/attendance/attendEmployee
![ArriveOfUser](https://github.com/Rashida5/HumanResourcesAPI/blob/main/images/markArriveOfUser.png)


#### GetData about attendance of User
##### url: http://localhost:8181/HR_API_REST/api/attendance/getAttendanceOfEmployee?employeeId=4&month=4&year=2024
![GetDataAbout](https://github.com/Rashida5/HumanResourcesAPI/blob/main/images/getDataAboutofAttendance.png)
