# AccountsExercise
A simple account RESTful API that provides a user with a CRUD service - using spring Boot

----------
GET all accounts:  http://localhost:8080/account-project/rest/accounts

[
    {
        "id": 1,
        "firstName": "Jon",
        "lastName": "Keef",
        "accountNumber": 8001
    },
    {
        "id": 2,
        "firstName": "Andrew",
        "lastName": "Reid",
        "accountNumber": 8002
    },
    {
        "id": 3,
        "firstName": "Nick",
        "lastName": "Apostolos",
        "accountNumber": 8003
    }
]

------
GET an account with a given ID : http://localhost:8080/account-project/rest/accounts/2

{
    "id": 2,
    "firstName": "Andrew",
    "lastName": "Reid",
    "accountNumber": 8002
}

-----------
POST with a json http://localhost:8080/account-project/rest/accounts

{
    "firstName": "Lee",
    "lastName": "Cook",
     "accountNumber": 123
}

RESPONSE : Account has been successfully added , with location URL in Header e.g. location → http://localhost:8080/account-project/rest/accounts/4


---------
DELETE an account http://localhost:8080/account-project/rest/accounts/{id}
                  http://localhost:8080/account-project/rest/accounts/2
{
    "message": "Account successfully deleted"
}                  
                  
