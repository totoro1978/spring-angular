import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from '../product.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
  animations: [
  	trigger('detailExpand', [
  		state('collapsed', style({height: '0px', minHeight: '0'})),
  		state('expanded', style({height: '*'})),
  		transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
  	])
  ]
})
export class ProductsComponent implements OnInit {

  expandedElement: PeriodicElement | null;
  
  data: Product[] = [];
  displayedColumns: string[] = ['prodName', 'prodDesc', 'prodPrice'];
  isLoadingResults = true;

  constructor(private productService: ProductService, private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts()
      .subscribe(products => {
        this.data = products;
        console.log(this.data);
        this.isLoadingResults = false;
      }, err => {
        console.log(err);
        this.isLoadingResults = false;
      });
  }

  addProd() {
    this.router.navigate(['addProduct']);
  }
  
  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }

}

export interface PeriodicElement {
  prodName: string;
  prodDesc: string;
  prodPrice: number;

}