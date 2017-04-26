ReadMe file for CSE 564 - Assignment 1 -

Name - Omkar Totade
ASU userid - ototade
ASU ID - 1209345380

The zip file name is 'POX-FoodMenu-ototade-Netbeans'.
I have written one project that has a server and also has a client java class that will act as client and send requests.


Instructions to Run the project - 

1. Prior to running the project, you need to place the FoodItemData.xml file (that the Professor has provided us) in the directory where your Glassfish is installed at the following path,

your_directory_name:\GlassFish\glassfish-4.1.1\glassfish\domains\domain1\config\src\main\resources\FoodItemData.xml

2. Unzip the project. Use Netbeans to run the project.

3. Right click on the project and select 'Run'. This will make the project be deployed on the server, and it will maybe launch a browser window that says 'Hello World'.

4. Close that browser window and come back to Netbeans.

5. Click on the 'Files' tab of the project in Netbeans.

6. In the src/main/resources there are two .xml files by the names, 'add_food_item.xml' and 'get_food_item.xml'. You can modify these files with the request messages you wish. These files are sent over to the server by the client.

7. Now find the 'FoodItemClient.java' file in the source package 'com.cse564.pox.foodmenu.ototade.netbeans.main' and only run that file. This is the client program.

8. Select 'Add Food Item' or 'Get Food Item' from the options provided, and you can see the proper response in XML format, based on your request message that you gave in step 6.
If you choose 'Add Food Item' from the options, the 'add_food_item.xml' file will be read and request will be taken from this file. If you choose 'Get Food Item' from the options, the 'get_food_item.xml' file will be read and request will be taken from this file.

9. Thus for proper request you will see proper response.

