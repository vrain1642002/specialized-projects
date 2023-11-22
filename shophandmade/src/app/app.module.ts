import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProductComponent } from './product/product.component';


// import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    
    HomeComponent,
         HeaderComponent,
         FooterComponent,
         ProductComponent
        
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [ProductComponent]
    
})
export class AppModule { }