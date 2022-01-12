# MenuApi

All URIs are relative to *http://localhost:8080/CFD/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addMenuItem**](MenuApi.md#addMenuItem) | **POST** /menu | Create a menu item
[**listMenu**](MenuApi.md#listMenu) | **GET** /menu | List all menu items
[**showMenuItemById**](MenuApi.md#showMenuItemById) | **GET** /menu/{itemId} | Info for a specific menu item


<a name="addMenuItem"></a>
# **addMenuItem**
> addMenuItem(menuItem)

Create a menu item

Creates a new item in the menu. Duplicates are allowed

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    MenuApi apiInstance = new MenuApi(defaultClient);
    MenuItem menuItem = new MenuItem(); // MenuItem | Item to add to the store
    try {
      apiInstance.addMenuItem(menuItem);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#addMenuItem");
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
 **menuItem** | [**MenuItem**](MenuItem.md)| Item to add to the store |

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

<a name="listMenu"></a>
# **listMenu**
> List&lt;MenuItem&gt; listMenu(limit)

List all menu items

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    MenuApi apiInstance = new MenuApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    try {
      List<MenuItem> result = apiInstance.listMenu(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#listMenu");
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
**200** | A paged array of menu items |  * x-next - A link to the next page of responses <br>  |
**0** | unexpected error |  -  |

<a name="showMenuItemById"></a>
# **showMenuItemById**
> MenuItem showMenuItemById(itemId)

Info for a specific menu item

### Example
```java
// Import classes:
import com.circleci.continuousfooddelivery.ApiClient;
import com.circleci.continuousfooddelivery.ApiException;
import com.circleci.continuousfooddelivery.Configuration;
import com.circleci.continuousfooddelivery.models.*;
import com.circleci.continuousfooddelivery.MenuApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/CFD/1.0.0");

    MenuApi apiInstance = new MenuApi(defaultClient);
    String itemId = "itemId_example"; // String | The id of the menu item to retrieve
    try {
      MenuItem result = apiInstance.showMenuItemById(itemId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuApi#showMenuItemById");
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
 **itemId** | **String**| The id of the menu item to retrieve |

### Return type

[**MenuItem**](MenuItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Expected response to a valid request |  -  |
**0** | unexpected error |  -  |

