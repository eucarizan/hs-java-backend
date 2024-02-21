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
    - [3: Image parameters](#3-image-parameters)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4: Zebra crossing](#4-zebra-crossing)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Examples](#43-examples)
    - [5: Foolproof API](#5-foolproof-api)
      - [5.1 Description](#51-description)
      - [5.2 Objectives](#52-objectives)
      - [5.3 Examples](#53-examples)

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

```java
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

### 3: Image parameters
#### 3.1 Description
In this stage, your task is to add versatility to the QR code service by allowing it to handle different request parameters. This will enable the generation of QR code images with various sizes and formats, as opposed to the same image every time.

Clients may need images in different formats and sizes, which requires the modification of the `GET /api/qrcode` endpoint to accept two request parameters:

- `size`: this parameter, measured in pixels, should be within a reasonable range. If the value is less than 150 pixels or exceeds 350 pixels, the endpoint should respond with the status code `400 BAD REQUEST`, accompanied by a JSON containing the `error` field and a suitable error message.

- `type`: the image can be in _PNG_, _JPEG_, or _GIF_ format. The endpoint should return the generated image in the requested format, including setting the appropriate `Content-Type` header. If the parameter value doesn't match these three formats, the endpoint should respond with the status code `400 BAD REQUEST` and a JSON containing the `error` field and a suitable error message.

Both parameters are mandatory. However, you don't need to account for missing parameters; the default Spring Boot behavior will suffice.

#### 3.2 Objectives
- Modify the `GET /api/qrcode` endpoint to accept the `size` request parameter. If the parameter value ranges between 150 and 350 pixels (inclusive), return the status code `200 OK` and the image of the requested size. Bear in mind that QR code images are square! If the parameter value is outside this range, return the status code `400 BAD REQUEST` along with a JSON-formatted request body containing the following:
  ```json
  {
    "error": "Image size must be between 150 and 350 pixels"
  }
  ```

- Modify the `GET /api/qrcode` endpoint to accept the `type` request parameter. If the parameter value is either `png`, `jpeg`, or `gif`, return the status code `200 OK` and the image in the requested format. Don't forget to set the correct `Content-Type` header in the response! If the parameter value doesn't match any of the three accepted types, return the status code `400 BAD REQUEST`, along with a JSON-formatted request body containing the following:
  ```json
  {
    "error": "Only png, jpeg and gif image types are supported"
  }
  ```

- If both the `size` and the `type` parameters are invalid, return the error message related to the `size` parameter.
- Aside from these modifications, the image generation and serialization process remains unchanged.

#### 3.3 Examples
**Example 1**. *a GET request to /api/qrcode with the correct size and type parameters*:
*Request*: `GET /api/qrcode?size=250&type=png`
*Response code*: `200 OK`
*Response header*: `Content-Type: image/png`
*Response body*: byte array

**Example 2**. *a GET request to /api/qrcode with an incorrect size parameter*:
*Request*: `GET /api/qrcode?size=100&type=png`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Image size must be between 150 and 350 pixels"
}
```

**Example 3**. *a GET request to /api/qrcode with an incorrect type parameter*:
*Request*: `GET /api/qrcode?size=250&type=tiff`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Only png, jpeg and gif image types are supported"
}
```

<hr/>

### 4: Zebra crossing
#### 4.1 Description
Now that you've completed all the necessary preparations, let's start generating QR codes. QR codes, or Quick Response codes, are square-shaped patterns of black squares on a white background. The specific arrangement of these squares encodes information, which could be in the form of text, a URL, geolocation, or other data types.

Don't worry; you won't be implementing the data encoding algorithm from scratch. Use the [ZXing open-source library](https://github.com/zxing/zxing) for this purpose.

First, add these dependencies to the `build.gradle` file:
```
dependencies {
    // Spring Boot starters
    // ...

    implementation 'com.google.zxing:core:3.5.2'
    implementation 'com.google.zxing:javase:3.5.2'
}
```

To generate a `BufferedImage` from a `String` representing some data, you can use the following code:
```java
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

class SomeClass {
    QRCodeWriter writer = new QRCodeWriter();
    try {
        BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, width, height);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
    } catch (WriterException e) {
        // handle the WriterException
    }
}
```

Initialize a QRCodeWriter object, a part of the ZXing library, to generate a QR code from the provided data. Then, encode the data into a bit matrix by invoking the `encode` method of the `QRCodeWriter` object. This method takes three parameters: the data you want to encode in the QR code (in the `String` format), the specific format of the barcode (in this case, `BarcodeFormat.QR_CODE` for QR codes), and the desired width and height of the resulting image. The `encode` method transforms the input data into a `BitMatrix` object, essentially a 2D array representing the QR code in binary format (black and white squares). Finally, convert the bit matrix to a BufferedImage by using the `toBufferedImage` method of the `MatrixToImageWriter` class.

You'll need to update the `GET /api/qrcode` endpoint to accept `contents` as another request parameter. This is a mandatory parameter because you need something to encode, and it cannot be empty or blank. If a client submits valid `contents`, `size`, and `type` request parameters, the QR code service should return the status code `200 OK` and a QR code of the specified size, with the encoded contents in the specified format. If the `contents` is not valid, the service should respond with the status code `400 BAD REQUEST` and a JSON with the `error` field and an appropriate error message.

All previous requirements for request parameter handling remain in effect. If any of the parameters is invalid, the service should respond with the status code `400 BAD REQUEST` and the appropriate error message. If multiple parameters are not valid, the error messages should follow this priority order:

invalid contents > invalid size > invalid type

#### 4.2 Objectives
- Modify the `GET /api/qrcode` endpoint to accept `contents` as a new request parameter, in addition to the others.
- If the `contents` is a non-empty and non-blank string, generate a QR code from the `contents` string and encode it into an image of the size specified by the `size` parameter and in the format specified by the `type` parameter. Return the status code `200 OK` and the generated QR code image in the response body. Don't forget to set the correct `Content-Type` header in the response.
- If the `contents` is empty or blank, the endpoint should return the status code `400 BAD REQUEST` and a request body in the JSON format with the following contents:
  ```json
  {
      "error": "Contents cannot be null or blank"
  }
  ```
- The error for invalid `contents` should have the highest priority. The requirements for handling the other request parameters remain unchanged.

#### 4.3 Examples
**Example 1**. *a GET request to /api/qrcode with the correct contents, size and type parameters*:
*Request*: `GET /api/qrcode?contents=abcdef&size=250&type=png`
*Response code*: `200 OK`
*Response header*: `Content-Type: image/png`
*Response body*: byte array

**Example 2**. *a GET request to /api/qrcode with an incorrect contents parameter*:
*Request*: `GET /api/qrcode?contents=&size=200&type=png`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Contents cannot be null or blank"
}
```

**Example 3**. *a GET request to /api/qrcode with incorrect contents, and type parameter*:
*Request*: `GET /api/qrcode?contents=&size=250&type=tiff`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Contents cannot be null or blank"
}
```

<hr/>

### 5: Foolproof API
#### 5.1 Description
QR codes have four error correction levels, determining how much code can be damaged or obscured while still readable. These levels are:

- **Level L (Low)**: The QR code can withstand up to approximately 7% damage.
- **Level M (Medium)**: The QR code can withstand up to approximately 15% damage.
- **Level Q (Quartile)**: The QR code can withstand up to approximately 25% damage.
- **Level H (High)**: The QR code can withstand up to approximately 30% damage.

These levels provide a trade-off between data capacity and resilience. Higher error correction levels require more space, reducing the amount of data that can be stored in the QR code. In this stage, the service should be able to handle a new request parameter, `correction` that defines the error correction level desired by the client. The accepted `correction` values should be `L`, `M`, `Q` and `H`. If a client specifies an incorrect correction level, the service should respond with the status code `400 BAD REQUEST` and a JSON with the `error` field and an appropriate error message.

If a request contains multiple invalid parameters, the error messages should have the following priority:

invalid contents > invalid size > invalid correction > invalid type

To implement different error correction levels, use the overloaded version of the `encode` method of the `QRCodeWriter` class. Besides the contents, barcode format, width, and height, it accepts encoder hints represented by a `Map` where keys are constants of the `EncodeHintType` and values are appropriate objects. It may sound confusing, but don't worry, we will explore a practical example. In our case, we need the specific `EncodeHintType` as key, which is the `EncodeHintType.ERROR_CORRECTION`. As a value, we will have to use the constants of the `ErrorCorrectionLevel` enum, namely `ErrorCorrectionLevel.L`, `ErrorCorrectionLevel.M`, `ErrorCorrectionLevel.Q` or `ErrorCorrectionLevel.H`. Here is the updated version of the QR code generation:
```java
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

QRCodeWriter writer = new QRCodeWriter();
Map<EncodeHintType, ?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
try {
    BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
    BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
} catch (WriterException e) {
    // handle the WriterException
}
```

In addition to the parameters, we have created the `Map` of encode hints and set the error correction level to `H` (high). To set the medium error correction level, you will need to replace `ErrorCorrectionLevel.H` with the relevant value. That's it!

In addition, let's make the QR code API more user-friendly. Now, all parameters except for `contents` should be optional and should have default values. If a client does not specify a particular request parameter, apply the corresponding default value:

- default `size` is `250`
- default `correction` is `L`
- default `type` is `png`

If a client specifies an invalid value for an optional parameter, the service should respond with the status code `400 BAD REQUEST`, a JSON with the `error` field, and an appropriate error message. The exact requirements as in the previous stage apply.

#### 5.2 Objectives
- Modify the `GET /api/qrcode` endpoint to accept a new parameter, `correction`, which represents the desired QR code error correction level and can only have values `L`, `M`, `Q` or `H`.
- Generate a QR code from the provided content, applying parameters from the request, including the error correction level.
- If the provided `correction` is not valid, the endpoint should return the status code `400 BAD REQUEST` and a request body in the JSON format with the following contents:
  ```json
  {
      "error": "Permitted error correction levels are L, M, Q, H"
  }
  ```
- The requirements for handling the other request parameters remain unchanged. If a request contains multiple invalid parameters, the error messages should have the following priority: invalid contents => invalid size => invalid correction => invalid type.
- All request parameters except for the contents should be optional and have the following default values: default `size` is `250`, default `correction` is `L` , and default `type` is `png`.


#### 5.3 Examples
**Example 1**. *a GET request to /api/qrcode with a correct contents and default other parameters*:
*Request*: `GET /api/qrcode?contents=abcdef`
*Response code*: `200 OK`
*Response header*: `Content-Type: image/png`
*Response body*: byte array

**Example 2**. *a GET request to /api/qrcode with an incorrect correction parameter*:
*Request*: `GET /api/qrcode?contents=abcde&correction=S`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Permitted error correction levels are L, M, Q, H"
}
```

**Example 3**. *a GET request to /api/qrcode with incorrect contents and correction parameters*:
*Request*: `GET /api/qrcode?contents=&correction=S`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Contents cannot be null or blank"
}
```

**Example 4**. *a GET request to /api/qrcode with an incorrect correction and type parameters*:
*Request*: `GET /api/qrcode?contents=abcde&correction=S&type=tiff`
*Response code*: `400 BAD REQUEST`
*Response body*:
```json
{
    "error": "Permitted error correction levels are L, M, Q, H"
}
```

<hr/>

[<<](../README.md)
