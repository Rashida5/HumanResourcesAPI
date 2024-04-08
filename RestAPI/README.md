# HR-System-Using-RestAPI
this rest apis enable CRUD operation for each Entity
### Technologies
- [x] JAX-RS (Jersey)
- [x] Jakarta persistance (Hibernate)
- [x] Postman
- [x] Junit 5 for testing
## Features

### Employees
#### Add Employee Request
##### url: http://localhost:8181/HR_API_REST/api/employees
![AddEmployee](C:\Users\Rashida\Desktop\HR_API\images\addEmployee.png)

#### get Data about Employee
##### url: http://localhost:8181/HR_API_REST/api/employees/1
![getEmployee](C:\Users\Rashida\Desktop\HR_API\images\getEmployee.png)

### Department

#### Add Department Request
##### url: http://localhost:8181/HR_API_REST/api/departments/addDepartment
![AddDepartment](C:\Users\Rashida\Desktop\HR_API\images\addDept.png)

#### Get Department Response 
##### url: http://localhost:8181/HR_API_REST/api/departments/getDepartment?departmentId=1
![GetDepartment](C:\Users\Rashida\Desktop\HR_API\images\getDept.png)

### Attendance

#### Mark Arrive of User
##### url: http://localhost:8181/HR_API_REST/api/attendance/attendEmployee
![ArriveOfUser](C:\Users\Rashida\Desktop\HR_API\images\markArriveOfUser.png)


#### GetData about attendance of User
##### url: http://localhost:8181/HR_API_REST/api/attendance/getAttendanceOfEmployee?employeeId=4&month=4&year=2024
![GetDataAbout](C:\Users\Rashida\Desktop\HR_API\images\getDataAboutofAttendance.png)
