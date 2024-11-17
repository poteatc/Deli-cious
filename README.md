# Caleb's DELI-cious Subs - POS Console Java Application

This is a console-based application designed for managing sandwich orders at a deli. Customers can customize sandwiches, add toppings, and go through the checkout process. The application is structured following the **Model-View-Controller (MVC)** architecture to separate concerns and ensure modularity and maintainability.

### Use the **AppController** class to run the appilcation from the console
### Use the **DeliApp** class in the `gui` package to preview a basic graphical interface to enter orders (currently does not print receipt to file)

## Project Overview

The application is structured into three core components to promote separation of concerns:

- **Model**: Represents the business logic and data structures.
- **View**: Handles user interface and input/output.
- **Controller**: Coordinates the flow of data between the model and view, handling user interactions.

### Functionality

The application flow is designed to guide the user through the following steps:

1. **Home Screen**: Displays the main menu with options to start a new order, view existing orders, remove an order, or proceed to checkout.

2. **Order Menu**: Allows users to add products (sandwiches, drinks, chips) to their order. Users can also view their order or confirm the order.

3. **Sandwich Customization**: Users can customize their sandwiches by selecting a bread type, size, toppings (meats, cheeses, regular toppings), and whether the sandwich is toasted.

4. **Checkout**: Users can review their order, confirm the details, enter payment information, and generate a receipt.

The application provides a simple, text-based navigation system that ensures users can easily select from available options and customize their order based on predefined choices (e.g., bread types, meat types, toppings).

### Application Flow

- **Start**: The user starts at the **HomeScreen**, where they can choose to create a new order, view previous orders, or proceed to checkout.

- **Order Creation**: If the user selects "New Order," they are taken to the **OrderScreen**. In this menu, the user can:
    - Add a sandwich, drink, or chips to their order.
    - View their current order.
    - Confirm the order or cancel the current order.

- **Sandwich Customization**: When adding a sandwich, the **SandwichScreen** guides the user through the sandwich customization process. The user can:
    - Select a **bread type** from a predefined list (e.g., white, whole wheat, etc.).
    - Choose a **sandwich size** (e.g., small, medium, large).
    - Add **toppings** (e.g., meats, cheeses, veggies) from various categories.
    - Choose whether they want their sandwich **toasted** or not.

- **Checkout**: At any point, the user can choose to proceed to checkout, where the **CheckoutScreen**:
    - Displays an order summary.
    - Prompts the user for payment details.
    - Generates and prints a receipt after successful payment.

### MVC Design Pattern

The application follows the **Model-View-Controller (MVC)** pattern to separate concerns and make the system more maintainable and scalable.

#### Model

The **Model** represents the data and the business logic of the application.

- **Order**: Contains the customer's order details, including sandwiches, drinks, chips, and total price.

- **Sandwich**: Represents an individual sandwich order, including its bread type, size, toppings, and toasting preference.

- **Receipt**: Responsible for generating and printing the order receipt after checkout.

- **Enums**: These define predefined options such as bread types (`BreadType`), meat types (`MeatType`), cheese types (`CheeseType`), and regular toppings (`RegularToppingType`).

#### View

The **View** is responsible for the user interface, displaying the menus, options, and prompts, and handling user input.

- **Screen Interface**: The `Screen` interface ensures all view classes implement the `display()` method to render the screen and `getSelection()` for capturing user input. This promotes consistency across different views (menus).

- **HomeScreen**: The entry point of the application, where the user selects their main action, such as creating a new order, viewing past orders, or checking out.

- **OrderScreen**: Allows users to manage the items in their order. They can add sandwiches, drinks, or chips, view the current order, or proceed to checkout.

- **SandwichScreen**: The menu for customizing a sandwich. Users can select the bread, size, toppings, and whether they want their sandwich toasted.

- **ToppingScreen**: Presents the available topping options (meats, cheeses, and other toppings) for the user to choose from while customizing their sandwich.

