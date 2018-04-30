import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/compiler/src/core";
/**
 * Created by SRX on 1/7/2018.
 */

import {HomeComponent} from "./component/cv.home.component";
import {RegisterComponent} from "./component/cv.register.component";
import {ReportComponent} from "./component/cv.report.component";
import {DataComponent} from "./component/cv.data.list.component";



const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'report',
    component: ReportComponent
  },
  {
    path: 'data-list-view',
    component: DataComponent
  }
]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
