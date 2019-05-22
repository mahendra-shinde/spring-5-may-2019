import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './services/employee.service';
import { Emp } from './viewmodels/emp.viewmodel';
import { Profile } from './viewmodels/profile.viewmodel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'testspringapp';
  
  constructor(private employeeService: EmployeeService) {
  }

  emp:Emp= null;
  getEmpByIdFromService() {
    this.employeeService.getEmpById(1001).subscribe((res: any) => {
      this.emp = res;
      console.log(this.emp);
    })
  }

  ngOnInit() {
    this.getEmpByIdFromService();
  }
}
