       ****    TransportDataExchange with Multiple Database ****  


 1. User Roles and Permissions:  
- Role-Based Access Control (RBAC):  
  - User authentication and authorization managed through role-based access.  
  - Each role has specific privileges:  
    - Bogdan: Full access to bus and trailer data management.  
    - Bova: Limited to viewing and updating bus operation data.  
    - Bristol: Limited to uploading trailer data.
      
![image](https://github.com/user-attachments/assets/19b3358e-8c52-4da6-9edc-a8a558f76472)

 2. Functional Flow:  
# 2.1. Bogdan Staff Flow:  
1. Log in and navigate to the Bogdan Dashboard.  
2. Upload CSV: Choose a file to upload bus operation data.  
3. View Operation Data: Check the uploaded data in tabular format.  
4. View Material Costs: After Bova staff updates material costs, Bogdan staff can verify the data.  
5. View Trailer Data: Access and verify trailer data uploaded by Bristol staff.  

# 2.2. Bova Staff Flow:  
1. Log in and navigate to the Bova Dashboard.  
2. View Operation Data: Check bus operation data uploaded by Bogdan staff.  
3. Enter/Update Material Costs: Input material costs for specific bus operations.  
4. Save Changes: Update the material cost data in the database.  

# 2.3. Bristol Staff Flow:  
1. Log in and navigate to the Bristol Dashboard.  
2. Upload CSV: Choose a file to upload trailer data.  

 3. Frontend Implementation:  
- Dynamic Dashboards: Using Thymeleaf and Bootstrap for a responsive design.  
- JavaScript: For dynamic table rendering and CRUD operations.  

 4. Backend Implementation:  
- Spring Boot REST APIs: For data fetching, updating, and file uploads.  
- Role-Based Authorization: Using Spring Security.  
- Multiple Database Support:  
  - Separate databases for Bus Operation Data, Material Costs, and Trailer Data.  
  - Centralized User Authentication and Authorization database for RBAC.  

 5. Database Design:  
- Bus Operation Database:  
  - Stores bus operation data uploaded by Bogdan staff.  
- Material Cost Database:  
  - Stores material cost data entered by Bova staff.  
- Trailer Data Database:  
  - Stores trailer data uploaded by Bristol staff.  
- User Management Database:  
  - Stores user credentials, roles, and permissions for RBAC.  

 6. Security and Authentication:  
- Role-Based Access Control (RBAC):  
  - Different dashboards and functionalities based on user roles:  
    - Bogdan Dashboard: Upload bus data, view operation data, check material cost, view trailer data.  
    - Bova Dashboard: View bus operation data, enter/update material cost.  
    - Bristol Dashboard: Upload trailer data CSV.  
- Spring Security Integration:  
  - Secure endpoints with role-based access restrictions.  
  - Token-based authentication for session management.  


 7. Future Enhancements:  
- Notification System:  
  - Notify Bogdan staff when material costs are updated by Bova staff.  
- Audit Logs:  
  - Track changes made to bus operation and material cost data.  
- Reports and Analytics:  
  - Generate detailed reports for management review.  



