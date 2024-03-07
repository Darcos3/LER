import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component'
import { EditComponent } from './components/edit/edit.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'edit/:id', component: EditComponent },
];
