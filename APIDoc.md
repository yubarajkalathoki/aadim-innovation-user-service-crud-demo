
### Create User

## POST 
```
url:port/context-path/api/users 
```

### Update User

## PUT 
```
url:port/context-path/api/users/1
```

### Delete User
## DELETE 
```
url:port/context-path/api/users/1
```

### Get All User

## GET
```
url:port/context-path/api/users
```

### Get Single User
## GET
```
url:port/context-path/api/users/1
```

Returns user detail which has id 1

GET
url:port/context-path/api/users/1/contacts

Returns contact details of user which has id 1

POST
url:port/context-path/api/users/1/contacts

Adds the new contacts for user id 1

Post Request Payload

```
{
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
```



### TODO Task
Create an API to delete user by email
	`delete from user where email='myemail@gmail.com'`

## DELETE
# URL
`port/context-path/api/users/{email}`


Create an API to delete user by name
	`delete from user where name='your name'`

## DELETE
# URL
`port/context-path/api/users/{name}`


## TODO Task

1. Create an api to add contact for existing user
	API: 
	create contact (columns) values (values) where user_id=1
2. Create an API to update contact for existing user
	create contact set column1=value1 where user_id=1
3. Create an api to delete single contact associated with given user
	delete from contact where id=1 and user_id=1
4. Create an API to delete multiple contacts associated with given user
	delete from contact where id in (1,2,3) and user_id=1
5. Create an API to delete all contacts at a time assiciated with given user
	delete from contact where user_id=1
6. Create an api to fetch all contacts associated with given user
