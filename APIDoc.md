## POST 
url:port/context-path/api/users 

Creates new user

PUT 
url:port/context-path/api/users/1

Updates existing user with id 1.

DELETE 
url:port/context-path/api/users/1

Deletes user whose id is 1

GET
url:port/context-path/api/users

Returns all users

GET
url:port/context-path/api/users/1

Returns user detail which has id 1

GET
url:port/context-path/api/users/1/contacts

Returns contact details of user which has id 1

POST
url:port/context-path/api/users/1/contacts

Adds the new contacts for user id 1

Post Request Payload

```{
 "name": "Bipana KC",
 "email": "milan@gmail.com",
 "password": "897",
 "mobileNumber": "1236547890",
 "contacts": [
  {
   "mobileNumber": "9851150050",
   "email": "shankar.prasad@gmail.com"
  },
  {
   "mobileNumber": "9812365478",
   "email": "shankar.sharma@aadimcollege.edu.np"
  }
 ]
}




## TODO Task

1. Create an api to add contact for existing user
2. Create an API to update contact for existing user
3. Create an api to delete single contact associated with given user
4. Create an API to delete multiple contacts associated with given user
5. Create anAPI to delete all contacts at a time assiciated with given user
6. Create an api to fetch all contacts associated with given user
