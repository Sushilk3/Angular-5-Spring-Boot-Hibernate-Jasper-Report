import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms'

import {routing} from "./app.routing";

// App View
import {AppComponent } from './app.component';
import {HomeComponent} from "./component/cv.home.component";
import {RegisterComponent} from "./component/cv.register.component";
import {ReportComponent} from "./component/cv.report.component";
import {NavBarComponent} from "./component/cv.nav-bar.component";
import { DataComponent } from './component/cv.data.list.component';

// Service
import {CurriculumViteaService} from "./service/cv.service";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    ReportComponent,
    NavBarComponent,
    DataComponent
  ],
  imports: [
    BrowserModule,
    routing,
    HttpModule,
    FormsModule
  ],
  providers: [CurriculumViteaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
