# QRCode Service
- [QRCode Service](#qrcode-service)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Basics unveiled](#1-basics-unveiled)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)
    - [2: First image](#2-first-image)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)

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

### 2: First image
#### 2.1 Description
QR codes are square-shaped patterns comprised of black squares on a white background. Your web service will generate QR codes and send them to clients as images.

In this stage, you must create a 250x250 pixel image filled with white color. You can accomplish this using the `java.awt.image.BufferedImage` class, which allows for image data manipulation. Here's an example:

```
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
Graphics2D g = image.createGraphics();

g.setColor(Color.WHITE);
g.fillRect(0, 0, width, height);
```

In this example, first, create a `BufferedImage` object with the specified width and height and an 8-bit RGB color space. Then, generate a `Graphics2D` object to draw into the image. Set the color to white and draw a rectangle to fill the image with white color.

Next, serialize the `BufferedImage` and include it in the response body. There are several ways to do this, but we recommend the following two methods:

- Return the `BufferedImage` from your request handler method and let Spring Boot serialize it for you. You'll need to create a `HttpMessageConverter<BufferedImage>` bean to facilitate the serialization:

- ```java
  // in the REST controller class

  @GetMapping(path = "/api/qrcode")
  public ResponseEntity<BufferedImage> getImage() {
      BufferedImage bufferedImage = ... // your BufferedImage source
      return ResponseEntity
              .ok()
              .contentType(MediaType.IMAGE_PNG)
              .body(bufferedImage);
  }


  // in a configuration class

  @Bean
  public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter() {
      return new BufferedImageHttpMessageConverter();
  }
  ```

- Serialize the `BufferedImage` into a byte array and return that array from your request handler method. For serialization, you can se the following method:
  ```java
  @GetMapping(path = "/api/qrcode")
  public ResponseEntity<byte[]> getImage() throws IOException {
      BufferedImage bufferedImage = ... // your BufferedImage source

      try (var baos = new ByteArrayOutputStream()) {
          ImageIO.write(bufferedImage, "png", baos); // writing the image in the PNG format
          byte[] bytes = baos.toByteArray();
          return ResponseEntity
                  .ok()
                  .contentType(MediaType.IMAGE_PNG)
                  .body(bytes);
      } catch (IOException e) {
          // handle the IOEexception
      }
  }
  ```

> It's important to programmatically create the image, as image editors can embed metadata in the image file, which could cause tests to fail.

#### 2.2 Objectives
In this stage, you should:
- Modify the `GET /api/qrcode` to return the status code `200 OK` and an image as the response body. The image must be a white square, 250x250 pixels, in PNG format.
- Set the correct `Content-Type` header of the response to indicate that the content type is `image/png`.

#### 2.3 Examples
**Example 1.** _a GET request to /api/health_:
_Response_: `200 OK`

**Example 2.** _a GET request to /api/qrcode_:
_Response code_: 200 OK
_Response header_: `Content-Type: image/png`
_Response body_: byte array

<hr/>

[<<](../README.md)
