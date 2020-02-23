import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Product } from './product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.scss']
})
export class ProductAddComponent implements OnInit {

  addProductForm: FormGroup;
  prodName = '';
  prodDesc = '';
  prodPrice = '';


  constructor(private formBuilder: FormBuilder, private router: Router, private productService: ProductService) { }

  ngOnInit() {
    this.addProductForm = this.formBuilder.group({
      'prodName' : [null, Validators.required],
      'prodDesc' : [null, Validators.required],
      'prodPrice' : [null, Validators.required]
    });
  }
  
  addProduct(form: NgForm) {
    this.productService.addProduct(form)
      .subscribe(res => {
        this.router.navigate(['products']);
      }, err => {
        console.log(err);
        alert(err.error);
      }); 
  }

}
