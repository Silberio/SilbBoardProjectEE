# Message Board EE Project

## Getting Started

The runnable jar file SpringApp.jar can be found in the /target folder and is really the only required file in order to run the program *as-is*. This is built using maven and tomcat, creating a fully executable, stand-alone application.

To run the application, download SpringAp.jar to a custom location, navigate to it with command prompt and run **java -jar SpringApp.jar**
The application can be accessed by opening any browser at the url *localhost:8080/home*

## Breakdown of the application

### Application is running
When the application is running, the MessageController class will redirect
the first user requests to messageform.html, with the method messageForm(), which contains a simple Text input field and a button field for the user to input the desired message.

### Data is entered
On click, the request is sent to the method message(). Here, a new instance of Message() object/bean is initialized. This is then filled with data provided.

### From view to control
 The request is processed as a HttpServletRequest parameter from the input form, mapped to home.html. The request is taken as a String, and checked for empty (in case the user presses the input button without writing anything) and sets a default value if this proves true.
 
 The user property is currently hard coded.
 
 Once the new Message bean is initialized, and data is passed to its respective fields, the bean is inserted into the data acces object repository. 
 
 The repository is currently hardcoded as a hashmap, but later on will support JDBC.
 
### Returning the data and object representation
 Once the bean is inserted, a view model handler adds a new attribute with the parameter name "messages" and passes the entire repository of message objects from the MessageService API.
 
 The request is further parsed by Thymeleaf on the client side, which retrieves the model attribute and displays it on the webpage. 
 Thymeleaf provides a *for each* loop, as *th:each="message ; ${messages}"*
 
 This creates a new *newmessage* div for each object in the MessageService repository.
 
#### Interactivity
 Each div represents a bean. It retrieves the information from each bean through Thymeleaf framework as *th:text="${object.field}"*.
 
 
 A link, serving as a delete button for each *newmessage* element is added. This sends a *GET* request with the specific message ID as parameter, which is processed by deleteMessage() method. 
 
 The ID is passed as a string, parsed locally and then passed as an integer parameter to removeMessageById() provided by the MessageService DAO. This removes the message belonging to the passed ID number from the actual repository.
 
 Once processed, the user is then redirected to the main page which is mapped to messageform. Next time the user posts a message, the reppository is reloaded anew with updated information (ergo, with the deleted post missing). 

## Technologies used

#### Maven
Used for standard project creation, managing the required dependencies and for creation of executable web app.

#### Spring Boot
Serves as base for the back end, handling of HTTP requests, Bean management and to link view to controller.

#### Thymeleaf
Framework  for serving static web content and hypertext. Provides some useful methods for creating view-to-controller connectivity.

#### Skeleton Boilerplate
Lightweight CSS boilerplate based on rows and columns.

### The Standalone App
The web app itself is exported as a runnable JAR file thru Maven. The JAR file is exported with all needed dependencies as well as Tomcat server dependencies for running locally.



