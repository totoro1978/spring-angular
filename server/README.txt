https://morioh.com/p/87c6606aed6f

*** Client
hsd@hsd-VGN-SZ56LN-B:~/eclipse-workspace/spring-angular$ ng new client
==> select SCSS



***  Server

curl -X POST -H "Content-Type: application/json" -d '{"fullName":"t1", "email":"t1@email.ghostinspector.com","password":"t1"}' http://localhost:8080/api/auth/register

curl -X POST -H "Content-Type: application/json" -d '{"email":"t1@email.ghostinspector.com","password":"t1"}' http://localhost:8080/api/auth/login


https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/

sudo apt-get install -y mongodb-org


================================
- How to run mongod
sudo service mongod start

- Verify mongodb status
sudo service mongod status

- Stop MongoDB
sudo service mongod stop

- Restart MongoDB
sudo service mongod restart

- Launch MongoDB shell
mongo

***
use springmongodb



db.roles.insertOne(   { role: "ADMIN" })
db.products.insertOne(   { prodName: "Prod 1", prodDesc: "desc 1", prodPrice: "100", prodImage: "thumb 1" })

db.product.drop()

t1@email.ghostinspector.com