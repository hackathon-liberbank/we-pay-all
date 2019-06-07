import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from '../../service/projectService';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  providers: [UserRegistreService]
})
export class SearchComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
