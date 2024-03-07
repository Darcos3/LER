import { Component } from '@angular/core';
import { ListaComponent } from '../components/lista/lista.component';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ ListaComponent, NgIf ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  listar:boolean = false;

  constructor(){
  }

  atras(){
    this.listar = false;
  }

  comenzar(){
    console.log('listar');
    this.listar = true;
  }

}
