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