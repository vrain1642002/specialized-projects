// header.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  toggleResponsiveClass() {
    const x = document.getElementById("myTopnav");

    if (x) {
      x.classList.toggle("responsive");
      }
    
  }
}
