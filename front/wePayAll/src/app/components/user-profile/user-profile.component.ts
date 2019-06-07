import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { UserRegistreService } from '../../service/projectService';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserRegistreService]
})
export class UserProfileComponent implements OnInit {

  public identity;

  public code: string;
  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
}

  ngOnInit() {

    this.identity = this._userRegisterService.getUserLogin();

    this._route.queryParams.subscribe(params => {
        this.code = params['code'];
        console.log(this.code)
      });

    if(this.code != null) {
      console.log("code guardado")
    }else {
      console.log("no llego")
    }

    console.log()
}

}
