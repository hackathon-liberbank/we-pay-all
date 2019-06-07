import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from '../../service/projectService';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Event } from '../../model/event';

@Component({
  selector: 'app-alta-evento',
  templateUrl: './alta-evento.component.html',
  styleUrls: ['./alta-evento.component.css'],
  providers: [UserRegistreService]
})
export class AltaEventoComponent implements OnInit {

  public show: boolean;
  public event: Event;
  public identity;

  constructor(
    private _userRegisterService: UserRegistreService,
  ) {
    this.show = true;
    this.event = new Event ('', '', 12);

  }

  ngOnInit() {

    this.identity = this._userRegisterService.getUserLogin();

  }

  suscribirse(){
    console.log("acceder")
    this.show = false;
    console.log(this.event)

  }
  pagar(){
    console.log("Pagar")

  }
}
