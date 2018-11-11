import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from './user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  @ViewChild('form') form: NgForm;

  constructor(private service: UserService) { }

  user = {} as User;

  ngOnInit() {
  }

  onSubmit() {
    if (this.form.submitted && this.form.valid) {
      // console.log(this.product);
      // console.log('selected' + this.selectedValue);
      // //console.log(this.category);
      //this.product.category = this.category.selectedValue;
      console.log(this.user);
      this.service.addUser(this.user).subscribe(user => this.user);
    }
  }

}
