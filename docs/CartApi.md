# CartApi

All URIs are relative to *http://localhost:8080/CFD/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCartItem**](CartApi.md#addCartItem) | **POST** /cart | Add a menu item a cart
[**deleteCartItem**](CartApi.md#deleteCartItem) | **DELETE** /cart/{itemId} | Remove item from cart
[**listCart**](CartApi.md#listCart) | **GET** /cart | List all cart items


<a name="addCartItem"></a>
# **addCartItem**
> addCartItem(menuItem)

Add a menu item a cart

Creates a new item in the cart. Duplicates are allowed

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.CartApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    CartApi apiInstance = new CartApi(defaultClient);
    MenuItem menuItem = new MenuItem(); // MenuItem | Item to add to the cart
    try {
      apiInstance.addCartItem(menuItem);
    } catch (ApiException e) {
      System.err.println("Exception when calling CartApi#addCartItem");
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
 **menuItem** | [**MenuItem**](MenuItem.md)| Item to add to the cart |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Null response |  -  |
**0** | unexpected error |  -  |

<a name="deleteCartItem"></a>
# **deleteCartItem**
> deleteCartItem(itemId)

Remove item from cart

The item must be in the cart. If multiple of same item, call this twice 

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.CartApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    CartApi apiInstance = new CartApi(defaultClient);
    Integer itemId = 56; // Integer | The menu item to delete from cart
    try {
      apiInstance.deleteCartItem(itemId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CartApi#deleteCartItem");
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
 **itemId** | **Integer**| The menu item to delete from cart |

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

<a name="listCart"></a>
# **listCart**
> List&lt;MenuItem&gt; listCart(limit)

List all cart items

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.CartApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    CartApi apiInstance = new CartApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    try {
      List<MenuItem> result = apiInstance.listCart(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CartApi#listCart");
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
 **limit** | **Integer**| How many items to return at one time (max 100) | [optional]

### Return type

[**List&lt;MenuItem&gt;**](MenuItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A paged array of cart items |  * x-next - A link to the next page of responses <br>  |
**0** | unexpected error |  -  |

