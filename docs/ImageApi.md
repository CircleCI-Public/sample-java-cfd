# ImageApi

All URIs are relative to *http://localhost:8080/CFD/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addImage**](ImageApi.md#addImage) | **POST** /image | Add an image to the restaraunt
[**deleteImage**](ImageApi.md#deleteImage) | **DELETE** /image/{imageId} | Remove image
[**getImage**](ImageApi.md#getImage) | **GET** /image/{imageId} | Get image


<a name="addImage"></a>
# **addImage**
> InlineResponse200 addImage(inlineObject)

Add an image to the restaraunt

Creates an image. Duplicates are allowed. Returns the image id

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.ImageApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    ImageApi apiInstance = new ImageApi(defaultClient);
    InlineObject inlineObject = new InlineObject(); // InlineObject | 
    try {
      InlineResponse200 result = apiInstance.addImage(inlineObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ImageApi#addImage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inlineObject** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteImage"></a>
# **deleteImage**
> deleteImage(imageId)

Remove image

The imageId must exist 

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.ImageApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    ImageApi apiInstance = new ImageApi(defaultClient);
    Integer imageId = 56; // Integer | The imageId to delete
    try {
      apiInstance.deleteImage(imageId);
    } catch (ApiException e) {
      System.err.println("Exception when calling ImageApi#deleteImage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **imageId** | **Integer**| The imageId to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Null response |  -  |
**0** | unexpected error |  -  |

<a name="getImage"></a>
# **getImage**
> File getImage(imageId)

Get image

Returns the image as image/png 

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.ImageApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    ImageApi apiInstance = new ImageApi(defaultClient);
    Integer imageId = 56; // Integer | The imageId of the image to retrieve
    try {
      File result = apiInstance.getImage(imageId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ImageApi#getImage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **imageId** | **Integer**| The imageId of the image to retrieve |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: image/png

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | image |  -  |

