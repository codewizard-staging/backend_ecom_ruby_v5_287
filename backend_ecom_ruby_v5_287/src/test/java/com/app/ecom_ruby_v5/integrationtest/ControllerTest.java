package com.app.ecom_ruby_v5.integrationtest;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.app.ecom_ruby_v5.SpringApp;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
class ControllerTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private WebApplicationContext context;
  @LocalServerPort
  private int port;

  @BeforeEach
  void setup() {
    RestAssuredMockMvc.webAppContextSetup(context);
  }

  
  
   private JsonNode getJSONFromFile(String filePath) throws IOException {
    try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)){
      JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
      return jsonNode;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  
  private String getPayload(String filePath) throws IOException {
	  String jsonString = mapper.writeValueAsString( getJSONFromFile(filePath) );
	  return jsonString;
  }

  @Test
  void testRetrieveServiceDocument() {
    final String xml = given()
        .accept(ContentType.XML)
        .when()
        .get("/ecom_ruby_v5/")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Collection<Node> n = ((Node) ((Node) path.get("service")).get("workspace")).get("collection");
    assertNotNull(n);
    assertFalse(n.isEmpty());
  }

  @Test
  void  testRetrieveMetadataDocument() {
    final String xml = given()
        .when()
        .get("/ecom_ruby_v5/$metadata")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Node n = ((Node) ((Node) path.get("edmx:Ed mx")).get("DataServices")).get("Schema");
    assertNotNull(n);
    assertEquals("ecom_ruby_v5", n.getAttribute("Namespace"));
    assertNotNull(n.get("EntityContainer"));
  }

	

	
  @Test
  void  testCreateOrderInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("OrderInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Orders")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsOrder() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("OrderInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Orders")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/Orders?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).OrderId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/Orders/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateUserInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("UserInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Users")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsUser() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("UserInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Users")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/Users?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).UserName", equalTo("'<<replace_with_keyFieldValue>>'"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/Users/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateProductTypeInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ProductTypeInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ProductTypes")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsProductType() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ProductTypeInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ProductTypes")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/ProductTypes?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).PtId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/ProductTypes/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateProductInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ProductInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Products")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsProduct() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ProductInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Products")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/Products?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Product_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/Products/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateProductPriceInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ProductPriceInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ProductPrices")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsProductPrice() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ProductPriceInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ProductPrices")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/ProductPrices?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).PpId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/ProductPrices/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateVendorInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("VendorInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Vendors")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsVendor() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("VendorInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Vendors")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/Vendors?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).VId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/Vendors/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateShipmentItemInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ShipmentItemInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ShipmentItems")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsShipmentItem() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ShipmentItemInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ShipmentItems")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/ShipmentItems?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Shipment_item_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/ShipmentItems/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateDocumentInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("DocumentInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Documents")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsDocument() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("DocumentInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Documents")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/Documents?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).DocId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/Documents/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateOtherDetailsInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("OtherDetailsInstance.json"))
        .when()
        .post("/ecom_ruby_v5/OtherDetails")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsOtherDetails() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("OtherDetailsInstance.json"))
        .when()
        .post("/ecom_ruby_v5/OtherDetails")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/OtherDetails?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).OtherDetailsId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/OtherDetails/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateOrderItemInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("OrderItemInstance.json"))
        .when()
        .post("/ecom_ruby_v5/OrderItems")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsOrderItem() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("OrderItemInstance.json"))
        .when()
        .post("/ecom_ruby_v5/OrderItems")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/OrderItems?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Order_item_id", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/OrderItems/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreatePComponentInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("PComponentInstance.json"))
        .when()
        .post("/ecom_ruby_v5/PComponents")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsPComponent() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("PComponentInstance.json"))
        .when()
        .post("/ecom_ruby_v5/PComponents")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/PComponents?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).CompId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/PComponents/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateSupplierInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("SupplierInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Suppliers")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsSupplier() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("SupplierInstance.json"))
        .when()
        .post("/ecom_ruby_v5/Suppliers")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/Suppliers?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).SId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/Suppliers/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateProductOnBoardingInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ProductOnBoardingInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ProductOnBoardings")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsProductOnBoarding() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ProductOnBoardingInstance.json"))
        .when()
        .post("/ecom_ruby_v5/ProductOnBoardings")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/ecom_ruby_v5/ProductOnBoardings?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).PbId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/ecom_ruby_v5/ProductOnBoardings/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
           
       
  
  
  
  
 
  @AfterEach
  void  teardown() {
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.Order");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.User");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ProductType");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.Product");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ProductPrice");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.Vendor");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ShipmentItem");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.Document");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.OtherDetails");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.OrderItem");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.PComponent");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.Supplier");
    jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ProductOnBoarding");
     jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ProductPComponents");
     jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ProductOtherImages");
     jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.OrderItems");
     jdbcTemplate.execute("DELETE FROM ecom_ruby_v5.ProductVendors");

    RestAssuredMockMvc.reset();
  }
}
