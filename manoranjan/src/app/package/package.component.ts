import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      sessionStorage.setItem('email', params.get('email'));

    })
  }
  sendPackage3() {
    this.router.navigateByUrl('/payment/90days/449');
  }
  sendPackage6() {
    this.router.navigateByUrl('/payment/180days/749');
  }


}
