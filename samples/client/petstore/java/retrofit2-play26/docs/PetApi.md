# PetApi

All URIs are relative to *http://petstore.swagger.io:80/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPet**](PetApi.md#addPet) | **POST** pet | Add a new pet to the store
[**deletePet**](PetApi.md#deletePet) | **DELETE** pet/{petId} | Deletes a pet
[**findPetsByStatus**](PetApi.md#findPetsByStatus) | **GET** pet/findByStatus | Finds Pets by status
[**findPetsByTags**](PetApi.md#findPetsByTags) | **GET** pet/findByTags | Finds Pets by tags
[**getPetById**](PetApi.md#getPetById) | **GET** pet/{petId} | Find pet by ID
[**updatePet**](PetApi.md#updatePet) | **PUT** pet | Update an existing pet
[**updatePetWithForm**](PetApi.md#updatePetWithForm) | **POST** pet/{petId} | Updates a pet in the store with form data
[**uploadFile**](PetApi.md#uploadFile) | **POST** pet/{petId}/uploadImage | uploads an image
[**uploadFileWithRequiredFile**](PetApi.md#uploadFileWithRequiredFile) | **POST** fake/{petId}/uploadImageWithRequiredFile | uploads an image (required)


<a name="addPet"></a>
# **addPet**
> addPet(pet)

Add a new pet to the store

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Pet pet = new Pet(); // Pet | Pet object that needs to be added to the store
try {
    apiInstance.addPet(pet);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#addPet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pet** | [**Pet**](Pet.md)| Pet object that needs to be added to the store |

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="deletePet"></a>
# **deletePet**
> deletePet(petId, apiKey)

Deletes a pet

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 56L; // Long | Pet id to delete
String apiKey = "apiKey_example"; // String | 
try {
    apiInstance.deletePet(petId, apiKey);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#deletePet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| Pet id to delete |
 **apiKey** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findPetsByStatus"></a>
# **findPetsByStatus**
> List&lt;Pet&gt; findPetsByStatus(status)

Finds Pets by status

Multiple status values can be provided with comma separated strings

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
List<String> status = Arrays.asList("status_example"); // List<String> | Status values that need to be considered for filter
try {
    List<Pet> result = apiInstance.findPetsByStatus(status);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#findPetsByStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List&lt;String&gt;**](String.md)| Status values that need to be considered for filter | [enum: available, pending, sold]

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="findPetsByTags"></a>
# **findPetsByTags**
> List&lt;Pet&gt; findPetsByTags(tags)

Finds Pets by tags

Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
List<String> tags = Arrays.asList("tags_example"); // List<String> | Tags to filter by
try {
    List<Pet> result = apiInstance.findPetsByTags(tags);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#findPetsByTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tags** | [**List&lt;String&gt;**](String.md)| Tags to filter by |

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="getPetById"></a>
# **getPetById**
> Pet getPetById(petId)

Find pet by ID

Returns a single pet

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

PetApi apiInstance = new PetApi();
Long petId = 56L; // Long | ID of pet to return
try {
    Pet result = apiInstance.getPetById(petId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#getPetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet to return |

### Return type

[**Pet**](Pet.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="updatePet"></a>
# **updatePet**
> updatePet(pet)

Update an existing pet

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Pet pet = new Pet(); // Pet | Pet object that needs to be added to the store
try {
    apiInstance.updatePet(pet);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#updatePet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pet** | [**Pet**](Pet.md)| Pet object that needs to be added to the store |

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="updatePetWithForm"></a>
# **updatePetWithForm**
> updatePetWithForm(petId, name, status)

Updates a pet in the store with form data

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 56L; // Long | ID of pet that needs to be updated
String name = "null"; // String | Updated name of the pet
String status = "null"; // String | Updated status of the pet
try {
    apiInstance.updatePetWithForm(petId, name, status);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#updatePetWithForm");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet that needs to be updated |
 **name** | **String**| Updated name of the pet | [optional] [default to null]
 **status** | **String**| Updated status of the pet | [optional] [default to null]

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

<a name="uploadFile"></a>
# **uploadFile**
> ModelApiResponse uploadFile(petId, additionalMetadata, file)

uploads an image

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 56L; // Long | ID of pet to update
String additionalMetadata = "null"; // String | Additional data to pass to server
File file = new File("null"); // File | file to upload
try {
    ModelApiResponse result = apiInstance.uploadFile(petId, additionalMetadata, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#uploadFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet to update |
 **additionalMetadata** | **String**| Additional data to pass to server | [optional] [default to null]
 **file** | **File**| file to upload | [optional] [default to null]

### Return type

[**ModelApiResponse**](ModelApiResponse.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="uploadFileWithRequiredFile"></a>
# **uploadFileWithRequiredFile**
> ModelApiResponse uploadFileWithRequiredFile(petId, requiredFile, additionalMetadata)

uploads an image (required)

### Example
```java
// Import classes:
//import org.openapitools.client.ApiClient;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.Configuration;
//import org.openapitools.client.auth.*;
//import org.openapitools.client.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petstore_auth
OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 56L; // Long | ID of pet to update
File requiredFile = new File("null"); // File | file to upload
String additionalMetadata = "null"; // String | Additional data to pass to server
try {
    ModelApiResponse result = apiInstance.uploadFileWithRequiredFile(petId, requiredFile, additionalMetadata);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#uploadFileWithRequiredFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet to update |
 **requiredFile** | **File**| file to upload | [default to null]
 **additionalMetadata** | **String**| Additional data to pass to server | [optional] [default to null]

### Return type

[**ModelApiResponse**](ModelApiResponse.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json
