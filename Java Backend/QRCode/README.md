# QRCode Service

- [QRCode Service](#qrcode-service)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Basics unveiled](#1-basics-unveiled)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)

## Learning outcomes
In this projec, master handling HTTP requests and parameters, image processing in Java, learn how to generate QR codes using the ZXing library, understand HTTP status codes and response content types, and practice serving files in different formats

## About
This project utilizes QR codes - 2D barcodes that can store large amounts of data and are easily read by smartphones. Through this Spring Boot project, users can learn about the technology behind QR codes, generate them programmatically, and integrate them into a web service.

## Stages
### 1: Basics unveiled
#### 1.1 Description
Our project begins with REST API endpoints. Given the straightforward functionality of this project, our API will only need two endpoints.

The first endpoint `GET /api/health` will consistently respond with the status code `200 OK`. This endpoint allows clients to ping the service, verifying its operation and availability.

The second endpoint, `GET /api/health`, will be utilized by clients to retrieve QR code images. The necessary logic for this will be implemented in subsequent stages. For the time being, it should respond with the status code `501 NOT IMPLEMENTED`.

#### 1.2 Objectives
Kick off the project by creating a Spring Boot web application. This application should be operable on any free port. You may use the default port `8080` or designate another port in the application.properties file. For example:

```
server.port=8181
```

Next, create a REST Controller that will manage two endpoints:
- `GET /api/health` endpoint that will respond with a status code `200 OK`.
- `GET /api/qrcode` endpoint that will respond with a status coce `501 NOT IMPLEMENTED`.

#### 1.3 Examples
**Example 1.** _a GET request to /api/health_:
_Response_: `200 OK`

**Example 2.** _a GET request to /api/qrcode_:
_Response_: `501 NOT IMPLEMENTED`

<hr/>

[<<](../README.md)
