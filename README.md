##Project 'Organizations'

Repo Link:

https://github.com/djandjiev/Organizations/

Used frameworks/API:

Spring Boot, String Data JPA, Hibernate, JUnit 4

####Curl requests:
---

curl requests have troubles with non-latin letters 


**Get all countries**

`curl -v http://localhost:8888/api/countries`

**Get all document types**

`curl -v http://localhost:8888/api/docs`

---

**Get all organizations**

`curl -v -X POST -d '{"name":"", "inn":null}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/organization/list`

**Get organization with id=10001**

`curl -v http://localhost:8888/api/organization/10001`

**Save new organization**

`curl -v -X POST -d '{"name": "LLC Romashka", "fullName": "Limited Liability Company Romashka", "inn": "7720666777", "kpp": "772001001", "address": "12, Zelenyi prospekt, Moscow", "phone": "4956660088", "isActive": true}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/organization/save`

to check this entity:

`curl -v http://localhost:8888/api/organization/10004`

**Update organization with id=10002**

`curl -v -X POST -d '{"id": 10002, "name": "Weles corp.", "fullName": "Weles corporation", "inn": "7714123456", "kpp": "771401001", "address": "8, Begovoi proezd, Moscow",  "phone": "4951234568", "isActive": true}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/organization/update`

---

**Get all offices of concrete organization**

`curl -v -X POST -d '{"orgId": 10000}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/office/list`

**Get organization id=10004**

`curl -v http://localhost:8888/api/office/10004`

**Save new office**

`curl -v -X POST -d '{"name": "New office", "address": "1, Red Square, Moscow", "orgId": 10002}'  -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/office/save`

**Update office with id=10005**

`curl -v -X POST -d '{"id": 10005, "name": "Domovoy", "address": "31, Leningradskii propekt, Moscow"}'  -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/office/update`

---

**Get all users in concrete office**

`curl -v -X POST -d '{"officeId": 10005}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/user/list`

**Get user with id=10010**

`curl -v http://localhost:8888/api/user/10010`

**Save new user**

`curl -v -X POST -d '{"firstName": "Michael", "secondName": "Owen", "position": "PR-Manager", "officeId": 10004}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/user/save`

**Update user with id=10006**

`curl -v -X POST -d '{"id": 10006, "firstName": "Bella", "secondName": "Fischer", "middleName": "Borisovna", "position": "CEO"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8888/api/user/update`

---
