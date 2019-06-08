import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from '../../service/projectService';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { UsersEvent, Users } from '../../model/usersEvent';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  providers: [UserRegistreService]
})
export class SearchComponent implements OnInit {

  public usersEvent: UsersEvent;
  constructor(
    private _userRegisterService: UserRegistreService,
  ) {
    this.usersEvent = new UsersEvent ([], '', '', '', '');
  }

  ngOnInit() {
    this._userRegisterService.getEvent(this.usersEvent).subscribe(
      response => {
        console.log(response)
        console.log('Nos muestra los datos a los que estamos suscripcion')
      },
      error => {
        console.log(error)
      }
    )
  }

}
