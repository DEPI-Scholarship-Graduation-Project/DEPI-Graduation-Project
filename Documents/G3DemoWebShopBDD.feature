Feature: Authentication
  As a user, I want to access my account using valid credentials securely
  So that I can use personalized features on the website.

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks on the Login button
    Then the user should be logged in
    And redirected to the homepage

  Scenario: User fails to log in with invalid credentials
    Given the user is on the login page
    When the user enters an incorrect username or password
    Then the system should display an error message indicating invalid credentials

  Scenario: User resets forgotten password
    Given the user is on the forgot password page
    When the user submits a registered email address
    Then a password reset link should be sent to the user's email

  Scenario: User registers a new account
    Given the user is on the registration page
    When the user fills all required fields with valid data
    And submits the registration form
    Then the account should be created successfully
    And the user should be redirected to a register-completion page

  Scenario: User logs out successfully
    Given the user is logged in
    When the user clicks the logout button
    Then the session should end
    And the user should be redirected to the homepage


Feature: Browsing & Searching
  As a user, I want to browse and search for products
  So that I can easily find items that interest me.

  Scenario: User views homepage product list
    Given the user opens the homepage
    Then a list of featured products should be displayed

  Scenario: User searches for a product by name
    Given the user is on any page with a search bar
    When the user enters a product name and presses Search
    Then matching results should appear in the product list

  Scenario: User filters products by price
    Given the user is on the product listing page
    When the user selects a specific price range
    Then only products from that range should be displayed

  Scenario: User sorts products by name
    Given the user is on the product list page
    When the user chooses “Sort by Name: A to Z”
    Then products should be displayed in ascending order by name


Feature: Product Interaction
  As a user, I want to interact with individual product pages
  So that I can view detailed information and make purchase decisions.

  Scenario: User views product details
    Given the user is on a product listing page
    When the user clicks on a product
    Then the product detail page should be displayed with name, price, and description

  Scenario: User adds a product to wishlist
    Given the user is logged in and viewing a product page
    When the user clicks “Add to Wishlist”
    Then the product should appear in the user’s wishlist

  Scenario: User adds a product review
    Given the user is logged in and has purchased the product
    When the user submits a review with rating and comment
    Then the review should appear under the product reviews section

  Scenario: User subscribes to back-in-stock notification
    Given the user is on a product page that is currently out of stock
    When the user enters their email to be notified
    Then the system should confirm that the subscription was successful


Feature: Shopping Cart
  As a user, I want to add, remove, and modify items in my cart
  So that I can manage my intended purchases.

  Scenario: User adds a product to the cart
    Given the user is on a product detail page
    When the user clicks “Add to Cart”
    Then the product should appear in the shopping cart

  Scenario: User updates product quantity in the cart
    Given the user is on the shopping cart page
    When the user changes the quantity of a product
    Then the total price should update accordingly

  Scenario: User removes a product from the cart
    Given the user is on the shopping cart page
    When the user clicks the remove button next to a product
    Then the product should be removed from the cart

  Scenario: User proceeds to checkout
    Given the user has at least one product in the cart
    When the user clicks “Checkout”
    Then the system should navigate to the checkout page


Feature: Account Management
  As a registered user, I want to manage my account settings and order history
  So that I can update personal details and track purchases.

  Scenario: User views order history
    Given the user is logged in
    When the user navigates to the “Orders” section
    Then all previous orders should be displayed

  Scenario: User updates profile information
    Given the user is logged in and on the account management page
    When the user edits and saves changes
    Then the system should confirm that the update was successful

  Scenario: User manages reward points
    Given the user is logged in
    When the user opens the “Reward Points” section
    Then the system should show available points and their usage history

  Scenario: User downloads purchased product
    Given the user has purchased a downloadable product
    When the user clicks the download link in their order
    Then the file should begin downloading successfully


Feature: Contact & Info
  As a visitor, I want to access store contact information and policies
  So that I can reach out for help or learn about store terms.

  Scenario: User views the Contact Us page
    Given the user is on the website
    When the user clicks the “Contact Us” link
    Then the contact form should be displayed

  Scenario: User submits a message via the Contact Us form
    Given the user is on the Contact Us page
    When the user fills out all fields and submits the form
    Then the system should display a success confirmation message

  Scenario: User views privacy policy
    Given the user is on the footer section of the website
    When the user clicks “Privacy Policy”
    Then the policy content should be displayed on a new page

  Scenario: User views terms and conditions
    Given the user is on the footer section of the website
    When the user clicks “Terms & Conditions”
    Then the terms page should be displayed correctly
