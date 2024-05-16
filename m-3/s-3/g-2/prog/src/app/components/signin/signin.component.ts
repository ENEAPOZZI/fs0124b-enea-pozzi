import { Component } from '@angular/core';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss'
})
export class SigninComponent {
  export class SigninComponent implements OnInit {
    username!:string
    password!: string
  constructor() { }


  ngOnInit(): void {
  }
  submitLogin(target: NgForm) {
    alert("Submitted")
  }

}
