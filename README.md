# 

## Model
www.msaez.io/#/147575574/storming/38521f19909a526e8a604dfadab3509723

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- 작가 관리
- ai service
- 포인트 관리
- 구독자관리
- 서재플랫폼
- 집필관리


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- 작가 관리
```
 http :8088/authors authorId="authorId"authorName="authorName"craeteDate="craeteDate"authorInfo="authorInfo"authorPortfolio="authorPortfolio"
```
- ai service
```
 http :8088/publishings id="id"title="title"summaryContent="summaryContent"summary="summary"category="category"imagepath="imagepath"contents="contents"
```
- 포인트 관리
```
 http :8088/points userId="userId"point="point"userType="userType"pointsDeadline="PointsDeadline"
```
- 구독자관리
```
 http :8088/users id="id"userid="userid"userType="userType"subscriptionStatus="subscriptionStatus"
```
- 서재플랫폼
```
 http :8088/플랫폼관리 id="id"userId="userId"authorId="authorId"bookId="bookId"categoryId="categoryId"isSubscribed="isSubscribed"isPublished="isPublished"
```
- 집필관리
```
 http :8088/원고 id="id"title="title"date="Date"authorName="author Name"contents="contents"status="status"type="type"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
