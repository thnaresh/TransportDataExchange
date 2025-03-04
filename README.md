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
![image](https://github.com/user-attachments/assets/5f904760-f37d-4386-87e4-7219f24870d2)
![image](https://github.com/user-attachments/assets/8e00d6a9-da46-4776-94e1-aced80d7020c)
![image](https://github.com/user-attachments/assets/b6be54be-676c-4a0e-b670-595c0f3b0315)
![image](https://github.com/user-attachments/assets/bfb4dc18-aea5-40e5-b124-48629763fa64)
![image](https://github.com/user-attachments/assets/f73f68ee-39ff-4037-9c00-1551f76cf55c)


# 2.2. Bova Staff Flow:  
1. Log in and navigate to the Bova Dashboard.  
2. View Operation Data: Check bus operation data uploaded by Bogdan staff.  
3. Enter/Update Material Costs: Input material costs for specific bus operations.  
4. Save Changes: Update the material cost data in the database.  
![image](https://github.com/user-attachments/assets/0e3aabb1-4a0c-41aa-aa28-491adaac4190)

# 2.3. Bristol Staff Flow:  
1. Log in and navigate to the Bristol Dashboard.  
2. Upload CSV: Choose a file to upload trailer data.  
![image](https://github.com/user-attachments/assets/47278299-36ac-4457-86f2-d622c231554f)
![image](https://github.com/user-attachments/assets/28552a0f-0b4e-4b55-a228-5feff5c3fc7d)

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



