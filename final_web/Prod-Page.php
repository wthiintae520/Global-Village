<?php

// $RatingOption = $_POST['RatingOption'];
$RatingOption = filter_input(INPUT_POST, 'RatingOption', FILTER_SANITIZE_STRING);
$CategoryOption = filter_input(INPUT_POST, 'CategoryOption', FILTER_SANITIZE_STRING);
$sortoptions = filter_input(INPUT_POST, 'sort-options', FILTER_SANITIZE_STRING); // format ..thêm


include ('./php/connect.php');

// if(isset($_POST['submit'])){
//   $selected = $_POST['sort-options'];
//   echo $selected
// }
if($RatingOption=='' && $CategoryOption=='' ){
  // $sqlquery = "SELECT id, productName, imagePath, price, rating FROM products";
  $sqlquery = "SELECT  id, productName, imagePath, price, rating FROM products";
} else {
  $sqlquery = "SELECT id, productName, imagePath, price, rating FROM products WHERE rating=$RatingOption ";// if we wanna add more variables, using "and" 
  //and imagePath=$CategoryOption;
      }
     
  $result = $mysqli->query($sqlquery);
  
  $prods = [];
  while($row = mysqli_fetch_array($result)){
    $prods[] = $row;
  }
  switch($sortoptions)
  {
   case 1:{
    $price = array_column($prods,'price');
    array_multisort($price, SORT_ASC, $prods);
    break;
   }
   case 2:{
    $price = array_column($prods,'price');
    array_multisort($price, SORT_DESC, $prods);
    break;
   }
   case 3:{
    $price = array_column($prods,'rating');
    array_multisort($price, SORT_ASC, $prods);
    break;
   }
   case 4:{
    $price = array_column($prods,'rating');
    array_multisort($price, SORT_DESC, $prods);
    break;
   }
   default:{
    $price = array_column($prods,'price');
    array_multisort($price, SORT_ASC, $prods);

   }

  }
     

  



?>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="./images/logo.png">
    <title>Global Village</title>
   
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap"   rel="stylesheet" />

    <link rel="stylesheet" href="./css/bootstrap.min.css">
	<script src="./js/jquery-3.4.1.slim.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./css/Prod-Page.css">

<style>
</style>
</head>
<body>
    <header>
        <a href="./index.php" class="logo">
          <img src="./images/logo.png" />
        </a>
 
        <ul class="main-menu">
          <li> <a href="./index.php">Home</a> </li>
          <li> <a href="#">About Us</a> </li>
          <li> <a href="#">Log in</a> </li>
          <li>
            <a href="#"> <i class="fa fa-shopping-cart fa_custom fa-2x"></i> </a>
          </li>
        </ul>
      </header>

      <p class="slogan1">
        <a class="nav-link"> </a><em>Savor your favorite food..</em>
      </p>
      <p class="slogan2"> <a class="nav-link"></a><em> Anywhere</em> </p>

    <div class="box">
      <!--Yummy yummy...-->
          <input id="myInput" type="text" name="" placeholder="Yummy Yummy..." />
          <input type="submit" class="submit-btn btn btn-warning" name="" value="Search" />
          </div>


          
      <!--Yummy yummy...-->
 
        

        

 

          


    <div class="filtering-food mt-5 ms-5">
      <form action="" method="post">
   
          <select class="inputok" name="sort-options" id="sort-options">
              <option value="">-----Sort by-----</option>
              <option value="1">Sort by Price ASC</option>
              <option value="2">Sort by Price DESC</option>
              <option value="3">Sort by Rating ASC</option>
              <option value="4">Sort by Rating DESC</option>
          </select>
<select class="inputok" name='RatingOption' id="RatingOption" > <!-- Use "select" to create object -->
  <option value =''>--Rating--</option>
  <option value="1">1 Star</option> <!-- Add all applicable options -->
  <option value="2">2 Stars</option>
  <option value="3">3 Stars</option>
  <option value="4">4 Stars</option>
  <option value="5">5 Stars</option>
  
</select>

<select class="inputok" name ='CategoryOption'id="CategoryOption"   > <!-- Use "select" to create object -->
  <option value =''>--Category--</option>
  <option value="Canada Food">Canada Food</option> <!-- Add all applicable options -->
  <option value="Chinese Food">Chinese Food</option>
  <option value="Vietnamese Food">Vietnamese Food</option>
  <option value="Korean Food">Korea Food</option>
  <option value="Taiwanese Food">Taiwanese Food</option>
  <option value="Indian Food">Indian Food</option>
  <option value="Drinks">Drinks</option>
</select>



<input class="inputok" type="number" id="price" name="tentacles"
min="1" placeholder="Price under..">




<button type='submit'  class="button inputok" onclick="filter()">Filtering</button>
</form>



          <div class="container">
        <div class="row justify-content-md-center">
            <div class="col">
               

                <!-- <hr> -->
                <div class="row mb-3">
   
              <?php 
              
              if(empty($prods))
              {
                
                  echo "<p style='color:white;font-size:30px;font-weight:bold;text-align:center;width:100%;'> No Result Found! </p>";
              }
              else
              foreach ($prods as $row)
              
              { ?>
						  <div class="col-lg-4 col-sm-6">
               
						<img id="prod_images" class="img-fluid img-thumbnail" src="<?php echo $row[2]; ?>" alt=""/>
            <div class="container">   
              <a value="<?php echo $row[0] ?>" href="./display.php?product=<?php echo $row[0] ?>" > 
              <div class="overlay"><div class="text"><?php echo $row[1]; ?>
               <br> Price: $ <?php echo $row[3]; ?> 
               <br> Rating:  <?php echo $row[4]; ?>/5</div>
              </div>
            </a>
          </div>
  
          </div>
						<?php } ?>

                </div>
            </div>
        </div>
    </div>


 


    
</body>


<script src=".\js\Prod-Page.js"></script>
</html>