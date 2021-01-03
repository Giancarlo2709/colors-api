Api de colores
===================
Api para crear, actualizar, eliminar y listar colores

## CircleCi
[![CircleCI](https://circleci.com/gh/Giancarlo2709/colors-api/tree/master.svg?style=svg)](https://circleci.com/gh/Giancarlo2709/colors-api/tree/master)

* * * * *
## Technology used
```
- OpenJdk 11
- Spring boot 2.4.1
- Apache Maven 3.6.3
- Spring-doc OpenApi 1.5.2
- jackson-dataformat-xml for XML Data
- Lombok
- Spring Data JPA
- DataBase Embedded H2
- Junit 5, Mockito
```

## Installation
Use [openjdk11](https://openjdk.java.net/install/)
and [maven](https://maven.apache.org/install.html) 
and [docker](https://docs.docker.com/engine/install/)
for installation

maven
```
# generate .jar for docker
mvn clean install
# executing .jar
mvn spring-boot:run
```

docker
```
# generate image docker 
# Note, you should generate the artifact as in the previous step
docker build -t colors-api .
# run container
docker run -d --name colors-api -it -p 8080:8080 colors-api
```

## Endpoints
To return json or xml send the following headers in each enpoint
```
Accept: application/xml or Accept:application/json
```

Url Base
```
http://localhost:8080
```

FindAll Colors:
```
Method: GET
Headers: Accept: application/xml or application/json
Uri: ${URL_BASE}/colors?page=1&size=5
Response: 
{
    "totalElements": 12,
    "totalPages": 3,
    "first": true,
    "last": false,
    "colors": [
        {
            "id": 1,
            "name": "cerulean",
            "color": "#98B2D1"
        }, ...
    ]
}
```

FindById
```
Method: GET
Headers: Accept: application/xml or application/json
Uri: ${URL_BASE}/colors/1
Response: 
{
    "id": 1,
    "name": "cerulean",
    "color": "#98B2D1",
    "year": "2000",
    "pantone_value": "15-4020"
}
```

CreateColor
```
Method: POST
Headers: Accept: application/xml or application/json
Uri: ${URL_BASE}/colors
Request:
{
    "name" : "colorX",
    "year": "2000",
    "color": "#FFFFF",
    "pantoneValue": "14-9845"
}
Response:
{
    "id": 13,
    "name": "colorX",
    "year": "2000",
    "color": "#FFFFF",
    "pantone_value": "14-9845"
}
```

UpdateColor
```
Method: PUT
Headers: Accept: application/xml or application/json
Uri: ${URL_BASE}/colors/13
Request:
{
    "name" : "colorX",
    "year": "2001",
    "color": "#FFFFF",
    "pantoneValue": "14-9845"
}
Response:
{
    "id": 13,
    "name": "colorX",
    "year": "2001",
    "color": "#FFFFF",
    "pantone_value": "14-9845"
}
```

DeleteColor
```
Method: DELETE
Headers: Accept: application/xml or application/json
Uri: ${URL_BASE}/colors/1
Response: 
{
    "deleted": true
}
```