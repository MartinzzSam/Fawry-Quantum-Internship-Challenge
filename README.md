# E-Commerce Shopping Cart System

A comprehensive Java-based e-commerce shopping cart system implementing core retail functionality with inventory management, customer checkout, and shipping services.

## 🏗️ Project Overview

This project implements a full-featured e-commerce backend system designed to handle product inventory, shopping cart operations, customer management, and order processing. The system demonstrates object-oriented programming principles, interface-based design, and service-oriented architecture.

### Key Features

- **Product Management**: Support for multiple product types including electronics, perishables, and digital goods
- **Inventory Control**: Real-time inventory tracking with stock validation
- **Shopping Cart**: Add/remove products with quantity management
- **Customer Management**: Customer profiles with balance tracking
- **Checkout System**: Complete order processing with invoice generation
- **Shipping Services**: Weight-based shipping calculations for physical products
- **Expiration Handling**: Automatic validation for perishable products

## 🏛️ Architecture Overview

The system follows a layered architecture with clear separation of concerns:

### Core Components

```
├── App.java                 # Main application entry point
├── classes/                 # Domain models
│   ├── Customer.java        # Customer entity
│   ├── Product.java         # Base product class
│   └── CartItem.java        # Shopping cart item
├── interfaces/              # Contract definitions
│   ├── IPerishable.java     # Perishable product behavior
│   ├── IShippableProduct.java # Shippable product behavior
│   └── IShippingService.java  # Shipping service contract
├── products/                # Product implementations
│   ├── Biscuits.java        # Perishable food product
│   ├── Cheese.java          # Perishable dairy product
│   ├── Mobile.java          # Electronic device
│   ├── MobileScratchCard.java # Digital product
│   └── TV.java              # Large electronic appliance
├── services/                # Business logic layer
│   ├── CartService.java     # Shopping cart operations
│   ├── CheckoutService.java # Order processing
│   ├── InventoryService.java # Inventory management
│   └── ShippingService.java # Shipping calculations
└── config/                  # Configuration management
    └── Configs.java         # System constants and settings
```

### Design Patterns Used

- **Template Method**: Base `Product` class with specialized implementations
- **Strategy**: Different shipping and product behaviors via interfaces
- **Service Layer**: Separation of business logic from presentation
- **Factory Method**: Product creation through specialized constructors

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- VS Code with Java Extension Pack
- Maven (optional, for dependency management)

### Project Structure

```
full_stack_development_internship_challenge_fawry/
├── src/                    # Source code
├── bin/                    # Compiled classes
├── lib/                    # Dependencies
└── README.md              # This file
```

### Running the Application

1. **Clone the repository**
   ```bash
   git clone [repository-url]
   cd full_stack_development_internship_challenge_fawry
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin App
   ```

### Expected Output

The application will demonstrate a complete shopping workflow:

```
** Shipment notice **
2x Cheese 2.0
1x Biscuits 0.5
Total package weight 2.5kg
** Checkout receipt **
2x Cheese 2000
3x Mobile 3000
1x Mobile Scratch Card 1000
1x Biscuits 1000
1x TV 1000
----------------------
Subtotal 8000
Shipping 12
Amount 8012
END.
```

## 🎯 Current Features

### Product Types
- **Electronics**: TV, Mobile devices
- **Perishables**: Cheese, Biscuits (with expiration dates)
- **Digital**: Mobile scratch cards (non-shippable)

### Business Rules
- ✅ Stock validation before adding to cart
- ✅ Expiration date checking for perishables
- ✅ Weight-based shipping calculations
- ✅ Customer balance verification
- ✅ Automatic inventory updates
- ✅ Invoice generation with itemized breakdown

### Validation Features
- Quantity validation (positive numbers only)
- Product existence verification
- Stock availability checking
- Expiration date validation
- Sufficient balance verification

## 🔧 Technical Implementation

### Key Classes and Responsibilities

**Product Hierarchy**
- `Product`: Base class with common attributes (id, name, price, quantity)
- `IPerishable`: Interface for products with expiration dates
- `IShippableProduct`: Interface for products requiring shipping

**Service Layer**
- `CartService`: Manages shopping cart operations and validations
- `CheckoutService`: Handles order processing and invoice generation
- `InventoryService`: Manages product inventory and retrieval
- `ShippingService`: Calculates shipping costs and manages shippable items

**Configuration Management**
- `Configs`: Centralized configuration for product IDs, weights, and shipping rates

## 📊 Performance Characteristics

- **Memory Usage**: In-memory storage for all data
- **Time Complexity**: O(n) for product searches and validations
- **Scalability**: Suitable for small to medium product catalogs
- **Concurrency**: Single-threaded design

## 🚀 Further Optimizations

### 🔥 Critical Priority (Fix First)

#### 1. **Bug Fixes**
- [ ] **Product ID Mismatch**: Fix inconsistency between App.java product IDs and Configs constants
- [ ] **Inventory Deduction**: Implement proper inventory reduction after successful checkout
- [ ] **Shipping Weight Calculation**: Fix incorrect total weight calculation in invoice printing
- [ ] **Memory Leaks**: Ensure proper cleanup of cart items after checkout

#### 2. **Exception Handling**
- [ ] Create custom exception classes (`InsufficientInventoryException`, `ExpiredProductException`)
- [ ] Add try-catch blocks throughout the application
- [ ] Implement proper error messages and user feedback
- [ ] Add input validation for all user inputs