- **CheckoutScreen**: Displays the order summary, allows users to make a payment, and generates the receipt once the transaction is complete.

#### Controller

The **Controller** handles the flow of the application by managing user input and orchestrating the interaction between the model and view components. Though most of the view classes (e.g., `SandwichScreen`, `ToppingScreen`) function as both a view and controller to handle some of the interaction logic, the controller layer can be further developed to centralize the application's logic.

For example, the `OrderController` (not fully shown here) could manage the entire flow of the order, from creating a new order, adding items, updating totals, and handling transitions between different screens. It would serve as a coordinator between the user interface (view) and the business logic (model).

### Design Choices: Interfaces and Inheritance

- **Interfaces**: The use of the `Screen` interface ensures that each view class (such as `HomeScreen`, `OrderScreen`, `SandwichScreen`) follows a consistent contract for displaying content and capturing user input. This allows for easy extension of the application if additional screens are needed in the future, without changing the overall flow of the program.

- **Inheritance**: While inheritance is not heavily used in this design, we could further extend classes like `SandwichScreen` or `ToppingScreen` to create specific types of screens in the future. For example, if we had different types of orders or product types, we could create specialized versions of existing screens.

- **Enums**: Enums like `BreadType`, `MeatType`, `CheeseType`, and `RegularToppingType` are used to define a fixed set of valid options. This approach ensures that users can only select valid options, preventing errors due to invalid inputs. Enums also encapsulate the description and business logic associated with each option, making the code more readable and maintainable.

### Navigation and Menu Flow

- **HomeScreen**: The first screen presented to the user. From here, the user can choose to start a new order, view previous orders, or proceed to checkout.

- **OrderScreen**: Displays after selecting "New Order." The user can add products to their order or proceed to checkout. This screen lets users manage what is currently in their order.

![image](https://github.com/user-attachments/assets/54db89ca-4487-423d-83d8-c0121ef0d9ee)


- **SandwichScreen**: Used when adding a sandwich to the order. The user is guided through customizing the sandwich, selecting options for bread, size, toppings, and toasting preference.

- **ToppingScreen**: Activated when the user needs to choose toppings for a sandwich. The user can select meats, cheeses, and other toppings.

![image](https://github.com/user-attachments/assets/c283983a-f2ea-4a85-8f4b-1f915beeb618)


- **CheckoutScreen**: When the user is ready to finalize their purchase, they proceed to this screen. It allows users to review their order, enter payment details, and finalize the transaction.



### UML Diagram 
- **Model**

![image](https://github.com/user-attachments/assets/74fecc03-b4e8-4673-97a1-053fe7f873dc)

- **View**

![image](https://github.com/user-attachments/assets/adf212b8-d8f8-4868-aa60-21675fe814ef)

- **Controller**

![image](https://github.com/user-attachments/assets/94a69b8b-641b-40f3-a789-e5a88b007d4f)


### Interesting Code - Using Streams in Java
![image](https://github.com/user-attachments/assets/9dffe80b-9f8b-4111-9c2b-c164059a00c6)
1. Using Java Streams to Filter Lists of Custom Data Types Using Enums
In the project, Java Streams are used to filter lists of custom data types such as Order, Sandwich, and Topping. For example, we filter orders based on specific ToppingType enums:
- This simplifies checking properties of objects and makes the code more readable and concise.
2. Using Method References and `mapToDouble` to Calculate the Sum of a List
Streams are also used to calculate the sum of a list, such as calculating the total price of an order:
Here, mapToDouble transforms the Topping objects of subtype Meat into double values (total prices), and sum() calculates the total.
- The use of method references (Topping::getPrice) makes the code cleaner and more readable.


### Conclusion

This application demonstrates a simple, modular system for managing sandwich orders. By following the MVC design pattern, we've ensured that the model, view, and controller layers are well-separated, making the system easy to extend and maintain. The use of interfaces for consistency and enums for predefined options helps create a robust, user-friendly application.
