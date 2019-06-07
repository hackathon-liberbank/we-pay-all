import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alta-evento',
  templateUrl: './alta-evento.component.html',
  styleUrls: ['./alta-evento.component.css']
})
export class AltaEventoComponent implements OnInit {

  public show: boolean;

  constructor() {
    this.show = true;
  }

  ngOnInit() {


  }

  suscribirse(){
    console.log("acceder")
    this.show = false;

  }
  pagar(){
    console.log("Pagar")

  }
}
