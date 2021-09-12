<?php require_once('./productDAO.php'); ?>
<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="shortcut icon" href="./Assets/logo.png" />
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Global Village</title>
		<link rel="stylesheet" href="addProduct.css" />
		<link rel="stylesheet" href="script.js"> </script>
		<!-- //Animate On Scroll Library -->
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
		<!-- fonts styles -->
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link href="https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap" rel="stylesheet" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
	</head>

	<body>
		<header>
			<a href="../index.html" class="logo">
				<img src="images/logo.png" />
			</a>
		</header>
		<div class="heading">
			<h1><em>Add a new product...</em></h1>
		</div>
		<div class="content">
			<?php
				try{
					$productDAO = new productDAO();
					//Tracks errors with the form fields
					$hasError = false;
					//Array for our error messages
					$errorMessages = Array();

					if(isset($_POST['id']) ||
						isset($_POST['productName']) || 
						isset($_POST['imagePath'])){
					
						
						if(!is_numeric($_POST['id']) || $_POST['id'] == ""){
							$hasError = true;
							$errorMessages['idError'] = 'Please enter a numeric ID.';
						}

						if($_POST['productName'] == ""){
							$errorMessages['productNameError'] = "Please enter a product name.";
							$hasError = true;
						}

						if($_POST['imagePath'] == ""){
							$errorMessages['imagePathError'] = "Please enter a image path.";
							$hasError = true;
						}

						if(!$hasError){
							$product = new Product($_POST['id'], $_POST['productName'], $_POST['imagePath'], $_POST['price'], $_POST['rating'], $_POST['description']);
							$addSuccess = $productDAO->addProduct($product);
							echo '<h3>' . $addSuccess . '</h3>';
						}
					}  

					if(isset($_GET['deleted'])){
						if($_GET['deleted'] == true){
							echo '<h3>Product Deleted</h3>';
						}
					}
			?>
			
			<form name="form" method="post" action="addProduct.php">
				<h3><em>ID</em></h3>
				<input id="id" type="text" name="id" placeholder="id" />
				<h3><em>Product Name</em></h3>
				<input id="productName" type="text" name="productName" placeholder="product name" />
				<h3><em>Image Path</em></h3>
				<input id="imagePath" type="text" name="imagePath" placeholder="image path" />
				<h3><em>Price</em></h3>
				<input id="price" type="text" name="price" placeholder="price" />
				<h3><em>Rating</em></h3>
				<input id="rating" type="text" name="rating" placeholder="rating" />
				<h3><em>Description</em></h3>
				<input id="description" type="text" name="description" placeholder="description" />
				<br />
				<br />
				<input type="submit" value="Add it!!" id="submit">
				<br />
				<br />
				<?php
					
					$products = $productDAO->getProducts();
						if($products){
							echo '<table border=\'1\'>';
							
							foreach($products as $product){
								echo '<tr>';
								echo '<td><a href=\'edit_product.php?id='. $product->getId() . '\'>' . $product->getId() . '</a></td>';
								echo '<td>' . $product->getProductName() . '</td>';
								echo '<td>' . $product->getImagePath() . '</td>';
								echo '<td>' . $product->getPrice() . '</td>';
								echo '<td>' . $product->getRating() . '</td>';
								echo '<td>' . $product->getDescription() . '</td>';
								echo '</tr>';
							}
						}
					
					}catch(Exception $e){
						//If there were any database connection/sql issues,
						//an error message will be displayed to the user.
						echo '<h3>Error on page.</h3>';
						echo '<p>' . $e->getMessage() . '</p>';            
					}
				?>
			</form>
		</div>			
		

		<script>
			//execute a JavaScript immediately after a page has been loaded
			window.onload = function() {
			}
		</script>
		
	</body>
	
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js">
	</script>
	<script>
    AOS.init();
	</script>
</html>