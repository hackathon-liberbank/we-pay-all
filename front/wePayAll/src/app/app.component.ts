import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from './service/projectService';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [UserRegistreService]
})
export class AppComponent implements OnInit {
  title = 'wePayAll';
  public status: string;
  public showForm: boolean;
  public identity;

  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.showForm = true;
  }

  ngOnInit() {
    this.identity = this._userRegisterService.getUserLogin();
    console.log(this.identity)
  }

  logOut() {
    localStorage.clear();
    this.identity = null;
    this._router.navigate(['/home']);
  }


}