### 🏗️ Architecture Improvements

#### 3. **Database Integration**
- [ ] Replace in-memory storage with relational database (H2, MySQL, PostgreSQL)
- [ ] Implement JPA/Hibernate for object-relational mapping
- [ ] Create proper entity relationships and foreign keys
- [ ] Add database migration scripts and version control

#### 4. **Service Layer Refactoring**
- [ ] Extract `InvoiceService` from `CheckoutService`
- [ ] Create `PaymentService` for multiple payment methods
- [ ] Add `NotificationService` for customer communications
- [ ] Implement `DiscountService` for promotional offers

#### 5. **Design Pattern Implementation**
- [ ] **Strategy Pattern**: Different shipping methods (Express, Standard, Overnight)
- [ ] **Factory Pattern**: Product creation with validation
- [ ] **Observer Pattern**: Inventory updates and customer notifications
- [ ] **Builder Pattern**: Complex order and invoice construction

### 💼 Business Logic Enhancements

#### 6. **Advanced Shopping Features**
- [ ] **Discount System**: Percentage discounts, bulk pricing, coupon codes
- [ ] **Tax Calculation**: Regional tax support with configurable rates
- [ ] **Order Management**: Order history, tracking, status updates
- [ ] **Product Categories**: Hierarchical categorization with search/filter
- [ ] **Wishlist**: Save products for later purchase

#### 7. **Payment Processing**
- [ ] Multiple payment methods (Credit Card, PayPal, Bank Transfer)
- [ ] Payment validation and fraud detection
- [ ] Refund and cancellation handling
- [ ] Payment history and transaction tracking

#### 8. **Customer Management**
- [ ] User authentication and authorization
- [ ] Customer profiles with shipping addresses
- [ ] Purchase history and recommendations
- [ ] Customer support and feedback system

### 🔧 Technical Optimizations

#### 9. **Performance Enhancements**
- [ ] Replace linear searches with HashMap-based lookups
- [ ] Implement caching for frequently accessed data
- [ ] Add pagination for large product catalogs
- [ ] Optimize database queries with proper indexing

#### 10. **Testing Framework**
- [ ] Add JUnit 5 for comprehensive unit testing
- [ ] Create integration tests for service interactions
- [ ] Implement test coverage reporting (JaCoCo)
- [ ] Add test data builders and mock objects

#### 11. **API Development**
- [ ] Create RESTful APIs using Spring Boot
- [ ] Add API documentation with Swagger/OpenAPI
- [ ] Implement proper HTTP status codes
- [ ] Add API versioning and rate limiting

### 🌐 User Experience Improvements

#### 12. **Web Interface**
- [ ] Create responsive web UI using Spring MVC or React
- [ ] Add AJAX for dynamic cart updates
- [ ] Implement product image support and galleries
- [ ] Add mobile-responsive design

#### 13. **Advanced Cart Features**
- [ ] Save cart for later functionality
- [ ] Cart sharing capabilities
- [ ] Recently viewed products
- [ ] Product comparison features

### 🔒 Security & Quality

#### 14. **Security Measures**
- [ ] Input sanitization and validation
- [ ] Authentication and authorization framework
- [ ] Rate limiting for API endpoints
- [ ] Secure payment processing with encryption
- [ ] Data protection and privacy compliance

#### 15. **Code Quality**
- [ ] Add comprehensive JavaDoc documentation
- [ ] Implement code formatting standards (Checkstyle, SpotBugs)
- [ ] Add logging with SLF4J/Logback
- [ ] Create proper error handling and monitoring

### 📊 Analytics & Reporting

#### 16. **Business Intelligence**
- [ ] Sales reporting and analytics dashboard
- [ ] Inventory tracking with low-stock alerts
- [ ] Customer behavior analysis
- [ ] Popular products and trend analysis
- [ ] Revenue and profit margin reporting

### 🚀 Deployment & DevOps

#### 17. **CI/CD Pipeline**
- [ ] Set up automated build and testing (Jenkins, GitHub Actions)
- [ ] Add Docker containerization
- [ ] Implement deployment automation
- [ ] Add health checks and monitoring (Prometheus, Grafana)

#### 18. **Scalability Improvements**
- [ ] Implement microservices architecture
- [ ] Add load balancing and clustering
- [ ] Implement caching strategies (Redis, Memcached)
- [ ] Add message queues for async processing

## 📱 Modern Features

### 19. **Mobile & Integration**
- [ ] Push notifications for order updates
- [ ] Email notifications for receipts and promotions
- [ ] Social media integration for sharing
- [ ] Mobile app development (Android/iOS)

### 20. **AI & Machine Learning**
- [ ] Product recommendation engine
- [ ] Predictive inventory management
- [ ] Customer segmentation and targeted marketing
- [ ] Fraud detection and prevention

## 🎯 Quick Wins Implementation Order

1. **Fix product ID mismatch** in `App.java`
2. **Add proper exception handling** to all services
3. **Implement inventory deduction** after successful checkout
4. **Add unit tests** for core business logic
5. **Create proper `InvoiceService`** class
6. **Add input validation** to all methods

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For questions or support, please contact:
- Email: [your-email@example.com]
- GitHub Issues: [repository-issues-url]

---

*This project demonstrates enterprise-level Java development practices and serves as a foundation for building scalable e-commerce solutions.*
