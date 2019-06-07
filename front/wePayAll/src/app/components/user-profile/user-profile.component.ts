import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {



  public code: string;
  constructor(
    private _route: ActivatedRoute,
    private _router: Router
  ) {
}

  ngOnInit() {
    this._route.queryParams.subscribe(params => {
        this.code = params['code'];
        console.log(this.code)

      });

    if(this.code != null) {
      console.log("code guardado")
    }else {
      console.log("no llego")
    }
}

}
