<?php
	class Product{
		private $id;
		private $productName;
		private $imagePath;
		private $price;
		private $rating;
		private $description;
		
		function __construct($id, $productName, $imagePath, $price, $rating, $description){
			$this->setId($id);
			$this->setProductName($productName);
			$this->setImagePath($imagePath);
			$this->setPrice($price);
			$this->setRating($rating);
			$this->setDescription($description);
		}
		
		public function getId(){
			return $this->id;
		}
		
		public function setId($id){
			$this->id = $id;
		}
		
		public function getProductName(){
			return $this->productName;
		}
		
		public function setProductName($productName){
			$this->productName = $productName;
		}
		
		public function getImagePath(){
			return $this->imagePath;
		}
		
		public function setImagePath($imagePath){
			$this->imagePath = $imagePath;
		}
		
		public function getPrice(){
			return $this->price;
		}
		
		public function setPrice($price){
			$this->price = $price;
		}
		
		public function getRating(){
			return $this->rating;
		}
		
		public function setRating($rating){
			$this->rating = $rating;
		}
		
		public function getDescription(){
			return $this->description;
		}
		
		public function setDescription($description){
			$this->description = $description;
		}
		
	}
?>