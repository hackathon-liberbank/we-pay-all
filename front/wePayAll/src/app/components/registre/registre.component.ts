import { Component, OnInit } from '@angular/core';
import { UserRegistre, Address } from '../../model/userRegistre';
import { UserRegistreService } from '../../service/projectService';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css'],
  providers: [UserRegistreService]
})
export class RegistreComponent implements OnInit {

  public user: UserRegistre;
  public status: string;
  public showForm: boolean;
  public identity;


  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.user = new UserRegistre('', '', '', '', new Address('', '', '', '', '') , '');
    this.showForm = true;
  }

  ngOnInit() {
  }


  resgistrar(form) {
    console.log(this.user)

    this._userRegisterService.registrado(this.user).subscribe(
      response => {
        if(response) {
          console.log("Registro completado")
          this.status = 'success'
          this.showForm = false;

        } else {
          this.status = 'error'
          this.showForm = false;
        }
      },
      error => {
        console.error(error)
      }
    );
  }

}
