<?php
require_once('abstractDAO.php');
require_once('product.php');

class productDAO extends abstractDAO {
        
    function __construct() {
        try{
            parent::__construct();
        } catch(mysqli_sql_exception $e){
            throw $e;
        }
    }
    
    public function getProducts(){
        //The query method returns a mysqli_result object
        $result = $this->mysqli->query('SELECT * FROM products');
        $products = Array();
        
        if($result->num_rows >= 1){
            while($row = $result->fetch_assoc()){
                
                $product = new Product($row['id'], $row['productName'], $row['imagePath'], $row['price'], $row['rating'], $row['description']);
                $products[] = $product;
            }
            $result->free();
            return $products;
        }
        $result->free();
        return false;
    }

    public function getProduct($id){
        $query = 'SELECT * FROM products WHERE id = ?';
        $stmt = $this->mysqli->prepare($query);
        $stmt->bind_param('i', $id);
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows == 1){
            $temp = $result->fetch_assoc();
            $product = new product($temp['id'], $temp['productName'], $temp['imagePath'], $temp['price'], $temp['rating'], $temp['description']);
            $result->free();
            return $product;
        }
        $result->free();
        return false;
    }

    public function addProduct($product){
        if(!is_numeric($product->getId())){
            return 'id must be a number.';
        }
        if(!$this->mysqli->connect_errno){
            
            $query = 'INSERT INTO products VALUES (?,?,?,?,?,?)';
            
            $stmt = $this->mysqli->prepare($query);
            
            $stmt->bind_param('issiis', 
                    $product->getId(), 
                    $product->getProductName(), 
                    $product->getImagePath(),
					$product->getPrice(),
					$product->getRating(),
					$product->getDescription());
            
            $stmt->execute();
            
            if($stmt->error){
                return $stmt->error;
            } else {
                return $product->getProductName() . ' ' . $product->getImagePath() . ' added successfully, not bad!';
            }
        } else {
            return 'Could not connect to Database.';
        }
    }
    
    public function deleteProduct($id){
        if(!$this->mysqli->connect_errno){
            $query = 'DELETE FROM products WHERE id = ?';
            $stmt = $this->mysqli->prepare($query);
            $stmt->bind_param('i', $id);
            $stmt->execute();
            if($stmt->error){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    
    public function editProduct($id, $productName, $imagePath){
        if(!$this->mysqli->connect_errno){
            $query = 'UPDATE products SET productName = ?, imagePath = ? WHERE id = ?';
            $stmt = $this->mysqli->prepare($query);
            $stmt->bind_param('ssi', $productName, $imagePath, $id);
            $stmt->execute();
            if($stmt->error){
                return false;
            } else {
                return $stmt->affected_rows;
            }
        } else {
            return false;
        }
    }
}

?>
