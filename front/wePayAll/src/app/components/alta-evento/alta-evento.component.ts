import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from '../../service/projectService';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { User } from '../../model/user';
import { Event } from '../../model/event';
import { UsersEvent, Users } from '../../model/usersEvent';

@Component({
  selector: 'app-alta-evento',
  templateUrl: './alta-evento.component.html',
  styleUrls: ['./alta-evento.component.css'],
  providers: [UserRegistreService]
})
export class AltaEventoComponent implements OnInit {

  public show: boolean;
  public event: Event;
  public user: User;
  public identity;

  constructor(
    private _userRegisterService: UserRegistreService,
  ) {
    this.show = true;
    this.event = new Event ('', '', '');

  }

  ngOnInit() {

    this.identity = this._userRegisterService.getUserLogin();

  }

//   suscribirse(){
//     console.log("evento creado");
//     this._userRegisterService.createEvent(this.event).subscribe(
//       response => {
//         console.log(response)
//          this.event = response;
//         if(this.event) {
//           this.eventId = this.event.eventId;
//           localStorage.setItem('eventId', JSON.stringify(this.eventId));
//           this.show = false;
//          }
//       },
//       error => {
//         console.error(error)
//       }
//     )
// }



  pagar(){
    console.log("Pagar")


  }
}
