## Creating new Spring Web (REST) project using Spring boot

1.  New -> Spring Starter project

    ```yaml
    name: 		bootdemo1
    group:		com.cg
    artifact:	bootdemo1
    package:        com.cg.bootdemo1
    ```

    > Click Next

2.  Search and add "web" dependency from list of available dependencies  
    ![alt text](images/select-web.png "Choose 'web' from List of dependencies")
    
    > Click next

3.  change bootVersion to 2.1.4.RELEASE

    ![alt text](images/select-boot-version.png "Change boot version to 2.1.4.RELEASE")

4.  Click "Finish"

5.  Open `src/main/resources/application.properties` file and add following properties:

    ```ini
    # Overwrite default port (from 8080 to 5000)
    server.port=5000
    ```
6.  Create a new Entity class 

    ```yaml
    Classname:  Product
    Package:    com.cg.bootdemo1.entities
    ```

    ```java
    public class Product {

	private String productId;
	private String name;
	private String description;
	private Double price;
    //create getters and setters here...
    }
    ```

    > The complete Product.java could be found [here](bootdemo1/src/main/java/com/cg/bootdemo1/entities/Product.java)

7. Create a new controller 

    ```yaml
    Classname:  ProductController
    Package:    com.cg.bootdemo1.controllers
    ```

    ```java
    @RestController
    public class ProductController {

        @GetMapping("/")
        public String sayHello() {
            return "Hello World";
        }
        
        // http://localhost:5000/all-products
        @GetMapping("/all-products")
        public List<Product> products(){
            List<Product> ps = new LinkedList<>();
            Product p1 = new Product();
            p1.setDescription("Sample product1");
            p1.setName("product1");
            p1.setPrice(120D);
            p1.setProductId("P01");
            ps.add(p1);
            Product p2 = new Product();
            p2.setDescription("Sample product2");
            p2.setName("product2");
            p2.setPrice(152.3D);
            p2.setProductId("P02");
            ps.add(p2);
            return ps;
        }
    }

    ```

    > The complete ProductController class could be found [here](bootdemo1/src/main/java/com/cg/bootdemo1/controllers/ProductController.java)

12. Run Project as "Spring Boot Application" and then hit URL:
    
    http://localhost:5000/all-products
    