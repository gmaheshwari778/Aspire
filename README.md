Aspire project is automation project with selenium and testNG.

# Project Name= Aspire Project 
# Project Structure

driver folder- This folder has chrome and firefox drivers and set in classpath.
lib- This folder has all the libraries for selenium, java and TestNG.
out- is copy of SRC to commit the code on SVN and run through Jenkins.
SRC- this is source code folder divide into three package
main, resource and Test.
In main package- This package has repository of all the XPath and methods, designe in POM.
resource package- This package has utilities to use in entire project.
Test Package- This package has Tes
Test Package- This package has Test cases that need to be executed through Automation.xml.
Automation.xml- This file has TestNG.xml which executes the Test package with parameter values.


Download the project 
Open up Git Bash, type in “cd Downloads” and hit Enter. This will take you to the Downloads folder in the command window, you can also type whatever file location you want to save the file in.

Now, type in “git clone git@github.com:gmaheshwari778/Aspire.git and hit Enter.


#Test cases explanation
Test1 Class- Under Test Package
This class extends the Base Class. In Base class, we have two methods Before test and After test.
In Before Class- start the browser with parameter values and call the register class to open the browser as per the parameter value.
In After Class- Once all the test cases executed quilt the driver.

Testcase1-
Calling the Home class where all the home page Xpath is defined with methods actions.
First- Select the electronics on the search field by setAll method in the Home class.
Second- Search the item from the search field by setSearch method
third- Validate the Belkin in Feature Brands If the text matches then click on the Belkin checkbox.
Fourth- set the input price min- 100 and 2000 and click on Go button by setPricemin, setPriceMax and sumit methods.
Fifth- Once the page is refresh- Validate the price value with min and max 
If price is between min and max assert pass otherwise assert failed.

Testcase2-
Calling the Home class where all the home page Xpath is defined with methods actions.
First- Select the electronics on the search field by setAll method in the Home class.
Second- Search the item from the search field by setSearch method
Third- set the input price min- 100 and 2000 and click on Go button by setPricemin, setPriceMax and sumit methods.
Fourth- Set the Featured drop-down list max to min by set feature and setSort method.
Fifth- Validate the all the items are sorted in max to min by using validateSorting method using for loop.


Testcase3-
Calling the Home class where all the home page Xpath is defined with methods actions.
First- Select the electronics on the search field by setAll method in the Home class.
Second- Search the item from the search field by setSearch method
Third- set the input price min- 100 and 2000 and click on Go button by setPricemin, setPriceMax and sumit methods.
Fourth- validate the price tag is coming on the result set. If the price is coming then select the first item from the list.
Fifth- Click on add to cart by setAddtocart method
Six- Click on set checkout by setCheckout method 
and validate that the Sign- in screen is coming through setValidateSigninPage (Using assert matching)







