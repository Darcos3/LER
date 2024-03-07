import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { NgFor } from '@angular/common';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista',
  standalone: true,
  imports: [ NgFor ],
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css'
})
export class ListaComponent implements OnInit {
  personas:any = [];
  estado:boolean = false;

  form: any = {
    nombre: '',
    numero_identificacion: '',
    fecha_nacimiento: ''
  } 

  constructor( private api: ApiService, private router: Router ){
  }
  

  ngOnInit() {
    this.obtenerPersonas();
  }

  atras(){
    this.router.navigate(["/"]);
    this.estado = false;
    console.log('atras')
  }

  obtenerPersonas(){
    this.api.obtenerPersonas().subscribe((data:any) =>{
      this.personas = data;
      console.log(this.personas);
    })
  }

  crear( nombre:any, num_ide:any, fecha_nac:any ){
    let body = {
      "nombre": nombre.value,
      "numero_identificacion": num_ide.value,
      "fecha_nacimiento": fecha_nac.value
    }

    this.api.crearPersona(body).subscribe((data:any)=>{
      alert('Se ha creado una nueva persona!');
      this.ngOnInit();
    })
  }

  editar(id:any){
    this.router.navigate(["/edit/" + id]);
  }

  eliminar(id:any){
    this.api.eliminarPersona(id).subscribe((data:any)=>{
      console.log(data);
      alert('Se ha eliminado la persona con id ' + id);
      this.ngOnInit();
    });
  }
}
