<?php
require_once('productDAO.php');

if(!isset($_GET['id']) || !is_numeric($_GET['id'])){
//Send the user back to the main page
header("Location: addProduct.php");
exit;

} else{
    $productDAO = new productDAO();
    $product = $productDAO->getEmployee($_GET['id']);
    if($product){
?>    
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 11 Demo App - Edit Product - <?php echo $product->getFirstName() . ' ' . $product->getLastName();?></title>
        <script type="text/javascript">
            function confirmDelete(employeeName){
                return confirm("Do you wish to delete " + employeeName + "?");
            }
        </script>
    </head>
    <body>
        
        <?php
        if(isset($_GET['recordsUpdated'])){
                if(is_numeric($_GET['recordsUpdated'])){
                    echo '<h3> '. $_GET['recordsUpdated']. ' Product Record Updated.</h3>';
                }
        }
        if(isset($_GET['missingFields'])){
                if($_GET['missingFields']){
                    echo '<h3 style="color:red;"> Please enter both first and last names.</h3>';
                }
        }?>
        <h3>Edit Product</h3>
        <form name="editEmployee" method="post" action="process_employee.php?action=edit">
            <table>
                <tr>
                    <td>Product ID:</td>
                    <td><input type="hidden" name="id" id="id" 
                               value="<?php echo $product->getEmployeeId();?>"><?php echo $product->getEmployeeId();?></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" id="firstName" 
                               value="<?php echo $product->getFirstName();?>"></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" id="lastName" 
                               value="<?php echo $product->getLastName();?>"></td>
                </tr>
                <tr>
                    <td cospan="2"><a onclick="return confirmDelete('<?php echo $product->getFirstName() . ' ' . $product->getLastName();?>')" href="process_employee.php?action=delete&employeeId=<?php echo $product->getEmployeeId();?>">DELETE <?php echo $employee->getFirstName() . " " . $employee->getLastName();?></a></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnSubmit" id="btnSubmit" value="Update Product"></td>
                    <td><input type="reset" name="btnReset" id="btnReset" value="Reset"></td>
                </tr>
            </table>
        </form>
        <h4><a href="index.php">Back to main page</a></h4>
    </body>
</html>
<?php } else{
//Send the user back to the main page
header("Location: index.php");
exit;
}

} ?>