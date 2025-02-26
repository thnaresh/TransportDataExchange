TransportDataExchange with Multiple database
4.1. Bogdan Staff Flow:

Log in and navigate to the Bogdan Dashboard.
Upload CSV: Choose a file to upload bus operation data.
View Operation Data: Check the uploaded data in tabular format.
View Material Costs: After Bova staff updates material costs, Bogdan staff can verify the data.
View Trailer Data: Access and verify trailer data uploaded by Bristol staff.
4.2. Bova Staff Flow:

Log in and navigate to the Bova Dashboard.
View Operation Data: Check bus operation data uploaded by Bogdan staff.
Enter/Update Material Costs: Input material costs for specific bus operations.
Save Changes: Update the material cost data in the database.
4.3. Bristol Staff Flow:

Log in and navigate to the Bristol Dashboard.
Upload CSV: Choose a file to upload trailer data.
5. Security and Authentication:
Role-Based Access Control (RBAC):
User authentication and authorization managed through role-based access.
Each role has specific privileges:
Bogdan: Full access to bus and trailer data management.
Bova: Limited to viewing and updating bus operation data.
Bristol: Limited to uploading trailer data.
6. Implementation Considerations:
Frontend:

Dynamic dashboards using Thymeleaf and Bootstrap for responsive design.
JavaScript for dynamic table rendering and CRUD operations.
Backend:

Spring Boot REST APIs for data fetching, updating, and file uploads.
Role-Based Authorization using Spring Security.
Database: Store bus operation data, material costs, trailer data, and user roles.
7. Future Enhancements:
Notification System: Notify Bogdan staff when material costs are updated by Bova staff.
Audit Logs: Track changes made to bus operation and material cost data.
Reports and Analytics: Generate reports for management review.

