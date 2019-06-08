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
  public usersEvent: UsersEvent;
  public identity;

  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.show = true;
    this.event = new Event ('', '', '');
    this.usersEvent = new UsersEvent ([], '', '', '', '');

  }

  ngOnInit() {

    this.identity = this._userRegisterService.getUserLogin();

  }

  suscribirse(){
    console.log("evento creado");
    this._userRegisterService.createEvent(this.event).subscribe(
      response => {
        console.log(response)
        this.show = false;
        this._userRegisterService.getEvent(this.usersEvent).subscribe(
          response => {
            console.log(response)
            console.log('Nos muestra los datos de la suscripcion')
          },
          error => {
            console.log(error)
          }
        )
      }, error => {
        console.error(error)
      }
    )
  }

  pagar(){
    console.log("Pagar")
    this._userRegisterService.makePayment().subscribe(
      response => {
        console.log(response)

        setTimeout(()=>{
          this._router.navigate(['/user-profile']);
      }, 3000);


      }, error => {
        console.error(error)
        this._router.navigate(['/user-profile']);
      }
    )



  }
}
