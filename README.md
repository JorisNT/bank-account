# bank-account



## Getting started

This application is a simple version of bank account.

ENV: Java 11, Spring boot 2.6.2, Postgres

## To run app

You need first to have an instance of configured postgres on you local machine.

1. Run the following command:
- docker run -d -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=bank postgres:alpine3.16

2. Run spring boot application. Application run on localhost:8080.

## API

Base path is: api/account

- /create [POST]: To create a bank account with a username in parameter
  - model: {<br/>
   username: string; <br/>
   }<br/><br/>

- /{username} [GET]: To get all informations of bank account for the given username <br/><br/>

- /transaction [POST]: To create a transaction related to a bank account
  - model: { <br/>
    bankAccountId: number;<br/>
    reason: string;<br/>
    type: CREDIT | DEBIT;<br/>
    amount: number;<br/>
  }
