import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Emp } from '../viewmodels/emp.viewmodel';
import { AppSettings } from  '../app.module';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }
  getEmpById(id:number):Observable<Emp>{
    return this.http.get<Emp>(AppSettings.baseURL +"/find/"+id)
  }
}
