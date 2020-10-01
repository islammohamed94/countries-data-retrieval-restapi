## REST API for Countries data retrieval using spring boot, Docker and postgresql on Ubuntu 20.04

# How it works:
**1. THE DOCKER CONTAINER SETUP**
* Download Docker [Here](https://docs.docker.com/engine/install/ubuntu/)
* Then open terminal and check:
```bash
docker info
```
You can check the Docker version from (You might need to install docker-compose using apt-get install)
```bash
docker --version
```
```bash
docker-compose --version
```

**2. THE JAVA APP**

* Clone the repository:
```bash
git clone https://github.com/islammohamed94/countries-data-retrieval-restapi.git
```
* Build the maven project using the command:
```bash
mvn clean install
```

* Run the bash script imageload.sh to add the world database to the current docker container or use the below command:
```bash
docker run -d -p 5432:5432 ghusta/postgres-world-db:2.5
```

* Now initiate the Docker container:
```bash
docker-compose up
```
* Then Go to [http://localhost:8080/demo/api/countries](http://localhost:8080/demo/api/countries) to test and would specify basic authorization a username: `user` and password: `user` or username: `admin` and password: `admin` to test the endpoint of the API.

* GET request to `/api/countries/BAH` returns the "country" with country_code BAH;
